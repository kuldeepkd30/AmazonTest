package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class ProductPage extends TestBase {
	
	
	@FindBy(xpath = "//div[@id='brandsRefinements']/ul/li")
	WebElement brand;
	
	@FindBy(xpath= "//div[@id='departments']/ul/li")
	List<WebElement>department;
	
	
	@FindBy(xpath="//div[@id='priceRefinements']/ul[1]/li" )
	List<WebElement> price;
	
	@FindBy(xpath="//div[@data-asin='B09871Q9LC']")
	WebElement Product;
	
	@FindBy(xpath="//li[@data-defaultasin='B09871GL75']")
	WebElement prodStyle;
	
	@FindBy(xpath ="//input[@id='add-to-cart-button']")
	WebElement addToCartButton;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public int priceFilter() {
		for(WebElement data: price) {
			System.out.println(data.getText());
			
			if(data.getText().equals("$25 to $50")) {
				data.click();
				break;
			}
		}
		return price.size();
	}
	
	
	public String productDepartment() {
		
		for(WebElement name: department) {
			System.out.println(name.getText());
			
			if(name.getText().equals("Men's Fashion")) {
				System.out.println(driver.getTitle());
				name.click();
				break;
			}
		}
		return driver.getTitle();
	}
	
	public String productLink() throws InterruptedException {
		
		Product.click();	
		Thread.sleep(2000);
		prodStyle.click();
		
		WebElement size = driver.findElement(By.xpath("//select[@name='dropdown_selected_size_name']"));
		Select fitting= new Select(size);
		fitting.selectByVisibleText("6-8");
		Thread.sleep(2000);
		
		WebElement quantity = driver.findElement(By.xpath("//select[@id='quantity']"));
		
		Select qty =new Select(quantity);
		qty.selectByValue("2");
		

		
		Thread.sleep(2000);
		
		addToCartButton.click();
		
		Thread.sleep(2000);
		
		String actualTitle = driver.getTitle();
		
		System.out.println(actualTitle);
		
		return actualTitle;
			
	}
}

