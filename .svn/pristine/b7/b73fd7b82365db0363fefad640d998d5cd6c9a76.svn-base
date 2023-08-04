package kr.or.ddit.ai.recommend.menu.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.ai.recommend.menu.service.MenuService;
import kr.or.ddit.ai.recommend.menu.vo.MenuVO;

@Controller
@RequestMapping("/ai/recommend")
public class MenuController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	MenuService menuService;
	
	//요청URI : /ai/recommend/menu
	@GetMapping("/menu")
	public String recom(Model model, Principal principal) {
		String userId = principal.getName();
		List<MenuVO> data = menuService.list(userId);
		log.info("data:########111", data);
		model.addAttribute("data", data);
	
		
		return "ai/recommend/menu";
	}
	
	@GetMapping("/menu1")
	public String recom1() {
		log.info("data:########222");
		return "ai/recommend/menu";
	}
	
	
}
