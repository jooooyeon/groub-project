package kr.or.ddit.schedule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.schedule.mapper.ScheduleMapper;
import kr.or.ddit.schedule.service.ScheduleService;
import kr.or.ddit.schedule.vo.ScheduleVO;

/**
* 일정 정보에 접근하는 서비스를 정의하기 위한 서비스 구현 클래스
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
@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	ScheduleMapper scheduleMapper;

	/**
	 * 전체 일정 조회
	 * @param userId
	 * @return 일정 목록
	 */
	@Override
	public List<ScheduleVO> listAll(String schdlTp) {
		return scheduleMapper.listAll(schdlTp);
	}


	/**
	 * 일정 등록
	 * @param scheduleVO 등록될 일정 정보
	 */
	@Override
	public int registSchdl(ScheduleVO scheduleVO) {
		return scheduleMapper.registSchdl(scheduleVO);
	};

	/**
	 * 일정 시간 변경
	 * @param scheduleVO 변경될 일정 정보
	 */
	@Override
	public int dragDropUpdate(ScheduleVO scheduleVO) {;
		return scheduleMapper.dragDropUpdate(scheduleVO);
	}

	/**
	 * 일정 삭제
	 * @param schdlNo 삭제될 일정 번호
	 */
	public int deleteSchdl(String schdlNo) {
		return scheduleMapper.deleteSchdl(schdlNo);
	};
}
