package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * 접근 거부시의 처리에 관한 handler 클래스를 정의한다.
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
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	/* 로그 설정 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 접근거부발생시 처리
	 * @param request
	 * @param response
	 * @param accessDeniedException
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.error("handle");
		log.error("accessDeniedException : " + accessDeniedException);

		response.sendRedirect("/accessError");
	}

}
