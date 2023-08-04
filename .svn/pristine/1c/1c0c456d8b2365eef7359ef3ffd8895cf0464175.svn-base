package kr.or.ddit.admin.account.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.admin.account.vo.UserRegisterVO;
import kr.or.ddit.common.service.CommonService;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;


/**
 * 관리자로서 소속원의 계정에 관한 요청을 처리하고
 * 웹 화면으로 전달하는  Controller를 정의한다
 * @author 노태현
 * @since 2023.07.12
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      	수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.12  노태현          최초 생성
 *
 * </pre>
 */

@Slf4j
@Controller
@RequestMapping("/admin/account")
public class AccountController {

	@Autowired
	CommonService  commonService;

	@Inject
	UserService userService;



	/**
	 * 직원의 등록 정보를 확인한다.
	 * @param mav 화면모델
	 * @param userId 확인하고자 하는 직원 특정
	 * @return forward:/admin/account/detail
	 */
	@GetMapping("/detail/{userId}")
	public ModelAndView accountDetail(ModelAndView mav, @PathVariable String userId) {
		log.info("admin/account/accountList Get");
		mav.setViewName("admin/account/detail");

		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO = userService.detailUserAuth(userVO);
		mav.addObject("userVO", userVO);
		return mav;
	}

	/**
	 * 직원의 등록 정보를 수정하기 위한 창을 표시한다.
	 * @param mav 화면모델
	 * @param userId 직원 특정
	 * @param coId 기업 특정
	 * @return forward:/admin/account/update
	 */
	@GetMapping("/update/{coId}/{userId}")
	public ModelAndView accountUpdate(ModelAndView mav, @PathVariable String coId, @PathVariable String userId) {
		log.info("admin/account/accountList Get");
		mav.setViewName("admin/account/update");

		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO = userService.detailUserAuth(userVO);

		List<Map<String, String>> jgList = commonService.selectCstCdList("JG",coId);
		List<Map<String, String>> jtList = commonService.selectCstCdList("JT",coId);
		List<Map<String, String>> deptList = commonService.selectDeptNoList(coId);
		List<Map<String, String>> mtrscList = commonService.selectMngCdList("MT");

		mav.addObject("userVO", userVO);
        mav.addObject("jgList", jgList);
        mav.addObject("jtList", jtList);
        mav.addObject("deptList", deptList);
        mav.addObject("mtrscList", mtrscList);

		return mav;
	}

	/**
	 * 직원의 등록 정보를 수정한다.
	 * @param userVO 직원의 수정정보
	 * @return redirect:/admin/account/detail/{userId}
	 */
	@PostMapping(value="/update", consumes="application/x-www-form-urlencoded")
	@Transactional
	public String accountUpdatePost(@ModelAttribute("userVO") UserVO userVO) {
		log.info("admin/account/update Post");

		int cnt = userService.update(userVO);
		log.info("admin/account/update Post update :" + cnt);
		String userId = userVO.getUserId();
		String url = "redirect: detail/"+userId;

		return url;
	};

	/**
	 * 직원의 목록과 그 정보를 표출한다.
	 * @param mav 화면모델
	 * @param authentication 로그인된 회원 정보로 소속 기업을 확인
	 * @return forward:/admin/account/list
	 */
	@GetMapping("/list")
	public ModelAndView accountList(ModelAndView mav, Authentication authentication) {
		log.info("admin/account/accountList Get");

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		UserVO userVO = customUser.getUserVO();
		String coId = userVO.getCoId();

		List<UserVO> userList = userService.list(coId);

        mav.addObject("userList", userList);
        mav.setViewName("admin/account/list");

		return mav;
	}

	/**
	 * 직원의 목록과 그 정보를 표출한다.
	 * @param mav 화면모델
	 * @param authentication 로그인된 회원 정보로 소속 기업을 확인
	 * @return forward:/admin/account/list
	 */
	@GetMapping("/auth")
	public ModelAndView hasAdminList(ModelAndView mav, Authentication authentication) {
		log.info("admin/account/accountList Get");

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		UserVO userVO = customUser.getUserVO();
		String coId = userVO.getCoId();

		List<UserVO> userList = userService.hasAdminList(coId);

		mav.addObject("userList", userList);
		mav.setViewName("admin/account/auth");

		return mav;
	}

	/**
	 * 직원의 생성 정보를 입력받는다.
	 * @param mav 화면모델
	 * @param authentication 로그인된 회원 정보로 소속 기업을 확인
	 * @return forward:/admin/account/create
	 */
	@GetMapping("/create")
	public ModelAndView accountCreate(ModelAndView mav, Authentication authentication) {
		log.info("admin/account/create Get");
		mav.setViewName("admin/account/create");

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		UserVO userVO = customUser.getUserVO();

		String coId = userVO.getCoId();


		List<Map<String, String>> jgList = commonService.selectCstCdList("JG",coId);
		List<Map<String, String>> jtList = commonService.selectCstCdList("JT",coId);
		List<Map<String, String>> deptList = commonService.selectDeptNoList(coId);
		List<Map<String, String>> mtrscList = commonService.selectMngCdList("MT");


        mav.addObject("jgList", jgList);
        mav.addObject("jtList", jtList);
        mav.addObject("deptList", deptList);
        mav.addObject("mtrscList", mtrscList);

		return mav;
	};

	/**
	 * 직원의 생성정보를 바탕으로 신규 계정을 생성하고 권한을 부여한다.
	 * @param userVO 직원의 생성정보
	 * @return redirect:/admin/account/detail/{userId}
	 */
	@Transactional
	@PostMapping(value="/create",consumes="application/x-www-form-urlencoded")
	public String accountCreatePost(@ModelAttribute("userRegisterVO") UserRegisterVO userRegisterVO) {
		log.info("admin/account/create Post");

		String userId = userRegisterVO.getUserId();
		String auth = "ROLE_USER";

		userService.registerUser(userRegisterVO);
		userService.registerEmpInfo(userRegisterVO);
		userService.addAuth(auth, userId);

		String url = "redirect: detail/"+userId;

		return url;
	};

	/**
	 * 입사연월 및 소속 회사에 따라 userId를 자동 생성하여 준다.
	 * @param search 검색조건
	 * @param coId 기업특정
	 * @param yearMonth 입사연월
	 * @return 조건에 근거하여 생성될 userId 값
	 */
	@PostMapping("/maxUserId")
	@ResponseBody
	public String maxUserId(@RequestParam("search") String search, @RequestParam("coId") String coId, @RequestParam("yearMonth") String yearMonth) {
		log.info("admin/account/maxUserId Post Ajax");

		String maxUserId = userService.maxUserId(search);
		String newUserId = "";
		if(maxUserId == null) {
			newUserId = coId+"_"+yearMonth+"0001";
			log.info("newUserId" + newUserId);
		} else {
			String numberPart = maxUserId.substring(maxUserId.lastIndexOf("_") + 1);
			int number = Integer.parseInt(numberPart);
			number++;
			// 증가한 숫자를 문자열로 변환하여 newUserId에 할당
			newUserId = maxUserId.substring(0, maxUserId.lastIndexOf("_") + 1) + String.format("%04d", number);
			log.info("newUserId" + newUserId);
		}

		return newUserId;
	}

	/**
	 * 직원 이메일 정보 입력시 기존 이메일과의 중복 여무를 검사한다.
	 * @param email 입력받은 이메일 정보
	 * @return 사용가능 결과 메시지
	 */
	@PostMapping("/checkEmail")
	@ResponseBody
	public String maxUserId(@RequestParam("email") String email) {
	    int cnt = 0;
	    String message = null;

	    cnt = userService.checkEmail(email);

	    if(cnt==0) {//사용할 수 있다.
	        message = "success";
	    }else {//사용할 수 없다.
	        message ="fail";
	    }
	    return message;
	}

	/**
	 * 계정의 활성상태 값을 변경한다.
	 * @param userId 변경하고자 하는 대상
	 * @return 결과 메시지
	 */
	@PostMapping("/accountAct")
	@ResponseBody
	public String accountAct(@RequestParam("userId") String userId) {
	    int cnt = 0;
	    cnt = userService.accountAct(userId);
	    userService.logSuccessZero(userId);
	    return userId;
	};

	/**
	 * 계정의 ROLE_ADMIN 권한을 삭제한다
	 * @param userId 권한을 삭제하고자 하는 대상
	 * @return 결과 메시지
	 */
	@PostMapping("/delAuth")
	@ResponseBody
	public String delAuth(@RequestParam("userId") String userId) {
		int cnt = 0;
		String message = null;

		String auth = "ROLE_ADMIN";

		cnt = userService.delAuth(auth, userId);

		if(cnt==1) {//권한 삭제
			message = "success";
		}else {
			message ="fail";
		}
		return message;
	};

	/**
	 * 계정의 ROLE_ADMIN 권한을 추가한다
	 * @param userId 권한을 추가하고자 하는 대상
	 * @return 결과 메시지
	 */
	@PostMapping("/addAuth")
	@ResponseBody
	public String addAuth(@RequestParam("userId") String userId) {
		int cnt = 0;
		String message = null;

		String auth = "ROLE_ADMIN";

		cnt = userService.addAuth(auth, userId);

		if(cnt==1) {//권한 추가
			message = "success";
		}else {
			message ="fail";
		}
		return "redirect: admin/account/auth" ;
	};



}
