package kr.or.ddit.empinfo.vo;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.bbscommon.BbsAtchVO;
import lombok.Data;
@Data
public class EmpInfoVO {
	
	//USERS
	private String userId; //기본키
	private String coId; //기업아이디(기업에서 직접 지정)
	private String userPswd; //사원계정 비밀번호
	private String userNm; //사용자이름
	private String userTelno; //핸드폰번호
	private String userEml; //메일주소
	private Date brthYmd; //생년월일
	private String userZip; //우편번호
	private String userAddr; //주소
	private String userDaddr; //상세주소
	private String userImg; //사진
	private String signImg; //서명사진
	private String gndrMf; //성별(남M,여W)
	private String hobby; //취미
	private String spcabl; //특기
	private String msngrStts; //메신저 상태 
	private String enabled; //해당아이디사용여부(1:사용, 0:비사용)
	private String mngrYn; //관리자여부 판단(Y:관리자, N:일반사용지)
	
	
	//EMP_INFO
	//private String userId; //기본키(emp_info)회원아이다(기업코드_사번)
	private int deptNo; //부서(Dept)테이블의 기본키를 받아오는 외래키 
	private String jbgdCd; //직급코드(공통코드)
	private String jbgdCdNm; //직급코드(공통코드)
	private String jbtlCd; //직무코드(공통코드)
	private String jbtlCdNm; //직무코드(공통코드)
	private int anslry; //연봉
	private String bankNm; //은행
	private long actNo; //계좌번호
	private Date jncmpYmd; //입사일
	private Date rsgntnYmd; //퇴사일
	private String hdofCd; //재직상태
	private String hdofCdNm; //재직상태
	private String mtrscCd; //병역이행여부
	private String mtrscCdNm; //병역이행여부
	
	//CO_INFO
	private String coNm; //기업명
	
	private String deptNm; //부서명
	
//	private MultipartFile[] files;
//	
//	private MultipartFile personpic;
	
	//인사이력
	private List<HrRcrdVO> hrRcrdVO;
	//가족정보
	private List<FamVO> famVO;
	//자격증정보
	private List<EmpInfoCertificationVO> empInfoCertificationVO;
	////공통코드 중 가족 관계 
	private List<FamManageCodeVO> famManageCodeVO;
}



