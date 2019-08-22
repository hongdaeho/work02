package org.hfs.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HfsVO4 {
	private String listNm = "주택금융 공급현황 ";  		//년도
;
	
//	List<HfsVO5> bankList = new ArrayList<HfsVO5>();
	HfsVO5 bankList = null;
	
	
		public String getListNm() {
		return listNm;
	}

	public void setListNm(String listNm) {
		this.listNm = listNm;
	}

	public HfsVO5 getBankList() {
		return bankList;
	}

	public void setBankList(HfsVO5 hfsVO5) {
		this.bankList = hfsVO5;
	}


}


