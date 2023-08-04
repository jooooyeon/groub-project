package kr.or.ddit.ai.recommend.book.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.ai.recommend.book.service.BookService;
import kr.or.ddit.ai.recommend.book.vo.BookRecomVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/book/recom")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	/**
	 * 회원별 책 추천 정보를 보여주는 페이지
	 * @param model db에서 조회한 추천 정보를 jsp로 넘겨주기 위한 모델
	 * @param principal 회원아이디를 받아오기 위함
	 * @return 책 추천 페이지로 이동됨
	 */
	@GetMapping("/list")
	public String bookList(Model model, Principal principal) {
		String userId = principal.getName();
		List<BookRecomVO> recomList = bookService.recomList(userId);
		model.addAttribute("data", recomList);
		log.debug("recomList: " + recomList);
		return "ai/recommend/book_recom";
	}

}
