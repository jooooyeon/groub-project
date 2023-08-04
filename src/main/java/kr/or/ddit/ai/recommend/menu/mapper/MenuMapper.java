package kr.or.ddit.ai.recommend.menu.mapper;

import java.util.List;

import kr.or.ddit.ai.recommend.menu.vo.MenuVO;

public interface MenuMapper {

	//리스트
	public List<MenuVO> list(String userId);
}
