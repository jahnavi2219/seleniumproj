package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.training.pom.LoginPOM;
import com.training.pom.MessagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class messageBDD24 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM login;
	private MessagePOM msg;
	private static Properties properties;
	
	@Given("^User should launch the application by valid url and he should be logged and present in home page$")
	public void user_should_launch_the_application_by_valid_url_and_he_should_be_logged_and_present_in_home_page() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		login = new LoginPOM(driver); 
		msg = new MessagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
		login.sendUserName("janu");
		login.sendPassword();
		login.clickLoginBtn();
	}

	@When("^User opens proper personal and message link$")
	public void user_opens_proper_personal_and_message_link() throws Throwable {
		msg.clickpersonal();
		msg.clickmessages();
		msg.clickreadmessage(); 
	   
	}

	@Then("^Message details are displayed$")
	public void message_details_are_displayed() throws Throwable {
		msg.clickreadmessage(); 
		String actual=driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
		String expected="Message details";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);   
	}

}
