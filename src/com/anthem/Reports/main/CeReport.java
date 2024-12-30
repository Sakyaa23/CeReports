package com.anthem.Reports.main;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.anthem.Reports.DbConnection.DBConnection;
import com.anthem.Reports.constants.ConfigData;

public class CeReport {
	static DBConnection connection= new DBConnection();
	static Connection con=null;
	 static ConfigData properties;
	    ArrayList<String> sqlList= new ArrayList<String>();
        static ArrayList<String> os= new ArrayList<String>();
        static ArrayList<String> resultList= new ArrayList<String>();
       
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		if(null==properties)
		{
			properties= ConfigData.getInstance();
			 
		}
		CeReport ce= new CeReport();
		 String path="CEReports.xlsx";
		os=ce.getOsList();
		resultList=ce.fetchCeData();
		resultList=ce.fetchClaimsData();
		resultList=ce.fetchspecData();
		
		for(String str:os)
		{
		System.out.println(""+str);
		}
		for(String str:resultList)
		{
		System.out.println(""+str);
		}
		con.close();
		XSSFWorkbook workbook= new XSSFWorkbook();
    	XSSFSheet sheet = workbook.createSheet("Reports");
    	//XSSFSheet sheet1 = workbook.createSheet("IS");
    	writeHeaderLineCe(sheet);
    	//writeHeaderLineIs(sheet1);
    	writeDataLines(resultList,os,workbook,sheet);
    	
    	FileOutputStream out= new FileOutputStream(path);
    	workbook.write(out);

	}

public ArrayList<String> fetchCeData() throws ClassNotFoundException, SQLException, IOException {
		
		con=connection.CedbConnection();
		 //step3 create the statement object  
        Statement stmt=con.createStatement();  
        sqlList.add(properties.getSql1());
        sqlList.add(properties.getSql2());
        sqlList.add(properties.getSql3());
        sqlList.add(properties.getSql4());
        sqlList.add(properties.getSql5());
        sqlList.add(properties.getSql6());
        sqlList.add(properties.getSql7());
        sqlList.add(properties.getSql8());
        sqlList.add(properties.getSql9());
        sqlList.add(properties.getSql10());
      
        ResultSet rs = null;
        for(String s: sqlList)
        {
     	    rs=stmt.executeQuery(s);
     	   rs.next(); 
     	   resultList.add(rs.getString(1));
            System.out.println(rs.getString(1));
        }
        stmt.close();
        return resultList;
		
	}

	
	public ArrayList<String> fetchClaimsData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=connection.claimsdbConnection();
		 //step3 create the statement object  
       Statement stmt=con.createStatement();  
       String sql=properties.getSql11();
     
       ResultSet rs = null;
      
    	    rs=stmt.executeQuery(sql);
    	   rs.next(); 
    	   resultList.add(rs.getString(1));
           System.out.println(rs.getString(1));
       
       stmt.close();
       return resultList;
	}
	
	public ArrayList<String> fetchspecData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=connection.SpecdbConnection();
		 //step3 create the statement object  
       Statement stmt=con.createStatement();  
       String sql=properties.getSql12();
     
       ResultSet rs = null;
      
    	    rs=stmt.executeQuery(sql);
    	   rs.next(); 
    	   resultList.add(rs.getString(1));
           System.out.println(rs.getString(1));
       
       stmt.close();
       return resultList;
	}

	public ArrayList<String> getOsList() {
		// TODO Auto-generated method stub
		os.add(properties.getEnrollment());
        os.add(properties.getCentral());
        os.add(properties.getWest());
        os.add(properties.getEast());
        os.add(properties.getLegal());
		os.add(properties.getFep());
        os.add(properties.getHr());
        os.add(properties.getProvider());
        os.add(properties.getFinance());
        os.add(properties.getCfsHome());
        os.add(properties.getClaims());
        os.add(properties.getSpecialty());
        
        return os;
		
	}

		private static  void writeHeaderLineCe(XSSFSheet sheet) {
		// TODO Auto-generated method stub
		Row headerRow = sheet.createRow(0);
		
		Cell headerCell= headerRow.createCell(0);
		headerCell.setCellValue("ObjectStore");
		
		 headerCell= headerRow.createCell(1);
		headerCell.setCellValue("Count");
		
	}


	private static void writeDataLines(ArrayList<String> resultList,ArrayList<String>  os ,XSSFWorkbook workbook, XSSFSheet sheet)
	{
		int i =0;
		
		for(int rowCount=1; rowCount<=resultList.size();rowCount++)
		{
			int columnCount=0;
			Row row= sheet.createRow(rowCount);
			Cell cell= row.createCell(columnCount++);
			cell.setCellValue(os.get(i));
			cell= row.createCell(columnCount++);
			cell.setCellValue(resultList.get(i));
			i++;
			columnCount=0;
			System.out.println("Row"+rowCount);
			System.out.println("column"+columnCount);
			System.out.println("i"+i);
		}
	}
	}
