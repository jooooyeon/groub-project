package kr.or.ddit.draft.vo;

import java.util.Date;

import lombok.Data;

/**
 * @author 정시윤 
 * 휴가 기안문서에 사용할 휴가 VO
 */
@Data
public class DraftVacVO {
	/**
	 * 휴가부여 관리번호(시퀀스)
	 * 또는 휴가 사용 시 사용한 부여받은 휴가 번호
	 */
	private int vacGrntNo;
	/**
	 * 휴가를 부여 받은 사용자 아이디
	 */
	private String userId;
	/**
	 * 부여받은 휴가의 유형 공통 코드 
	 * 혹은 사용할 유가의 유형 공통 코드
	 */
	private String vacTp;
	/**
	 * 휴가 유형의 유형 명(연차, 병가, 보상, 포상)
	 */
	private String vacNm;
	/**
	 * 부여받은 일자
	 */
	private Date vacGrntYmd;
	/**
	 * 부여받은 휴가의 총 일 수
	 */
	private int vacGrntDays;
	/**
	 * 부여받은 휴가의 유효기간(만료일자)
	 */
	private Date vldYmd;

	/**
	 * 남은 휴가 일 수
	 */
	private double remainVacDays;

	/**
	 * 휴가를 사용한 일 수
	 */
	private int vacUseDays;

	/**
	 * 휴가를 사용한 사유
	 */
	private String vacRsn;

	/**
	 * 휴가사용이력 관리 번호
	 */
	private int vacUseNo;

	/**
	 * 한 기안에 휴가를 얼마나 사용했는지
	 */
	private double cnyDay;

	/**
	 * 휴가 시작 일시
	 */
	private String bgngDt;

	/**
	 * 휴가 종료 일시
	 */
	private String endDt;
	
	

}
