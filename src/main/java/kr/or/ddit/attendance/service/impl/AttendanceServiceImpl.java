package kr.or.ddit.attendance.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.attendance.service.AttendanceService;
import kr.or.ddit.attendance.vo.AttendanceVO;
import kr.or.ddit.attendance.mapper.AttendanceMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Inject
	AttendanceMapper attendanceMapper;
	
	//근태 목록
	@Override
	public List<AttendanceVO> list(String userId){
		return this.attendanceMapper.list(userId);
	}
	
	@Override
	public AttendanceVO slectToday(String userId){
		return this.attendanceMapper.slectToday(userId);	
	};
	
	@Override
	public int checkToday(String userId) {
		return this.attendanceMapper.checkToday(userId);		
	};
	
	//데이터 넣기
	@Override
	public int insert(AttendanceVO attendanceVO) {
		return this.attendanceMapper.insert(attendanceVO);
	}
	
	//데이터 수정
	public int update(AttendanceVO attendanceVO) {
		return this.attendanceMapper.update(attendanceVO);
	}

}
