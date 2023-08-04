package kr.or.ddit.user.vo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import lombok.Data;

/**
* 그룹웨어 사용자 인사정보를 처리하기위한 VO클래스
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
public class UserEmpVO {
	private String userId;
	private String userPswd;
	private String coId;
	private String enabled;
	private String userNm;
	private String userTelno;
	private String userEml;
	private Date brthYmd;
	private String userZip;
	private String userAddr;
	private String userDaddr;
	private String userImg;
	private String signImg;
	private String gndrMf;
	private String hobby;
	private String spcabl;
	private String msngrStts;
	private String mngrYn;
	private String deptNo;
	private String jbgdCd;
	private String jbtlCd;

	@Valid
	private List<UsersAuthVO> usersAuthVOList;

	public UserEmpVO() {
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPswd() {
		return userPswd;
	}

	public void setUserPswd(String userPswd) {
		this.userPswd = userPswd;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
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

	public Date getBrthYmd() {
		return brthYmd;
	}

	public void setBrthYmd(Date brthYmd) {
		this.brthYmd = brthYmd;
	}

	public String getUserZip() {
		return userZip;
	}

	public void setUserZip(String userZip) {
		this.userZip = userZip;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserDaddr() {
		return userDaddr;
	}

	public void setUserDaddr(String userDaddr) {
		this.userDaddr = userDaddr;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getSignImg() {
		return signImg;
	}

	public void setSignImg(String signImg) {
		this.signImg = signImg;
	}

	public String getGndrMf() {
		return gndrMf;
	}

	public void setGndrMf(String gndrMf) {
		this.gndrMf = gndrMf;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSpcabl() {
		return spcabl;
	}

	public void setSpcabl(String spcabl) {
		this.spcabl = spcabl;
	}

	public String getMsngrStts() {
		return msngrStts;
	}

	public void setMsngrStts(String msngrStts) {
		this.msngrStts = msngrStts;
	}

	public String getMngrYn() {
		return mngrYn;
	}

	public void setMngrYn(String mngrYn) {
		this.mngrYn = mngrYn;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
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

	public List<UsersAuthVO> getUsersAuthVOList() {
		return usersAuthVOList;
	}

	public void setUsersAuthVOList(List<UsersAuthVO> usersAuthVOList) {
		this.usersAuthVOList = usersAuthVOList;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPswd=" + userPswd + ", coId=" + coId + ", enabled=" + enabled
				+ ", userNm=" + userNm + ", userTelno=" + userTelno + ", userEml=" + userEml + ", brthYmd=" + brthYmd
				+ ", userZip=" + userZip + ", userAddr=" + userAddr + ", userDaddr=" + userDaddr + ", userImg="
				+ userImg + ", signImg=" + signImg + ", gndrMf=" + gndrMf + ", hobby=" + hobby + ", spcabl=" + spcabl
				+ ", msngrStts=" + msngrStts + ", mngrYn=" + mngrYn + ", deptNo=" + deptNo + ", jbgdCd=" + jbgdCd
				+ ", jbtlCd=" + jbtlCd + ", usersAuthVOList=" + usersAuthVOList + "]";
	}


}
