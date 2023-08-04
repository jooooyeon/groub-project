package kr.or.ddit.reservation.vo;

/**
* 회의실에 포함되는 자산 정보를 처리하기 위한 VO클래스
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
public class OffmFxtrsVO {

	private int oFxtrsNo;
	private int offmNo;
	private String fxtrsNm;
	private String fxtrsExpln;
	public int getoFxtrsNo() {
		return oFxtrsNo;
	}
	public void setoFxtrsNo(int oFxtrsNo) {
		this.oFxtrsNo = oFxtrsNo;
	}
	public int getOffmNo() {
		return offmNo;
	}
	public void setOffmNo(int offmNo) {
		this.offmNo = offmNo;
	}
	public String getFxtrsNm() {
		return fxtrsNm;
	}
	public void setFxtrsNm(String fxtrsNm) {
		this.fxtrsNm = fxtrsNm;
	}
	public String getFxtrsExpln() {
		return fxtrsExpln;
	}
	public void setFxtrsExpln(String fxtrsExpln) {
		this.fxtrsExpln = fxtrsExpln;
	}

	@Override
	public String toString() {
		return "OffmFxtrsVO [oFxtrsNo=" + oFxtrsNo + ", offmNo=" + offmNo + ", fxtrsNm=" + fxtrsNm + ", fxtrsExpln="
				+ fxtrsExpln + "]";
	}

}
