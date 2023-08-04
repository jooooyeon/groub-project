package kr.or.ddit.servey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.security.CustomUser;
import kr.or.ddit.servey.mapper.ServeyMapper;
import kr.or.ddit.servey.vo.ServeyOptionVO;
import kr.or.ddit.servey.vo.ServeyQItemVO;
import kr.or.ddit.servey.vo.ServeyResponseVO;
import kr.or.ddit.servey.vo.ServeyVO;
import kr.or.ddit.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServeyServiceImpl {

	@Autowired
	private ServeyMapper serveyMapper;
	
	@Transactional
	public int serveyInsert(ServeyVO s) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUser cus = (CustomUser) auth.getPrincipal();
		UserVO user = cus.getUserVO();
		
		s.setUserId(user.getUserId());
		s.setCoId(user.getCoId());
		
		int rlt = this.serveyMapper.serveyInsert(s);
		
		List<ServeyQItemVO> qItemList = s.getServeyQItemVOList();
		
		for(int i=0; i<qItemList.size();i++) {
			rlt += this.serveyMapper.serveyQItemInsert(qItemList.get(i));
			rlt += this.serveyMapper.serveyOptionInsert(qItemList.get(i));
		}
		
		log.info("result>> "+rlt);
		
		return rlt;
	}
	
	
	public List<ServeyVO> serveyList(){
		return this.serveyMapper.serveyList();
	}
	
	/**
	 * 설문지 상세보기(하나의 설문지로 만들기)
	 * @param int srvyNo
	 * @return ServeyVO
	 */
	public ServeyVO serveyDetail(int srvyNo) {
		//설문지 받아오기
		ServeyVO s = this.serveyMapper.serveyDetail(srvyNo);
		//전체 인원 수 받아오기
		s.setTotalUser(this.serveyMapper.totalUser(srvyNo));
		log.info("s>> "+s);
		
		//가라 List
		List<ServeyQItemVO> qItemList = s.getServeyQItemVOList();
		List<ServeyQItemVO> temp = new ArrayList<ServeyQItemVO>();
		//전체 설문질문 받아오기
		for(ServeyQItemVO sQItem:qItemList) {
			log.info("sQItem>> "+sQItem);
			//설문질문 속 각각의 질문으로, 설문질문 받아오고 vo 속에 보기 넣기
			for(ServeyOptionVO sOption:sQItem.getServeyOptionVOList()) {
				sOption.setSelectUser(this.serveyMapper.selectUser(sOption));
				log.info("sOption>> "+sOption);
			}
			//설문지에 대한 전체 설문질문과 각각의 질문에 맞는 문항 세팅이 끝난 것은 List<ServeyQItemVO> temp 속에 담기
			temp.add(sQItem);
		}
		log.info("temp>> "+temp);
		//설문지 완성!
		s.setServeyQItemVOList(temp);
		return s;
	}
	
	
	/**
	 * 설문 질문 상세보기
	 * @param int srvyNo
	 * @return List<ServeyQItemVO>
	 */
	public List<ServeyQItemVO> serveyDetailQuestion(int srvyNo) {
		return this.serveyMapper.serveyDetailQuestion(srvyNo);
	}


	/**
	 * 설문 보기
	 * @param i
	 * @return List<ServeyOptionVO>
	 */
	public List<ServeyOptionVO> serveyDateilBoki(int i) {
		return this.serveyMapper.serveyDateilBoki(i);
	}
	
	
	
	/**
	 * 설문 답변
	 * @param serveyResponseVO
	 * @return INT
	 */
	public int serveyAnswer(ServeyResponseVO serveyResponseVO) {
		return this.serveyMapper.serveyAnswer(serveyResponseVO);
	}
	
}
