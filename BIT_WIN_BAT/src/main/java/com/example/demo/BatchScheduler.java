package com.example.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.common.Common;

import lombok.extern.slf4j.Slf4j;

/**
 * 배치 목록입니다.
 * @author kimhosung
 *
 */
@Component
public class BatchScheduler {

	@Scheduled(cron = "0 0 7 * * *")
	public void scheduleFixedRateTask() {
	        
	        //TB_MR_LIST 적재 
	        Common.openapi("http://localhost:5001/batch/list");
	        
	        //TB_MR_TICKER 적재 
	        Common.openapi("http://localhost:5001/batch/curprice");
	        
	}

}
