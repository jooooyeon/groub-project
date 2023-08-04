package kr.or.ddit.chat.vo;

import java.io.Serializable;

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
public class ChatUserVO implements Serializable {
	/**
	 * 대화방 관리번호
	 */
	private int chatRmNo;
	/**
	 * 사용자 아이디
	 */
	private String userId;
	/**
	 * 방장여부
	 */
	private String hostYn;
	/**
	 * 부서이름
	 */
	private String deptNm;
	/**
	 * 사용자 이름
	 */
	private String userNm;
	/**
	 * 사용자 직급
	 */
	private String cstCdNm;
	/**
	 * 사용자 사진
	 */
	private String userImg;
}
