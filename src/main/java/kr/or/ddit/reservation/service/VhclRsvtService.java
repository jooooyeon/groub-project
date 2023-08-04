package kr.or.ddit.reservation.service;

import java.util.List;

import kr.or.ddit.reservation.vo.VhclRsvtVO;
import kr.or.ddit.reservation.vo.VhclVO;
import kr.or.ddit.user.vo.UserVO;


public interface VhclRsvtService {
	/* 차량 예약 목록 조회 */
	public List<VhclRsvtVO> getRsvtList(UserVO userVO) throws Exception;

	/* 차량번호별 목록 조회 */
	public List<VhclRsvtVO> getRsvtListVchlNo(String vhclNo) throws Exception;

	/* 예약 중복 조회 */
	public List<VhclRsvtVO> reserveCheck(VhclRsvtVO vhclRsvtVO) throws Exception;

	/* 차량 예약 등록 */
	public int insert(VhclRsvtVO VhclRsvtVO) throws Exception;

	/* 예약 삭제 */
	public int delete(String vRsvtNo) throws Exception;

	/*예약 시간 변경*/
	public int update(VhclRsvtVO VhclRsvtVO) throws Exception;

	/* 차량 목록 조회 */
	public List<VhclVO> getVhcl(UserVO userVO) throws Exception;

	/* 내 예약현황 조회. 현재 시간 이후 예약 */
	public List<VhclRsvtVO> getMylistFute(String userId) throws Exception;

	/* 내 예약현황 조회. 현재 진행 예약 */
	public List<VhclRsvtVO> getMylistIng(String userId) throws Exception;

	/* 내 예약현황 조회. 현재 시간 이전 예약 */
	public List<VhclRsvtVO> getMylistEnd(String userId) throws Exception;

	/* 내 예약현황 조회. 당일예약 */
	public List<VhclRsvtVO> getMylistToday(String userId) throws Exception;

}
