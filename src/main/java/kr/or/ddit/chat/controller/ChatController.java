package kr.or.ddit.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.chat.service.ChatServiceImpl;
import kr.or.ddit.chat.vo.ChatMsgVO;
import kr.or.ddit.chat.vo.ChatRoomVO;
import kr.or.ddit.chat.vo.ChatUserVO;
import kr.or.ddit.chat.vo.ChatVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 메신저 controller
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
@RequestMapping("/chat")
@Controller
@Secured({"ROLE_USER","ROLE_ADMIN"})
public class ChatController {
	
	@Autowired
	private SimpMessageSendingOperations simpMessageSendingOperations;

	@Autowired
	private ChatServiceImpl chatServiceImpl;
	
	/**
	 * 대화방 등록
	 * @param ChatVO c
	 * @return int
	 */
	@ResponseBody
	@PostMapping("/add")
	public String main(ChatVO formData) {
		log.info("ChatVO>> "+formData);
		this.chatServiceImpl.insertRoom(formData);
		return "success";
	}
	
	/**
	 * 채팅방 리스트 전달
	 * @return String success
	 */
	@ResponseBody
	@GetMapping("/list")
	public List<ChatRoomVO> list(ChatUserVO cUser) {
		log.info("cUser>> ",cUser);
		return this.chatServiceImpl.chatList(cUser);
	}
	
	/**
	 * 채팅방 메세지 목록
	 * @param ChatMsgVO msg
	 * @return List<ChatMsgVO>
	 */
	@ResponseBody
	@GetMapping("/msgList")
	public List<ChatMsgVO> msgList(ChatMsgVO msg){
		return this.chatServiceImpl.msgList(msg);
	}
}