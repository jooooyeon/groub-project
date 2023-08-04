package kr.or.ddit.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.or.ddit.user.mapper.UserMapper;
import kr.or.ddit.user.vo.UserVO;

/**
 * 스프링 시큐리티에서 제공하는 UserDetailsService를 구현하는 클래스를 정의한다
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
//UserDetailsService : 스프링 시큐리티에서 제공해주고 있는, 사용자 상세 정보를 갖고 있는 인터페이스
@Service
public class CustomUserDetailsService implements UserDetailsService{

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username){
		UserVO userVO = new UserVO();
		userVO.setUserId(username);
		userVO = this.userMapper.detailUserAuth(userVO);

		log.info("loadUserByUsername:userVO : " + userVO);

		if (userVO == null) {
			log.info("User not found");
			throw new UsernameNotFoundException("User not found");
		} else if (userVO.getEnabled().equals("0")) {
			log.info("DisabledException");
			throw new DisabledException("DisabledException");
		} else {

			return new CustomUser(userVO);
		}
	}
}
