package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class CreateNewAccountPage extends TestBase {
	
	@FindBy(name = "customerName")
	WebElement cusName ;
	
	@FindBy(name = "email")
	WebElement email ;
	
	@FindBy(name = "password")
	WebElement password ;
	
	@FindBy(name = "passwordCheck")
	WebElement passwordCheck ;
	
	@FindBy(id = "continue")
	WebElement continueButton ;
	
	@FindBy(linkText = "Conditions of Use")
	WebElement conditionLink;
	
	@FindBy(linkText = "Privacy Notice")
	WebElement privacyLink;
	
	@FindBy(linkText = "Sign in")
	WebElement signInLink;
	
	@FindBy(linkText = "Create a free business account")
	WebElement businessLink;
	
	@FindBy(xpath="//div[@id='auth-password-invalid-password-alert']")
	WebElement lessCharErr;
	
	@FindBy(xpath="//div[@id='auth-password-mismatch-alert']")
	WebElement pwdmmErr;
	
	@FindBy(xpath="//div[@id='auth-passwordCheck-missing-alert']")
	WebElement authPwdErr;
	////div[@id='auth-password-mismatch-alert']
	
	@FindBy(xpath="//div[@id='auth-customerName-missing-alert']")
	WebElement missingNErr;
	
	//auth-customerName-missing-alert
	@FindBy(xpath="//div[@id='auth-email-missing-alert']")
	WebElement emptyMailErr;
	
	//auth-email-missing-alert 
	public CreateNewAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String CreateNewAccountPageTitle() {
		return driver.getTitle();
	}

public String smallPwdErr() throws InterruptedException {
		
		String name = info.getCellData("Sheet2",0,2);
		cusName.sendKeys(name);
		
		String mailId = info.getCellData("Sheet2",1,2);
		email.sendKeys(mailId);
		
		String pwd = info.getCellData("Sheet2",2,2);
		password.sendKeys(pwd);
		
		String matPwd = info.getCellData("Sheet2",3,2);
		passwordCheck.sendKeys(matPwd);
		continueButton.click();
		
		String sPwdErr = lessCharErr.getText();
		System.out.println(sPwdErr);
		
		return sPwdErr;
		
	}

public String unmatchPwdErr() {
	
	String name = info.getCellData("Sheet2",0,3);
	cusName.sendKeys(name);
	
	String mailId = info.getCellData("Sheet2",1,3);
	email.sendKeys(mailId);
	
	String pwd = info.getCellData("Sheet2",2,3);
	password.sendKeys(pwd);
	
	String matPwd = info.getCellData("Sheet2",3,3);
	passwordCheck.sendKeys(matPwd);
	continueButton.click();
	
	String mmPwdErr = pwdmmErr.getText();
	System.out.println(mmPwdErr);
	
	return mmPwdErr;
	
}

public String emptyRePwdErr() {
	
	String name = info.getCellData("Sheet2",0,4);
	cusName.sendKeys(name);
	
	String mailId = info.getCellData("Sheet2",1,4);
	email.sendKeys(mailId);
	
	String pwd = info.getCellData("Sheet2",2,4);
	password.sendKeys(pwd);
	
	String matPwd = info.getCellData("Sheet2",3,4);
	passwordCheck.sendKeys(matPwd);
	continueButton.click();
	
	String auPwdErr = authPwdErr.getText();
	System.out.println(auPwdErr);
	
	return auPwdErr;
	
}

public String blanckNmErr() {
	
	String name = info.getCellData("Sheet2",0,5);
	cusName.sendKeys(name);
	
	String mailId = info.getCellData("Sheet2",1,5);
	email.sendKeys(mailId);
	
	String pwd = info.getCellData("Sheet2",2,5);
	password.sendKeys(pwd);
	
	String matPwd = info.getCellData("Sheet2",3,5);
	passwordCheck.sendKeys(matPwd);
	continueButton.click();
	
	String nameErr = missingNErr.getText();
	System.out.println(nameErr);
	
	return nameErr;
	
}

public String emptyMailErr() {
	
	String name = info.getCellData("Sheet2",0,6);
	cusName.sendKeys(name);
	
	String mailId = info.getCellData("Sheet2",1,6);
	email.sendKeys(mailId);
	
	String pwd = info.getCellData("Sheet2",2,6);
	password.sendKeys(pwd);
	
	String matPwd = info.getCellData("Sheet2",3,6);
	passwordCheck.sendKeys(matPwd);
	continueButton.click();
	
	String mailErr = emptyMailErr.getText();
	System.out.println(mailErr);
	
	return mailErr;
	
}
public String condition() {
	conditionLink.click();
	return driver.getTitle();
}

public String privacy() {
	privacyLink.click();
	return driver.getTitle();
}

public String businessAcc() {
	businessLink.click();
	return driver.getTitle();
}

public SignInPage signIn() {
	signInLink.click();
	return new SignInPage();
}
}
	
	
	
	