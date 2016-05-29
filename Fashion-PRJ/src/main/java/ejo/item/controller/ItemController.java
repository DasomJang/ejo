package ejo.item.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ejo.item.service.ItemService;
import ejo.repository.vo.ItemFileVO;
import ejo.repository.vo.MemberVO;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/makeCoordi.do")
	public void detailItem(HttpSession session, Model model) throws Exception {
		MemberVO user = (MemberVO)session.getAttribute("user");
		ItemFileVO item = new ItemFileVO();
		Map<String, Object> result = itemService.detailItem(item);
		model.addAttribute("item", result.get("item"));
	}
}
