package kr.or.ddit.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket Config
 * 
 * @author 김종명
 * @since 2023.06.26
 * @version 1.0
 * @see
 *
 * << 개정이력(Modification Information) >>
 *
 *   수정일     수정자           수정내용
 *  -------    --------    ---------------------------
 *  2023.06.26  김종명          최초 생성
 *  2023.07.17  김종명          chat endPoint 추가
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 웹소켓 입구와 출구 설정
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");
    }

    /**
     * 소켓 두개 설정
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
            .setAllowedOrigins("*")
            .withSockJS();

        registry.addEndpoint("/chat")
            .setAllowedOrigins("*")
            .withSockJS();
    }
}
