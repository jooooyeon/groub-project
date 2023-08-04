package kr.or.ddit.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 비밀번호 암호화에 관한 클래스를 정의한다.
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
public class CustomNoOpPasswordEncoder implements PasswordEncoder{

	/**
	 * 비밀번호를 암호화한다
	 * @param rawPassword 암호화려는 비밀번호
	 * @return 암호화된 비밀번호
	 */
	@Override
	public String encode(CharSequence rawPassword) {
		//프로젝트 목적인 스프링 숙달을 위하여 생성한것으로, 암호화는 생략함
		return rawPassword.toString();
	}

	/**
	 * 입력된 비밀번호와 DB에 등록된 비밀번호를 비교한다
	 * @param rawPassword
	 * @param encodedPassword
	 * @return 암호화된 비밀번호
	 */
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}
}

