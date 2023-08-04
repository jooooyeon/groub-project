package kr.or.ddit.notice.vo;

import java.util.Date;

import lombok.Data;


public class PstHdVO {
	private String cstCd; //공통그룹코드와 3자리 일련번호의 합
	private String coId; //공통코드를 사용하는 기업의 아이디
	private String grCd; //공통코드가 속하는 분류의 코드
	private String cstCdNm; //각 기업에서 입력한 코드의 이름
	private String userId; //공통코드를 등록한 사용자의 아이디
	private Date regDt; //공통코드를 등록한 일시
	private String useYn; //Y:사용, N:사용안함
	
	public PstHdVO() {
	}

	public String getCstCd() {
		return cstCd;
	}

	public void setCstCd(String cstCd) {
		this.cstCd = cstCd;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getGrCd() {
		return grCd;
	}

	public void setGrCd(String grCd) {
		this.grCd = grCd;
	}

	public String getCstCdNm() {
		return cstCdNm;
	}

	public void setCstCdNm(String cstCdNm) {
		this.cstCdNm = cstCdNm;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	@Override
	public String toString() {
		return "PstHdVO [cstCd=" + cstCd + ", coId=" + coId + ", grCd=" + grCd + ", cstCdNm=" + cstCdNm + ", userId="
				+ userId + ", regDt=" + regDt + ", useYn=" + useYn + "]";
	}
	
	
	
}
