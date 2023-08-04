package kr.or.ddit.ai.module.vehicle.vo;

import java.util.Date;

public class VehicleVO {
	private int vLogNo;
	private String vhclNo;
	private String vhclIo;
	private Date cgDt;

	public int getvLogNo() {
		return vLogNo;
	}

	public void setvLogNo(int vLogNo) {
		this.vLogNo = vLogNo;
	}

	public String getVhclNo() {
		return vhclNo;
	}

	public void setVhclNo(String vhclNo) {
		this.vhclNo = vhclNo;
	}

	public String getVhclIo() {
		return vhclIo;
	}

	public void setVhclIo(String vhclIo) {
		this.vhclIo = vhclIo;
	}

	public Date getCgDt() {
		return cgDt;
	}

	public void setCgDt(Date cgDt) {
		this.cgDt = cgDt;
	}

}
