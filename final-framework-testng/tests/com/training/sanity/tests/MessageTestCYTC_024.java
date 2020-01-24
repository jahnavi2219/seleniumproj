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

import com.training.pom.MessagePOM;
import com.training.pom.LoansrepayPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MessageTestCYTC_024 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM login;
	private MessagePOM msg;
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
		msg = new MessagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		login.sendUserName("janu");
		login.sendPassword();
		login.clickLoginBtn();
		Thread.sleep(3000);
		msg.clickpersonal();
		msg.clickmessages();
		msg.clickreadmessage(); 
		String actual=driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
		String expected="Message details";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
}
	@AfterMethod
	public void tearDown() throws Exception {
	Thread.sleep(3000);
	driver.quit();
}
}