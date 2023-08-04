package kr.or.ddit.websocket.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 김종명
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlarmVO {
	/**
	 * 보내는 사람 이름
	 */
	private String senderNm;
	/**
	 * 보내는 사람 아이디
	 */
	private String sender;
	/**
	 * 사용자 아이디
	 */
	private String userId;
	/**
	 * 사용자 웹소켓 sessionId 값 저장
	 */
	private String sessionId;
	/**
	 * 사용자 이름
	 */
	private String userNm;
	/**
	 * 사용자 이메일
	 */
	private String userEml;
	
}
