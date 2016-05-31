package ejo.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ejo.board.service.BoardService;
import ejo.repository.vo.BoardFileVO;
import ejo.repository.vo.BoardRecomVO;
import ejo.repository.vo.BoardVO;
import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.BoardScoreVO;
import ejo.repository.vo.MemberVO;
import ejo.repository.vo.ThemeVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	////////////////////////// 상세   //////////////////////////	
	@RequestMapping("/detail.do")
	public void detailBoard(HttpSession session, int boardNo, Model model) throws Exception {
		Map<String, Object> result = boardService.detailBoard(boardNo);
		model.addAttribute("file", result.get("file"));
		model.addAttribute("board", result.get("board"));
	}
	
	/////////// 댓글   ///////////	
	@RequestMapping("/listComment.json")
	@ResponseBody
	public List<BoardCommentVO> selectComment(int boardNo) throws Exception {
		return boardService.selectComment(boardNo);
	}
	
	@RequestMapping("/registComment.json")
	@ResponseBody
	public BoardCommentVO registComment(HttpSession session, BoardCommentVO comment) throws Exception {
		MemberVO user = (MemberVO)session.getAttribute("user");
		System.out.println(user.getId());
		comment.setId(user.getId());		
		return boardService.registComment(comment);
	}
	
	@RequestMapping("/modifyComment.json")
	@ResponseBody
	public void updateComment(BoardCommentVO comment) throws Exception {
		boardService.updateComment(comment);		
	}
	
	@RequestMapping("/deleteComment.json")
	@ResponseBody
	public List<BoardCommentVO> deleteComment(BoardCommentVO comment) throws Exception {
		return boardService.deleteComment(comment);
	}
	

	/////////// 평점   ///////////
	@RequestMapping("/scoreBar.json")
	@ResponseBody
	public Map<String, Integer> selectScoreCnt(int boardNo) throws Exception {
		Map<String, Integer> result = boardService.selectScoreCnt(boardNo);
		return result;
	}
	
	@RequestMapping("/registScore.json")
	@ResponseBody
	public int registScore(HttpSession session, BoardScoreVO score) throws Exception {
		MemberVO user = (MemberVO)session.getAttribute("user");
		score.setId(user.getId());
		int count = boardService.registScore(score);
		return count;
	}
	
	
	////////////////////////// 테마리스트   //////////////////////////	
	@RequestMapping("/themeList.do")
	public void themeList(String genderNo, Model model) throws Exception{
		List<ThemeVO> thList =  boardService.selectTheme(genderNo);
		model.addAttribute("thList",thList);
	}
	
	/////////// 테마별 리스트 조회   ///////////	
	@RequestMapping("/list.do")
	public void themeListBoard(HttpSession session,String themeNo, Model model) throws Exception{
		MemberVO user = (MemberVO)session.getAttribute("user");
		String id = user.getId();
		Map<String, Object> result = boardService.selectThemeBoard(themeNo, id);
		model.addAttribute("thListBoard",result.get("thListBoard"));
		model.addAttribute("thListBoardFile",result.get("thListBoardFile"));
		
	} 
	
	@RequestMapping("/registRecom.json")
	@ResponseBody
	public int registBoardRecom(HttpSession session, BoardRecomVO boardRecom) throws Exception{
		MemberVO user = (MemberVO)session.getAttribute("user");
		boardRecom.setId(user.getId());
		boardService.registBoardRecom(boardRecom);			
		return 1;
	}	
	
	@RequestMapping("/deleteRecom.json")
	@ResponseBody
	public int deleteBoardRecom(HttpSession session, BoardRecomVO boardRecom) throws Exception{
		MemberVO user = (MemberVO)session.getAttribute("user");
		boardRecom.setId(user.getId());
		boardService.deleteBoardRecom(boardRecom);			
		return 0;
	}	
}
