package kr.or.ddit.mail.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * 메일 vo
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
@Data
public class MailVO implements Serializable {
	/**
	 * 메일 번호
	 */
	private int emlNo;
	
	/**
	 * 메일 휴지통/삭제/중요 알려주는 상태
	 */
	private String emlStts;
	/**
	 * 삭제 여부
	 */
	private String delYn;
	/**
	 * 삭제일시
	 */
	private String delDt;
	/**
	 * 수신자 이메일
	 */
	private String rcptnEml;
	/**
	 * 열람시각
	 */
	private String openDt;
	
	/**
	 * 발신자 이메일
	 */
	private String dsptchEml;
	/**
	 * 발신일시
	 */
	private String dsptchDt;
	/**
	 * 메일 제목
	 */
	private String emlTtl;
	/**
	 * 메일 내용
	 */
	private String emlCn;
	/**
	 * 보낸사람/숨은참조/참조에 대한 상태
	 */
	private String dsptchCd;
	
	/**
	 * 외부 메일로 발송한 txt
	 */
	private String txt;
	
	/**
	 * VO에서 받을 파일 목록
	 */
	private MultipartFile[] files;
	
	/**
	 * MailAtchVO의 List
	 */
	private List<MailAtchVO> mailAtchList;
	
	/**
	 * mybatis에서 설정할 query의 selectkey에 대한 에러 처리
	 */
	private int mailFlNo;
	
	/**
	 * 부서이름
	 */
	private String deptNm;
	/**
	 * 직급
	 */
	private String cstCdNm;
	/**
	 * 사용자 이름
	 */
	private String userNm;
	/**
	 * 코드 이름
	 */
	private String mngCdNm1;
	/**
	 * 수신자, 발신자 구분
	 */
	private String mailSort;
	/**
	 * 사용자 id
	 */
	private String userId;
	/**
	 * 메일함 분류
	 */
	private String sort;
	/**
	 * 사용자 이미지
	 */
	private String userImg;
}
