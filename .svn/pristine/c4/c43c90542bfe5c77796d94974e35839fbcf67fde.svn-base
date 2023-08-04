package kr.or.ddit.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.empinfo.service.EmpInfoService;
import kr.or.ddit.mail.service.MailServiceImpl;
import kr.or.ddit.mail.vo.MailVO;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.GroubUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private MailServiceImpl mailServiceImpl;

	@Autowired
	private UserService userService;

	@Autowired
	private EmpInfoService empInfoService;

		//요청URI : /accessError
		//접근 거부 처리 메소드. 403나왔을 때 여기서 처리하겠다.
		@GetMapping("/accessError")
		public String accessDenied(Authentication auth, Model model) {
			//auth : 로그인 관련 정보
			log.info("access Denied : " + auth);

			model.addAttribute("msg","Access Denined");

			//forwarding
			return "common/accessError";
		}

		//오류 메시지, 로그아웃 페시지를 파라미터로 준비
		//<security:form-login login-page="/login"/>
		@GetMapping("/login")
		public String login(@RequestParam(value = "error", required = false)String error, String logout,
				Model model, HttpServletRequest request, @RequestParam(value = "userId", required = false)String userId) {

			if(error != null) {
				model.addAttribute("error", error);
			}
			if(logout != null) {
				model.addAttribute("logout", "Logout");
			}
			if(userId != null) {
				model.addAttribute("userId", userId);
			}

			return "common/loginForm";
		}

		@PostMapping("/forgotPswd")
		public String forgotPswdPost(@RequestParam("findPwUserId") String userId, @RequestParam("findPwUserEmail") String findUserEmail) throws Exception {
			log.info("Post:forgotPswd");

			MailVO mail = new MailVO();
			String temp = GroubUtils.getTempPassword();

			mail.setRcptnEml(findUserEmail);
			mail.setEmlTtl("Groub 임시비밀번호 안내");
			mail.setTxt("안녕하세요. Groub 임시비밀번호 안내 관련 이메일 입니다.\n" + " 회원님의 임시 비밀번호는 "
	                + temp + " 입니다." + "로그인 후에 비밀번호를 변경을 해주세요");

			UserVO userVO = new UserVO();
			userVO.setUserId(userId);
			userVO.setUserPswd(temp);

			//임시비밀번호 변경
			empInfoService.changePw(userVO);
			//안내 메일 발송
			mailServiceImpl.sendMail(mail);

			return "common/loginForm";
		}

		@ResponseBody
		@PostMapping("/forgotPswd/checkEmail")
		public String checkEmail(@RequestParam("findUserId") String userId, @RequestParam("findUserEmail") String findUserEmail) {
			log.info("forgotPswd/checkEmail");
			String userEml = userService.checkEmlId(userId);
			String message = "";
			int cnt;
			//아이디가 없으면. 아이디를 확인해라.
			cnt = userService.checkId(userId);
			if(cnt == 0) {
				message = "no";
			} else if(userEml.equals(findUserEmail)) {
				message = "yes";
			} else {
				message = "noMatch";
			}

			return message;
		}
}
