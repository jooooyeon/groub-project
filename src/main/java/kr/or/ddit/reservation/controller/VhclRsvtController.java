package kr.or.ddit.reservation.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.reservation.service.VhclRsvtService;
import kr.or.ddit.reservation.vo.VhclRsvtVO;
import kr.or.ddit.reservation.vo.VhclVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.vo.UserVO;

@Controller
@RequestMapping("/reservation")
public class VhclRsvtController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Inject
	private VhclRsvtService vhclRsvtService;

	@GetMapping("/vhcl")
	public ModelAndView vhclMain(Authentication authentication, ModelAndView mav) {

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		UserVO userVO = customUser.getUserVO();

		try {
			List<VhclVO> data = vhclRsvtService.getVhcl(userVO);
			mav.addObject("data",data);
			mav.setViewName("reservation/vhcl");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	@ResponseBody
	@PostMapping("/calendar")
	public List<Map<String, Object>> getCalendarList(Authentication authentication) throws Exception {
	    CustomUser customUser = (CustomUser) authentication.getPrincipal();
	    UserVO userVO = customUser.getUserVO();

		log.info("getCalendarList");

		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		HashMap<String, Object> hash = new HashMap<>();

		List<VhclRsvtVO> carReservation = vhclRsvtService.getRsvtList(userVO);

		for(VhclRsvtVO vo : carReservation) {
			hash.put("id", vo.getVRsvtNo());
			hash.put("title", vo.getPrps());
			hash.put("start", vo.getStrtRsvtDt());
			hash.put("end", vo.getRsvtDt());
			jsonObj = new JSONObject(hash);
			jsonArr.add(jsonObj);
		}
		log.info("jsonArrCheck:{}",jsonArr);
		return jsonArr;
	}

	@ResponseBody
	@PostMapping("/calendar/{vhclNo}")
	public List<Map<String, Object>> getCalendarListvRsvtNo(@PathVariable String vhclNo, Authentication authentication) throws Exception {

		log.info("getCalendarList");

		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		HashMap<String, Object> hash = new HashMap<>();

		List<VhclRsvtVO> carReservation = vhclRsvtService.getRsvtListVchlNo(vhclNo);

		for(VhclRsvtVO vo : carReservation) {
			log.info("c:{vo}", vo);
			hash.put("id", vo.getVRsvtNo());
			hash.put("title", vo.getPrps());
			hash.put("start", vo.getStrtRsvtDt());
			hash.put("end", vo.getEndRsvtDt());
			jsonObj = new JSONObject(hash);
			jsonArr.add(jsonObj);
		}
		log.info("jsonArrCheck:{}",jsonArr);
		return jsonArr;
	}

	/* Modal Form태그로 등록 */
	@ResponseBody
	@Transactional
	@PostMapping(value = "/insertForm", produces="application/json; charset=utf-8")
	public String insertForm(@RequestBody List<Map<String, Object>> param) throws Exception{

		int result = 0;

		for(Map<String, Object> list : param) {

			String prps = (String) list.get("prps");
			String strtRsvt = (String)list.get("strtRsvtDt"); // 시작 시간
			String endRsvt = (String)list.get("endRsvtDt"); // 끝나는 시간
			String userId = (String)list.get("userId"); //
			String vhclNo = (String)list.get("vhclNo"); //차량번호

            VhclRsvtVO vhclRsvtVO = new VhclRsvtVO();
            vhclRsvtVO.setStrtRsvtDt(strtRsvt);
            vhclRsvtVO.setEndRsvtDt(endRsvt);
            vhclRsvtVO.setUserId(userId);
            vhclRsvtVO.setVhclNo(vhclNo);
            vhclRsvtVO.setPrps(prps);

            List<VhclRsvtVO> check = this.vhclRsvtService.reserveCheck(vhclRsvtVO);
            if(check.size() > 0) {
            	return "fail";
            } else {
            	result =  this.vhclRsvtService.insert(vhclRsvtVO);
            	log.info("insertForm result : " + result);
            	return "redirect:reservation/calendar/"+ vhclNo;
            }

		}
		return "reservation/calendar/" + param.get(0).get("vhclNo");
	}






	/*예약 시간 변경*/
	@PatchMapping("/updateVhcl")
	@Transactional
	@ResponseBody
	public String modifyEvent(@RequestBody List<Map<String, Object>>param) throws Exception {

		int result = 0;

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");


		for(Map<String, Object> list : param) {

			String startDateString = (String)list.get("start"); // 시작 시간
			String endDateString = (String)list.get("end"); // 끝나는 시간
			String vRsvtNoStr = (String)list.get("id"); //
			int vRsvtNo = Integer.parseInt(vRsvtNoStr);

			LocalDateTime modifiedStartDate = LocalDateTime.parse(startDateString, dateTimeFormatter);
            LocalDateTime modifiedEndDate = LocalDateTime.parse(endDateString, dateTimeFormatter);

			log.info("updateVhcl : modifiedStartDate " + modifiedStartDate);
            log.info("updateVhcl : modifiedEndDate " + modifiedEndDate);

            LocalDateTime loStrtDt = LocalDateTime.parse(String.valueOf(modifiedStartDate), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            LocalDateTime loEndDt = LocalDateTime.parse(String.valueOf(modifiedEndDate), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            String strtDt = loStrtDt.format(outputFormatter);
            String endDt  = loEndDt.format(outputFormatter);

            log.info("updateVhcl : strtDt " + strtDt);
            log.info("updateVhcl : endDt " + endDt);

            VhclRsvtVO vhclRsvtVO = new VhclRsvtVO();
            vhclRsvtVO.setStrtRsvtDt(strtDt);
            vhclRsvtVO.setEndRsvtDt(endDt);
            vhclRsvtVO.setVRsvtNo(vRsvtNo);

            log.info("updateVhcl : vRsvtNo" + vRsvtNo);

            log.info("updateVhcl : " + vhclRsvtVO.toString());

            result =  this.vhclRsvtService.update(vhclRsvtVO);
            log.info("updateVhcl result : " + result);
		}

		return "reservation/calendar";
	}

	// 이벤트 삭제
	@DeleteMapping("/deleteVhcl")
	@ResponseBody
	public String deleteEvent(@RequestBody List<Map<String, Object>> param) throws Exception {

		int result = 0;

		for(Map<String, Object> list : param) {

			String vRsvtNo = (String)list.get("id"); //

            log.info("vRsvtNovRsvtNo : " + vRsvtNo);


			result = this.vhclRsvtService.delete(vRsvtNo);
		}

		return "reservation/calendar";
	}

	/* 이벤트 등록 */
	@PostMapping("/insertVhcl")
	@Transactional
	@ResponseBody
	public String addEvent(@RequestBody List<Map<String, Object>> param, Principal principal) throws Exception {

		String userId = principal.getName();

		int result = 0;

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");

		for(Map<String, Object> list : param) {

			String prps = (String) list.get("title");
			String startDateString = (String)list.get("start"); // 시작 시간
			String endDateString = (String)list.get("end"); // 끝나는 시간
			String vhclNo = (String)list.get("description"); //차량번호

			LocalDateTime modifiedStartDate = LocalDateTime.parse(startDateString, dateTimeFormatter);
            LocalDateTime modifiedEndDate = LocalDateTime.parse(endDateString, dateTimeFormatter);

            modifiedStartDate = modifiedStartDate.plusHours(9);
            modifiedEndDate = modifiedEndDate.plusHours(9);

			log.info("updateVhcl : modifiedStartDate " + modifiedStartDate);
            log.info("updateVhcl : modifiedEndDate " + modifiedEndDate);

            LocalDateTime loStrtDt = LocalDateTime.parse(String.valueOf(modifiedStartDate), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            LocalDateTime loEndDt = LocalDateTime.parse(String.valueOf(modifiedEndDate), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            String strtDt = loStrtDt.format(outputFormatter);
            String endDt  = loEndDt.format(outputFormatter);


            VhclRsvtVO vhclRsvtVO = new VhclRsvtVO();
            vhclRsvtVO.setStrtRsvtDt(strtDt);
            vhclRsvtVO.setEndRsvtDt(endDt);
            vhclRsvtVO.setUserId(userId);
            vhclRsvtVO.setVhclNo(vhclNo);
            vhclRsvtVO.setPrps(prps);

            log.info("vhclRsvtVO : vhclRsvtVO " + vhclRsvtVO);

            result =  this.vhclRsvtService.insert(vhclRsvtVO);

            log.info("updateVhcl result : " + result);
		}

		return "reservation/calendar";
	}


}
