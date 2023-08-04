package kr.or.ddit.attendance.service;

import java.util.List;

import kr.or.ddit.attendance.vo.AttendanceVO;

//서비스 interface : 비즈니스 로직(기능)
public interface AttendanceService {
	
	//목록보기
	public List<AttendanceVO> list(String userId);
	
	public AttendanceVO slectToday(String userId);
	
	public int checkToday(String userId);
	
	//데이터 넣기
	public int insert(AttendanceVO attendanceVO);
	
	//데이터 수정
	public int update(AttendanceVO attendanceVO);

	

}
