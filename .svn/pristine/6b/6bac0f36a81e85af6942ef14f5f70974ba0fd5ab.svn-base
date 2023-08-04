package kr.or.ddit.websocket.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import kr.or.ddit.chat.service.ChatServiceImpl;
import kr.or.ddit.chat.vo.ChatMsgVO;
import kr.or.ddit.chat.vo.ChatUserVO;
import kr.or.ddit.draft.service.DraftService;
import kr.or.ddit.msg.service.MsgServiceImpl;
import kr.or.ddit.msg.vo.MsgVO;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.websocket.handler.WebsocketHandler;
import kr.or.ddit.websocket.vo.AlarmVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 실시간 알람/메신저 controller
 * 
 * @author 김종명
 * @since 2023.07.03
 * @version 1.0
 * @see
 *
 * << 개정이력(Modification Information) >>
 *
 *   수정일     수정자           수정내용
 *  -------    --------    ---------------------------
 *  2023.07.03  김종명        최초 생성
 *	2023.07.04	김종명        쪽지 알람
 *	2023.07.11  김종명        메일 알람
 *  2023.07.23  김종명        공지사항 알람, 메신저 알람
 *  2023.07.23  김종명        사용자 기업 아이디로 기업 내 모든 사용자에게 알람 발송
 *  2023.07.23  김종명        전체 일정 알람, 설문조사 신규 알람
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class AlarmController {

	@Autowired
	private SimpMessageSendingOperations simpMessageSendingOperations;

	@Autowired
	private WebsocketHandler websocketHandler;
	
	@Autowired
	private ChatServiceImpl chatServiceImpl;
	
	@Autowired
	private MsgServiceImpl msgServiceImpl;
	
	@Autowired
	private DraftService draftService;
	
	/** 설문조사 기업내 사용자 전체에게 신규 알람
	 * @param MsgVO msg
	 * @throws InterruptedException
	 */
	@MessageMapping("/servey")
	public void servey(MsgVO msg) throws InterruptedException {
		String mess = String.format( "설문조사 " + "가 신규 등록되었습니다");
		msg.setMemoCn(mess);
		msg.setMemoTtl("설문조사");

		MsgVO m = this.msgServiceImpl.selectCoId(msg);
		log.info("사용자 기업 아이디 반환>> "+m);
		List<UserVO> coUserList = this.msgServiceImpl.coUserList(m);
		log.info("사용자 기업 내 전체 리스트 반환>> "+coUserList);
		for(UserVO u:coUserList) {
			msg.setUserId(u.getUserId());
			this.msgServiceImpl.insertAlarmNotice(msg);
		}
		
		Thread.sleep(1000);
		log.info("msg>> "+msg);
		
		this.simpMessageSendingOperations.convertAndSend("/sub/noticeAlarm",msg);
	}
	
	/**
	 * 전체 일정 알람
	 * @param MsgVO msg
	 * @throws InterruptedException
	 */
	@MessageMapping("/scheduleAll")
	public void scheduleAll(MsgVO msg) throws InterruptedException {
		log.info("전체 일정 알람>> "+msg);
		String mess = String.format( "전체일정 " + "알람 왔어요");
		msg.setMemoCn(mess);
		msg.setMemoTtl("일정");
		
		MsgVO m = this.msgServiceImpl.selectCoId(msg);
		log.info("사용자 기업 아이디 반환>> "+m);
		List<UserVO> coUserList = this.msgServiceImpl.coUserList(m);
		log.info("사용자 기업 내 전체 리스트 반환>> "+coUserList);
		for(UserVO u:coUserList) {
			msg.setUserId(u.getUserId());
			this.msgServiceImpl.insertAlarmNotice(msg);
		}
		
		Thread.sleep(1000);
		this.simpMessageSendingOperations.convertAndSend("/sub/noticeAlarm",msg);
		log.info("msg>> "+msg);
	}
	
	/**
	 * 결재되었을 때, 당사자에게 보내는 알람
	 * @param AlarmVO a
	 * @throws InterruptedException
	 */
	@MessageMapping("/docResult")
	public void docResult(AlarmVO a) throws InterruptedException {
		log.info("결재됨 알람>> "+a);
		Thread.sleep(500);
		alarm(a, "결재완료");
	}
	
	/**
	 * 결재하기 알람
	 * @param AlarmVO a
	 * @throws InterruptedException
	 */
	@MessageMapping("/docAlarm")
	public void docAlarm(AlarmVO a) throws InterruptedException {
		log.info("결재 알람>> "+a);
		alarm(a, "결재");
	}
	
	/**
	 * 기안하기 알람
	 * @param AlarmVO a
	 * @throws InterruptedException
	 */
	@MessageMapping("/vacAlarm")
	public void vacAlarm(AlarmVO a) throws InterruptedException {
		log.info("기안 알람>> "+a);
		alarm(a, "기안");
	}
	
	/**
	 * 기업 내 모든 사용자에게 보내는 공지사항 알람
	 * @param AlarmVO a
	 * @throws InterruptedException
	 */
	@MessageMapping("/noticeAlarm")
	public void noticeAlarm(MsgVO msg) throws InterruptedException {
		String mess = String.format( "공지사항 " + "알람 왔어요");
		msg.setMemoCn(mess);
		msg.setMemoTtl("["+msg.getCstCdNm()+"]"+" 공지사항");
		
		List<UserVO> coUserList = this.msgServiceImpl.coUserList(msg);
		for(UserVO u:coUserList) {
			msg.setUserId(u.getUserId());
			this.msgServiceImpl.insertAlarmNotice(msg);
		}
		
		Thread.sleep(1000);
		this.simpMessageSendingOperations.convertAndSend("/sub/noticeAlarm",msg);
		log.info("msg>> "+msg);
	}
	
	/**
	 * 쪽지 알람
	 * @param a
	 * @throws InterruptedException
	 */
	@MessageMapping("/msg")
	public void AlarmMsg(AlarmVO a) throws InterruptedException {
		log.info("쪽지 알람>> "+a);
		alarm(a, "쪽지");
	}

	/**
	 * 메일 알람
	 * @param AlarmVO a
	 * @throws InterruptedException
	 */
	@MessageMapping("/mail")
	public void AlarmMail(AlarmVO a) throws InterruptedException {
		log.info("메일 알람>> "+a);
		Thread.sleep(2000);
		alarm(a, "메일");
	}

	/**
	 * 메신저 알람
	 * @param AlarmVO a
	 * @throws InterruptedException
	 */
	@MessageMapping("/chat")
	public void AlarmMessenger(AlarmVO a) throws InterruptedException {
		log.info("메신저 알람>> "+a);
		alarm(a, "매신저");
	}

	/**
	 * WebSocketHandler 처리한 userData를 footer에 보냄
	 */
	@MessageMapping("/userData")
	public void userData() {
		simpMessageSendingOperations.convertAndSend("/sub/userData", this.websocketHandler.getUser());
	}
	
	/**
	 * 채팅방 대화내역 DB 저장과 불러오기
	 * @param ChatMsgVO msg
	 * @throws InterruptedException 
	 */
	@MessageMapping("/chatRoom")
	public void chatRoom(ChatMsgVO msg) throws InterruptedException {
		if(msg.getUserId()!=null) this.chatServiceImpl.msgInsert(msg);
		List<ChatMsgVO> msgList = this.chatServiceImpl.msgList(msg);
		
		this.simpMessageSendingOperations.convertAndSend("/sub/chatRoom/"+msg.getChatRmNo(),msgList);
		
		String userId = msg.getUserId();
		if(userId==null&&userId.equals(""))return;
		ChatUserVO ul = new ChatUserVO();
		ul.setChatRmNo(msg.getChatRmNo());
		List<ChatUserVO> ulList = this.chatServiceImpl.userList(ul);
		List<ChatUserVO> temp = new ArrayList<ChatUserVO>();
		
		ChatUserVO me = new ChatUserVO();
		for(ChatUserVO ulVO:ulList) {
			if(ulVO.getUserId().equals(userId)) {
				me.setDeptNm(ulVO.getDeptNm());
				me.setCstCdNm(ulVO.getCstCdNm());
				me.setUserNm(ulVO.getUserNm());
			}else {
				temp.add(ulVO);
			}
		}
		
		for(ChatUserVO ulVO:temp) {
			String mess = String.format("%s %s %s님에게 메신저 왔어요", me.getDeptNm(), me.getCstCdNm(), me.getUserNm());
			Map<String,Object> map = new ConcurrentHashMap<String, Object>();
			map.put("msg", mess);
			this.simpMessageSendingOperations.convertAndSend("/sub/alarm/"+ulVO.getUserId(),map);
		}
	}
	
	/**
	 * 알람을 보내기 위한 공통 메서드
	 * @param AlaramVO a
	 * @param String s
	 * @throws InterruptedException
	 */
	private void alarm(AlarmVO a, String s) throws InterruptedException {
		log.info("알람>> "+a);
		log.info("알람 s>> "+s);
		Thread.sleep(1000);
		
		MsgVO m = new MsgVO();
		String mess = "";
		
		if (a == null) return;
		
		if(!(s.equals("")||s==null)) {
			if(s.equals("결재")||s.equals("결재완료")) mess = String.format("%s님에게 " + s + " 되었습니다", a.getSenderNm());
			else mess = String.format("%s님에게 " + s + " 왔어요", a.getSenderNm());
			m.setMemoCn(mess);
			m.setMemoTtl(s);
			m.setStatCd("MM006");
			m.setSender(a.getSender());
			m.setUserId(a.getUserId());
			log.info("알람 저장>> "+m);
			
			this.msgServiceImpl.insert(m);
		}
		List<MsgVO> mList = this.msgServiceImpl.listAlarm(m);
		List<MsgVO> mTemp = new ArrayList<MsgVO>();
		
		for(MsgVO mVO:mList) if(mVO.getStatCd().equals("MM006")||mVO.getStatCd().equals("MM007")) mTemp.add(mVO);
		
		Map<String,Object> map = new ConcurrentHashMap<String, Object>();
		map.put("msg", mess);
		map.put("alarm", mTemp);
		if(s!=null) map.put("drft",s);
		
		simpMessageSendingOperations.convertAndSend(String.format("/sub/alarm/%s", a.getUserId()), map);
		
	}
}
