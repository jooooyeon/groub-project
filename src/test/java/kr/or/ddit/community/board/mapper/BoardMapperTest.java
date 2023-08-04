package kr.or.ddit.community.board.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.community.board.vo.BoardVO;

public interface BoardMapperTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"test-context.xml"});

		BoardMapper boardMapper = (BoardMapper)context.getBean("boardMapper");
		System.out.println(boardMapper);
		BoardVO boardVO = new BoardVO();
		boardVO.setPstNo(18);

		BoardVO list = boardMapper.detail(boardVO);
//		System.out.println(list.size());
//		for(BoardVO boardVO: list) {
//
//			System.out.println(boardVO);
//		}

			System.out.println(list);
	}
	
}
