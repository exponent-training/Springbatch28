package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;


@RestController
public class ExcelController {
	
	@GetMapping(value = "/export/excel")
	public void dataWriteInExcel() {
		
		Student student  =  new Student();
		student.setId(1);student.setName("Abcd");
		student.setAddress("Pune");student.setUname("admin");
		student.setPass("admin");student.setFees(50000);
		
		
		//Create Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//Create Blank Sheet
		XSSFSheet sheet = workbook.createSheet("StudentData");
		
		Map<String, Object[]> map  =  new HashMap<String, Object[]>();
		map.put("1", new Object[] {"ID","NAME","ADDRESS","UNAME","PASS","FEES"});
		map.put("2", new Object[] {student.getId(),student.getName(),student.getAddress(),student.getUname(),student.getPass(),student.getFees()});
	    map.put("3", new Object[] {2,"Pqrs","Pune","pqrs@gmail.com","pqrs@321",50000});
	    map.put("4", new Object[] {3,"Lmn","Pune","lmn@gmail.com","lmn@321",50000});
	    
	   Set<String> keySet = map.keySet();
	   int rownum = 0;
	   for (String key : keySet) {
		
		    Row row = sheet.createRow(rownum++);
		    Object[] objArr = map.get(key);
		    
		    int cellnum = 0;
		      
		       for(Object obj : objArr) {
		    	   
		    	     Cell cell = row.createCell(cellnum++);
		    	     
		    	     if(obj instanceof String) {
		    	    	 cell.setCellValue((String)obj);
		    	     }
		    	     else if(obj instanceof Integer) {
		    	    	 cell.setCellValue((Integer)obj);
		    	     }else if(obj instanceof Double){
		    	    	 cell.setCellValue((Double)obj);
		    	     }
		       }
	   }
	    
	    try {
			FileOutputStream out = new FileOutputStream(new File("D:\\Student_data_sheet.xlsx"));
				workbook.write(out);
				out.close();
				System.out.println("Data Write In Excel File.");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	 
	}

}
