package kr.or.ddit.attendance.vo;

import java.util.Date;

//자바빈 클래스
//1)멤버변수 2)기본생성자 3)getter/setter메소드
public class AttendanceVO {
	//근태번호
	private int dclzNo;
	//회원아이디
	private String userId;
	//출근일시
	private Date attendDt;
	
	private String attendDt2;
	
	private int workHm;
	private int workH;
	private int workM;
	
	
	//퇴근일시
	private Date lvffcDt;
	//근무구분
	private String dclzSttsCd;
	
	//기본생성자
	public AttendanceVO() {
		
	}

	public int getDclzNo() {
		return dclzNo;
	}

	public void setDclzNo(int dclzNo) {
		this.dclzNo = dclzNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getAttendDt() {
		return attendDt;
	}

	public void setAttendDt(Date attendDt) {
		this.attendDt = attendDt;
	}

	public Date getLvffcDt() {
		return lvffcDt;
	}

	public void setLvffcDt(Date lvffcDt) {
		this.lvffcDt = lvffcDt;
	}

	public String getDclzSttsCd() {
		return dclzSttsCd;
	}

	public void setDclzSttsCd(String dclzSttsCd) {
		this.dclzSttsCd = dclzSttsCd;
	}
	
	

	public String getAttendDt2() {
		return attendDt2;
	}

	public void setAttendDt2(String attendDt2) {
		this.attendDt2 = attendDt2;
	}

	public int getWorkHm() {
		return workHm;
	}

	public void setWorkHm(int workHm) {
		this.workHm = workHm;
	}

	public int getWorkH() {
		return workH;
	}

	public void setWorkH(int workH) {
		this.workH = workH;
	}

	public int getWorkM() {
		return workM;
	}

	public void setWorkM(int workM) {
		this.workM = workM;
	}

	@Override
	public String toString() {
		return "AttendanceVO [dclzNo=" + dclzNo + ", userId=" + userId + ", attendDt=" + attendDt + ", attendDt2="
				+ attendDt2 + ", workHm=" + workHm + ", lvffcDt=" + lvffcDt + ", dclzSttsCd=" + dclzSttsCd + "]";
	}


	
	

}
