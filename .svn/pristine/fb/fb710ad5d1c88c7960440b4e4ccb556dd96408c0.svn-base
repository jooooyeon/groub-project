package kr.or.ddit.resume.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import kr.or.ddit.resume.service.ResumeService;
import kr.or.ddit.resume.vo.ResumeVO;
import lombok.extern.slf4j.Slf4j;

@Secured({"ROLE_ADMIN","ROLE_USER"})
@Slf4j
@RequestMapping("/resume")
@Controller
public class ResumeController {
	
	@Autowired
	ResumeService resumeService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/register")
	public String register() {
		return "resume/register";
	}
	
	
	
	/**
	 * 이력서 리스트를 확인할 수 있는 화면
	 * @param resumeVO ResumeVO의 값
	 * @param model 화면으로 이동
	 * @return
	 */
	@GetMapping("/resumeList")
	public String resumeList(ResumeVO resumeVO, Model model) {
		
		
		List<ResumeVO> resumeList = this.resumeService.resumeList();
		log.info("resumeList :{} " , resumeList);
		
		model.addAttribute("data",resumeList);
		
		
		return "resume/resumeList";
	}
	
	
	/**
	 * 이력서의 상세내역 확인
	 * @param int rsmNo 이력서 번호에 맞는 사용자 정보 출력
	 * @param Model model
	 * @param resumeVO 
	 * @return String
	 */
	@GetMapping("/resumeDetail")
	public String resumeDetail(@RequestParam("rsmNo") int rsmNo, Model model, ResumeVO resumeVO) {
		log.info("resumeDetail에 왔다!");
		
		
		ResumeVO resumeVO2 = this.resumeService.resumeDetail(rsmNo);
		
		log.info("resumeVO {}: ",resumeVO2);
		
		model.addAttribute("data",resumeVO2);
		
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> entity = rest.getForEntity("http://127.0.0.1:8000/ai?rsmNo="+rsmNo, String.class); 
		String result = entity.getBody().replace("\"", "");
		log.info("result>> "+result);
		
		model.addAttribute("result",result);
		
		return "resume/resumeDetail";
	}
	
}
