package ejo.boardMember.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ejo.boardMember.service.BoardMemberService;
import ejo.repository.vo.BoardMemberFileVO;
import ejo.repository.vo.BoardMemberRecomVO;
import ejo.repository.vo.BoardMemberVO;
import ejo.repository.vo.MemberVO;



@Controller
@RequestMapping("/boardMember")
public class BoardMemberConroller {
	
	@Autowired
ServletContext servletContext;
	
	@Autowired
	private BoardMemberService boardService;
	
	@RequestMapping("/regist.do")
	public String insertBoard(MultipartHttpServletRequest mRequest) throws Exception{
		
		String savePath = servletContext.getRealPath("upload");
		System.out.println("savePath :::" + savePath);
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String str = sdf.format(new Date());
		System.out.println(str);
		
		savePath += str;
		File f = new File(savePath);
		System.out.println(f.mkdirs());
		
		
		String title = mRequest.getParameter("title");
		String id = mRequest.getParameter("id");
		
		
		BoardMemberVO boardMemberVO = new BoardMemberVO();
		boardMemberVO.setTitle(title);
		boardMemberVO.setId(id);
	
		
		BoardMemberFileVO boardMemberFileVO = null;
		MultipartFile mFile = mRequest.getFile("attachFile");
		
		String oriFileName = mFile.getOriginalFilename();
		if(oriFileName != null && !oriFileName.equals("")){
			String ext = "";
			int index = oriFileName.lastIndexOf(".");
			if(index != -1){
				ext = oriFileName.substring(index);
			}
//			long fileSize = mFile.getSize();
//			System.out.println("파일 사이즈  " + fileSize);
			
			String saveFileName = "mlec-" + UUID.randomUUID().toString() + ext;
			System.out.println("저장할 파일명 : " + saveFileName);
			
			mFile.transferTo(new File(savePath + "/" + saveFileName));
			System.out.println(str);
			boardMemberFileVO = new BoardMemberFileVO();
			boardMemberFileVO.setFilePath(str);
			boardMemberFileVO.setOriFileName(mFile.getOriginalFilename());
			boardMemberFileVO.setRealFileName(saveFileName);
		
		}
		boardService.insertBoard(boardMemberVO, boardMemberFileVO);
		return "redirect:/boardMember/list.do";
			
	}
@RequestMapping("/registForm.do")
	public void registForm(HttpServletRequest req) throws Exception{
		
	}
@RequestMapping("/list.do")
public void listBoard(HttpSession session, BoardMemberVO boardMemberVO,Model model) throws Exception {
	
 //     List<BoardMemberFileVO> fileDown = boardService.
//	BoardMemberVO.setBoardMemberFileVO(fileDown);
	//boardMember.setBoardMemberFileVO(fileDown);
	
	MemberVO user= (MemberVO)session.getAttribute("user");
	String id = user.getId();
	
	Map<String, Object> result = boardService.listBoard(id);
	model.addAttribute("list", result.get("list"));
//	model.addAttribute("recomCount", result.get("recomCount"));
	// 전체 게시글 카운트

		
}

@RequestMapping("/delete.do")
public String deleteBoard(int memberBoardNo) throws Exception {
	// 게시물 삭제 처리 호출
	boardService.deleteBoard(memberBoardNo);
	// 페이지 이동
	return "redirect:list.do";
}

@RequestMapping("/registRecom.json")
@ResponseBody
public int registBoardRecom(HttpSession session, BoardMemberRecomVO boardMemberRecomVO) throws Exception{
	MemberVO user = (MemberVO)session.getAttribute("user");
	boardMemberRecomVO.setId(user.getId());
	boardService.registBoardRecom(boardMemberRecomVO);			
	return 1;
}	


@RequestMapping("/deleteRecom.json")
@ResponseBody
public int deleteBoardRecom(HttpSession session, BoardMemberRecomVO boardMemberRecomVO) throws Exception{
	MemberVO user = (MemberVO)session.getAttribute("user");
	boardMemberRecomVO.setId(user.getId());
	boardService.deleteBoardRecom(boardMemberRecomVO);			
	return 0;
}	
}


	

