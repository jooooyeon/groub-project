package kr.or.ddit.organization.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.organization.vo.OrganizationVO;

public interface OrganizationMapperTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"test-context.xml"});

		OrganizationMapper organizationMapper = (OrganizationMapper)context.getBean("organizationMapper");
		System.out.println(organizationMapper);
		
	
//		List<OrganizationVO> list = organizationMapper.list();
//
//		for(OrganizationVO vo : list) {
//			System.out.println(vo);
//		}
//		
	}
	
}
