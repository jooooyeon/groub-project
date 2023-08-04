package kr.or.ddit.ai.recommend.goodness.fit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import kr.or.ddit.ai.recommend.goodness.fit.service.FitServiceImpl;
import kr.or.ddit.ai.recommend.goodness.fit.vo.CrtfctVO;
import kr.or.ddit.ai.recommend.goodness.fit.vo.FitVO;
import kr.or.ddit.ai.recommend.goodness.fit.vo.SkillVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 김종명
 *
 */
@Slf4j
@CrossOrigin("*")
@RequestMapping("/goodness")
@Controller
@Secured({"ROLE_USER","ROLE_ADMIN"})
public class FitController {

	@Autowired
	private FitServiceImpl fitServiceImpl;
	
	/**
	 * 부서 적합도 결과 페이지로 포워딩, 결과를 model에 담아서 보냄
	 * @param Model model
	 * @return goodness/result JSP forwarding
	 */
	@GetMapping("/result")
	public String result(Model model) {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> entity = rest.getForEntity("http://127.0.0.1:8000/ai", String.class); 
		model.addAttribute("result",entity.getBody());
		return "goodness/result";
	}
	
	/**
	 * 부서 적합도 설정 페이지로 포워딩하기
	 * @return goodness/fit JSP forwarding
	 */
	@GetMapping("/fit/popup")
	public String fit() {
		return "/goodness/popup/fit";
	}

	/**
	 * 부서 적합도 설정에 대한 성공여부
	 * @return success 성공 메시지
	 */
	@ResponseBody
	@PostMapping("/set")
	public String set() {
		return "success";
	}

	/**
	 * 자격기술, 자격증 추가에 대한 popup
	 * @param FitVO fit
	 * @param Model model
	 * @return /goodness/popup/add JSP 내용 그대로 modal에 forwarding
	 */
	@GetMapping("/add/popup")
	public String add(FitVO fit, Model model) {
		log.info("fit>> " + fit);
		List<FitVO> fitList = null;

		if (fit.isCondition() == true) {
			fitList = this.fitServiceImpl.crtfct(fit);
		} else {
			fitList = this.fitServiceImpl.qnsinfo(fit);
		}

		model.addAttribute("fit", fit);
		model.addAttribute("fitList", fitList);

		return "/goodness/popup/add";
	}

	/**
	 * 자격기술이나 자격증 리스트 받아오기
	 * @param FitVO fit
	 * @return fitList
	 */
	@ResponseBody
	@GetMapping("/condition")
	public List<FitVO> condition(FitVO fit) {
		log.info("fit>> " + fit);
		List<FitVO> fitList = null;

		if (fit.isCondition() == true) {
			fitList = this.fitServiceImpl.crtfct(fit);
		} else {
			fitList = this.fitServiceImpl.qnsinfo(fit);
		}
		return fitList;
	}

	/**
	 * 부서적합도 설정 저장
	 * @param FitVO fit
	 * @param int[] skillList
	 * @param int[] crtfctList
	 * @return success 성공여부
	 */
	@ResponseBody
	@PostMapping("/add")
	public String add(FitVO fit, int[] skillList, int[] crtfctList) {
		List<SkillVO> ski = new ArrayList<>();
		List<CrtfctVO> crtf = new ArrayList<CrtfctVO>();
		
	    if (skillList != null) {
	    	for(int i:skillList) {
	    		SkillVO s = new SkillVO();
	    		s.setSkillNo(i);
	    		ski.add(s);
	    	}
	    	fit.setSkillNoList(ski);
	    }
	    if (crtfctList != null) {
	    	for(int i:crtfctList) {
	    		CrtfctVO c = new CrtfctVO();
	    		c.setCrtfctNo(i);
	    		crtf.add(c);
	    	}
	    	fit.setCrtfctNoList(crtf);
	    }
	    
	    int result = this.fitServiceImpl.insert(fit);
	    log.info("result>> "+result);
	    return "success";
	}

}
