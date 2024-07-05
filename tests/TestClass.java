package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import utility.GetData;

public class TestClass extends SetupDriver {

	public HomePage hp;
	GetData getdata = new GetData();
	String calcPath = "C:\\Users\\zikaz\\OneDrive\\Desktop\\projects\\Selenium ddt\\bankCalculator.xlsx";

	@Test
	public void test00_OpenPage() throws InterruptedException, IOException {

		setup();
		hp = new HomePage(driver);
		hp.openUrl();
		Thread.sleep(1000);
		hp.openAndVerifyServicePage();
		hp.openCalculatorsTab();
		hp.openSavingsCalculator();

		String[][] data = getdata.get2DarrayData(calcPath);
		int rows = data.length;

		for (int a = 0; a < rows; a++) {

			hp.setupCalculatorData(data[a][0], data[a][1], data[a][2], data[a][3], data[a][4]);
			String txt = hp.getResultData();
			Double dataD = hp.reformatTxt(txt);
			hp.calculatorReset();

			Assert.assertEquals(dataD, Double.parseDouble(data[a][5]));
		}
		Thread.sleep(1000);
		teardown();
	}

}
