package kr.or.ddit.ai.module.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.ai.module.article.mapper.ArticleMapper;
import kr.or.ddit.ai.module.article.vo.ArticleVO;

/**
 * @author 김종명
 *
 */
@Service
public class ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	/**
	 * 요약 기사 불러오기
	 * 
	 * @return List<ArticleVO>
	 */
	public List<ArticleVO> list() {
		return this.articleMapper.list();
	}

}
