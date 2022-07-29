package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	TestUtil testutil;
	HomePage homePage;
	
	
	public HomePageTest() {
		super();
	}

 @BeforeMethod
 public void setUp() {
	 
	 initialization();
	 testutil = new TestUtil();
	 homePage = new HomePage();
	 
 }
 
@Test(priority = 1)
 public void homePageTitleTest() {
	 
	 String homePageTitle = homePage.homePageTitle();
	 Assert.assertEquals(homePageTitle, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items", "Home Page Title isn't Match");
 }
 

 @Test(priority = 2)
 public void globalLocationTest() {
	 
	 String count = homePage.globalLocation();
	 Assert.assertEquals(count, "Canada");
 }
 
 @Test(priority = 3)
 public void searchBarTest() {
	 homePage.search();	 
 }
 
 @Test(priority = 4)
 public void selectedLangTest() {
	String language = homePage.languages();
	Assert.assertEquals(language, "English", "Doesn't match");
 }
 
 @Test(priority = 5)
 public void footerListTest() {
	int list = homePage.footerList();
	Assert.assertEquals(list, 1, "The number of footer links are not matched");
 }
 
@Test(priority = 6)
 public void headerListTest() {
	 int list = homePage.headerList();
	 Assert.assertEquals(list, 28, "The numbers of Header Links are not matched");
 }
 
 @AfterMethod
 public void tearDown() {
	 driver.quit();
 }
 
}
