package com.training.multi.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {

	public WebDriver getDriver(String browser, String os) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			if (os.equalsIgnoreCase("windows")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
			}
			else {
				System.setProperty("webdriver.chrome.driver", "/root/Downloads/chromedriver_linux");
			}
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//geckodriver.exe");
			driver = new FirefoxDriver();
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
