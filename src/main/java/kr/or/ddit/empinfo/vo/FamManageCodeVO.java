package kr.or.ddit.empinfo.vo;

import lombok.Data;

@Data
public class FamManageCodeVO {
	
	//공통코드 중 가족 관계
	private String mngCd; //매니지코드
	private String grCd; //공통코드분류
	private String mngCdNm1; //관계한글명
	private String useYn; //사용여부

}
