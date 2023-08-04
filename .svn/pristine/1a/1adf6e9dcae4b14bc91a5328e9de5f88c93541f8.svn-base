package kr.or.ddit.ai.recommend.book.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ai.recommend.book.mapper.BookMapper;
import kr.or.ddit.ai.recommend.book.service.BookService;
import kr.or.ddit.ai.recommend.book.vo.BookRecomVO;

@Service
public class BookServiceImpl implements BookService {
	
	@Inject
	BookMapper bookMapper;
	
	@Override
	public List<BookRecomVO> recomList(String userId) {
		return bookMapper.recomList(userId);
	}
	
}
