package com.NopCommerce.TestCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.NopCommerce.Utilities.ReadConfig;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	ReadConfig readconfig = new ReadConfig();
	//public String baseURL="https://admin-demo.nopcommerce.com/login/";
	public String baseURL=readconfig.getApplicationURL();
	public String username = readconfig.getUserEmail();
	public String password = readconfig.getPassword();
	public static Logger logger;
	static String path = "/Users/patel/eclipse-workspace/NopCommerceV1/src/test/java/com/NopCommerceTestData/LoginDataCredentials.xlsx";
	
	@BeforeClass
	@Parameters("browser")
	 public void setup(String br)
	{
		
		logger =Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("safari"))
		{
			
			driver = new SafariDriver();
			
		}
		else if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	} 
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File tgt =new File(System.getProperty("user.dir")+ "/Screenshots/" +tname + ".png");
		FileUtils.copyFile(src, tgt);
		System.out.println("Screenshot taken");
	}
	public static String randomstring () throws IOException 
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(6);
		return (generatedString1);
	}
	
	public static String randomNum() throws IOException
	{
		String generatedString2=RandomStringUtils.randomNumeric(5);
		return (generatedString2);
	}
	

}
