package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.training.pom.LoginPOM;
import com.training.pom.MsgtrashPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class msgtrashBDD25 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM login;
	private MsgtrashPOM msg;
	private static Properties properties;
	@Given("^User should launch cyclos application by valid url and he should be logged and present in home page$")
	public void user_should_launch_cyclos_application_by_valid_url_and_he_should_be_logged_and_present_in_home_page() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		login = new LoginPOM(driver); 
		msg = new MsgtrashPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
		login.sendUserName("janu");
		login.sendPassword();
		login.clickLoginBtn();
	}

	@When("^User opens proper personal and message link and then deletes$")
	public void user_opens_proper_personal_and_message_link_and_then_deletes() throws Throwable {
		msg.clickpersonal();
		msg.clickmessages();
		Thread.sleep(3000);
		Thread.sleep(3000);
		msg.clicktrash();
		Thread.sleep(3000);
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
	}

	@Then("^Selected message should be deleted and shows remaining messages$")
	public void selected_message_should_be_deleted_and_shows_remaining_messages() throws Throwable {
		String actual=driver.findElement(By.xpath("//td[contains(text(),'Search results')]")).getText();
		String expected="Search results";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}


}
