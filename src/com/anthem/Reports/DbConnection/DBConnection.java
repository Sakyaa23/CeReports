package com.anthem.Reports.DbConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.anthem.Reports.constants.ConfigData;


public class DBConnection {
	
		ConfigData properties;
		
		public Connection CedbConnection() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			//step1 load the driver class  
			if(null==properties)
			{
				properties= ConfigData.getInstance();
			}
	        Class.forName("oracle.jdbc.driver.OracleDriver");  
	          
	        //step2 create  the connection object  
	        Connection con = DriverManager.getConnection(
	        		properties.getCeDburl(),properties.getCeUser(),properties.getCePassword());
			return con;
	          
		}
		
		public Connection SpecdbConnection() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			//step1 load the driver class  
			if(null==properties)
			{
				properties= ConfigData.getInstance();
			}
	        Class.forName("oracle.jdbc.driver.OracleDriver");  
	          
	        //step2 create  the connection object  
	        Connection con = DriverManager.getConnection(
	        		properties.getSpecUrl(),properties.getSpecUser(),properties.getSpecPassword());
			return con;
	          
		}
		
		public Connection claimsdbConnection() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			//step1 load the driver class  
			if(null==properties)
			{
				properties= ConfigData.getInstance();
			}
	        Class.forName("oracle.jdbc.driver.OracleDriver");  
	          
	        //step2 create  the connection object  
	        Connection con = DriverManager.getConnection(
	        		properties.getClaimsUrl(),properties.getClaimsUser(),properties.getClaimsPassword());
			return con;
	          
		}

}
