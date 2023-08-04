package kr.or.ddit.ai.recommend.certification.mapper;

import java.util.List;

import kr.or.ddit.ai.recommend.certification.vo.AiCrtfctRsltVO;

public interface CertificationMapper {

	
	/**
	 * 사용자의 자격증 추천 정보
	 * @param userId 사용자의 ID
	 * @return 리스트형태의 자격증 정보
	 */
	public List<AiCrtfctRsltVO> list(String userId);
	
	
}
