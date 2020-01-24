package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccinfPOM {
private WebDriver driver; 
	
	public AccinfPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement accounts; 
	
	@FindBy(xpath="//span[contains(text(),'System Payment')]")
	private WebElement systempaylink; 
	
	@FindBy(xpath="//input[@id='amount']")
	private WebElement amount;
	
	@FindBy(xpath="//select[@id='type']")
	private WebElement transactiontype ;
	
	@FindBy(xpath="//textarea[@id='description']")
	private WebElement description;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement submit;
	
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement submit1;
	
	@FindBy(xpath="//span[contains(text(),'Account Information')]")
	private WebElement accinformation ;
	
	public void clickaccounts() {
		this.accounts.click();
	}
	
	public void clicksystempaylink() {
		this.systempaylink.click();
	}
	
	
	public void sendamount(String amount) {
		this.amount.sendKeys(amount);
	}
	
	public void clicktransactiontype() {
		this.transactiontype.click();
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
	

	public void clickaccinformation() {
		this.accinformation.click();
	}
	
	
	
	
}
