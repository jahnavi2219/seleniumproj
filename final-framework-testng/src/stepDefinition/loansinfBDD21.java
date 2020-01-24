package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.training.pom.LoansinfPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loansinfBDD21 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM lg;
	private LoansinfPOM la;
	private static Properties properties;


	@Given("^User should launch the application by valid url with valid admin credentials and admin should grant the loan$")
	public void user_should_launch_the_application_by_valid_url_with_valid_admin_credentials_and_admin_should_grant_the_loan() throws Throwable {properties = new Properties();
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			lg = new LoginPOM(driver); 
			la = new LoansinfPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			driver.get("http://localhost:8585/");
		}
	

	@When("^User should be logged and should be in homepage and should display information if it is available$")
	public void user_should_be_logged_and_should_be_in_homepage_and_should_display_information_if_it_is_available() throws Throwable {
		lg.sendUserName("janu");
		lg.sendPassword();
		lg.clickLoginBtn();
		
	}

	@Then("^Loans information of member is displayed$")
	public void loans_information_of_member_is_displayed() throws Throwable {
		la.clickacct();
		la.clickloans();
		la.clickview();
		la.clickback();
		String actual=driver.findElement(By.xpath("//td[contains(text(),'My loans')]")).getText();
		String expected="My loans";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	    
	}



}
