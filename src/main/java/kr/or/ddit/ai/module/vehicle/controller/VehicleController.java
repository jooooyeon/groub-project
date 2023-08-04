package kr.or.ddit.ai.module.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.ai.module.vehicle.service.VehicleService;
import kr.or.ddit.ai.module.vehicle.vo.VehicleVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ai/module")
public class VehicleController {
	

	@Autowired
	VehicleService vehicleService;
	
	
	//요청URI : /ai/module/vehicle
	@GetMapping("/vehicle")
	public String vehicleInout(Model model) {
		
		
		
		List<VehicleVO> mylist = this.vehicleService.list();
		log.debug("data : " + mylist);
		System.out.println(mylist.size() );
		System.out.println("babo");
		
		for(int i=0;i<mylist.size();i++) {
			System.out.println("mylist["+i+"]"+mylist.get(i));
		}
		
		
		
		
		model.addAttribute("data", mylist);
		
		
		
		return "ai/module/vehicle";
	}

}
