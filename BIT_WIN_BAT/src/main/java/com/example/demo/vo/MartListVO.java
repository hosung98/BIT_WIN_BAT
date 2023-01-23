package com.example.demo.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
 * 업비트 마켓에 있는 목록 VO
 */
@Data
@Getter
@Setter
public class MartListVO {
	String mr_cd;
	String kor_nm;
	String eng_nm;

	public String getMr_cd() {
		return mr_cd;
	}
	public void setMr_cd(String mr_cd) {
		this.mr_cd = mr_cd;
	}
	public String getKor_nm() {
		return kor_nm;
	}
	public void setKor_nm(String kor_nm) {
		this.kor_nm = kor_nm;
	}
	public String getEng_nm() {
		return eng_nm;
	}
	public void setEng_nm(String eng_nm) {
		this.eng_nm = eng_nm;
	}
	
	
}
