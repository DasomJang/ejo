package ejo.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ejo.member.service.MemberService;
import ejo.repository.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/join/join.do")
	public String joinMember(MemberVO member)throws Exception{
		memberService.insertMember(member);
		return "redirect:/main/main.do";
	}
	
	@RequestMapping("/join/joinForm.do")
	public void joinForm(HttpServletRequest req)throws Exception{
   	}	
	
	
	@RequestMapping("/join/chkId.json")
	@ResponseBody
	public int selectOneMember(String id) throws Exception{
		int chkid = memberService.selectMember(id);
		return chkid;
	}
}
