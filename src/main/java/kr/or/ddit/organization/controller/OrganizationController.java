package kr.or.ddit.organization.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.or.ddit.organization.controller.OrganizationController;
import kr.or.ddit.organization.service.OrganizationService;
import kr.or.ddit.organization.vo.OrganizationVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.vo.UserVO;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrganizationService organizationService;

	@GetMapping("/list")
	public String list(Model model, Authentication authentication) {
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
	    UserVO userVO = customUser.getUserVO();
	    
	    String coId = userVO.getCoId();
		
		List<OrganizationVO> data = this.organizationService.list(coId);
		log.info("list=>data : " + data);

		List<Map<String, Object>> nodes = new ArrayList<>();
		for (OrganizationVO vo : data) {
			Map<String, Object> node = new HashMap<>();
			node.put("child", vo.getUserNm()); // 자식: 부서원
			node.put("parent", vo.getDeptNm()); // 부모: 부서이름
			nodes.add(node);
		}

		Gson gson = new Gson();
		String tree = gson.toJson(nodes); // json 형태로 변환
		model.addAttribute("tree", tree);
		log.info("tree check : " + tree);

		return "organization/list";

	}

	// tree에 사원 정보 가져오기
	@ResponseBody
	@PostMapping("/jsonList")
	public String jsonList(Authentication authentication) {
	    CustomUser customUser = (CustomUser) authentication.getPrincipal();
	    UserVO userVO = customUser.getUserVO();
	    
	    String coId = userVO.getCoId();
	    
		List<OrganizationVO> data = this.organizationService.list(coId);
		log.info("list=>data : " + data);

		List<Map<String, Object>> nodes = new ArrayList<>();
		for (OrganizationVO vo : data) {
			Map<String, Object> node = new HashMap<>();
			node.put("child", vo.getUserNm()); // tree 자식: 부서원
			node.put("parent", vo.getDeptNm()); // tree 부모: 부서이름
			node.put("id", vo.getUserId());
			node.put("name", vo.getUserNm());
			node.put("tel", vo.getUserTelno());
			node.put("email", vo.getUserEml());
			node.put("img", vo.getUserImg());
			node.put("dept", vo.getDeptNm());
			node.put("jbgdCd", vo.getJbgdCd());   //직급
			node.put("jbtlCd", vo.getJbtlCd());	  //
			node.put("coId", vo.getCoId());
			nodes.add(node);
			
		}
		log.debug("yteyetre: "+nodes);
		
		Gson gson = new Gson();
		return gson.toJson(nodes); // json 형태로 변환
	}
	
	
	
	
}







