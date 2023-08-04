package kr.or.ddit.ai.recommend.economy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.ai.recommend.economy.vo.EconomyVO;

public interface EconomyMapper {

		public List<EconomyVO> list();

		public List<EconomyVO> listAtfDt(String startDate);

		public List<EconomyVO> symbolPrices(@Param("startDate") String startDate, @Param("symbol") String symbol);

}
