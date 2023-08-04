package kr.or.ddit.resume.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.resume.mapper.ResumeMapper;
import kr.or.ddit.resume.service.ResumeService;
import kr.or.ddit.resume.vo.ResumeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResumeServiceImpl implements ResumeService {

   @Inject
   ResumeMapper resumeMapper;

   
	//이력서 리스트 값 읽어오기
	@Override
	public List<ResumeVO> resumeList() {
		return this.resumeMapper.resumeList();
	}


   //이력서 상세정보 읽어오기
	@Override
	public ResumeVO resumeDetail(int rsmNo) {
		return this.resumeMapper.resumeDetail(rsmNo);
	}
   
   
 
}