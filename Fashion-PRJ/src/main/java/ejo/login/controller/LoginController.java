package ejo.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ejo.repository.vo.MemberVO;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/loginForm.do")
	public void loginForm() {}
	
	@RequestMapping("/login.do")
	public String login(HttpSession session, MemberVO member) throws Exception {
		session.setAttribute("user", member);		
		return "redirect:/main/main.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/main/main.do";
	}
}
