package kr.or.ddit.draft.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.ai.recommend.book.service.BookService;
import lombok.extern.slf4j.Slf4j;

@Secured({ "ROLE_USER", "ROLE_ADMIN" })
@Controller
@Slf4j
@RequestMapping("/draft")
public class testContr {
	
//	@Autowired
//	BookService bookService;
	
	@GetMapping("/test")
	public String draftVacForm(Model model, Principal principal) {
		
		return "draft/form/mytest";
	}
	@GetMapping("/test2")
	public String draftVacForm2(Model model, Principal principal) {
		
		return "draft/form/mytest2";
	}

}
