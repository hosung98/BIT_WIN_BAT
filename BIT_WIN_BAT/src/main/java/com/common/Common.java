package com.common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
/**
 * 공통 메소드 입니다.
 * @author kimhosung
 *
 */
public class Common {
	
	//URL CALL FORM 
	public static void openapi(String url) {
        try {
	        HttpClient client = HttpClientBuilder.create().build();
	        HttpGet request = new HttpGet(url);
	        request.setHeader("Content-Type", "application/json");
			HttpResponse response = client.execute(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
