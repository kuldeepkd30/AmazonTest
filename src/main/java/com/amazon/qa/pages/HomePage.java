package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory - Object Repository
	
	@FindBy(id="nav-link-accountList")
	WebElement signInLink;
	
	@FindBy(id="nav-cart")
	WebElement cartLink;
	
	
	@FindBy(xpath = "//span[contains(text(),'Canada')]")
	WebElement location;
	
	@FindBy(xpath="//span[@class='nav-action-inner']")
	WebElement signInButton;
	
	@FindBy(id="nav-orders")
	WebElement OrdersLink;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(id ="icp-touch-link-language")
	WebElement language;
	
	@FindBy(id="nav-link-accountList")
	WebElement account;
	
	@FindBy(xpath = "//div[@class='navFooterVerticalColumn navAccessibility']")
	List<WebElement> footerList;
	
	@FindBy(xpath ="//div[@id='nav-xshop']/a")
	List<WebElement> headerList;
	
	@FindBy(id = "nav-flyout-ya-signin")
	WebElement user;
	
	@FindBy(id = "createAccountSubmit")
	WebElement createAccountButton;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	
	public String globalLocation() {
		return location.getText();
	}
	
	public ProductPage search() {
		
		String searchData = prop.getProperty("search");
		
		searchBar.sendKeys(searchData);
		

		
		searchButton.click();
		
		
		return new ProductPage();
	}
	
	public String languages() {
		
		return language.getText();
	}
	
	public int footerList() {
		
		for(WebElement a:footerList) {
			System.out.println(a.getText());
		}
		
		return footerList.size();
	}
	
	public int headerList() {
		
		for(WebElement a: headerList) {
			System.out.println(a.getText());	
		}
		return headerList.size();
	}
	
	public SignInPage signInacc() {
		
		Actions builder = new Actions(driver);
		builder.moveToElement(account).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(user));
		
		user.click();
		
		return new SignInPage();
		
	}
public CreateNewAccountPage createAcc() {
		
		Actions builder = new Actions(driver);
		builder.moveToElement(account).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(user));
		
		user.click();
		createAccountButton.click();
		
		
		
		return new CreateNewAccountPage();
		
	}
	
	
}
