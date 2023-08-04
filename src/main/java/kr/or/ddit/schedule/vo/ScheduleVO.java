package kr.or.ddit.schedule.vo;

import lombok.Data;

/**
* 일정 정보를 처리하기 위한 VO클래스
* @author 노태현
* @since 2023.07.21
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
 *   수정일      	수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.21  노태현          최초 생성
*
* </pre>
*/
@Data
public class ScheduleVO {

	private String schdlNo;
	private String userId;
	private String deptNo;
	private String coId;
	private String schdlTtl;
	private String schdlCn;
	private String regDt;
	private String strtSchdlDt;
	private String endSchdlDt;
	private String schdlTp;
	private String delYn;
	private String delDt;

}
