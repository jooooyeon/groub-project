package kr.or.ddit.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.vo.UserLogVO;
import kr.or.ddit.user.vo.UserVO;

/**
 * 로그인 성공시 처리에 관한 handler 클래스를 정의한다.
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
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Inject
	UserService userservice;

	/**
	 * 로그인 성공시 로그기록 및 인증된 사용자 정보를 리턴한다.
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		log.warn("onAuthenticationSuccess");

		String ipAddress = request.getRemoteAddr();

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		UserVO userVO = customUser.getUserVO();

		String userId = userVO.getUserId();
		String message = "SUCCESS";

		log.info("ipAddress : " + ipAddress);

		int result;

		UserLogVO userLogVO = new UserLogVO();
		userLogVO.setUserId(userId);
		userLogVO.setIpAddr(ipAddress);
		userLogVO.setLogStts(message);
		userLogVO.setNtnCd("KR");
		userLogVO.setFailCnt(0);

		// 로그인 성공시 로그기록, 로그인 실패 횟수를 초기화
		userservice.userLog(userLogVO);
		userservice.logSuccessZero(userId);

		//사용자 아이디를 리턴
		log.info(customUser.getUsername());
		//부모(super)에게 반납
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
