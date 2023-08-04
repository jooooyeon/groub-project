package kr.or.ddit.admin.log.mapper;

import java.util.List;

import kr.or.ddit.user.vo.UserLogVO;

public interface LogMapper {

	/**
	 * 로그 목록
	 * @param coId 로그를 조회할 회사명
	 * @return 로그 목록
	 */
	public List<UserLogVO> logList(String coId);


}
