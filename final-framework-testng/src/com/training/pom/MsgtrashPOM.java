package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MsgtrashPOM {
	private WebDriver driver; 
	
	public MsgtrashPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	private WebElement personal;
	
	@FindBy(xpath="//span[contains(text(),'Messages')]")
	private WebElement messages;
	
	@FindBy(xpath="//td[contains(text(),'Search results')]")
	private WebElement searchresults;
	
	@FindBy(xpath="//tr[6]//td[5]//img[1]")
	private WebElement trash;
	

	public void clickpersonal() {
		this.personal.click();
	}
	
	public void clickmessages() {
		this.messages.click();
	}
	

	public void clicktrash() {
		this.trash.click();
	}
	
}
