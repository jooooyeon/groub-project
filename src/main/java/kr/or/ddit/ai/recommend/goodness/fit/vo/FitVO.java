package kr.or.ddit.ai.recommend.goodness.fit.vo;

import java.util.List;

import lombok.Data;

/**
 * @author 김종명
 *
 */
@Data
public class FitVO {
	/**
	 * 부서 적합도 설정 관리번호
	 */
	private int fitNo;
	/**
	 * 제목
	 */
	private String title;
	/**
	 * 자격증 번호
	 */
	private String aiCrtfctNo;
	/**
	 * 자격기술 번호
	 */
	private String qnsinfoNo;
	/**
	 * 부서번호 
	 */
	private int deptNo;
	/**
	 * 자격증명
	 */
	private String crtfctNm;
	/**
	 * 자격기술 분류명
	 */
	private String skillTp;
	/**
	 * 자격기술 이름명
	 */
	private String skillNm;
	/**
	 * 자격증인지, 자격기술인지 판단하는 근거
	 */
	private boolean condition;
	
	/**
	 * 선택된 자격증 번호
	 */
	private int crtfcNo;
	/**
	 * 선택된 자격기술 번호
	 */
	private int skillNo;
	/**
	 * 최종학력
	 */
	private int finalEdu;
	/**
	 * 최종학력 세부사항
	 */
	private String finalEduDtl;
	/**
	 * 경력
	 */
	private int career;
	/**
	 * 경력 세부사항
	 */
	private String careerDtl;
	/**
	 * 자격증 시퀀스
	 */
	private int crtfctSeq;
	/**
	 * 자격기술 시퀀스
	 */
	private int skillSeq;

	/**
	 * 자격증 번호 목록
	 */
	private List<CrtfctVO> crtfctNoList;
	/**
	 * 자격기술 번호 목록
	 */
	private List<SkillVO> skillNoList;
}
