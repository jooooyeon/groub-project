package kr.or.ddit.draft.vo;

import java.util.Date;

import lombok.Data;

@Data
public class DraftOpnVO {
	
	/**
	 * 기안에 작성된 의견 관리 번호
	 */
	private int drOpnNo;
	
	private int drNo;
	/**
	 * 의견을 작성한 사용자 아이디
	 */
	private String userId;
	/**
	 * 의견 내용
	 */
	private String opnnCn;
	/**
	 * 의견 작성 일시
	 */
	private Date drOpnnDt;
	/**
	 * 의견 삭제 여부
	 */
	private String delYn;
	/**
	 * 의견 삭제 일시
	 */
	private Date delDt;

}
