/* 
 * Copyright (C) 2018 Yee Young Han <websearch@naver.com> (http://blog.naver.com/websearch)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA 
 */

package org.hfs.db;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class htsTmRow
{
	private String m_year;  		//년도
	private String m_month;			//월
	private String m_jamt;			//주택도시기금
	private String m_kb_amt;		//국민은행
	private String m_wr_amt;		//우리은행
	private String m_sh_amt;		//신한은행
	private String m_ct_amt;		//시티은행
	private String m_hn_amt;		//하나은행
	private String m_nh_amt;		//농협
	private String m_ex_amt;		//외환은행
	private String m_et_amt;		//기타은행

	
	private static SimpleDateFormat m_clsDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

	// INSERT 
	public htsTmRow( String year, String month, String jAmt, String kbAmt, String wrAmt, String shAmt, String ctAmt, String hnAmt, String nhAmt, String exAmt, String etcAmt )
	{
		m_year = year;
		m_month = month;
		m_jamt = jAmt;
		m_kb_amt = kbAmt;
		m_wr_amt = wrAmt;
		m_sh_amt = shAmt;
		m_ct_amt = ctAmt;
		m_hn_amt = hnAmt;
		m_nh_amt = nhAmt;
		m_ex_amt = exAmt;
		m_et_amt = etcAmt;

		
	}

	public String getM_year() {
		return m_year;
	}

	public void setM_year(String m_year) {
		this.m_year = m_year;
	}

	public String getM_month() {
		return m_month;
	}

	public void setM_month(String m_month) {
		this.m_month = m_month;
	}

	public String getM_jamt() {
		return m_jamt;
	}

	public void setM_jamt(String m_jamt) {
		this.m_jamt = m_jamt;
	}

	public String getM_kb_amt() {
		return m_kb_amt;
	}

	public void setM_kb_amt(String m_kb_amt) {
		this.m_kb_amt = m_kb_amt;
	}

	public String getM_wr_amt() {
		return m_wr_amt;
	}

	public void setM_wr_amt(String m_wr_amt) {
		this.m_wr_amt = m_wr_amt;
	}

	public String getM_sh_amt() {
		return m_sh_amt;
	}

	public void setM_sh_amt(String m_sh_amt) {
		this.m_sh_amt = m_sh_amt;
	}

	public String getM_ct_amt() {
		return m_ct_amt;
	}

	public void setM_ct_amt(String m_ct_amt) {
		this.m_ct_amt = m_ct_amt;
	}

	public String getM_hn_amt() {
		return m_hn_amt;
	}

	public void setM_hn_amt(String m_hn_amt) {
		this.m_hn_amt = m_hn_amt;
	}

	public String getM_nh_amt() {
		return m_nh_amt;
	}

	public void setM_nh_amt(String m_nh_amt) {
		this.m_nh_amt = m_nh_amt;
	}

	public String getM_ex_amt() {
		return m_ex_amt;
	}

	public void setM_ex_amt(String m_ex_amt) {
		this.m_ex_amt = m_ex_amt;
	}

	public String getM_et_amt() {
		return m_et_amt;
	}

	public void setM_et_amt(String m_et_amt) {
		this.m_et_amt = m_et_amt;
	}

	public static SimpleDateFormat getM_clsDateFormat() {
		return m_clsDateFormat;
	}

	public static void setM_clsDateFormat(SimpleDateFormat m_clsDateFormat) {
		htsTmRow.m_clsDateFormat = m_clsDateFormat;
	}
	
	
	
	
}
	
	