package kr.or.ddit.chat.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 메신저 vo
 * 
 * @author 김종명
 * @since 2023.07.17
 * @version 1.0
 * @see
 *
 * << 개정이력(Modification Information) >>
 *
 *   수정일     수정자           수정내용
 *  -------    --------    ---------------------------
 *  2023.07.03  김종명        최초 생성
 */
@Data
public class ChatRoomVO implements Serializable {
	/**
	 * 대화방 관리번호
	 */
	private int chatRmNo;
	/**
	 * 대화방 사용자
	 */
	private String userId;
	/**
	 * 대화방 이름
	 */
	private String cahtRmNm;
	/**
	 * 대화방 개설일시
	 */
	private Date crtDt;
	/**
	 * 대화방 사용자 리스트
	 */
	private List<ChatUserVO> userList;
}
