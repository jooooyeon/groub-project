package kr.or.ddit.chat.vo;

import java.io.Serializable;
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
public class ChatVO implements Serializable{
	/**
	 * 대화방 정보
	 */
	private ChatRoomVO chatRoomVO;
	/**
	 * 대화방 사용자 정보
	 */
	private List<ChatUserVO> chatUserList;
	/**
	 * 대화방 메시지 정보
	 */
	private List<ChatMsgVO> chatMsgList;
	/**
	 * 대화방 첨부파일 정보
	 */
	private List<ChatAtchVO> chatAtchList;
}
