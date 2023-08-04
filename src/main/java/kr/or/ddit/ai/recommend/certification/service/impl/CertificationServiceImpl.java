package kr.or.ddit.ai.recommend.certification.service.impl;

import java.security.cert.Certificate;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ai.recommend.certification.mapper.CertificationMapper;
import kr.or.ddit.ai.recommend.certification.service.CertificationService;
import kr.or.ddit.ai.recommend.certification.vo.AiCrtfctRsltVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CertificationServiceImpl implements CertificationService{
	
	@Inject
	CertificationMapper certificationMapper;
	
	/**
	 * 자격증 추천리스트
	 */
	@Override
	public List<AiCrtfctRsltVO> list(String userId){
		return this.certificationMapper.list(userId);
	}

}
