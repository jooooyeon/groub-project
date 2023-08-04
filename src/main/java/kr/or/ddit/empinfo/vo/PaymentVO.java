package kr.or.ddit.empinfo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PaymentVO {

	//급여 연월 , 공제후 지급액, 지급항목함계 ,  공제 항목합계 , 지급일 (메인화면)
	
	/**
	 * 급여명세번호 (기본키 시퀀스)
	 */
	private int paymentNo;
	/**
	 * 회원아이디
	 */
	private String userId;
	/**
	 * 기업아이디
	 */
	private String coId;
	/**
	 * 급여 연월
	 */
	private String workYm;
	/**
	 * 지급일
	 */
	private String payYmd;
	/**
	 * 기본급
	 */
	private int salary;
	/**
	 * 기본급
	 */
	private int roundSalary;
	/**
	 * 연장근로수당
	 */
	private int extnSalary;
	/**
	 * 식대
	 */
	private int cgffd;
	/**
	 * 국민연금
	 */
	private int npn;
	/**
	 * 고용보험
	 */
	private int emplyminsrnc;
	/**
	 * 소득세
	 */
	private int incmtax;
	/**
	 * 지방소득세
	 */
	private int llx;
	/**
	 * 공제후 실 지급액
	 */
	private int pymntamt;
	/**
	 * 건강보험
	 */
	private int nhis;
	/**
	 * 장기요양보험
	 */
	private int ltc;
	/**
	 * 지급항목합계(기본급,연장근로,식대)
	 */
	private int totalPayment;
	/**
	 * 공제항목합계(세금,보험)
	 */
	private int totalTex;
	/**
	 * 급여지급 연도
	 */
	private int selectYear;
	/**
	 * 입사일
	 */
	private int joinYear;
	/**
	 * 부서
	 */
	private String deptNoNm;
	/**
	 * 직급
	 */
	private String jbgdCdNm;
	/**
	 * 이름
	 */
	private String userNm;
	/**
	 * 생년월일
	 */
	private Date brthYmd;
	/**
	 * 은행명
	 */
	private String bankNm;
	/**
	 * 계좌번호
	 */
	private String actNo;


	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
