package kr.or.ddit.resume.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author 이주연
 *
 */
@Data
public class ResumeVO {

	private int rsmNo;  //이력서 시퀀스(기본키)
	private Date rsmDt; //이력서 접수 일시
	private String rsmNm; //지원자 한글이름
	private int telno; //전화번호
	private String mailAddr; //메일주소
	private String addr; //주소
	private String mtrscCd; //병역이행여부
	private String resumeEdu; //학력사항
	private String image; //증명사진
	private String resumeMajor; //전공분야
	private String graduate; //졸업구분(대졸 고졸 등)
	private int resumeCareer; //경력연차
	private String resumeFile; //자기소개서파일
	private String resumeTp; //채용구분(신입/경력)
	private int deptNo; //채용부서
	private String rsmEgNm; //지원자 영문이름
	private String deptNoNm; //채용부서명
	/**
	 * 자격기술명
	 */
	private List<String> qnsinfNm;
	/**
	 * 경력사항
	 */
	private List<ResumeCareerVO> resumeCareerVO; 
	
	
	//자격증
	private List<ResumeCirtificationVO> resumeCirtificationVO;
	
}
