package com.training.multi.browser.testing;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.multi.base.BaseTest;

public class MultiTests extends BaseTest {
	
	@BeforeMethod
	public void beforeSuite() {
	}

	@AfterMethod
	public void afterSuite() {
	}
	
	@Test(enabled = true)
	public void Test01() {
		//WebDriver driver = getDriver("chrome", "windows");
		WebDriver driver = getDriver("firefox", "linux");
		driver.get("https://www.weather.com");
		driver.manage().window().maximize();
		waitForPageLoaded(driver);
		driver.findElement(By.xpath("//*[@id=\"header-LocalsuiteNav-9e937d06-a4be-493a-bc54-942db4a05af8\"]/div/div/div/ul/li[7]/a/span")).click();
		waitForPageLoaded(driver);
		waitTillMapsLoads(driver, "WELCOME TO OUR MAP!");
		driver.close();
	}
	
	@Test(enabled = false)
	public void Test02() {
		//WebDriver driver = getDriver("chrome", "linux");
		WebDriver driver = getDriver("chrome", "windows");
		driver.get("https://www.weather.com");
		driver.manage().window().maximize();
		waitForPageLoaded(driver);
		driver.findElement(By.xpath("//*[@id=\"header-LocalsuiteNav-9e937d06-a4be-493a-bc54-942db4a05af8\"]/div/div/div/ul/li[7]/a/span")).click();
		waitForPageLoaded(driver);
		waitTillMapsLoads(driver, "WELCOME TO OUR MAP!");
		driver.close();
	}
	
	@Test(enabled = false)
	public void Test03() {
		//WebDriver driver = getDriver("chrome", "linux");
		WebDriver driver = getDriver("chrome", "windows");
		driver.get("https://www.weather.com");
		driver.manage().window().maximize();
		waitForPageLoaded(driver);
		driver.findElement(By.xpath("//*[@id=\"header-LocalsuiteNav-9e937d06-a4be-493a-bc54-942db4a05af8\"]/div/div/div/ul/li[7]/a/span")).click();
		waitForPageLoaded(driver);
		waitTillMapsLoads(driver, "WELCOME TO OUR MAP!");
		driver.close();
	}
	
	public void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		try {
			//Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
			Thread.sleep(1000);
		} 
		catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
	
	public void waitTillMapsLoads(WebDriver driver, String text) {
		boolean found = false;
		int counter = 0;
		while (!found && counter < 15) {
			System.out.println("counter : "+counter);
			waitTime(1000);
			List<WebElement> list = driver.findElements(By.tagName("h2"));
			//System.out.println("list size : "+list.size());
			for (WebElement x:list) {
				//System.out.println("x : "+x.getText());
				if (x.getText().trim().contains(text.trim())) {
					System.out.println("x : "+x.getText().trim());
					found = true;
				}
			}
			counter++;
		}
	}
	
	public void waitTime(int time) {
		try {
			Thread.sleep(time);
		}
		catch (Exception e) {
			
		}
	}
}
