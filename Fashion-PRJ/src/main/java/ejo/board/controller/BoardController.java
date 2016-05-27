package ejo.board.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ejo.board.service.BoardService;
import ejo.repository.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@RequestMapping("/detail.do")
	public void detailBoard(HttpSession session, int no, Model model) throws Exception {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Map<String, Object> result = boardService.detailBoard(no);
		model.addAttribute("file", result.get("file"));
	}
}
