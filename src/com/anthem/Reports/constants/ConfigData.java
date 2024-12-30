package com.anthem.Reports.constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigData {
	
	Properties properties;
	private static ConfigData Instance;
	public static final String propName="db.properties";
	
	public static final ConfigData getInstance()
	{
		if (Instance==null)
		{
			Instance= new ConfigData();
		}
		return Instance;
	}
	
	private ConfigData()
	{
		StringBuilder builder= new StringBuilder();
		//ClassLoader loader = Thread.class.getClassLoader();
		builder.append("/com/anthem/Reports/config/");
		builder.append(propName);
		InputStream propinput= ClassLoader.class.getResourceAsStream(builder.toString());
		if(propinput==null)
		{
			throw new RuntimeException("Properties file not found");
		}
		properties= new Properties();
		try {
			properties.load(propinput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {
//			if(propinput !=null)
//
//		{
//				try {
//					propinput.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				}
//		}
	}
	
	public String getEnrollment()
	{
		return properties.getProperty(Constants.ENROLLMENT);
	}
	public String getCentral()
	{
		return properties.getProperty(Constants.CENTRALCLAIMS);
	}

	public String getWest()
	{
		return properties.getProperty(Constants.WESTCLAIMS);
	}
	
	public String getEast()
	{
		return properties.getProperty(Constants.EASTCLAIMS);
	}
	
	public String getLegal()
	{
		return properties.getProperty(Constants.LEGAL);
	}
	
	public String getFep()
	{
		return properties.getProperty(Constants.FEP);
	}
	
	public String getHr()
	{
		return properties.getProperty(Constants.HR);
	}
	
	public String getProvider()
	{
		return properties.getProperty(Constants.PROVIDER);
	}

	public String getFinance()
	{
		return properties.getProperty(Constants.FINANCE);
	}
	
	public String getCfsHome()
	{
		return properties.getProperty(Constants.CFSHOME);
	}
	
	public String getClaims()
	{
		return properties.getProperty(Constants.CLAIMS);
	}
	
	public String getSpecialty()
	{
		return properties.getProperty(Constants.SPECIALTY);
	}
	
	public String getSql1()
	{
		return properties.getProperty(Constants.SQL1);
	}
	public String getSql2()
	{
		return properties.getProperty(Constants.SQL2);
	}
	
	public String getSql3()
	{
		return properties.getProperty(Constants.SQL3);
	}
	
	public String getSql4()
	{
		return properties.getProperty(Constants.SQL4);
	}
	
	public String getSql5()
	{
		return properties.getProperty(Constants.SQL5);
	}
	
	public String getSql6()
	{
		return properties.getProperty(Constants.SQL6);
	}
	public String getSql7()
	{
		return properties.getProperty(Constants.SQL7);
	}
	public String getSql8()
	{
		return properties.getProperty(Constants.SQL8);
	}
	public String getSql9()
	{
		return properties.getProperty(Constants.SQL9);
	}
	public String getSql10()
	{
		return properties.getProperty(Constants.SQL10);
	}
	public String getSql11()
	{
		return properties.getProperty(Constants.SQL11);
	}
	public String getSql12()
	{
		return properties.getProperty(Constants.SQL12);
	}
	
	
	public String getCeDburl()
	{
		return properties.getProperty(Constants.CEDBURL);
	}
	public String getCeUser()
	{
		return properties.getProperty(Constants.CEUSER);
	}
	public String getCePassword()
	{
		return properties.getProperty(Constants.CEPASSWORD);
	}
	public String getSpecUrl()
	{
		return properties.getProperty(Constants.SPECDBURL);
	}
	public String getSpecUser()
	{
		return properties.getProperty(Constants.SPECUSER);
	}
	public String getSpecPassword()
	{
		return properties.getProperty(Constants.SPECPASSWORD);
	}
	
	public String getClaimsUrl()
	{
		return properties.getProperty(Constants.CLAIMSDBURL);
	}
	public String getClaimsUser()
	{
		return properties.getProperty(Constants.CLAIMSCUSER);
	}
	public String getClaimsPassword()
	{
		return properties.getProperty(Constants.CLAIMSPASSWORD);
	}
}
