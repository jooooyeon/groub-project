package kr.or.ddit.ai.recommend.menu.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ai.recommend.certification.mapper.CertificationMapper;
import kr.or.ddit.ai.recommend.certification.vo.AiCrtfctRsltVO;
import kr.or.ddit.ai.recommend.menu.mapper.MenuMapper;
import kr.or.ddit.ai.recommend.menu.service.MenuService;
import kr.or.ddit.ai.recommend.menu.vo.MenuVO;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Inject
	MenuMapper menuMapper;

	@Override
	public List<MenuVO> list(String userId) {
		return this.menuMapper.list(userId);
	}

	

}
