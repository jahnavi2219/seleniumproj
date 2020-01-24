package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoansinfPOM {
private WebDriver driver; 
	
	public LoansinfPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement accounts; 
	
	
	@FindBy(xpath="//span[contains(text(),'Loans')]")
	private WebElement loans;
	
	@FindBy(xpath="//img[@class='details view']")
	private WebElement view;
	
	@FindBy(xpath="//input[@id='backButton']")
	private WebElement back;
	
	
	public void clickacct() {
		this.accounts.click();
	}
	
	public void clickloans(){
		this.loans.click();
	}
	
	
	public void clickview(){
		this.view.click();
	}
	 
	public void clickback(){
		this.back.click();
	}
	
	
	
	
	
	

}
