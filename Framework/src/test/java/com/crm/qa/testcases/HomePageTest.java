package com.crm.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		testutil=new TestUtil();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
				
	}
	
	
	@Test(priority =1)
	public void verifyhomepagetitleTest() {
		String actual = homepage.verifyhomepageTitle();
		Assert.assertEquals(actual, "CRMPRO");
	}
	
	@Test(priority = 2)
	public void verifyusernameLabelTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyuserlabel());
	}
	
	@Test(priority = 3)
	public void verifyContactsLink() {
		testutil.switchToFrame();
		contactspage = homepage.clickOncontactsLink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
