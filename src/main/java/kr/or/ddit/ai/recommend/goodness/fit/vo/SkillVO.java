package kr.or.ddit.ai.recommend.goodness.fit.vo;

import lombok.Data;

/**
 * @author 김종명
 *
 */
@Data
public class SkillVO {
	/**
	 * 자격기술 번호
	 */
	private int skillNo;
	/**
	 * 자격기술 이름
	 */
	private String skillNm;
	/**
	 * 부서별 적합도 관리번호
	 */
	private int fitNo; 
	/**
	 * 자격기술 시퀀스
	 */
	private int skillSeq;
}
