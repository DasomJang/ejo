package ejo.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ejo.board.service.BoardService;
import ejo.repository.vo.BoardCommentVO;
import ejo.repository.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@RequestMapping("/detail.do")
	public void detailBoard(HttpSession session, int boardNo, Model model) throws Exception {
//		MemberVO user = (MemberVO)session.getAttribute("user");
		Map<String, Object> result = boardService.detailBoard(boardNo);
		model.addAttribute("file", result.get("file"));
		model.addAttribute("board", result.get("board"));
	}
	
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
	
	
	
	
	
	
	
	
	
}
