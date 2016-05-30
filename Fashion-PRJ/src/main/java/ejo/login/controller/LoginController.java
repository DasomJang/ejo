package ejo.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ejo.login.service.LoginService;
import ejo.repository.vo.MemberVO;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/loginForm.do")
	public void loginForm() {}
	
	@RequestMapping("/login.do")
	public String login(HttpSession session, MemberVO member, RedirectAttributes attr) throws Exception {
		MemberVO memberFromDB = loginService.selectOneLogin(member);	
		if(memberFromDB != null){
			session.setAttribute("user", memberFromDB);
			return "redirect:/main/main.do";
		}	
		else{
			attr.addFlashAttribute("msg", "아이디와 패스워드를 확인하세요!");
			return "redirect:/main/main.do";
		}
	
	}

	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/main/main.do";
	}
}
