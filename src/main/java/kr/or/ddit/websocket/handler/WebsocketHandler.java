package kr.or.ddit.websocket.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 김종명
 *
 */
@Slf4j
@Component
public class WebsocketHandler implements Serializable {

	/**
	 * 메세지 보내는 클래스 불러옴
	 */
	@Autowired
	private SimpMessagingTemplate simpleMessagingTemplate;

	/**
	 * user에 대한 정보를 담은 map
	 */
	private Map<String, List<String>> user = new ConcurrentHashMap<>();
	/**
	 * user의 webSocketSession 정보를 담은 map
	 */
	private Map<String, String> userSession = new ConcurrentHashMap<String, String>();

	public Map<String, String> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, String> userSession) {
		this.userSession = userSession;
	}

	public Map<String, List<String>> getUser() {
		return user;
	}

	public void setUser(Map<String, List<String>> user) {
		this.user = user;
	}

	/**
	 * Session이 연결될 때, user, userSession Map에 클라이언트에 보낼 데이터 세팅하기
	 * @param SessionConnectEvent event
	 * @throws InterruptedException
	 */
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectEvent event) throws InterruptedException {
		UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) event.getUser();
		CustomUser customUser = (CustomUser) authenticationToken.getPrincipal();
		UserVO user = (UserVO) customUser.getUserVO();
		String userId = user.getUserId();
		String userNm = user.getUserNm();
		String userEml = user.getUserEml();
		String deptNm = user.getDeptNm();
		String jbgdNm = user.getJbgdNm();
		
		List<String> userData = new ArrayList<String>();
		
		userData.add(deptNm);
		userData.add(userNm);
		userData.add(jbgdNm);
		userData.add(userEml);
		userData.add(userId);
		
		this.user.put(userId,userData);
		
		SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
		String sessionId = headers.getSessionId();
		
		this.userSession.put(userId,sessionId);
	}

	/**
	 * Session이 끊길 때, user, userSession Map에서 등록된 userId 제거하고 클라이언트로 데이터 보내주기
	 * @param SessionDisconnectEvent event
	 */
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) event.getUser();
		CustomUser customUser = (CustomUser) authenticationToken.getPrincipal();
		UserVO user = (UserVO) customUser.getUserVO();
		String userId = user.getUserId();
		
		this.user.remove(userId);
		this.userSession.remove(userId);

		simpleMessagingTemplate.convertAndSend("/sub/userData", this.user);
		simpleMessagingTemplate.convertAndSend("/sub/userList", this.userSession);
	}
}
