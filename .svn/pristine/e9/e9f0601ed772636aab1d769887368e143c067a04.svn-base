package kr.or.ddit.ai.recommend.goodness.fit.mapper;

import java.util.List;

import kr.or.ddit.ai.recommend.goodness.fit.vo.CrtfctVO;
import kr.or.ddit.ai.recommend.goodness.fit.vo.FitVO;

public interface FitMapper {
	/**
	 * 자격증 불러오기
	 * @param FitVO fit
	 * @return List<FitVO>
	 */
	public List<FitVO> crtfct(FitVO fit);
	/**
	 * 자격기술 정보 불러오기
	 * @param FitVO fit
	 * @return List<FitVO>
	 */ 
	public List<FitVO> qnsinfo(FitVO fit);
	/**
	 * 부서별 결과값 저장
	 * @param fit
	 * @return
	 */
	public int insertFit(FitVO fit);
	/**
	 * 부서별 자격증 정보 저장
	 * @param List<CrtfctVO> crtList
	 * @return int
	 */
	public int insertCrtfct(List<CrtfctVO> crtList);
	/**
	 * 부서별 자격기술 저장
	 * @param FitVO fit
	 * @return int
	 */
	public int insertSkill(FitVO fit);
	/**
	 * 결과 불러오기
	 * @param FitVO fit
	 * @return List<FitVO>
	 */
	public List<FitVO> result(FitVO fit);
}
