package kr.or.ddit.resume.service;

import java.util.List;

import kr.or.ddit.resume.vo.ResumeVO;

public interface ResumeService {

	//이력서 리스트 값 읽어오기
	public List<ResumeVO> resumeList();
	

   //이력서 상세정보 읽어오기
   public ResumeVO resumeDetail(int resumeVO);
   
}