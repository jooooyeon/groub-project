package kr.or.ddit.schedule.service;

import java.util.List;

import kr.or.ddit.schedule.vo.ScheduleVO;

/**
* 일정 정보에 접근하는 서비스를 정의하기 위한 서비스 인터페이스
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
public interface ScheduleService {

	/**
	 * 전체 일정 조회
	 * @param userId
	 * @return 일정 목록
	 */
	public List<ScheduleVO> listAll(String schdlTp);


	/**
	 * 일정 등록
	 * @param scheduleVO 등록될 일정 정보
	 */
	public int registSchdl(ScheduleVO scheduleVO);

	/**
	 * 일정 시간 변경
	 * @param scheduleVO 변경될 일정 정보
	 */
	public int dragDropUpdate(ScheduleVO scheduleVO);

	/**
	 * 일정 삭제
	 * @param schdlNo 삭제될 일정 번호
	 */
	public int deleteSchdl(String schdlNo);

}
