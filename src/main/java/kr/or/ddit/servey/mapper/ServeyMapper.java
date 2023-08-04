package kr.or.ddit.servey.mapper;

import java.util.List;

import kr.or.ddit.servey.vo.ServeyOptionVO;
import kr.or.ddit.servey.vo.ServeyQItemVO;
import kr.or.ddit.servey.vo.ServeyResponseVO;
import kr.or.ddit.servey.vo.ServeyVO;

public interface ServeyMapper {
	/**
	 * 설문조사 등록
	 * @param ServeyVO s
	 * @return int
	 */
	public int serveyInsert(ServeyVO s);
	
	/**
	 * 설문지 등록
	 * @param ServeyVO s
	 * @return int
	 */
	public int serveyQOptionInsert(ServeyVO s);
	
	/**
	 * 설문지 질문
	 * @param ServeyVO s
	 * @return int
	 */
	public int serveyQItemInsert(ServeyQItemVO serveyQItemVO);	
	
	/**
	 * 설문지 질문에 딸린 설문지 내용
	 * @param ServeyQItemVO s
	 * @return int
	 */
	public int serveyOptionInsert(ServeyQItemVO s);
	
	
	/**
	 * 설문지 목록
	 * @return List<ServeyVO>
	 */
	public List<ServeyVO> serveyList();
	
	
	/**
	 * 설문 기본정보
	 * @param s
	 * @return int
	 */
	public ServeyVO serveyDetail(int s);
	
	/**
	 * 설문 문항
	 * @param s
	 * @return List<ServeyQItemVO>
	 */
	public List<ServeyQItemVO> serveyDetailQuestion(int s);
	
	/**
	 * 설문지의 보기 문항
	 * @param i
	 * @return List<ServeyOptionVO>
	 */
	public List<ServeyOptionVO> serveyDateilBoki(int i);
	
	/**
	 * 설문지 선택 답변
	 * @param serveyResponseVO
	 * @return int
	 */
	public int serveyAnswer(ServeyResponseVO serveyResponseVO);
	
	/**
	 * 설문 문항 옵션 사용자 수
	 * @param ServeyOptionVO sOpt
	 * @return int
	 */
	public int selectUser(ServeyOptionVO sOpt);
	
	/**
	 * 설문지 이용 전체 사용자 수
	 * @param int srvyNo
	 * @return int
	 */
	public int totalUser(int srvyNo);
}
