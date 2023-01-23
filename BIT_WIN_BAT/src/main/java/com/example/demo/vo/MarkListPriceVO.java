package com.example.demo.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MarkListPriceVO {
	public String mr_cd;//마켓 종목코드   
	public String trade_date;    //최근거래일
	public String trade_time;    //최근거래시
	public double opening_price; //시가  
	public double high_price;    //고가
	public double low_price;     //종가
	public double trade_price;   //저가   
	public double prev_closing_price;//전일 종
	public String change;//EVEN : 보합 RISE : 상승 FALL : 하락
	
	
	/**
	 * @return the mr_cd
	 */
	public String getMr_cd() {
		return mr_cd;
	}
	/**
	 * @param mr_cd the mr_cd to set
	 */
	public void setMr_cd(String mr_cd) {
		this.mr_cd = mr_cd;
	}
	/**
	 * @return the trade_date
	 */
	public String getTrade_date() {
		return trade_date;
	}
	/**
	 * @param trade_date the trade_date to set
	 */
	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
	}
	/**
	 * @return the trade_time
	 */
	public String getTrade_time() {
		return trade_time;
	}
	/**
	 * @param trade_time the trade_time to set
	 */
	public void setTrade_time(String trade_time) {
		this.trade_time = trade_time;
	}
	/**
	 * @return the opening_price
	 */
	public double getOpening_price() {
		return opening_price;
	}
	/**
	 * @param opening_price the opening_price to set
	 */
	public void setOpening_price(double opening_price) {
		this.opening_price = opening_price;
	}
	/**
	 * @return the high_price
	 */
	public double getHigh_price() {
		return high_price;
	}
	/**
	 * @param high_price the high_price to set
	 */
	public void setHigh_price(double high_price) {
		this.high_price = high_price;
	}
	/**
	 * @return the low_price
	 */
	public double getLow_price() {
		return low_price;
	}
	/**
	 * @param low_price the low_price to set
	 */
	public void setLow_price(double low_price) {
		this.low_price = low_price;
	}
	/**
	 * @return the trade_price
	 */
	public double getTrade_price() {
		return trade_price;
	}
	/**
	 * @param trade_price the trade_price to set
	 */
	public void setTrade_price(double trade_price) {
		this.trade_price = trade_price;
	}
	/**
	 * @return the prev_closing_price
	 */
	public double getPrev_closing_price() {
		return prev_closing_price;
	}
	/**
	 * @param prev_closing_price the prev_closing_price to set
	 */
	public void setPrev_closing_price(double prev_closing_price) {
		this.prev_closing_price = prev_closing_price;
	}
	/**
	 * @return the change
	 */
	public String getChange() {
		return change;
	}
	/**
	 * @param change the change to set
	 */
	public void setChange(String change) {
		this.change = change;
	}
	
	
}
