package kr.or.ddit.empinfo.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class FamVO {
	
	//FAM
	private int famNo; //기본키(시퀀스)
	private String userId; //접속자 아이디
	private String famNm; //가족이름
	private String famRelCd; //가족관계(공통코드)
	private String famRelCdNm; //가족관계(공통코드)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date brthYmdFam; //가족생일
	private String gndrMfFam; //가족 성별(남M,여W)
	
	
}


