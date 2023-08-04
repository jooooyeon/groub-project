package kr.or.ddit.reservation.controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.reservation.service.OffmlRsvtService;
import kr.or.ddit.reservation.service.VhclRsvtService;
import kr.or.ddit.reservation.vo.OffmRsvtVO;
import kr.or.ddit.reservation.vo.VhclRsvtVO;

@Controller
@RequestMapping("/reservation")
public class MyRsvtController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Inject
	private VhclRsvtService vhclRsvtService;

	@Inject
	private OffmlRsvtService offmlRsvtService;

	@GetMapping("/mylist")
	public ModelAndView mylist(ModelAndView mav, Principal principal) throws Exception {

		String userId = principal.getName();

		List<VhclRsvtVO> vhclRsvtFute = vhclRsvtService.getMylistFute(userId);
		List<VhclRsvtVO> vhclRsvEnd = vhclRsvtService.getMylistEnd(userId);
		List<VhclRsvtVO> vhclRsvIng = vhclRsvtService.getMylistIng(userId);

		for(VhclRsvtVO vhclRsvtVO : vhclRsvtFute) {
			int cnt = vhclRsvtVO.getVRsvtNo();
			vhclRsvtVO.setVnoStr(cnt+"");
		}

		List<OffmRsvtVO> offmRsvtFute = offmlRsvtService.getMylistFute(userId);
		List<OffmRsvtVO> offmRsvEnd = offmlRsvtService.getMylistEnd(userId);
		List<OffmRsvtVO> offmRsvIng = offmlRsvtService.getMylistIng(userId);

		for(OffmRsvtVO offmRsvtVO : offmRsvtFute) {
			int cnt = offmRsvtVO.getORsvtNo();
			offmRsvtVO.setOnoStr(cnt+"");
		}

		mav.addObject("vhclIng",vhclRsvIng);
		mav.addObject("vhclFute",vhclRsvtFute);
		mav.addObject("vhclEnd",vhclRsvEnd);

		mav.addObject("offmIng",offmRsvIng);
		mav.addObject("offmFute",offmRsvtFute);
		mav.addObject("offmEnd",offmRsvEnd);

		mav.setViewName("reservation/mylist");

		return mav;
	}

	/**
	 * (차량)예약을 취소한다.
	 * @param vRsvtNo 취소하고자 하는 예약번호
	 * @return 결과 메시지
	 * @throws Exception
	 */
	@PostMapping("/delVhcl")
	@ResponseBody
	public String delVhcl(@RequestParam("vRsvtNo") String vRsvtNo) throws Exception {
	    int cnt = 0;
	    cnt = vhclRsvtService.delete(vRsvtNo);
	    return "success";
	};

	/**
	 * (회의실)예약을 취소한다.
	 * @param oRsvtNo 취소하고자 하는 예약번호
	 * @return 결과 메시지
	 * @throws Exception
	 */
	@PostMapping("/delOffm")
	@ResponseBody
	public String delOffm(@RequestParam("oRsvtNo") String oRsvtNo) throws Exception {
		int cnt = 0;
		cnt = offmlRsvtService.delete(oRsvtNo);
		return "success";
	};



}
