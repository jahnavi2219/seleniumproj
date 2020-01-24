package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.training.pom.AccinfPOM;
import com.training.pom.LoginPOM;
import com.training.pom.OtherpaymentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class accinfBDD35 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM login;
	private AccinfPOM ac;
	private static Properties properties;
	
	@Given("^User should launch application by valid url and he should be logged and present in home page$")
	public void user_should_launch_application_by_valid_url_and_he_should_be_logged_and_present_in_home_page() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		login = new LoginPOM(driver); 
		ac = new AccinfPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
		login.sendUserName("janu");
		login.sendPassword();
		login.clickLoginBtn();
	}

	@When("^User gives proper credentials in system payment in accounts link$")
	public void user_gives_proper_credentials_in_system_payment_in_accounts_link() throws Throwable {
		ac.clickaccounts();
		ac.clicksystempaylink();
		ac.sendamount("500");
		ac.clicktransactiontype();
		ac.senddescription("charity");
	}

	@Then("^Payment is done and transaction details are displayed$")
	public void payment_is_done_and_transaction_details_are_displayed() throws Throwable {
		ac.clicksubmit();
		ac.clicksubmit1();
		ac.clickaccinformation();
		
		String actual=driver.findElement(By.xpath("//td[contains(text(),'Search results')]")).getText();
		String expected="Search results";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}

}
