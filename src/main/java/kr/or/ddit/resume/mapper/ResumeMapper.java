package kr.or.ddit.resume.mapper;

import java.util.List;

import kr.or.ddit.resume.vo.ResumeVO;


public interface ResumeMapper {
   
   //이력서 리스트 값 읽어오기
   public List<ResumeVO> resumeList();
   
  
   
   //이력서 상세정보 읽어오기
   public ResumeVO resumeDetail(int rsmNo);
   
}