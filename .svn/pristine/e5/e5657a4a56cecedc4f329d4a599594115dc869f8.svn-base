package kr.or.ddit.user.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.user.vo.UserVO;

public interface UserMapperTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"test-context.xml"});

		UserMapper userMapper = (UserMapper)context.getBean("userMapper");
		System.out.println(userMapper);

//		List<UserVO> list = userMapper.list();
//		System.out.println(list.size());
//		for(UserVO userVO: list) {
//
//			System.out.println(userVO);
//		}

	}

}
