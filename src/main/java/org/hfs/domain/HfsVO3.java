package org.hfs.domain;

import java.math.BigDecimal;
import java.util.Date;

public class HfsVO3 {

	private String year = "";	//기타은행
	private int amt = 0;		//최대금액
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}

}
