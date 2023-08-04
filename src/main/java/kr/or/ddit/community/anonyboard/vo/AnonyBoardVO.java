package kr.or.ddit.community.anonyboard.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.bbscommon.BbsAtchVO;
import lombok.Data;

@Data
public class AnonyBoardVO  {
	private int pstNo; //게시물 관리번호
	private String userId; //기업코드_사원번호 이루어진 회원 아이디
	private String coId; //글을 작성한 회원의 기업
	private String delrNm; //회원아이디_게시물 삭제자
	private String mdfrNm; //회원아이디_게시물 마지막 수정자
	private String pstHd;//게시물 머리말
	private List<AnonyPstHdVO> pstHdVO; 
	private String pstTtl; //게시물 제목
	private String pstCn; //게시물 내용
	private Date regDt; //게시물 등록일
	private Date mdfcnDt; //게시물 마지막 수정일
	private int inqCnt; //게시물 열람 횟수
	private String bbsClsf; //게시판 분류
	private String tempYn; //게시물 임시저장 여부 Y/N
	private String delYn; //게시물 삭제 여부 Y/N
	private Date delDt; //게시물 삭제일
	
	private String userNm; //사용자이름
	private String cstCdNm; 
	private String headerAsKor; //말머리
	
	
	private MultipartFile[] attachFiles; //첨부파일
	
	private List<BbsAtchVO> bbsAtchVO; //게시판 첨부파일



	
	
	
	
	
	
	
	
	
	
}
