package kr.or.ddit.ai.recommend.economy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kr.or.ddit.ai.recommend.economy.mapper.EconomyMapper;
import kr.or.ddit.ai.recommend.economy.vo.EconomyVO;

@Controller
public class EconomyController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EconomyMapper economymapper;

	@GetMapping("/ai/economy")
	public String list() {

		return "ai/recommend/economy";
	}


	@ResponseBody
	@GetMapping("/ai/economy/chartKS11")
	public String economyChartKospy(Model model) {

		List<EconomyVO> list =  economymapper.symbolPrices("2023-05-17", "KS11");

        Gson gson = new Gson();
        JsonArray jArray = new JsonArray();


        for (EconomyVO economyVO : list) {
            JsonObject object = new JsonObject();
            int close = economyVO.getClose();
            int pred = economyVO.getPred();
            String detail = economyVO.getDetail();
            String date = economyVO.getEcnmDt();

            object.addProperty("close", close);
            object.addProperty("pred", pred);
            object.addProperty("date", date);
            object.addProperty("detail", detail);
            jArray.add(object);
        }

        String json = gson.toJson(jArray);
        log.info("json변환: "+json);

        return json;
	}

	@ResponseBody
	@GetMapping("/ai/economy/chartKQ11")
	public String economyChartKosdaq(Model model) {

		List<EconomyVO> list =  economymapper.symbolPrices("2023-07-10", "KQ11");

		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();


		for (EconomyVO economyVO : list) {
			JsonObject object = new JsonObject();
			int close = economyVO.getClose();
			int pred = economyVO.getPred();
			String detail = economyVO.getDetail();
			String date = economyVO.getEcnmDt();

			object.addProperty("close", close);
			object.addProperty("pred", pred);
			object.addProperty("date", date);
			object.addProperty("detail", detail);
			jArray.add(object);
		}

		String json = gson.toJson(jArray);
		log.info("json변환: "+json);

		return json;
	}




	@ResponseBody
	@GetMapping("/ai/economy/chartEtc")
	public String economyChartEtc(Model model, String symbol) {

		List<EconomyVO> list =  economymapper.symbolPrices("2023-07-10", symbol);

		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();


		for (EconomyVO economyVO : list) {
			JsonObject object = new JsonObject();
			int close = economyVO.getClose();
			int pred = economyVO.getPred();
			String detail = economyVO.getDetail();
			String date = economyVO.getEcnmDt();

			object.addProperty("close", close);
			object.addProperty("pred", pred);
			object.addProperty("date", date);
			object.addProperty("detail", detail);
			jArray.add(object);
		}

		String json = gson.toJson(jArray);
		log.info("json변환: "+json);

		return json;
	}


}
