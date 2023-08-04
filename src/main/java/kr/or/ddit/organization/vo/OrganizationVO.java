package kr.or.ddit.organization.vo;

import lombok.Data;

@Data
public class OrganizationVO {
	
	private String userId;
	private String userNm;
	private String userTelno;
	private String userEml;
	private String userImg;
	private String deptNm;
	private String jbgdCd;
	private String jbtlCd;
	private String coId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserTelno() {
		return userTelno;
	}
	public void setUserTelno(String userTelno) {
		this.userTelno = userTelno;
	}
	public String getUserEml() {
		return userEml;
	}
	public void setUserEml(String userEml) {
		this.userEml = userEml;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getDeptNm() {
		return deptNm;
	}
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	public String getJbgdCd() {
		return jbgdCd;
	}
	public void setJbgdCd(String jbgdCd) {
		this.jbgdCd = jbgdCd;
	}
	public String getJbtlCd() {
		return jbtlCd;
	}
	public void setJbtlCd(String jbtlCd) {
		this.jbtlCd = jbtlCd;
	}
	public String getCoId() {
		return coId;
	}
	public void setCoId(String coId) {
		this.coId = coId;
	}
	
	@Override
	public String toString() {
		return "OrganizationVO [userId=" + userId + ", userNm=" + userNm + ", userTelno=" + userTelno + ", userEml="
				+ userEml + ", userImg=" + userImg + ", deptNm=" + deptNm + ", jbgdCd=" + jbgdCd + ", jbtlCd=" + jbtlCd
				+ ", coId=" + coId + "]";
	}
	
	
	
}
