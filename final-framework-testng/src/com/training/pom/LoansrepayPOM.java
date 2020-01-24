package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoansrepayPOM {
	
private WebDriver driver; 
	
	
	public LoansrepayPOM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement accounts; 
	
	
	@FindBy(xpath="//span[contains(text(),'Loans')]")
	private WebElement loans;
	
	@FindBy(xpath="//img[@class='details view']")
	private WebElement view;
	
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement repay;
	
	public void clickacct() {
		this.accounts.click();
	}
	
	public void clickloans(){
		this.loans.click();
	}
	
	
	public void clickview(){
		this.view.click();
	}
	 
	public void clickrepay(){
		this.repay.click();
	}
}
