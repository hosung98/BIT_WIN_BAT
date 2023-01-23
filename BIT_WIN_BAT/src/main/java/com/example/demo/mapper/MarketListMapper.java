package com.example.demo.mapper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.MarkListPriceVO;
import com.example.demo.vo.MartListVO;

@Mapper
public interface MarketListMapper {

	
	void insertTicker(MarkListPriceVO vo);
	
	int insertMarketList(MartListVO vo);
	
	int initMarketList();
	
	int initMarketTicker();
	
	List<Map<String, String>> selectMarketList();
	
	
}
