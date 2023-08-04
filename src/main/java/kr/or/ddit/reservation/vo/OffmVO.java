package kr.or.ddit.reservation.vo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

/**
* 회의실 정보를 처리하기 위한 VO클래스
* @author 노태현
* @since 2023.07.21
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
 *   수정일      	수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.21  노태현          최초 생성
*
* </pre>
*/
public class OffmVO {

	private int offmNo;
	private String userId;
	private String coId;
	private String offmNm;
	private Date regDt;
	private String enabled;

	@Valid
	private List<OffmFxtrsVO> offmFxtrsVOList;

	public OffmVO() {
	}

	public int getOffmNo() {
		return offmNo;
	}

	public void setOffmNo(int offmNo) {
		this.offmNo = offmNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getOffmNm() {
		return offmNm;
	}

	public void setOffmNm(String offmNm) {
		this.offmNm = offmNm;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public List<OffmFxtrsVO> getOffmFxtrsVOList() {
		return offmFxtrsVOList;
	}

	public void setOffmFxtrsVOList(List<OffmFxtrsVO> offmFxtrsVOList) {
		this.offmFxtrsVOList = offmFxtrsVOList;
	}

	@Override
	public String toString() {
		return "OffmVO [offmNo=" + offmNo + ", userId=" + userId + ", coId=" + coId + ", offmNm=" + offmNm + ", regDt="
				+ regDt + ", enabled=" + enabled + ", offmFxtrsVOList=" + offmFxtrsVOList + "]";
	}


}
