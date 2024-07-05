package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public WebDriver driver;
	public WebDriverWait wait;

	public Base(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	public void writeText(By element, String txt) {

		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(txt);
	}

}
