package kr.or.ddit.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.chat.mapper.ChatMapper;
import kr.or.ddit.chat.vo.ChatMsgVO;
import kr.or.ddit.chat.vo.ChatRoomVO;
import kr.or.ddit.chat.vo.ChatUserVO;
import kr.or.ddit.chat.vo.ChatVO;
import kr.or.ddit.msg.vo.MsgVO;
import kr.or.ddit.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 메신저 service
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
@Slf4j
@Service
public class ChatServiceImpl {
	@Autowired
	private ChatMapper chatMapper;
	
	/**
	 * 채팅방 등록
	 * @param ChatVO chat
	 * @return int 채팅방 등록 결과
	 */
	@Transactional
	public int insertRoom(ChatVO cv) {
		int rlt = this.chatMapper.chatRoomMerge(cv);
		log.info("chatRoom inert 이후 cv>> "+cv);
		List<ChatUserVO> userList = cv.getChatUserList();
		for(ChatUserVO u : userList) {
			if(u.getUserId().equals(cv.getChatRoomVO().getUserId())) u.setHostYn("Y");
			else u.setHostYn("N");
		}
		rlt += this.chatMapper.chatRoomUserInsert(cv);
		
		return rlt;
	}
	
	/**
	 * 채팅방 목록
	 * @param ChatUserVO cUser
	 * @return List<ChatRoomVO>
	 */
	public List<ChatRoomVO> chatList(ChatUserVO cUser){
		List<ChatRoomVO> chatList = this.chatMapper.chatList(cUser);
		for(int i=0; i<chatList.size();i++) {
			ChatRoomVO crVO = chatList.get(i);
			ChatUserVO u = new ChatUserVO();
			u.setChatRmNo(crVO.getChatRmNo());
			crVO.setUserList(this.chatMapper.userList(u));
			log.info("this.chatMapper.userList(u)>> "+this.chatMapper.userList(u));
			
			chatList.set(i, crVO);
		}
		return chatList;
	}
	
	/**
	 * 채팅방 대화내역 리스트
	 * @param ChatMsgVO c
	 * @return List<ChatMsgVO>
	 */
	public List<ChatMsgVO> msgList(ChatMsgVO msg){
		return this.chatMapper.msgList(msg);
	}
	
	/**
	 * 채팅방 대화목록 저장
	 * @param ChatMsgVO msg
	 * @return int
	 */
	public int msgInsert(ChatMsgVO msg) {
		msg.setFileYn("N");
		return this.chatMapper.msgInsert(msg);
	}
	
	/**
	 * 특정 대화방 사용자 내역
	 * @param ChatUserVO userList
	 * @return List<ChatUserVO>
	 */
	public List<ChatUserVO> userList(ChatUserVO ul){
		return this.chatMapper.userList(ul);
	}
}
