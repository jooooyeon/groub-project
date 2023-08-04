package kr.or.ddit.admin.log.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.admin.log.mapper.LogMapper;
import kr.or.ddit.admin.log.service.LogService;
import kr.or.ddit.user.vo.UserLogVO;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	LogMapper logMapper;

	/**
	 * 로그 목록
	 * @param coId 로그를 조회할 회사명
	 * @return 로그 목록
	 */
	public List<UserLogVO> logList(String coId){
		return logMapper.logList(coId);
	};

}
