package kr.or.ddit.ai.module.article.mapper;

import java.util.List;

import kr.or.ddit.ai.module.article.vo.ArticleVO;

/**
 * @author 김종명
 *
 */
public interface ArticleMapper {

	/**
	 * 요약 기사 불러오기
	 * 
	 * @return List<ArticleVO>
	 */
	public List<ArticleVO> list();

}
