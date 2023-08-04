package kr.or.ddit.servey.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.community.board.vo.BoardVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.servey.service.ServeyServiceImpl;
import kr.or.ddit.servey.vo.ServeyOptionVO;
import kr.or.ddit.servey.vo.ServeyQItemVO;
import kr.or.ddit.servey.vo.ServeyResponseVO;
import kr.or.ddit.servey.vo.ServeyVO;
import kr.or.ddit.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;



/**
 * 설문조사 탭에서 설문조사를 참여, 작성, 분석하는 게시판에 대한
 * 웹화면으로 전달하는  Controller를 정의한다
 * @author 이주연, 김종명
 * @since 2023.07.27
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      	수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.27  이주연          최초 생성
 *
 * </pre>
 */
@Secured({"ROLE_USER","ROLE_ADMIN"})
@Slf4j
@RequestMapping("/servey")
@Controller
public class ServeyController {
	
	@Inject
	private ServeyServiceImpl serveyServiceImpl;
	
	
	
	/**
	 * 설문조사 등록
	 * @return 설문작성 페이지로 이동
	 */
	@GetMapping("/serveyRegister")
	public String serveyRegister() {
		
		return "/servey/serveyRegister";
	}

	
	/**
	 * 설문조사 등록
	 * @param s 설문지 작성 내용(제목, 기간, 문항, 보기 등)
	 * @return 성공 메시지
	 */
	@ResponseBody
	@PostMapping("/serveySave")
	public String serveySave(@RequestBody ServeyVO s) {
		log.info("serveyVO "+s);
		
		this.serveyServiceImpl.serveyInsert(s);
		
		return "success";
	}
	
	
	/**
	 * 설문조사 
	 * @param model JSP화면으로 넘겨주기 위함
	 * @return 설문조사 목록 페이지로 이동
	 */
	@GetMapping("/serveyList")
	public String serveyList(Model model){
		List<ServeyVO> serveyVO =  this.serveyServiceImpl.serveyList();
		model.addAttribute("data",serveyVO);
		
		Date currentDate = new Date();
		model.addAttribute("date",currentDate);
		
		
		return "servey/serveyList";
	}
	
	
	/**
	 * 설문 조사 상세 내역 확인
	 * @param srvyNo 설문지 번호를 받아와 해당 설문에 대한 내역을 보여주기 위함
	 * @param model JSP화면으로 넘겨주기 위함
	 * @param serveyVO 설문의 제목과 기간 유형 안내문구 등
	 * @param serveyQItemVO 설문 질문 문항
	 * @param serveyOptionVO 설문 보기 문항
	 * @return
	 */
	@GetMapping("/serveyDetail")
	public String serveyDetail(@RequestParam("srvyNo") int srvyNo, Model model, ServeyVO serveyVO, ServeyQItemVO serveyQItemVO, ServeyOptionVO serveyOptionVO) {
		log.info("serveyDetail에 왔다!");
		
		ServeyVO serveyVOs = this.serveyServiceImpl.serveyDetail(srvyNo);
		log.info("serveyVOs"+serveyVOs);
		model.addAttribute("data",serveyVOs);
		
	
		return "servey/serveyDetail";
		
	}
	
	/**
	 * 설문조사 참여하기
	 * @param serveyResponse 설문에 참여하여 선택한 문항과 보기 정보 저장
	 * @param authentication 참여자 정보 가져오기
	 * @return 설문조사 리스트로 이동
	 */
	@PostMapping("/serveyListPost")
	public String serveyListPost(@ModelAttribute ServeyResponseVO serveyResponse, Authentication authentication ) {
		
		log.info("serveyResponse : " + serveyResponse);
		
		CustomUser cus = (CustomUser) authentication.getPrincipal();
		UserVO userVO = cus.getUserVO();
		String userId = userVO.getUserId();
		
		serveyResponse.setUserId(userId);
		
		for(int i=0; i<serveyResponse.getQNo().length; i++) {
			ServeyResponseVO svrVo = new ServeyResponseVO();
			svrVo.setRspnsNo(serveyResponse.getRspnsNo());
			svrVo.setSrvyNo(serveyResponse.getSrvyNo());
			svrVo.setQitemNo(serveyResponse.getQNo()[i]);
			svrVo.setUserId(serveyResponse.getUserId());
			svrVo.setRspnsCt(serveyResponse.getRsCt()[i]);
			
			int result = this.serveyServiceImpl.serveyAnswer(svrVo);
			log.info("result : " + result);
		}
		
		
		
		return "redirect:/servey/serveyList";
	}
	
	
	
	/**
	 * 설문조사 내역 확인
	 * @param model JSP화면으로 넘겨주기 위함
	 * @return 설문조사 상세내역 리스트 화면 이동
	 */
	@GetMapping("/serveyListEmployee")
	public String serveyListEmployee(Model model){
		List<ServeyVO> serveyVO =  this.serveyServiceImpl.serveyList();
		model.addAttribute("data",serveyVO);
		
		return "servey/serveyListEmployee";
	}

	
	/**
	 * 설문조사 상세 내역 확인
	 * @param srvyNo 설문 번호
	 * @param model JSP화면으로 넘겨주기 위함
	 * @param serveyVO 해당 설문번호에 해당하는 제목, 기간, 안내 문구 등을 받아옴
	 * @param serveyQItemVO 해당 설문번호에 해당하는 질문 항목 받아옴
	 * @param serveyOptionVO 해당 설문번호에 해당하고 해당 질문 내역에 해당하는 보기정보와 해당 보기 정보 선택한 사람의 수등을 받아옴
	 * @return
	 */
	@GetMapping("/serveyDetailEmployee")
	public String serveyDetailEmployee(@RequestParam("srvyNo") int srvyNo, Model model, ServeyVO serveyVO, ServeyQItemVO serveyQItemVO, ServeyOptionVO serveyOptionVO) {
		log.info("serveyDetailEmployee에 왔다!");
		
		ServeyVO serveyVOs = this.serveyServiceImpl.serveyDetail(srvyNo);
		model.addAttribute("data",serveyVOs);
		
		return "servey/serveyDetailEmployee";
		
	}
	
	
	
}
