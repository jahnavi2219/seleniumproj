package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.training.pom.LoansrepayPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loansrepayBDD22 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM lg;
	private LoansrepayPOM lr;
	private static Properties properties;
	
	@Given("^User should launch the application by valid url and user should be logged as member and should present in homepage$")
	public void user_should_launch_the_application_by_valid_url_and_user_should_be_logged_as_member_and_should_present_in_homepage() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		lg = new LoginPOM(driver); 
		lr = new LoansrepayPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
		lg.sendUserName("janu");
		lg.sendPassword();
		lg.clickLoginBtn();
	}

	@When("^Loans information is displayed and select amount to repay$")
	public void loans_information_is_displayed_and_select_amount_to_repay() throws Throwable {
		lr.clickacct();
		lr.clickloans();
		lr.clickview();
	   
	}

	@Then("^Amount is repaid and the remaining amount is displayed$")
	public void amount_is_repaid_and_the_remaining_amount_is_displayed() throws Throwable {
		lr.clickrepay();
		Thread.sleep(5000);
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		Thread.sleep(4000);
		Alert alert2=driver.switchTo().alert();
		alert1.accept();
		String actual=driver.findElement(By.xpath("//td[contains(text(),'Loan details')]")).getText();
		String expected="Loan details";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	   
	}



}
