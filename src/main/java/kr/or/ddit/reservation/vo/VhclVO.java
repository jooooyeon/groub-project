package kr.or.ddit.reservation.vo;

import java.util.Date;

/**
* 차량에 관한 정보를 처리하기 위한 VO클래스
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
public class VhclVO {

	private String vhclNo;
	private String userId;
	private String coId;
	private int rdcpctCnt;
	private String vhclNm;
	private String vhclYmd;
	private String vhclMc;
	private String fuelType;
	private Date regDt;
	private String enabled;
	public String getVhclNo() {
		return vhclNo;
	}
	public void setVhclNo(String vhclNo) {
		this.vhclNo = vhclNo;
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
	public int getRdcpctCnt() {
		return rdcpctCnt;
	}
	public void setRdcpctCnt(int rdcpctCnt) {
		this.rdcpctCnt = rdcpctCnt;
	}
	public String getVhclNm() {
		return vhclNm;
	}
	public void setVhclNm(String vhclNm) {
		this.vhclNm = vhclNm;
	}
	public String getVhclYmd() {
		return vhclYmd;
	}
	public void setVhclYmd(String vhclYmd) {
		this.vhclYmd = vhclYmd;
	}
	public String getVhclMc() {
		return vhclMc;
	}
	public void setVhclMc(String vhclMc) {
		this.vhclMc = vhclMc;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
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

	@Override
	public String toString() {
		return "Vhcl [vhclNo=" + vhclNo + ", userId=" + userId + ", coId=" + coId + ", rdcpctCnt=" + rdcpctCnt
				+ ", vhclNm=" + vhclNm + ", vhclYmd=" + vhclYmd + ", vhclMc=" + vhclMc + ", fuelType=" + fuelType
				+ ", regDt=" + regDt + ", enabled=" + enabled + "]";
	}
}
