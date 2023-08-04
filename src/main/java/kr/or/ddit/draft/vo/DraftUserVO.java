package kr.or.ddit.draft.vo;

import java.util.List;

import lombok.Data;

/**
 * @author 정시윤
 * 기안에 사용할 유저VO
 */
@Data
public class DraftUserVO {
	/**
	 * 사용자 아이디
	 */
	private String userId;
	/**
	 * 사용자의 기업 아이디
	 */
	private String coId;
	/**
	 * 사용자명
	 */
	private String userNm;
	/**
	 * 사용자의 이메일 주소
	 */
	private String userEml;
	/**
	 * 사용자의 증명사진
	 */
	private String userImg;
	/**
	 * 사용자의 사인 이미지
	 */
	private String signImg;
	
	/**
	 * 사용자의 부서번호
	 */
	private int deptNo;
	
	/**
	 * 부서번호에 해당하는 부서명
	 */
	private String deptNm;
	
	/**
	 * 사용자의 직급 코드
	 */
	private String jbgdCd;
	/**
	 * 직급 코드에 해당하는 직급명
	 */
	private String jbgdNm;
	
	/**
	 * 사용자의 직책 코드
	 */
	private String jbtlCd;
	/**
	 * 직책 코드에 해당하는 직책 명
	 */
	private String jbtlNm;
	
	/**
	 * 선택한 유저에 대한 휴가 정보 리스트
	 */
	private List<DraftVacVO> draftVacVOList;
	
	
}
