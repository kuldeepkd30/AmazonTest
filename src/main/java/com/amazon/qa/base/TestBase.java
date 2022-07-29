package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.util.TestUtil;
import com.amazon.qa.util.WebEventListener;
import com.amazon.qa.testdata.Xls_Reader;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverWait wait;
	public static WebEventListener eventListener;
	public static Xls_Reader info = new Xls_Reader("C:\\Selenium_Workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\testdata\\Amazon_TestData.xlsx");
	
	public TestBase() {
	
		try {
		FileInputStream f= new FileInputStream("C:\\Selenium_Workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(f);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//Now create 
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
	
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
	
		driver.get(prop.getProperty("url"));
		
		wait = new WebDriverWait(driver,TestUtil.EXPLICIT_WAIT);

	
		
	}
}
