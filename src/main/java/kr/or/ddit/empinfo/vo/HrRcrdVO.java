package kr.or.ddit.empinfo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class HrRcrdVO {

	//HR_RCRD 인사이력
		private int hrRcrdNo; //(시퀀스)
		private String deptNo; //부서
		private String deptNoRecord; //부서
		private String jbgdCd; //직급 이력	
		private String jbgdCdNmRecord; //직급 이력	
		private String jbtlCd; //직책 이력
		private String jbtlCdNmRecord; //직책 이력
		private Date bgngYmd; //시작일
		private Date endYmd;//종료일
		private String hrRcrdExpln; //변경사유
	
}
