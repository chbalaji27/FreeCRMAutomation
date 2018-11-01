package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	ContactsPage contactspage;
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	//String sheetName="contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testutil.switchToFrame();
		
		
		contactspage=homepage.clickOncontactsLink();
		}

	@DataProvider()
	public Object[][] getCRMTestdata() {
		Object data[][]=TestUtil.getTestData( "contacts");
		return data;
		
	}
	
	@Test(dataProvider="getCRMTestdata")
	public void validateNewcontact(String title,String firstname,String lastname,String company) {
		homepage.clickonNewcontactLink();
		//contactspage.createNewContact("Mr.", "Balaji", "CH", "CTS");
		contactspage.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
