package kr.or.ddit.reservation.service;

import java.util.List;

import kr.or.ddit.reservation.vo.OffmRsvtVO;
import kr.or.ddit.reservation.vo.OffmVO;
import kr.or.ddit.user.vo.UserVO;

public interface OffmlRsvtService {

	/*회사별 회의실 정보*/
	public List<OffmVO> getOffmList(String coId) throws Exception;

	/* 회사별 회의실 예약 목록 조회 */
	public List<OffmRsvtVO> getRsvtList(UserVO userVO) throws Exception;

	/* 회사별 회의실 예약 목록 조회 */
	public List<OffmRsvtVO> getRsvtListOffmNo(String offmNo) throws Exception;

	/* 회의실 예약 등록 */
	public int insert(OffmRsvtVO offmRsvtVO) throws Exception;

	/* 예약 삭제 */
	public int delete(String oRsvtNo) throws Exception;

	/* 예약 중복 조회 */
	public List<OffmRsvtVO> reserveCheck(OffmRsvtVO offmRsvtVO) throws Exception;

	/* 내 예약현황 조회. 현재 시간 이후 예약 */
	public List<OffmRsvtVO> getMylistFute(String userId) throws Exception;

	/* 내 예약현황 조회. 현재 진행 예약 */
	public List<OffmRsvtVO> getMylistIng(String userId) throws Exception;

	/* 내 예약현황 조회. 현재 시간 이전 예약 */
	public List<OffmRsvtVO> getMylistEnd(String userId) throws Exception;

	/* 내 예약현황 조회. 당일 예약 */
	public List<OffmRsvtVO> getMylistToday(String userId) throws Exception;

}
