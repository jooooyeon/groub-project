package kr.or.ddit.ai.module.vehicle.service.impl;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import kr.or.ddit.ai.module.vehicle.mapper.VehicleMapper;
import kr.or.ddit.ai.module.vehicle.service.VehicleService;
import kr.or.ddit.ai.module.vehicle.vo.VehicleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Inject
	VehicleMapper vehicleMapper;
	
	// 목록
		@Override
		public List<VehicleVO> list() {
			return this.vehicleMapper.list();
		}
	

}
