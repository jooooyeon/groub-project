package kr.or.ddit.servey.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ServeyVO {
 
	private int srvyNo; //설문관리번호(기본키 시퀀스) 1
	private String userId; //설문지 등록 회원
	private String coId; //설문지 등록 기업
	private String srvyTtl; //설문제목 o
	private String bgngDt; //설문 시작일 o
	private String endDt; //설문 종료일 o
	private String srvyStts; //매니지코드SV (진행SV001 완료SV002 예정SV003 취소SV004 )
	private String srvyCn; //설문목적 o
	private Date regDt; //설문 등록일시
	private List<ServeyQItemVO> serveyQItemVOList;
	private int totalUser; //전체 사용자 수 
}
