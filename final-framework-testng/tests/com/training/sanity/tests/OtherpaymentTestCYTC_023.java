package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.LoansrepayPOM;
import com.training.pom.LoginPOM;
import com.training.pom.OtherpaymentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OtherpaymentTestCYTC_023 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM login;
	private OtherpaymentPOM op;
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
		op = new OtherpaymentPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		login.sendUserName("janu");
		login.sendPassword();
		login.clickLoginBtn();
		Thread.sleep(1000);
		op.clickaccounts();
		op.clickmemberpayment();
		op.clickname("selenium");
		Thread.sleep(2000);
		op.clickreciept("selenium");
		
		op.sendamount("5000");
		op.senddescription("Birthday gift");
		op.clicksubmit();
		op.clicksubmit1();
		
		String actual=driver.findElement(By.xpath("//body[@class='main']//tr//tr[1]//td[1]")).getText();
		String expected="The payment has been performed";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		

		}
	@AfterMethod
	public void tearDown() throws Exception {
	Thread.sleep(3000);
	//driver.quit();
}
}
