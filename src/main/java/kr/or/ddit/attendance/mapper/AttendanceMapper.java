package kr.or.ddit.attendance.mapper;

import java.util.List;

import kr.or.ddit.attendance.vo.AttendanceVO;

public interface AttendanceMapper {
	
	//근태 목록 조회
	public List<AttendanceVO> list(String userId);
	
	public AttendanceVO slectToday(String userId);
	
	public int checkToday(String userId);
	
	//출퇴근 데이터 넣기
	public int insert(AttendanceVO attendanceVO);
	
	//데이터 수정(퇴근시간 조정)
	public int update(AttendanceVO attendanceVO);
	

}
