package kr.or.ddit.draft.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.or.ddit.common.service.CommonService;
import kr.or.ddit.draft.service.DraftService;
import kr.or.ddit.draft.vo.DraftAtrzVO;
import kr.or.ddit.draft.vo.DraftSttsCd;
import kr.or.ddit.draft.vo.DraftUserVO;
import kr.or.ddit.draft.vo.DraftVO;
import kr.or.ddit.draft.vo.DraftVacVO;
import kr.or.ddit.empinfo.service.EmpInfoService;
import kr.or.ddit.empinfo.vo.EmpInfoVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.util.GroubUtils;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Secured({ "ROLE_USER", "ROLE_ADMIN" })
@Controller
@Slf4j
@RequestMapping("/draft")
public class DraftController {


	@Autowired
	DraftService draftService;

	@Autowired
	CommonService commonService;
	
	@Autowired
	EmpInfoService empInfoService;


	@GetMapping("/list")
	public String draftMain(Model model, Principal principal) {

		return "draft/draft_main";
	}

	/**
	 * 기안 문서 양식 페이지 이동
	 * @return 기안 문서 양식을 모아둔 페이지
	 */
	@GetMapping("/form")
	public String draftForm() {

		return "draft/draft_form";
	}

	/**
	 * 휴가 기안 문서
	 * @param model 사용자의 휴가, 기본인적사항 등을 페이지에 넘기기 위함
	 * @param principal 로그인한 유저의 ID
	 * @return 휴가 기안문서
	 * @throws Exception
	 */
	@GetMapping("/form/vac")
	public String draftVacForm(Model model, Principal principal) throws Exception {

		DraftUserVO draftUserVO = draftService.selectDraftUsesrInfo(principal.getName());
		model.addAttribute("draftUserVO", draftUserVO);
		List<DraftVacVO> draftVacVOList = draftUserVO.getDraftVacVOList();
		model.addAttribute("draftVacVOList", draftVacVOList);

		List<Map<String, String>> selectMngCdList = commonService.selectMngCdList("VU");
		model.addAttribute("selectMngCdList", selectMngCdList);

		return "draft/form/vacForm";
	}
	
	/**
	 * 자유 기안 문서
	 * @param model 기본인적사항 등을 페이지에 넘기기 위함
	 * @param principal 로그인한 유저의 ID
	 * @return 자유 기안문서
	 * @throws Exception
	 */
	@GetMapping("/form/empty")
	public String draftEmptyForm(Model model, Principal principal) throws Exception {
		
		DraftUserVO draftUserVO = draftService.selectDraftUsesrInfo(principal.getName());
		model.addAttribute("draftUserVO", draftUserVO);
		List<DraftVacVO> draftVacVOList = draftUserVO.getDraftVacVOList();
		model.addAttribute("draftVacVOList", draftVacVOList);
		
		List<Map<String, String>> selectMngCdList = commonService.selectMngCdList("VU");
		model.addAttribute("selectMngCdList", selectMngCdList);
		
		return "draft/form/emptyForm";
	}

	/**
	 * 기안 문서 작성 후 기안하기를 통해 기안 정보를 저장
	 * @param principal 로그인한 기안자의 정보
	 * @param draftVO 기안, 휴가, 결재선 등의 데이터
	 * @return 
	 * @throws Exception
	 */
	@PostMapping("/form/post")
	public String makeDraft(Principal principal, @ModelAttribute DraftVO draftVO) throws Exception{
		
		draftVO.setUserId(principal.getName());
		log.debug("draftVO 확인하기: " + draftVO);

		int draftInsert = draftService.draftInsert(draftVO);
		
		return "redirect:/draft/doc?category=during";
	}
	
	/**
	 * 임시 저장 기안 문서 리스트 페이지
	 * @param model 임시저장한 기안 문서의 목록을 전달
	 * @param principal 유저의 아이디
	 * @return 임시 기안 문서 페이지
	 * @throws Exception
	 */
	@GetMapping("/doc/temp")
	public String showMyImsiDraftList(Model model, Principal principal) throws Exception { 
		
		// 유저아이디
		String userId = principal.getName();
		
		// 유저 정보
		DraftUserVO draftUserVO = draftService.selectDraftUsesrInfo(userId);
		
		// 기안 상태 열거형에서 공통 코드 가져오기
		String drSttsCd = DraftSttsCd.valueOf("temp".toUpperCase()).getDraftSttsCd();
		
		//선탁한 기안 상태에 해당하는 기안 문서 리스트 가져오기
		List<DraftVO> draftSelectList = draftService.draftMySelectList(userId, drSttsCd);
		
		for (DraftVO draftVO : draftSelectList) {
			draftVO.setDrDtForm2();
		}
		
		model.addAttribute("draftSelectList", draftSelectList);
		model.addAttribute("draftUserVO", draftUserVO);
		
		return "draft/myimsidraftList";
	}

	/**
	 * 설정된 카테고리에 해당되는 기안문서 리스트를 보여줌
	 * @param category 기안형태에 따른 리스트
	 * @param model 문서리스트와 공통 코드를 jsp에 넘기기 위함
	 * @param principal 어떤 사용자인지 특정하기 위함(userId)
	 * @return 카테고리에 맞는 기안문서 리스트
	 * @throws Exception
	 */
	@GetMapping("/doc")
	public String showMyDraftList(@RequestParam String category, Model model, Principal principal) throws Exception { 
		
		// 유저아이디
		String userId = principal.getName();
		
		// 유저 정보
		DraftUserVO draftUserVO = draftService.selectDraftUsesrInfo(userId);
		
		// 기안 상태 열거형에서 공통 코드 가져오기
//		String drSttsCd = DraftSttsCd.valueOf(category.toUpperCase()).getDraftSttsCd();
		
		// 모든 상태의 기안 문서 가져오기로 변경
		String drSttsCd = "";
		//선탁한 기안 상태에 해당하는 기안 문서 리스트 가져오기
		List<DraftVO> draftSelectList = draftService.draftMySelectList(userId, drSttsCd);
		
		for (DraftVO draftVO : draftSelectList) {
			draftVO.setDrDtForm2();
		}
		
		model.addAttribute("draftSelectList", draftSelectList);
		model.addAttribute("draftUserVO", draftUserVO);
		
		return "draft/mydraftList";
	}
	
	/**
	 * 내 기안문서 상세 보기
	 * @param category 기안 문서의 종류(임시저장, 완료, 기안진행중 등)
	 * @param drNo 상세보기할 기안 문서의 번호
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/doc/{drNo}")
	public String showMyDraft(@PathVariable int drNo, Model model, Principal principal) throws Exception { 
		String userId = principal.getName();
		
//		String drSttsCd = DraftSttsCd.valueOf(category.toUpperCase()).getDraftSttsCd();
		
		DraftVO draftSelect = draftService.draftSelect(drNo);
		
		//표기 형식 설정 //이렇게 안해도 jsd에서 불러올때 만들어준 get메소드 불러오면 됨
//		for (DraftAtrzVO draftAtrzVO : draftSelect.getDraftAtrzVOList()) {
//			if(draftAtrzVO.getAtrzDt() != null) {
//				draftAtrzVO.setAtrzDtForm();
//			}
//		}
		
		List<DraftVO> mydraftAtrzList = draftService.mydraftAtrzList(userId);

		EmpInfoVO empInfoVO = new EmpInfoVO();
		empInfoVO.setUserId(draftSelect.getUserId());
		empInfoVO = this.empInfoService.detail(empInfoVO);

		
		model.addAttribute("mydraftAtrzList", mydraftAtrzList);
		
		model.addAttribute("draftSelect", draftSelect);
		// 기안자의 이미지/ 사인 받아오기
		model.addAttribute("empInfoVO", empInfoVO);
		model.addAttribute("draUserId", userId);
		
		return "draft/mydraft";
	}
	
	/**
	 * 사용자의 휴가 정보를 받아오기 위한 AJAX
	 * @param principal 로그인한 유저 아이디
	 * @return 부여받은 휴가 정보를 JSON 형태로로 변환하여 넘겨줌
	 * @throws Exception
	 */
	@PostMapping("/vac/info")
	@ResponseBody
	public String vacInfo(Principal principal) throws Exception { 
		String userId = principal.getName();
		
		DraftUserVO draftUserVO = draftService.selectDraftUsesrInfo(principal.getName());
		List<DraftVacVO> draftVacVOList = draftUserVO.getDraftVacVOList();
		List<Map<String, String>> selectMngCdList = commonService.selectMngCdList("VU");
		
		Gson gson = new Gson();
		String json = gson.toJson(draftVacVOList);
		return json;
	}
	
	/**
	 * 사용자가 사용할 수 있는 휴가의 종류(공통코드관리) 리스트를 받아오는 AJAX
	 * @return 공통코드로 정의해둔 휴가사용방식의 리스트를 JSON 형태로 전달
	 * @throws Exception
	 */
	@PostMapping("/vac/info/MngCd")
	@ResponseBody
	public String vacInfoMngCd() throws Exception { 
		
		List<Map<String, String>> selectMngCdList = commonService.selectMngCdList("VU");
		Gson gson = new Gson();
		String json = gson.toJson(selectMngCdList);
		return json;
	}
	
	
	/**
	 * 결재할 문서 리스트
	 * @param model 결재 문서의 정보, 결재한 사람의 유저 정보
	 * @param principal 로그인 한 사용자의 ID 
	 * @return 결재자로 선택된 문서 리스트 페이지
	 * @throws Exception
	 */
	@GetMapping("/doc/atrz")
	public String MydraftAtrzList(Model model, Principal principal) throws Exception { 
		String userId = principal.getName();
		
		// 유저 정보
//		DraftUserVO draftUserVO = draftService.selectDraftUsesrInfo(userId);
		List<DraftVO> mydraftAtrzList = draftService.mydraftAtrzList(userId);
		List<Map<String, String>> selectMngCdList = commonService.selectMngCdList("DS");
		
		for (DraftVO draftVO : mydraftAtrzList) {
			draftVO.setDrDtForm2();
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(mydraftAtrzList);
		
		String json2 = gson.toJson(selectMngCdList);
		
		model.addAttribute("mydraftAtrzList", mydraftAtrzList);
		model.addAttribute("selectMngCdList", json2);
		model.addAttribute("json", json);
		
		return "draft/myAtrzList";
	}
	
	/**
	 * 결재/ 반려 처리
	 * @param draftVO 결재 코드, 의견, 최종결재일 경우 휴가 처리 등을 위한 자료
	 * @return 결재 목록으로 리다이렉트
	 * @throws Exception
	 */
	@PostMapping("/doc/atrz/post")
	public String draftApprovePost(@ModelAttribute DraftVO draftVO) throws Exception {
		
		draftService.draftAtrzUpdate(draftVO);
		
		return "redirect:/draft/doc/atrz";
	}
	

}
