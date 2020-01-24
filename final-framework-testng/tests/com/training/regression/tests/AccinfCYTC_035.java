package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AccinfPOM;
import com.training.pom.LoginPOM;
import com.training.pom.OtherpaymentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AccinfCYTC_035 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM login;
	private AccinfPOM ac;
	private static Properties properties;
	//private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		login = new LoginPOM(driver); 
		ac = new AccinfPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@Test
	public void validLoginTest() throws InterruptedException {
		login.sendUserName("janu");
		login.sendPassword();
		login.clickLoginBtn();
		Thread.sleep(1000);
		ac.clickaccounts();
		ac.clicksystempaylink();
		ac.sendamount("500");
		ac.clicktransactiontype();
		ac.senddescription("charity");
		ac.clicksubmit();
		ac.clicksubmit1();
		ac.clickaccinformation();
		
		String actual=driver.findElement(By.xpath("//td[contains(text(),'Search results')]")).getText();
		String expected="Search results";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
		
	}	
	@AfterMethod
	public void tearDown() throws Exception {
	Thread.sleep(3000);
	//driver.quit();
}
	
}
