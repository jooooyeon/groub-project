package kr.or.ddit.mail.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * 메일 config
 * 
 * @author 김종명
 * @since 2023.07.10
 * @version 1.0
 * @see
 *
 * << 개정이력(Modification Information) >>
 *
 *   수정일     수정자           수정내용
 *  -------    --------    ---------------------------
 *  2023.07.10  김종명        최초 생성
 */
@Slf4j
@Configuration
@PropertySource("classpath:email.properties")
public class MailConfig {

	public MailConfig() throws IOException {
		log.info("EmailConfig.java constructor called");
	}

	/**
	 * 프로토콜 설정
	 */
	@Value("${spring.mail.transport.protocol}")
	private String protocol;

	/**
	 * 권한 설정
	 */
	@Value("${spring.mail.properties.mail.smtp.auth}")
	private boolean auth;

	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private boolean starttls;

	@Value("${spring.mail.debug}")
	private boolean debug;

	@Value("${spring.mail.host}")
	private String host;

	@Value("${spring.mail.port}")
	private int port;

	@Value("${spring.mail.username}")
	private String username;

	@Value("${spring.mail.password}")
	private String password;

	@Value("${spring.mail.default.encoding}")
	private String encoding;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 외부로 메일 보내기 설정
	 * @return JavaMailSender
	 */
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", protocol);
		properties.put("mail.smtp.auth", auth);
		properties.put("mail.smtp.starttls.enable", starttls);
		properties.put("mail.smtp.debug", debug);

		mailSender.setHost(host);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		mailSender.setPort(port);
		mailSender.setJavaMailProperties(properties);
		mailSender.setDefaultEncoding(encoding);

		return mailSender;
	}
}
