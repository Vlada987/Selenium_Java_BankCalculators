package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends Base {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String url = "https://www.cit.com/";
	public String ServicePageUrl = "https://www.cit.com/cit-bank/resources/services";

	public void openUrl() {

		driver.get(url);
	}

	public void openAndVerifyServicePage() {

		driver.findElement(By.xpath("//a[@href='/cit-bank/resources/services']")).click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, ServicePageUrl);
	}

	public void openCalculatorsTab() {

		driver.findElement(By.linkText("See calculators")).click();
	}

	public void openSavingsCalculator() {

		driver.findElement(By.linkText("Let's get started")).click();
	}

	public void setupCalculatorData(String dep, String per, String apy, String contr, String freqID) {

		writeText(By.id("mat-input-0"), dep);
		writeText(By.id("mat-input-1"), per);
		writeText(By.id("mat-input-3"), apy);
		writeText(By.id("mat-input-2"), contr);
		driver.findElement(By.id("mat-select-0")).click();
		driver.findElement(By.id("mat-option-" + freqID + "")).click();
		driver.findElement(By.id("CIT-chart-submit")).click();
	}

	public String getResultData() {

		return driver.findElement(By.id("resultBox")).getText();
	}

	public Double reformatTxt(String txtToDouble) {

		String fullTxt = getResultData();
		String part = fullTxt.replace("Your savings could be worth $", "");
		String[] splited = part.split(" after");
		String num = splited[0];
		Double d = Double.parseDouble(num.replace(",", ""));
		return d;
	}

	public void calculatorReset() {

		driver.findElement(By.id("CIT-chart-reset")).click();
	}

}
