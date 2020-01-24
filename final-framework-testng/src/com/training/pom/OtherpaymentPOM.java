package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtherpaymentPOM {
private WebDriver driver; 
	
	public OtherpaymentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement accounts; 
	
	@FindBy(xpath="//span[contains(text(),'Member Payment')]")
	private WebElement memberpayment; 
	
	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement name; 
	
	@FindBy(xpath="//input[@id='memberName']")
	private WebElement reciept; 
	
	@FindBy(xpath="//input[@id='amount']")
	private WebElement amount; 
	
	@FindBy(xpath="//textarea[@id='description']")
	private WebElement description; 
	

	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement submit; 
	
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement submit1; 
	
	public void clickaccounts() {
		this.accounts.click();
	}
	
	public void clickmemberpayment() {
		this.memberpayment.click();
	}
	
	
	public void clickname(String name) {
		this.name.sendKeys(name);
	}
	
	public void clickreciept(String reciept) {
		this.reciept.sendKeys(reciept);
	}
	
	public void sendamount(String amount) {
		this.amount.sendKeys(amount);
	}
	
	public void senddescription(String description) {
		this.description.sendKeys(description);
	}
	
	public void clicksubmit() {
		this.submit.click();
	}
	
	
	public void clicksubmit1() {
		this.submit1.click();
	}
	
	
	
}
