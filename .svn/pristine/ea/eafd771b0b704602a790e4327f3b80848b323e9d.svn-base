package kr.or.ddit.reservation.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.reservation.mapper.VhclRsvtMapper;
import kr.or.ddit.reservation.service.VhclRsvtService;
import kr.or.ddit.reservation.vo.OffmRsvtVO;
import kr.or.ddit.reservation.vo.VhclRsvtVO;
import kr.or.ddit.reservation.vo.VhclVO;
import kr.or.ddit.user.vo.UserVO;


@Service
public class VhclRsvtServiceImpl implements VhclRsvtService{

	@Inject
	private VhclRsvtMapper mapper;

	/* 차량 예약 목록 조회 */
	@Override
	public List<VhclRsvtVO> getRsvtList(UserVO userVO) throws Exception {
		return mapper.getRsvtList(userVO);
	}

	/* 차량번호별 목록 조회 */
	@Override
	public List<VhclRsvtVO> getRsvtListVchlNo(String vhclNo) throws Exception{
		return mapper.getRsvtListVchlNo(vhclNo);
	};

	/* 예약 중복 조회 */
	@Override
	public List<VhclRsvtVO> reserveCheck(VhclRsvtVO vhclRsvtVO) throws Exception{
		return mapper.reserveCheck(vhclRsvtVO);
	};

	/* 차량 예약 등록 */
	@Override
	public int insert(VhclRsvtVO vhclRsvtVO) throws Exception {
		return mapper.insert(vhclRsvtVO);
	}

	/* 예약 삭제 */
	@Override
	public int delete(String vRsvtNo) throws Exception{
		return mapper.delete(vRsvtNo);
	};


	/*예약 시간 변경*/
	@Override
	public int update(VhclRsvtVO vhclRsvtVO) throws Exception {
		return mapper.update(vhclRsvtVO);
	}

	/* 차량 목록 조회 */
	@Override
	public List<VhclVO> getVhcl(UserVO userVO) throws Exception{
		return mapper.getVhcl(userVO);
	}

	/* 내 예약현황 조회. 현재 시간 이후 예약 */
	@Override
	public List<VhclRsvtVO> getMylistFute(String userId) throws Exception{
		return mapper.getMylistFute(userId);
	};

	/* 내 예약현황 조회. 현재 진행 예약 */
	@Override
	public List<VhclRsvtVO> getMylistIng(String userId) throws Exception{
		return mapper.getMylistIng(userId);
	};

	/* 내 예약현황 조회. 현재 시간 이전 예약 */
	@Override
	public List<VhclRsvtVO> getMylistEnd(String userId) throws Exception{
		return mapper.getMylistEnd(userId);
	};

	/* 내 예약현황 조회. 당일예약 */
	@Override
	public List<VhclRsvtVO> getMylistToday(String userId) throws Exception{
		List<VhclRsvtVO> list = mapper.getMylistToday(userId);

		for(VhclRsvtVO vhclRsvtVO : list) {
			String todayTimeSt = vhclRsvtVO.getStrtRsvtDt();
			String timeOnlySt = todayTimeSt.substring(11);
			String todayTimeEd = vhclRsvtVO.getEndRsvtDt();
			String timeOnlyEd = todayTimeEd.substring(11);

			String timing = timeOnlySt + "~"+timeOnlyEd;

			vhclRsvtVO.setStrtRsvtDt(timing);
		}

		return list;
	};

}
