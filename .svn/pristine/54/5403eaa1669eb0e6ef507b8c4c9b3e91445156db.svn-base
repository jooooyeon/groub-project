package kr.or.ddit.user.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
* 그룹웨어에 로그인 하려는 대상의 정보를 처리하기 위한 VO클래스
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
public class UserLogVO {
	private int logNo;
	private String userId;
	private String coId;
	private String logStts;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date logYmd;
	private String ipAddr;
	private String ntnCd;
	private int failCnt;
	private String logTime;

}
