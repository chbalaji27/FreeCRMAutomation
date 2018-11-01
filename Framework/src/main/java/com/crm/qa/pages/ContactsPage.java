package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(name = "title")
	WebElement title;
	
	@FindBy(id = "first_name")
	WebElement firstname;
	
	@FindBy(id = "surname")
	WebElement lastname;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value = 'Save']")
	WebElement savebtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String Title,String First_name,String Last_name,String Company_name) {
		Select select=new Select(title);
		select.selectByValue(Title);
		
		firstname.sendKeys(First_name);
		lastname.sendKeys(Last_name);
		company.sendKeys(Company_name);
		savebtn.submit();
		
		
		
	}
}
