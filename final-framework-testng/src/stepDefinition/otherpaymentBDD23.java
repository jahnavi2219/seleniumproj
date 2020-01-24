package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.training.pom.LoginPOM;
import com.training.pom.OtherpaymentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class otherpaymentBDD23 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM login;
	private OtherpaymentPOM op;
	private static Properties properties;
	
	@Given("^User should launch the application by valid url and he should be logged as member recepient member name should be known$")
	public void user_should_launch_the_application_by_valid_url_and_he_should_be_logged_as_member_recepient_member_name_should_be_known()  throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		login = new LoginPOM(driver); 
		op = new OtherpaymentPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
		login.sendUserName("janu");
		login.sendPassword();
		login.clickLoginBtn();
	}

	@When("^Valid credentials for login,amount and description should be given$")
	public void valid_credentials_for_login_amount_and_description_should_be_given() throws Throwable {
		
		op.clickaccounts();
		op.clickmemberpayment();
		op.clickname("selenium");
		Thread.sleep(3000);
		op.clickreciept("selenium");
		op.sendamount("5000");
		op.senddescription("Birthday gift");
		op.clicksubmit();
		op.clicksubmit1();
		
	}

	@Then("^Payment has been performed and message should be displayed$")
	public void payment_has_been_performed_and_message_should_be_displayed() throws Throwable {
		
		String actual=driver.findElement(By.xpath("//body[@class='main']//tr//tr[1]//td[1]")).getText();
		String expected="The payment has been performed";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	   
	}

}








