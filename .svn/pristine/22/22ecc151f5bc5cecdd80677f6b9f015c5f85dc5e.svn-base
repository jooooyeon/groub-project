package kr.or.ddit.draft.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.util.GroubUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class DraftVO {
	
	/**
	 * 기안 번혼
	 */
	private int drNo;
	
	/**
	 * 기안을 작성한 사용자 아이디
	 */
	private String userId;
	
	/**
	 * 기안을 작성한 사용자 명
	 */
	private String userNm;
	/**
	 * 기안을 작성한 사용자의 부서명
	 */
	private String deptNm;
	
	/**
	 * 기안의 현재 상태(진행중/ 완료/ 임시저장) 
	 */
	private String drSttsCd;
	
	/**
	 * 기안 최종 처리 일시
	 */
	private Date fnshDt;
	
	/**
	 * 기안 문서의 제목
	 */
	private String drftTitle;
	
	/**
	 * 기안 문서 작성 일자
	 */
	private Date drDt;
	
	/**
	 * 기안 문서 작성 일자(yyyy-MM-dd 형식)
	 */
	private String drDtFm1;
	
	/**
	 * 기안 문서 작성 일자(yyyy-MM-dd HH24:mm:ss 형식)
	 */
	private String drDtFm2;
	
	/**
	 * 기안 문서 삭제 여부
	 */
	private String delYn;
	
	/**
	 * 기안 문서 삭제 일자
	 */
	private Date delDt;
	
	/**
	 * 기안 문서내 기안 의견 번호
	 */
	private int drOpnNo;
	
	/**
	 * 기안 문서내 휴가 사용 번호
	 */
	private int vacUseNo;
	
	/**
	 * 기안 문서내 첨부파일 번호
	 */
	private int drftFlNo;
	
	private String drSttsCdTemp;
	
	/**
	 * 기안 문서가 작성된 HTML 코드
	 */
	private String drStrg;
	
	/**
	 * 휴가 기안의 휴가 내용
	 */
	private DraftVacVO draftVacVO;
	
	/**
	 * 기안 문서에 등록된 첨부파일 배열
	 */
	private MultipartFile[] attachFiles;
	
	/**
	 * 기안의 첨부파일 리스트
	 */
	private List<DraftAttachVO> draftAttachVOList;
	
	/**
	 * 기안의 의견 리스트
	 */
	private List<DraftOpnVO> draftOpnVOList;
	/**
	 * 기안의 결재권자 리스트
	 */
	private List<DraftAtrzVO> draftAtrzVOList;
	
	
	/**
	 * 기안 문서 작성일을 yyyy:MM:dd 의 포맷으로 바꿔서 출력
	 * @return yyyy-MM-dd
	 */
	public String getShowDrDtForm1() {
		return GroubUtils.year2String(drDt);
	}
	
	/**
	 * 기안 문서의 drDtFm1을 yyyy:MM:dd 형태로 저장한다
	 */
	public void setDrDtForm1() {
		this.drDtFm2 = GroubUtils.year2String(drDt);
	}
	
	/**
	 * 기안 문서 작성일을 yyyy-MM-dd HH:mm:ss 의 포맷으로 바꿔서 출력
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public String getShowDrDtForm2() {
		return GroubUtils.year2String2(drDt);
	}
	
	/**
	 * 기안 문서의 drDtFm2을 yyyy-MM-dd HH:mm:ss 형태로 저장한다
	 */
	public void setDrDtForm2() {
		this.drDtFm2 = GroubUtils.year2String2(drDt);
	}
	
	public String getMakeYMD(Date date) {
		return GroubUtils.year2String(date);
	}
	public String getMakeYMDHMS(Date date) {
		return GroubUtils.year2String2(date);
	}
	
}
