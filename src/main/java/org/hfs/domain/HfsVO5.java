package org.hfs.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HfsVO5 {
	String year = "";
	int total_amount = 0;
	HfsVO6 detail_amount = null;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public HfsVO6 getDetail_amount() {
		return detail_amount;
	}
	public void setDetail_amount(HfsVO6 detail_amount) {
		this.detail_amount = detail_amount;
	}
			
	

	

}


