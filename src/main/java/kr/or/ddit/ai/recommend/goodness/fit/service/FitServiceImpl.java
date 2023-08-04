package kr.or.ddit.ai.recommend.goodness.fit.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.ai.recommend.goodness.fit.mapper.FitMapper;
import kr.or.ddit.ai.recommend.goodness.fit.vo.CrtfctVO;
import kr.or.ddit.ai.recommend.goodness.fit.vo.FitVO;
import kr.or.ddit.ai.recommend.goodness.fit.vo.SkillVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 김종명
 *
 */
@Slf4j
@Service
public class FitServiceImpl {
	
	@Autowired
	private FitMapper fitMapper;
	
	/**
	 * 자격증 정보 불러오기
	 * @param FitVO fit
	 * @return List<FitVO>
	 */
	public List<FitVO> crtfct(FitVO fit){
		return this.fitMapper.crtfct(fit);
	}
	
	/**
	 * 자격기술 정보 불러오기
	 * @param FitVO fit
	 * @return List<FitVO>
	 */
	public List<FitVO> qnsinfo(FitVO fit){
		return this.fitMapper.qnsinfo(fit);
	}
	
	/**
	 * 부서별 적합도 저장
	 * @param FitVO fit
	 * @return int
	 */
	@Transactional
	public int insert(FitVO fit) {
		log.info("fit>> "+fit);
		//1)
		int result = this.fitMapper.insertFit(fit);
		
		//2)
		List<CrtfctVO> crtList = fit.getCrtfctNoList();
		if(crtList!=null) {
			for(CrtfctVO c:crtList)c.setFitNo(fit.getFitNo());		
			log.info("crtList : " + crtList);
			result += this.fitMapper.insertCrtfct(crtList);
		}
		
		//3)
		List<SkillVO> sList = fit.getSkillNoList();
		if(sList!=null) {
			for(SkillVO s:sList)s.setFitNo(fit.getFitNo());
			result += this.fitMapper.insertSkill(fit);
			log.info("fit.skillNoList : " + fit.getSkillNoList());
		}
		
		log.info("result : " + result);
		
		return result;
	}
	
}
