package kr.or.ddit.admin.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.admin.code.service.CodeService;
import kr.or.ddit.admin.code.vo.CstCdVO;
import kr.or.ddit.admin.code.vo.GrCdVO;
import kr.or.ddit.admin.code.vo.MngCdVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 관리자로서 공통코드를 확인과 사용자 코드를 관리할 수 있다
 * 공통코드에 관한 웹 화면으로 전달하는 Controller를 정의한다
 * @author 노태현
 * @since 2023.07.13
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      	수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.13  노태현          최초 생성
 *
 * </pre>
 */
@Slf4j
@Controller
@RequestMapping("/admin/code")
public class CodeContoller {

	@Autowired
	CodeService codeService;

	@GetMapping("/groupCdList")
	public ModelAndView groupCodeList(ModelAndView mav) {
		log.info("groupCodeList");

		List<GrCdVO> codeList = codeService.groupCodeList();
        mav.addObject("codeList", codeList);
        mav.setViewName("admin/code/groupCdList");

		return mav;
	}

	@GetMapping("/manageCdList")
	public ModelAndView manageCodeList(ModelAndView mav) {
		log.info("manageCodeList");

		List<MngCdVO> codeList = codeService.manageCodeList();
		List<MngCdVO> codeName = codeService.manageCodeName();

		mav.addObject("codeList", codeList);
		mav.addObject("codeName", codeName);
		mav.setViewName("admin/code/manageCdList");

		return mav;
	}

	@GetMapping("/customeCdList")
	public ModelAndView customeCdList(ModelAndView mav, Authentication authentication) {
		log.info("customeCdList");

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		UserVO userVO = customUser.getUserVO();
		String coId = userVO.getCoId();

		List<CstCdVO> codeList = codeService.customeCodeList(coId);
		List<CstCdVO> codeName = codeService.customeCodeName(coId);

		for(CstCdVO mngCdVO : codeList) {
			String regymdt = mngCdVO.getRegDt();
			String subregymdt = regymdt.substring(0, 10);
			mngCdVO.setRegDt(subregymdt);
		}

		mav.addObject("codeList", codeList);
		mav.addObject("codeName", codeName);
		mav.setViewName("admin/code/customeCdList");

		return mav;
	}


	@PostMapping("/newCstCd")
	@ResponseBody
	public String maxUserId(@RequestParam("grCd") String grCd, @RequestParam("coId") String coId) {
		log.info("admin/account/maxUserId Post Ajax");

		String maxUserId = codeService.maxCstCd(grCd, coId);
		if(maxUserId != null) {
			int number = Integer.parseInt(maxUserId.substring(2)); // 문자열에서 숫자 부분 추출
			number++; // 1을 더함
			String result = maxUserId.substring(0, 2) + String.format("%03d", number);

			return result;
		}else {
			return "";
		}
	}

	@PostMapping("/createCstCd")
	@ResponseBody
	public List<CstCdVO> createCstCd(@RequestParam("grCd") String grCd, @RequestParam("cstCd") String cstCd, @RequestParam("userId") String userId,
            				@RequestParam("cstCdNm") String cstCdNm, @RequestParam("coId") String coId) {
		CstCdVO cstCdVO = new CstCdVO();
		cstCdVO.setCoId(coId);
		cstCdVO.setGrCd(grCd);
		cstCdVO.setCstCd(cstCd);
		cstCdVO.setCstCdNm(cstCdNm);
		cstCdVO.setUserId(userId);

		int cnt = codeService.createCsdCd(cstCdVO);

		List<CstCdVO> codeList = codeService.customeCodeList(coId);

		return codeList;
	}

	@PostMapping("/codeAct")
	@ResponseBody
	public String accountAct(@RequestParam("cstCd") String cstCd) {
	    int cnt = 0;

	    cnt = codeService.codeAct(cstCd);

	    return cstCd;
	};

}
