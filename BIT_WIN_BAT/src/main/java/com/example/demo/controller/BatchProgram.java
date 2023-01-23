package com.example.demo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.MarketListMapper;
import com.example.demo.vo.MarkListPriceVO;
import com.example.demo.vo.MartListVO;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:8080") // 컨트롤러에서 설정
@Service
@Slf4j
public class BatchProgram {
	
	@Autowired
	MarketListMapper mrMapper;
	
	private static final Logger log = LoggerFactory.getLogger(BatchProgram.class);

	/*
	 * 마켓의 종목의 명칭을 가져옵니다. 
	 */
	@RequestMapping(value="/batch/list", method=RequestMethod.GET)
	public void batchList() {
		try {
			
	        HttpClient client = HttpClientBuilder.create().build();
	        HttpGet request = new HttpGet("https://api.upbit.com/v1/market/all");
	        request.setHeader("Content-Type", "application/json");

	        HttpResponse response = client.execute(request);
	        HttpEntity entity = response.getEntity();
	        String json = EntityUtils.toString(entity, "UTF-8");
	        
    		JSONParser parser = new JSONParser();
    		JSONArray jsonarray = (JSONArray) parser.parse(json);
    		
    		//테이블 초기화 
    		mrMapper.initMarketList();
    		
    		for (int i = 0; i < jsonarray.size(); i++) {
    			JSONObject obj = (JSONObject) jsonarray.get(i);
    			MartListVO vo = new MartListVO();
    			vo.setMr_cd(obj.get("market").toString());
    			vo.setEng_nm(obj.get("english_name").toString());
    			vo.setKor_nm(obj.get("korean_name").toString());
    			 try {
    				 mrMapper.insertMarketList(vo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		
    		
		} catch (org.apache.http.ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}	
	}
	
	/*
	 * 마켓의 종목의 현재가 정보를 가져옵니다.
	 */
	@RequestMapping(value="/batch/curprice", method=RequestMethod.GET)	
	public void insertCurrentPrice() {
		try {
					
			//TB_MR_LIST 테이블 종목코드 가져오기  
			List<Map<String, String>> map =  mrMapper.selectMarketList();
    		//테이블 초기화 
    		mrMapper.initMarketTicker();	
    		
    		
			for(int i = 0 ; i < map.size(); i++) {
				Thread.sleep(100);
		        HttpClient client = HttpClientBuilder.create().build();
		        HttpGet request = new HttpGet("https://api.upbit.com/v1/ticker?markets=" + map.get(i).get("mr_cd"));
		        request.setHeader("Content-Type", "application/json");

		        HttpResponse response = client.execute(request);
		        HttpEntity entity = response.getEntity();
		        String json = EntityUtils.toString(entity, "UTF-8");
		       
				JSONParser parser = new JSONParser();
				JSONArray jsonarray = (JSONArray) parser.parse(json);


				//종목에 따른 현재가 정보 넣기  
	    		for (int j = 0; j < jsonarray.size(); j++) {
	    			JSONObject obj = (JSONObject) jsonarray.get(j);
	    			MarkListPriceVO vo = new MarkListPriceVO();
	    			vo.setMr_cd(map.get(i).get("mr_cd"));
	    			vo.setTrade_date(obj.get("trade_date").toString());
	    			vo.setTrade_time(obj.get("trade_time").toString());
	    			vo.setOpening_price(Double.parseDouble(obj.get("opening_price").toString()));
	    			vo.setHigh_price(Double.parseDouble(obj.get("high_price").toString()));
	    			vo.setLow_price(Double.parseDouble(obj.get("low_price").toString()));
	    			vo.setTrade_price(Double.parseDouble(obj.get("trade_price").toString()));
	    			vo.setPrev_closing_price(Double.parseDouble(obj.get("prev_closing_price").toString()));
	    			vo.setChange(obj.get("change").toString());
	    			mrMapper.insertTicker(vo);
	    		}				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
