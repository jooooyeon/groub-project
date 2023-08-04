package kr.or.ddit.admin.log.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.admin.log.service.LogService;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.vo.UserLogVO;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.GroubUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/log")
public class LogController {

	@Autowired
	LogService logService;

	@GetMapping("/logList")
	public String logList(Model model, Authentication authentication) {

		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		UserVO userVO = customUser.getUserVO();
		String coId = userVO.getCoId();

		List<UserLogVO> logList = logService.logList(coId);
		for(UserLogVO userLogVO : logList) {
			String logTime = GroubUtils.year2String2(userLogVO.getLogYmd());
			userLogVO.setLogTime(logTime);
		}

		model.addAttribute("logList", logList);

		return "admin/log/logList";
	}
}
