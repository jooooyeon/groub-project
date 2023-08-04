package kr.or.ddit.schedule.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.schedule.service.ScheduleService;
import kr.or.ddit.schedule.vo.ScheduleVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 일정에 관한 요청을 처리한다
 * 웹 화면으로 전달하는 Controller를 정의한다
 * @author 노태현
 * @since 2023.07.20
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      	수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.20  노태현          최초 생성
 *   2023.07.25  노태현          main페이지 차트 추가
 *
 * </pre>
 */

@Controller
@Slf4j
@Secured({"ROLE_ADMIN","ROLE_USER"})
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;


	@GetMapping("/list")
	public String scheduleList() {
		log.info("scheduleList");
		return "schedule/list";
	}


	/**
	 * 등록된 일정의 목록을 보여준다.
	 * @param checkedValues 회사,팀,개인으로 구분되는 체크박스의 체크된 항목
	 * @param authentication 로그인된 사용자의 소속회사,팀,개인을 식별하기 위한 인증 정보
	 * @return 체크된 항목(회사,팀,개인 중)에 해당하는 일정 목록
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/list")
	public List<Map<String, Object>> scheduleListPost(@RequestParam("checkedValues") List<String> checkedValues
			,Authentication authentication) throws Exception {
		log.info("scheduleListPost");

		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		HashMap<String, Object> hash = new HashMap<>();

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		UserVO userVO = customUser.getUserVO();
		String coId = userVO.getCoId();
		String userId = userVO.getUserId();
		String deptNo = userVO.getDeptNo();


		for(String schdlTp : checkedValues) {
			log.info(schdlTp);
			String textColor = "";
			String classNames = "";
			List<ScheduleVO> dataList = scheduleService.listAll(schdlTp);

			if(schdlTp.equals(coId)) {
				textColor = "red";
				classNames = "bg-danger-subtle";
			}
			if(schdlTp.equals(deptNo)) {
				textColor = "blue";
				classNames = "bg-primary-subtle";
			}
			if(schdlTp.equals(userId)) {
				textColor = "green";
				classNames = "bg-success-subtle";
			}

			for(ScheduleVO scheduleVO : dataList) {
				hash.put("id", scheduleVO.getSchdlNo());
				hash.put("title", scheduleVO.getSchdlTtl());
				hash.put("content", scheduleVO.getSchdlCn());
				hash.put("start", scheduleVO.getStrtSchdlDt());
				hash.put("end", scheduleVO.getEndSchdlDt());
				hash.put("textColor", textColor);
				hash.put("classNames", classNames);
				jsonObj = new JSONObject(hash);
				jsonArr.add(jsonObj);
			}

		}



		log.info("jsonArrCheck:{}",jsonArr);
		return jsonArr;
	}




	/**
	 * 일정을 등록한다
	 * @param param 등록하려는 일정의 정보
	 * @param principal 일정 등록자를 식별하기 위한 인증 정보
	 * @return forward:schedule/list
	 * @throws Exception
	 */
	@PostMapping("/registSchdl")
	@Transactional
	@ResponseBody
	public String addEvent(@RequestBody List<Map<String, Object>> param, Principal principal) throws Exception {

		String userId = principal.getName();

		int result = 0;


		for(Map<String, Object> list : param) {

			String title = (String) list.get("title");
			String startDateString = (String)list.get("start"); // 시작 시간
			String endDateString = (String)list.get("end"); // 끝나는 시간
			String schdlTp = (String)list.get("schdlTp");
			String schdlCn = (String)list.get("schdlCn");

			log.info(startDateString); //String "2023-07-26 16:00"
			log.info(endDateString);   //2023-07-26 19:00

            ScheduleVO scheduleVO = new ScheduleVO();
            scheduleVO.setStrtSchdlDt(startDateString);
            scheduleVO.setEndSchdlDt(endDateString);
            scheduleVO.setUserId(userId);
            scheduleVO.setSchdlTtl(title);
            scheduleVO.setSchdlCn(schdlCn);
            scheduleVO.setSchdlTp(schdlTp);

            log.info("ScheduleVO : scheduleVO " + scheduleVO);

            result =  this.scheduleService.registSchdl(scheduleVO);

            log.info("updateVhcl result : " + result);
		}

		return "schedule/list";
	}

	/**
	 * 일정 삭제
	 * @param param 삭제하려는 일정 정보
	 * @return forward:schedule/list
	 * @throws Exception
	 */
	@DeleteMapping("/deleteSchdl")
	@ResponseBody
	public String deleteEvent(@RequestBody List<Map<String, Object>> param) throws Exception {

		int result = 0;

		for(Map<String, Object> list : param) {
			String schdlNo = (String)list.get("id");
			result = this.scheduleService.deleteSchdl(schdlNo);
		}
		return "reservation/calendar";
	}


	/**
	 * 일정 시간 변경
	 * @param param 변경하고자 하는 일정 정보
	 * @return forward:schedule/list
	 * @throws Exception
	 */
	@PatchMapping("/updateSchdl")
	@ResponseBody
	public String modifyEvent(@RequestBody List<Map<String, Object>>param) throws Exception {
		log.info("logInfo" + "updateSchdl / modifyEvent");

		int result = 0;

		for(Map<String, Object> list : param) {

			ScheduleVO scheduleVO = new ScheduleVO();

			String start = (String)list.get("start"); // 시작 시간
			String end = (String)list.get("end"); // 끝나는 시간
			String schdlNoStr = (String)list.get("id"); //

			String[] partsSt = start.split("T");
			String datePartSt = partsSt[0];
			String timePartSt = partsSt[1].substring(0, 5);

			String[] partsEd = end.split("T");
			String datePartEd = partsEd[0];
			String timePartEd = partsEd[1].substring(0, 5);

			String startDateString = datePartSt + " " + timePartSt;
			String endDateString = datePartEd + " " + timePartEd;

			scheduleVO.setSchdlNo(schdlNoStr);
			scheduleVO.setStrtSchdlDt(startDateString);
			scheduleVO.setEndSchdlDt(endDateString);

			result = this.scheduleService.dragDropUpdate(scheduleVO);
		}


		return "schedule/list";
	}


	/**
	 * 일정 등록 - 풀캘린더의 select옵션을 이용한 간편 등록
	 * @param param 등록하려는 일정 정보
	 * @param principal 등록자를 식별하기 위한 인증 정보
	 * @return forward:schedule/list
	 * @throws Exception
	 */
	@PostMapping("/selectSchdl")
	@Transactional
	@ResponseBody
	public String addEventSelect(@RequestBody List<Map<String, Object>> param, Principal principal) throws Exception {
		log.info("selectSchdl / addEventSelect");

		String userId = principal.getName();

		int result = 0;

		for(Map<String, Object> list : param) {

			String title = (String) list.get("title");
			String start9 = (String)list.get("start"); // 시작 시간
			String end9 = (String)list.get("end"); // 끝나는 시간

			LocalDateTime dateTimeSt = LocalDateTime.parse(start9, DateTimeFormatter.ISO_DATE_TIME);
			LocalDateTime dateTimeEd = LocalDateTime.parse(end9, DateTimeFormatter.ISO_DATE_TIME);

			LocalDateTime startDt = dateTimeSt.plus(9, ChronoUnit.HOURS);
			LocalDateTime endDt = dateTimeEd.plus(9, ChronoUnit.HOURS);

			String start = startDt.toString();
			String end = endDt.toString();

			String[] partsSt = start.split("T");
			String datePartSt = partsSt[0];
			String timePartSt = partsSt[1].substring(0, 5);

			String[] partsEd = end.split("T");
			String datePartEd = partsEd[0];
			String timePartEd = partsEd[1].substring(0, 5);

			String startDateString = datePartSt + " " + timePartSt;
			String endDateString = datePartEd + " " + timePartEd;

            ScheduleVO scheduleVO = new ScheduleVO();
            scheduleVO.setStrtSchdlDt(startDateString);
            scheduleVO.setEndSchdlDt(endDateString);
            scheduleVO.setUserId(userId);
            scheduleVO.setSchdlTtl(title);
            scheduleVO.setSchdlCn("");
            scheduleVO.setSchdlTp(userId);

            log.info("ScheduleVO : scheduleVO " + scheduleVO);

            result =  this.scheduleService.registSchdl(scheduleVO);

            log.info("updateVhcl result : " + result);
		}

		return "schedule/list";
	}



	/**
	 * 등록된 일정의 목록 홈화면에 보여준다.
	 * @param checkedValues 회사,팀,개인으로 구분되는 체크박스의 체크된 항목
	 * @param authentication 로그인된 사용자의 소속회사,팀,개인을 식별하기 위한 인증 정보
	 * @return 체크된 항목(회사,팀,개인 중)에 해당하는 일정 목록
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/list2Home")
	public List<Map<String, Object>> scheduleList2Home(@RequestParam("checkedValues") List<String> checkedValues
			,Authentication authentication) throws Exception {
		log.info("scheduleListPost");

		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		HashMap<String, Object> hash = new HashMap<>();

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		UserVO userVO = customUser.getUserVO();
		String coId = userVO.getCoId();
		String userId = userVO.getUserId();
		String deptNo = userVO.getDeptNo();


		for(String schdlTp : checkedValues) {
			log.info(schdlTp);
			String textColor = "";
			String classNames = "";
			List<ScheduleVO> dataList = scheduleService.listAll(schdlTp);

			if(schdlTp.equals(coId)) {
				textColor = "red";
				classNames = "bg-danger-subtle";
			}
			if(schdlTp.equals(deptNo)) {
				textColor = "blue";
				classNames = "bg-primary-subtle";
			}
			if(schdlTp.equals(userId)) {
				textColor = "green";
				classNames = "bg-success-subtle";
			}

			for(ScheduleVO scheduleVO : dataList) {
				hash.put("id", scheduleVO.getSchdlNo());
				hash.put("title", scheduleVO.getSchdlTtl());
				hash.put("content", scheduleVO.getSchdlCn());
				hash.put("start", scheduleVO.getStrtSchdlDt());
				hash.put("end", scheduleVO.getEndSchdlDt());
				hash.put("textColor", textColor);
				hash.put("classNames", classNames);
				hash.put("allDay", true);
				jsonObj = new JSONObject(hash);
				jsonArr.add(jsonObj);
			}

		}


		log.info("jsonArrCheck:{}",jsonArr);
		return jsonArr;
	}



}
