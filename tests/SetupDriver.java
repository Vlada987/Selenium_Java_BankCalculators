package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetupDriver {

	public WebDriver driver;
	String gecko = "C:\\Users\\zikaz\\OneDrive\\Desktop\\projects\\Selenium ddt\\geckodriver.exe";

	public void setup() {

		System.setProperty("webdriver.gecko.driver", gecko);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public void teardown() {

		driver.quit();
	}

}
