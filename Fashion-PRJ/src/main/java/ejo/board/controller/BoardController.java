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
import ejo.repository.vo.BoardScoreVO;
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
	
	//////////////////////////평점   //////////////////////////
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
	
	
	
	
	
	
	
}
