package kr.or.ddit.mail.vo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * 메일 첨부파일 vo
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
public class MailAtchVO implements Serializable {

	/**
	 * 첨부파일 관리번호
	 */
	private int mailFlNo;
	/**
	 * 파일 이름
	 */
	private String fileNm;
	/**
	 * 파일 이름 중복방지
	 */
	private String fileUuid;
	/**
	 * 파일 경로
	 */
	private String filePath;
	/**
	 * 확장자명
	 */
	private String fileExtn;
	/**
	 * 파일 크기
	 */
	private String fileSize;
	/**
	 * 메일 관리번호
	 */
	private int emlNo;
	/**
	 * 파일
	 */
	private MultipartFile file;

}
