package com.training.multi.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {

	public WebDriver getDriver(String browser, String os) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			if (os.equalsIgnoreCase("windows")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
				driver = new ChromeDriver();
			}
			else {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--no-sandbox");
				System.setProperty("webdriver.chrome.driver", "/tmp/chromedriver_linux");
				driver = new ChromeDriver(options);
			}
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			if (os.equalsIgnoreCase("windows")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else {
				System.setProperty("webdriver.gecko.driver", "/tmp/geckodriver_linux");
				driver = new FirefoxDriver();
			}
			
		} else if (browser.equalsIgnoreCase("interexplorer")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("invalid browser name!!");
			return null;
		}
		return driver;
	}
}
