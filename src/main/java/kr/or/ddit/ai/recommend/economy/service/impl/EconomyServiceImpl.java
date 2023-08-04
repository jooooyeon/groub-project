package kr.or.ddit.ai.recommend.economy.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ai.recommend.economy.mapper.EconomyMapper;
import kr.or.ddit.ai.recommend.economy.service.EconomyService;
import kr.or.ddit.ai.recommend.economy.vo.EconomyVO;

@Service
public class EconomyServiceImpl implements EconomyService {

	@Inject
	EconomyMapper economyMapper;

	@Override
	public List<EconomyVO> list(){
		return economyMapper.list();
	};

	@Override
	public List<EconomyVO> listAtfDt(String startDate){
		return economyMapper.listAtfDt(startDate);
	};

	@Override
	public List<EconomyVO> symbolPrices(String startDate, String symbol){
		return economyMapper.symbolPrices(startDate, symbol);
	};

}
