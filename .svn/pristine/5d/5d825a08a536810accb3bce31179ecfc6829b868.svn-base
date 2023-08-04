package kr.or.ddit.draft.vo;

import java.util.Date;

import kr.or.ddit.util.GroubUtils;
import lombok.Data;

/**
 * @author 정시윤
 * 기안에 속한 결재
 */
@Data
public class DraftAtrzVO {
	
	/**
	 * 결재의 순번을 구분
	 */
	private int atrzSn;
	
	private int drNo;
	/**
	 * 결재권자의 아이디
	 */
	private String userId;
	
	/**
	 * 결재권자의 이름
	 */
	private String userNm;
	
	/**
	 * 결재권자의 부서명
	 */
	private String deptNm;
	
	/**
	 * 결재권자의 직급명
	 */
	private String jbgdNm;
	
	/**
	 * 결재권자의 사진
	 */
	private String userImg;
	
	/**
	 * 결재권자의 사인 이미지
	 */
	private String signImg;
	
	private int maxAtrzSn;
	
	/**
	 * 결재자/ 수신자/ 회람자/ 대결자 등의 역할을 의미
	 */
	private String atrzCd;
	/**
	 * 승인 / 반려와 같은 결재 상태 코드
	 */
	private String atrzSttsCd;
	/**
	 * 결재 상태 코드 명
	 */
	private String atrzSttsNm;
	
	/**
	 * 결재, 반려 등을 시행한 일시
	 */
	private Date atrzDt;
	
	/**
	 * 결재, 반려 등을 시행한 일시(yyyy-MM-dd)
	 */
	private String atrzDtFm;
	
	/**
	 * 결재, 반려 등을 시행한 일시(yyyy-MM-dd) 바꿔준다
	 */
	public String getAtrzDtForm() {
		if (this.atrzDt != null) {
			return GroubUtils.year2String(this.atrzDt);
		}
		return null;
	}
	
	/**
	 * 결재, 반려 등을 시행한 일시(yyyy-MM-dd) 바꿔준다
	 */
	public void setAtrzDtForm() {
		this.atrzDtFm = GroubUtils.year2String(atrzDt);
	}
}
