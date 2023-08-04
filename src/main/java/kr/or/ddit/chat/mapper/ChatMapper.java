package kr.or.ddit.chat.mapper;

import java.util.List;

import kr.or.ddit.chat.vo.ChatMsgVO;
import kr.or.ddit.chat.vo.ChatRoomVO;
import kr.or.ddit.chat.vo.ChatUserVO;
import kr.or.ddit.chat.vo.ChatVO;
import kr.or.ddit.user.vo.UserVO;

/**
 * 메신저 mapper
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
 *  2023.07.17  김종명        대화방 등록
 *  2023.07.18  김종명        채팅방 리스트 전달, 채팅방 목록 보기
 */
public interface ChatMapper {

	/**
	 * 채팅방 등록
	 * @param ChatVO chat 
	 * @return int
	 */
	public int chatRoomMerge(ChatVO cv);
	/**
	 * 채팅방 사용자 등록, 채팅방 방장 Y/N
	 * @param ChatVO chat 
	 * @return int
	 */
	public int chatRoomUserInsert(ChatVO cv);
	
	/**
	 * 모든 사용자 불러오기
	 * @param u
	 * @return List<UserVO>
	 */
	public List<ChatUserVO> userList(ChatUserVO u);
	
	/**
	 * 사용자가 포함된 대화방 목록 가져오기
	 * @param ChatUserVO cUser
	 * @return List<ChatRoomVO>
	 */
	public List<ChatRoomVO> chatList(ChatUserVO cUser);
	
	/**
	 * 채팅 내용 저장
	 * @param ChatMsgVO msg
	 * @return int
	 */
	public int msgInsert(ChatMsgVO msg);
	
	/**
	 * 채팅방 대화내역 리스트
	 * @param ChatMsgVO c
	 * @return List<ChatMsgVO>
	 */
	public List<ChatMsgVO> msgList(ChatMsgVO msg);	
}
