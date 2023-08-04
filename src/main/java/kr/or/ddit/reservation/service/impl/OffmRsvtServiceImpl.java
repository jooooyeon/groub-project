package kr.or.ddit.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.reservation.mapper.OffmRsvtMapper;
import kr.or.ddit.reservation.service.OffmlRsvtService;
import kr.or.ddit.reservation.vo.OffmRsvtVO;
import kr.or.ddit.reservation.vo.OffmVO;
import kr.or.ddit.user.vo.UserVO;

@Service
public class OffmRsvtServiceImpl implements OffmlRsvtService{

	@Autowired
	private OffmRsvtMapper offmRsvtMapper;

	@Override
	public List<OffmVO> getOffmList(String coId) throws Exception {
		return offmRsvtMapper.getOffmList(coId);
	}

	/* 회사별 회의실 예약 목록 조회 */
	@Override
	public List<OffmRsvtVO> getRsvtList(UserVO userVO) throws Exception{
		return offmRsvtMapper.getRsvtList(userVO);
	};

	/* 회사별 회의실 예약 목록 조회 */
	@Override
	public List<OffmRsvtVO> getRsvtListOffmNo(String offmNo) throws Exception{
		return offmRsvtMapper.getRsvtListOffmNo(offmNo);
	};

	/* 회의실 예약 등록 */
	@Override
	public int insert(OffmRsvtVO offmRsvtVO) throws Exception{
		return offmRsvtMapper.insert(offmRsvtVO);
	};

	/* 예약 삭제 */
	public int delete(String oRsvtNo) throws Exception{
		return offmRsvtMapper.delete(oRsvtNo);
	};

	/* 예약 중복 조회 */
	@Override
	public List<OffmRsvtVO> reserveCheck(OffmRsvtVO offmRsvtVO) throws Exception{
		return offmRsvtMapper.reserveCheck(offmRsvtVO);
	};

	/* 내 예약현황 조회. 현재 시간 이후 예약 */

	@Override
	public List<OffmRsvtVO> getMylistFute(String userId) throws Exception{
		return offmRsvtMapper.getMylistFute(userId);
	};

	/* 내 예약현황 조회. 현재 진행 예약 */
	@Override
	public List<OffmRsvtVO> getMylistIng(String userId) throws Exception{
		return offmRsvtMapper.getMylistIng(userId);
	};

	/* 내 예약현황 조회. 현재 시간 이전 예약 */
	@Override
	public List<OffmRsvtVO> getMylistEnd(String userId) throws Exception{
		return offmRsvtMapper.getMylistEnd(userId);
	};

	/* 내 예약현황 조회. 당일 예약 */
	@Override
	public List<OffmRsvtVO> getMylistToday(String userId) throws Exception{
		List<OffmRsvtVO> list = offmRsvtMapper.getMylistToday(userId);

		for(OffmRsvtVO offmRsvtVO : list) {
			String todayTimeSt = offmRsvtVO.getStrtRsvtDt();
			String timeOnlySt = todayTimeSt.substring(11);
			String todayTimeEd = offmRsvtVO.getEndRsvtDt();
			String timeOnlyEd = todayTimeEd.substring(11);

			String timing = timeOnlySt + "~"+timeOnlyEd;

			offmRsvtVO.setStrtRsvtDt(timing);

		}

		return list;
	};
}
