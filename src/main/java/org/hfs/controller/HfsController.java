package org.hfs.controller;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.hfs.dao.HfsDAO;
import org.hfs.domain.hfsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.opencsv.CSVReader;
 


@RestController
@RequestMapping("/stg")
public class HfsController {
	@Inject
	private HfsDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HfsController.class);
	
	 
	
	
	@RequestMapping(value="upload", method = RequestMethod.POST, produces="text/plain;Charset=UTF-8")
    @ResponseBody
    public void uploadContent(String[] args)  {
		 try{
	         InputStreamReader is = new InputStreamReader(new FileInputStream("C:\\sts-bundel396\\workspace\\DevProject\\data\\data.csv"), "EUC-KR");
	         CSVReader reader = new CSVReader(is); 
	         List<String[]> list = reader.readAll();
	         
	         ArrayList<hfsVO> arr = new ArrayList<>();
	         
	         int i = 0;
	         for(String[] str : list){
	        	
	        	 
	             hfsVO hfsVO1 = new hfsVO();
	             hfsVO1.setYear(str[0]);
	             hfsVO1.setMonth(str[1]);
	             hfsVO1.setJ_amt(str[2]);
	             hfsVO1.setKb_Amt(str[3]);
	             hfsVO1.setWr_amt(str[4]);
	             hfsVO1.setSh_amt(str[5]);
	             hfsVO1.setCt_amt(str[6]);
	             hfsVO1.setHn_amt(str[7]);
	             hfsVO1.setNh_amt(str[8]);
	             hfsVO1.setEx_amt(str[9]);
	             hfsVO1.setEtc_amt(str[10]);
	             System.out.println("Year : "+hfsVO1.getYear()+", Jamt : "+hfsVO1.getJ_amt()+", kb_amt : "+hfsVO1.getKb_Amt());
	             
	             if(i!= 0) 
	             {
	            	 dao.insertHfs(hfsVO1);
	             }
	             i++;
	             
	             //arr.add(hfsVO1); 
	         }
	         
	         //for(hfsVO hfsVO1 : arr){
	         //    //System.out.println("Year1 : "+hfsVO1.getYear()+", Jamt1 : "+hfsVO1.getJ_amt() ", kb_amt1 : "+hfsVO1.getKb_Amt());
	         //}
	         
	         //m_clsSession.insert( "Insert", new htsTmRow( hfsVO1.getYear, hfsVO1.get  ) );

	         
	         
	         
	         
	         
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		 
		 
	   }
	
	
	
	/*
	@RequestMapping(value="",method=RequestMethod.GET)
	public ResponseEntity<List<DataObj>>list() {
		logger.info("send");
		
		List<DataObj> prList = new ArrayList<>();
		
		DataObj program = new DataObj();
		
		program.setSeqNo(1);
		program.setRegion("평창군");
		program.setProgramNm("넓은 벌 동쪽 끝으로");
		program.setProgramTm("유머");
		program.setRegDate(new Date());
		
		prList.add(program);
		
		
		
		program = new DataObj();
		
		program.setSeqNo(2);
		program.setRegion("원주시");
		program.setProgramNm("날마다 새로우며 깊어지고 넓어진다");
		program.setProgramTm("코믹");
		program.setRegDate(new Date());
		 
		prList.add(board);
	
		
		ResponseEntity<List<DataObj>> entity = new ResponseEntity<>(prList, HttpStatus.OK);
		
		return entity;
		
	}
	*/

	    @RequestMapping(value="", method = RequestMethod.POST, produces="text/plain;Charset=UTF-8")
	    @ResponseBody
	    public String uploadContent(MultipartHttpServletRequest req) throws Exception{
	        //Gson gson = new Gson();
	        //FolderSet set = new FolderSet();
	        List<MultipartFile> mf = req.getFiles("files[]");
	        
	        System.out.println(mf);
	        
	        // 중략
			return null;

	    }
  
	
	/*
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<String>register(@RequestBody DataObj board) {
		
		logger.info("register");
		
		ResponseEntity<String> entity  = new ResponseEntity<>("SUCESS", HttpStatus.OK);
		return entity;
		
	}
	*/
	/*
	@RequestMapping(value="/{boardNo}", method = RequestMethod.GET)
	public ResponseEntity<DataObj> read(@PathVariable("boardNo") int boardNo) {
		logger.info("read");
		 
		DataObj board = new DataObj();
		
		board.setSeqNo(1);
		board.setRegion("평창군");
		board.setProgramNm("넓은 벌 동쪽 끝으로");
		board.setProgramTm("hongkd");
		board.setRegDate(new Date());
		
		ResponseEntity<DataObj> entity = new ResponseEntity<>(board, HttpStatus.OK);
		
		return entity;
		
	}
	*/
	/*
	@RequestMapping(value="/{boardNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("boardNo") int boardNO) {
		logger.info("remove");	
		
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		
		return entity;
	
	}
	
	
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody DataObj board) {
		
		logger.info("modify");
		
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		
		return entity;
		
	}
	*/
	
	
	
	
	
	
}