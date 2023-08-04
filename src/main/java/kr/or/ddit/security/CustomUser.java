package kr.or.ddit.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.ddit.user.vo.UserVO;

/**
 * 스프링 시큐리티에서 정의된 User를 상속받아 UserVO정보를 연계하는 클래스를 정의한다.
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
public class CustomUser extends User{

	private UserVO userVO;

	//User의 생성자를 처리해주는 생성자
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	//CustomUserDetailsService 클래스에서 인증 성공시 사용되는 생성자
	public CustomUser(UserVO userVO) {
		super(userVO.getUserId()
			, userVO.getUserPswd()
			, userVO.getUsersAuthVOList().stream().map(auth->new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList())
		);
		this.userVO = userVO;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
}
