package kr.or.ddit.ai.module.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.ai.module.article.service.ArticleService;
import kr.or.ddit.ai.module.article.vo.ArticleVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 김종명
 *
 */
@Slf4j
@Secured({"ROLE_ADMIN","ROLE_USER"})
@RequestMapping("/ai")
@Controller
public class ArticleController {

	@Autowired
	ArticleService articleService;
	
	/**
	 * 요약 기사 불러오기
	 * 
	 * @param Model model
	 * @return ai/module/summarize JSP forwarding
	 */
	@GetMapping("/article/summarize")
	public String artcle(Model model) {
		List<ArticleVO> artiList =  this.articleService.list();
		model.addAttribute("artiList", artiList);
		log.info("artiList"+artiList);
		return "ai/module/summarize";
	}
}
