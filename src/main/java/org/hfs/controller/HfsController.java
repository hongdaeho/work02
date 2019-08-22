package org.hfs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hfs.dao.HfsDAO;
import org.hfs.domain.HfsVO;
import org.hfs.domain.HfsVO2;
import org.hfs.domain.HfsVO3;
import org.hfs.domain.HfsVO4;
import org.hfs.domain.HfsVO5;
import org.hfs.domain.HfsVO6;

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import net.sf.json.JSONSerializer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;





@RestController
@RequestMapping("/stg")
public class HfsController {
	@Autowired
	private HfsDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HfsController.class);
	
	//업로드 
	@RequestMapping(value="upload", method = RequestMethod.POST, produces="text/plain;Charset=UTF-8")
    public void uploadContent(String[] args)  {
	try {
		InputStreamReader is = new InputStreamReader(new FileInputStream("C:\\tmp\\data.csv"), "EUC-KR");
		
	    CSVReader reader = new CSVReader(is); 
	    List<String[]> list = reader.readAll();
	        
	    ArrayList<HfsVO> arr = new ArrayList<>();
	         
	    int i = 0;
	    for(String[] str : list){
	       	 
		    if(i!= 0) 
		    {
		    	HfsVO hfsVO1 = new HfsVO();
			    hfsVO1.setYear		(str[0]);  
			    hfsVO1.setMonth	(str[1]);	  
			    hfsVO1.setJamt	    (Integer.parseInt(str[2].replaceAll(",", "")));                             
		        hfsVO1.setKbamt	(Integer.parseInt(str[3].replaceAll(",", "")));       
		        hfsVO1.setWramt	(Integer.parseInt(str[4].replaceAll(",", "")));   
		        hfsVO1.setShamt	(Integer.parseInt(str[5].replaceAll(",", "")));    
		        hfsVO1.setCtamt	(Integer.parseInt(str[6].replaceAll(",", "")));    
		        hfsVO1.setHnamt	(Integer.parseInt(str[7].replaceAll(",", "")));    
		        hfsVO1.setNhamt	(Integer.parseInt(str[8].replaceAll(",", "")));    
		        hfsVO1.setExamt 	(Integer.parseInt(str[9].replaceAll(",", "")));    
		        hfsVO1.setEtcamt	(Integer.parseInt(str[10].replaceAll(",", "")));       	
		             
	            //System.out.println("Year : "+hfsVO1.getYear()+", Jamt : "+hfsVO1.getJamt()+", kb_amt : "+hfsVO1.getKbamt());
	             
	            dao.insertHfs(hfsVO1);
         	}
             i++;
	     }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	   }
	
	//리스트조회
	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<HfsVO> list(){
		logger.info("list");  
		List<HfsVO> hfsList = null;
		hfsList = dao.selectHfs();
		
		//System.out.println(getClass().getResource("/data/data.csv"));
		
		System.out.println(hfsList.size());
		for(int i =0; i<hfsList.size(); i++)
		{
			System.out.println	
			("year : "+hfsList.get(i).getYear() + " month : "+hfsList.get(i).getMonth() + " jamt : "+hfsList.get(i).getJamt() + " kb_amt : "+hfsList.get(i).getKbamt() );
		}
		return hfsList; 
		
	} 
	
	//년도별 지원금액 합계 
	@RequestMapping(value="sum",method=RequestMethod.GET)
	public @ResponseBody JSONObject sum(){
		logger.info("sum");  
	
		//List<HfsVO> hfsList = new ArrayList<HfsVO>();
		//ArrayList<HfsVO> arr = new ArrayList<>();
		List<HfsVO> hfsList = null;
		List<HfsVO4> resultList = new ArrayList<HfsVO4>();
		HfsVO4 resultVO = new HfsVO4();
		HfsVO5 hfsVO5 = new HfsVO5();
		HfsVO6 hfsVO6 = new HfsVO6();
		
		List<HashMap<String, String>> retMap = new ArrayList<>();		
		hfsList = dao.selectHfs003(); 

		JSONObject jsonObject1 = new JSONObject(); 
		JSONObject jsonObject2 = new JSONObject();
		JSONObject jsonObject3 = new JSONObject(); 
		JSONArray jsonArray2 = new JSONArray(); 
        JSONArray jsonArray1 = new JSONArray(); 
        JSONObject finalJsonObject1 = new JSONObject(); 
		
		System.out.println(hfsList.size());
		for(int i =0; i<hfsList.size(); i++)
		{
			 
			jsonObject2.put("year", hfsList.get(i).getYear()+"년");
			jsonObject2.put("total_amount",hfsList.get(i).getSumamt());
			
			jsonObject1.put("주택도시기금", hfsList.get(i).getJamt());
		   	jsonObject1.put("국민은행"	  , hfsList.get(i).getKbamt());	
		   	jsonObject1.put("우리은행"	  , hfsList.get(i).getWramt());
		   	jsonObject1.put("신한은행"	  , hfsList.get(i).getShamt());
		   	jsonObject1.put("시티은행"	  , hfsList.get(i).getCtamt());
            jsonObject1.put("하나은행"	  , hfsList.get(i).getHnamt());
            jsonObject1.put("농협"	  , hfsList.get(i).getNhamt());
            jsonObject1.put("외환은행"	  , hfsList.get(i).getExamt());
            jsonObject1.put("기타은행"	  , hfsList.get(i).getEtcamt());
            jsonObject2.put("detail amount", jsonObject1);
            jsonArray1.add(jsonObject2); 

		}
		   jsonObject3.put("name", "주택금융 공급현황");
		   jsonObject3.put("list", jsonArray1);
		  
		   System.out.println(jsonObject3);
		
		//ResponseEntity<List<HfsVO>> entity = new ResponseEntity<>(hfsList, HttpStatus.OK);
		return jsonObject3 ; 
		
	} 
	
	//전체 지원금액 중에서 가장 큰 금액의 기관명 출력
	@RequestMapping(value="max",method=RequestMethod.GET)
	public List<HfsVO2> max(String input){
		logger.info("max");  

		System.out.println("input : "+input ); 
		HfsVO hfsVO = new HfsVO();
		HfsVO2 hfsVO2 = new HfsVO2();
		List<HfsVO> hfsList2= new ArrayList<HfsVO>();
		List<HfsVO2> resultList= new ArrayList<HfsVO2>();
		hfsList2 = dao.selectHfs001(); 
	
		int max = 0;
		
		max = hfsList2.get(0).getJamt();  
		for(int i=0 ; i < hfsList2.size(); i++ )
		{
			if(max <= hfsList2.get(i).getJamt() ) {hfsVO2.setBankNm("주택도시기금"); 	max = hfsList2.get(i).getJamt(); hfsVO2.setYear(hfsList2.get(i).getYear());   }
			if(max <= hfsList2.get(i).getKbamt()) {hfsVO2.setBankNm("국민은행"); 		max = hfsList2.get(i).getKbamt(); hfsVO2.setYear(hfsList2.get(i).getYear());  }
			if(max <= hfsList2.get(i).getWramt()) {hfsVO2.setBankNm("우리은행"); 		max = hfsList2.get(i).getWramt(); hfsVO2.setYear(hfsList2.get(i).getYear());  }
			if(max <= hfsList2.get(i).getShamt()) {hfsVO2.setBankNm("신한은행");		max = hfsList2.get(i).getShamt(); hfsVO2.setYear(hfsList2.get(i).getYear());  }
			if(max <= hfsList2.get(i).getCtamt()) {hfsVO2.setBankNm("시티은행"); 		max = hfsList2.get(i).getCtamt(); hfsVO2.setYear(hfsList2.get(i).getYear());  }
			if(max <= hfsList2.get(i).getHnamt()) {hfsVO2.setBankNm("하나은행"); 		max = hfsList2.get(i).getHnamt(); hfsVO2.setYear(hfsList2.get(i).getYear());  }
			if(max <= hfsList2.get(i).getNhamt()) {hfsVO2.setBankNm("농협");			max = hfsList2.get(i).getNhamt(); hfsVO2.setYear(hfsList2.get(i).getYear());  }
			if(max <= hfsList2.get(i).getExamt()) {hfsVO2.setBankNm("외환은행");		max = hfsList2.get(i).getExamt(); hfsVO2.setYear(hfsList2.get(i).getYear());  }
			if(max <= hfsList2.get(i).getEtcamt()){hfsVO2.setBankNm("기타은행");	 	max = hfsList2.get(i).getEtcamt(); hfsVO2.setYear(hfsList2.get(i).getYear()); }
			}
		
		resultList.add(hfsVO2);
		//ResponseEntity<List<HfsVO>> entity = new ResponseEntity<>(hfsList, HttpStatus.OK);
		return resultList; 
		
	} 
	
	//외환은행 금액중 작은 금액 큰금액 
	@RequestMapping(value="min",method=RequestMethod.GET)
	public List<HfsVO3> min(){
		logger.info("min");  
	
		//List<HfsVO> hfsList = new ArrayList<HfsVO>();
		String BankCode = "8";
		List<HfsVO3> hfsList3 = null;
		List<HfsVO3> resultlist = new ArrayList<HfsVO3>();
		HfsVO3 minVO = new HfsVO3();
		HfsVO3 maxVO = new HfsVO3();
		
		hfsList3 = dao.selectHfs002(BankCode); 
		
		System.out.println("selectHfs002 Amt: "+hfsList3.get(0).getAmt() );
		

		int min = hfsList3.get(0).getAmt();  int max = 0;
		for(int i=0; i<hfsList3.size(); i++)
		{
			if(min >= hfsList3.get(i).getAmt() ) { minVO.setYear(hfsList3.get(i).getYear());  minVO.setAmt(hfsList3.get(i).getAmt()); min = hfsList3.get(i).getAmt(); }
			if(max <= hfsList3.get(i).getAmt() ) { maxVO.setYear(hfsList3.get(i).getYear());  maxVO.setAmt(hfsList3.get(i).getAmt()); max = hfsList3.get(i).getAmt(); }
		}
		
		resultlist.add(minVO);
		resultlist.add(maxVO);
		System.out.println(resultlist.size());
	
		//ResponseEntity<List<HfsVO>> entity = new ResponseEntity<>(hfsList, HttpStatus.OK);
		return resultlist; 
		
	} 
	
	//
	@RequestMapping(value="pre",method=RequestMethod.GET)
	public List<HfsVO2> pre(String input){
		logger.info("pre");  
		System.out.println("input : "+input ); 
		JSONParser jsonParser1 = new JSONParser();
        JSONObject jsonObject1;

        try {
            
            jsonObject1 = (JSONObject) jsonParser1.parse(input);
            System.out.println(jsonObject1);
            System.out.println(jsonObject1.get("year"));
            
            String year = (String) jsonObject1.get("year");
            String month =  (String) jsonObject1.get("month");
            
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        
		HfsVO hfsVO = new HfsVO();
		HfsVO2 hfsVO2 = new HfsVO2();
		System.out.println("selectHfs001 Jamt: "+hfsVO.getJamt() );
		
		List<HfsVO2> hfsList2= new ArrayList<HfsVO2>();
				//dao.selectHfs();
		int max = 0;
		max = hfsVO.getJamt();  
		hfsList2.add(hfsVO2);

		//ResponseEntity<List<HfsVO>> entity = new ResponseEntity<>(hfsList, HttpStatus.OK);
		return hfsList2; 
		
	} 

}