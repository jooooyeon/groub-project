package kr.or.ddit.attendance.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.attendance.controller.AttendanceController;
import kr.or.ddit.attendance.service.AttendanceService;
import kr.or.ddit.attendance.vo.AttendanceVO;
import kr.or.ddit.attendance.mapper.AttendanceMapper;

@Controller
@RequestMapping("/attendance")
@Secured({"ROLE_ADMIN","ROLE_USER"})
public class AttendanceController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	//호출하기 위해 의존성 주입(DI)
	@Autowired  
	AttendanceService attendanceService;
	
	//근무현황으로 갑니다
	@GetMapping("/work")
	public String work(Model model, AttendanceVO attendanceVO, Principal principal) {
		String userID = principal.getName();
		attendanceVO.setUserId(userID);
		
		int cnt = 0;
		
		cnt = this.attendanceService.checkToday(userID);
		
		if(cnt > 0) {
			AttendanceVO atdcToday = this.attendanceService.slectToday(userID);
			
			int hour = atdcToday.getWorkHm()/60;
			int minute = atdcToday.getWorkHm()%60;
			
			atdcToday.setWorkH(hour);
			atdcToday.setWorkM(minute);
			
			model.addAttribute("atdcToday", atdcToday);
		}
		
		
		List<AttendanceVO> atdcList = this.attendanceService.list(userID);
		for(AttendanceVO atdcVO : atdcList) {
			int hour = atdcVO.getWorkHm()/60;
			int minute = atdcVO.getWorkHm()%60;
			
			atdcVO.setWorkH(hour);
			atdcVO.setWorkM(minute);			
		}
		
		log.info("atdcList : " + atdcList);
		
		model.addAttribute("atdcList", atdcList);
		
		return "attendance/work";
	}
	
	//근태현황으로 갑니다
	@RequestMapping("/attend")
	public String attend() {
		return "attendance/attend";
	}
	
	//근무현황(work) CRUD 시작
	//데이터 넘기기
	//요청URI : /attendance/insert
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(Model model, @ModelAttribute AttendanceVO attendanceVO, Principal principal) {
		attendanceVO.setUserId(principal.getName());
		log.info("출근result: 아무거나 " + attendanceVO);
		
		int result = attendanceService.insert(attendanceVO);
		System.out.println("result : " + result);
		
//		return "attendance/insert";    //요청 처리 후 work로 다시 이동
		return "attendance/work";    //요청 처리 후 work로 다시 이동
	}

    // 퇴근 시간 업데이트
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute AttendanceVO attendanceVO, Principal principal, @RequestParam("dclzNo") int dclzNo) {
    	attendanceVO.setUserId(principal.getName());
		log.info("퇴근result: 아무거나 " + attendanceVO);
		log.info("퇴근result: 아무거나 아무거나아무거나" + dclzNo);
    	
        // 현재 시간으로 퇴근 시간 설정
    	attendanceVO.setLvffcDt(new Date());
    	attendanceVO.setDclzNo(dclzNo);
    	
        int result = attendanceService.update(attendanceVO);
        System.out.println("result22222222: " +  result);
        
        return "redirect:/attendance/work"; // 퇴근 후 근무현황 페이지로 이동
    }
	
	
}





