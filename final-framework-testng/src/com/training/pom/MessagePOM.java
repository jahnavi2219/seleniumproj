package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePOM  {
		private WebDriver driver; 
		
		public MessagePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//span[contains(text(),'Personal')]")
		private WebElement personal;
		
		@FindBy(xpath="//span[contains(text(),'Messages')]")
		private WebElement messages;
		
		@FindBy(xpath="//td[contains(text(),'Search results')]")
		private WebElement searchresults;
		
		@FindBy(xpath="//td[@class='readMessage']//a[@class='linkList messageDetails'][contains(text(),'Loan granted')]")
		private WebElement readmessage;
		
		public void clickpersonal() {
			this.personal.click();
		}
		
		public void clickmessages() {
			this.messages.click();
		}
		
		public void clickreadmessage() {
			this.readmessage.click();
		}
		
		

}
