package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CreateNewAccountPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.ProductPage;
import com.amazon.qa.pages.SignInPage;
import com.amazon.qa.util.TestUtil;

public class CreateAccountPageTest extends TestBase {
	TestUtil testUtil;
	HomePage homePage;
	ProductPage productPage;
	SignInPage signInpage;
	CreateNewAccountPage createNewAccountPage;
	
	public CreateAccountPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil= new TestUtil();
		homePage = new HomePage();
		productPage = new ProductPage();
		signInpage = new SignInPage();
		createNewAccountPage = new CreateNewAccountPage();
		homePage.createAcc();
		
	}
	@Test(priority = 1)
	public void NewUserAccountTitleTest() {
		String pageTitle = createNewAccountPage.CreateNewAccountPageTitle();
		 Assert.assertEquals(pageTitle,"Amazon Registration", "Title isn't matched");
	}
	
	@Test(priority = 2)
	public void passwordSizeErrTest() throws InterruptedException {
		String pwderr = createNewAccountPage.smallPwdErr();
		 Assert.assertEquals(pwderr,"Minimum 6 characters required", "Title isn't matched");
	}
	
	@Test(priority = 3)
	public void nonIdenticalpwdErrTest() throws InterruptedException {
		String pwderr = createNewAccountPage.unmatchPwdErr();
		 Assert.assertEquals(pwderr,"Passwords do not match", "Title isn't matched");
	}
	
	@Test(priority = 4)
	public void emptypwdErrTest() throws InterruptedException {
		String pwderr = createNewAccountPage.emptyRePwdErr();
		 Assert.assertEquals(pwderr,"Type your password again", "Title isn't matched");
	}
	
	@Test(priority = 5)
	public void emptyNmErrTest() throws InterruptedException {
		String pwderr = createNewAccountPage.blanckNmErr();
		 Assert.assertEquals(pwderr,"Enter your name", "Title isn't matched");
	}
	
	@Test(priority = 6)
	public void emptyEmailErrTest() throws InterruptedException {
		String pwderr = createNewAccountPage.emptyMailErr();
		 Assert.assertEquals(pwderr,"Enter your e-mail address or mobile phone number", "Title isn't matched");
	}
	@Test(priority =7)
	public void conditionLinkTest() {
	String pageTitle = createNewAccountPage.condition();
	Assert.assertEquals(pageTitle,"Amazon.ca Conditions of Use - Amazon Customer Service", "Title isn't matched, Link is not working.");
		
	}
	
	@Test(priority =8)
	public void privacyLinkTest() {
	String pageTitle = createNewAccountPage.privacy();
	Assert.assertEquals(pageTitle,"Amazon.ca Privacy Notice - Amazon Customer Service");
		
	}
	
	@Test(priority =9)
	public void businessAccLinkTest() {
	String pageTitle = createNewAccountPage.businessAcc();
	Assert.assertEquals(pageTitle,"Amazon.ca Privacy Notice - Amazon Customer Service");
		
	}
	@AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }

}
