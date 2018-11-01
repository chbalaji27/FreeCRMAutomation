package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;


public class HomePage extends TestBase {
	
	TestUtil testutil;
	
	@FindBy(xpath="//td[contains(text(),'User: Balaji CH')]")
	WebElement Usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement NewContactsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String verifyhomepageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyuserlabel() {
		return Usernamelabel.isDisplayed();
	}
	
	public ContactsPage clickOncontactsLink() {
		
		
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public void clickonNewcontactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		NewContactsLink.click();
	}
}
