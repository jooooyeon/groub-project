package kr.or.ddit.ai.recommend.certification.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.ai.recommend.certification.service.CertificationService;
import kr.or.ddit.ai.recommend.certification.vo.AiCrtfctRsltVO;
import lombok.extern.slf4j.Slf4j;



/**
 * AI기능으로서 부서, 연차, 경력을 고려한 자격증 추천에 대한 요청을 처리하고
 * 웹화면으로 전달하는  Controller를 정의한다
 * @author 이주연
 * @since 2023.07.18
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      	수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.18  이주연          최초 생성
 *
 * </pre>
 */

@Controller
public class CertificationController {

	@Autowired
	CertificationService certificationService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 회원별 자격증 추천 정보를 보여주는 페이지
	 * @param model DB에서 조회한 추천정보를 JSP로 전달
	 * @param principal 회원아이디를 받아오기 위함
	 * @return 자격증 추천 페이지 이동
	 */
	@GetMapping("/certification")
	public String recom(Model model, Principal principal) {
		String userId = principal.getName();
		List<AiCrtfctRsltVO> data = this.certificationService.list(userId);
		log.info("data",data);
		model.addAttribute("data",data);
	
		
		return "ai/recommend/certification";
	}
	
	
}
