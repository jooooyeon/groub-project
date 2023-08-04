package kr.or.ddit.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.reservation.service.OffmlRsvtService;
import kr.or.ddit.reservation.vo.OffmRsvtVO;
import kr.or.ddit.reservation.vo.OffmVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.vo.UserVO;

@Controller
@RequestMapping("/reservationOffm")
public class OffmRsvtController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OffmlRsvtService offmlRsvtService;

	@GetMapping("/main")
	public ModelAndView offmMain(Authentication authentication, ModelAndView mav) throws Exception {

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		UserVO userVO = customUser.getUserVO();
		String coId = userVO.getCoId();
		List<OffmVO> data = offmlRsvtService.getOffmList(coId);

		mav.addObject("data",data);
		mav.setViewName("reservation/offm");

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

		List<OffmRsvtVO> roomReservation = offmlRsvtService.getRsvtList(userVO);

		for(OffmRsvtVO vo : roomReservation) {
			hash.put("id", vo.getORsvtNo());
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
	@PostMapping("/calendar/{offmNo}")
	public List<Map<String, Object>> getCalendarListvRsvtNo(@PathVariable String offmNo, Authentication authentication) throws Exception {

		log.info("getCalendarList");

		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		HashMap<String, Object> hash = new HashMap<>();

		List<OffmRsvtVO> roomReservation = offmlRsvtService.getRsvtListOffmNo(offmNo);

		for(OffmRsvtVO vo : roomReservation) {
			hash.put("id", vo.getORsvtNo());
			hash.put("title", vo.getPrps());
			hash.put("start", vo.getStrtRsvtDt());
			hash.put("end", vo.getEndRsvtDt());
			jsonObj = new JSONObject(hash);
			jsonArr.add(jsonObj);
		}
		log.info("jsonArrCheck:{}",jsonArr);
		return jsonArr;
	}


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
			String offmNo = (String)list.get("offmNo"); //차량번호

			OffmRsvtVO offmRsvtVO = new OffmRsvtVO();
			offmRsvtVO.setStrtRsvtDt(strtRsvt);
			offmRsvtVO.setEndRsvtDt(endRsvt);
			offmRsvtVO.setUserId(userId);
			offmRsvtVO.setOffmNo(offmNo);
			offmRsvtVO.setPrps(prps);

            List<OffmRsvtVO> check = this.offmlRsvtService.reserveCheck(offmRsvtVO);
            if(check.size() > 0) {
            	return "fail";
            } else {
            	result =  this.offmlRsvtService.insert(offmRsvtVO);
            	log.info("insertForm result : " + result);
            	return "redirect:reservation/calendar/"+ offmNo;
            }

		}
		return "reservation/calendar/" + param.get(0).get("vhclNo");
	}

}
