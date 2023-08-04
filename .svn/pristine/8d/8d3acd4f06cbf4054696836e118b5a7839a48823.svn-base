package kr.or.ddit.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.vo.UserLogVO;

/**
 * 로그인 실패시 처리에 관한 handler 클래스를 정의한다.
 * @author 노태현
 * @since 2023.07.21
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      	수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.21  노태현          최초 생성
 *
 * </pre>
 */
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Inject
	UserService userservice;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private String error;

	//생성자
    public CustomLoginFailureHandler() {
        // 실패 URL 설정
        setDefaultFailureUrl("/login?error="+error);
    }

	/**
	 * 로그인 실패시 로그기록, 계정 잠금 등의 처리와
	 * error의 원인을 리턴한다.
	 * @param request
	 * @param response
	 * @param accessDeniedException
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String userId = request.getParameter("username");
		String ipAddress = request.getRemoteAddr();

		UserLogVO userLogVO = new UserLogVO();
		userLogVO.setUserId(userId);
		userLogVO.setIpAddr(ipAddress);
		userLogVO.setNtnCd("KR");

		if(userservice.checkId(userId) == 0) {

			// 로그인 시도한 아이디가 없는 경우 처리, 로그기록
			error = "존재하지 않는 아이디입니다. 아이디를 확인하십시오";
			userLogVO.setLogStts("NoID");
			userservice.userLog(userLogVO);
		} else if (userservice.checkIdEn(userId).equals("0")) {
			// 로그인 시도한 아이디가 존재하나 잠긴 경우 처리, 로그기록
			error = "잠긴 계정입니다. 관리자에게 문의하십시오";
			userLogVO.setLogStts("LOCKED");
			userservice.userLog(userLogVO);
		} else {
			// 비밀번호가 틀린 경우 처리, 로그기록, 계정잠금
			error = "비밀번호를 확인 하십시오.\n 로그인 시도 ";
			userservice.logFailCntUp(userId);
			error = error + (userservice.checkCntUp(userId) + "/5");
			if(userservice.checkCntUp(userId) == 5){
				userservice.accountAct(userId);
				error = error + "<br> 계정이 잠겼습니다. 관리자에게 문의하십시오";
			};
			userLogVO.setLogStts("FAIL");
			userservice.userLog(userLogVO);
		}

	    setDefaultFailureUrl("/login?error="+ URLEncoder.encode(error, "utf-8")+"&userId="+userId);
	    super.onAuthenticationFailure(request, response, exception);
	}
}
