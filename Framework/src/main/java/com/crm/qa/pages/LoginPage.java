package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory ---- Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//body//div[@id='navbar-collapse']//ul//li[2]//a")
	WebElement signupBtn;
	
	@FindBy(xpath = "//body//div[@class='navbar-header']//a//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver	, this);
	}
	
	//Actions
	public String validateloginpageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMlogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.submit();
		return new HomePage();
		
	}
}
