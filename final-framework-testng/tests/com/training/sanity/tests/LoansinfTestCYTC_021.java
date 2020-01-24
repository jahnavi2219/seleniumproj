package com.training.sanity.tests;

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




import com.training.generics.ScreenShot;
import com.training.pom.LoansinfPOM;
import com.training.pom.LoginPOM ;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoansinfTestCYTC_021 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM lg;
	private LoansinfPOM la;
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
		lg = new LoginPOM(driver); 
		la=new LoansinfPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@Test
	public void validLoginTest() {
		lg.sendUserName("janu");
		lg.sendPassword();
		lg.clickLoginBtn();
		//loansinfPOM.sendPassword()
		la.clickacct();
		la.clickloans();
		la.clickview();
		la.clickback();
		String actual=driver.findElement(By.xpath("//td[contains(text(),'My loans')]")).getText();
		String expected="My loans";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
	Thread.sleep(3000);
	driver.quit();
}
}	

