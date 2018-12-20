package com.FMHerndonBrian.pom_shopping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CSV_DDT_ShoppingTestDriver {
	public WebDriver driver;
	public CsvReader testdata;
	String item2Search;
	String customerName;

	@BeforeClass
	public void setup() throws IOException {
		System.out.println("Brower gets prepared her and will navigate to the AUT.");

		String url = "http://www.sdettraining.com/online";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

		System.out.println("Retrieve Test Data... ");
		String csvInputData = "C:\\Users\\Huser\\Desktop\\Brian SDET Files\\Test Input\\shoppingData.csv";
//		String csvResults = "C:\\Users\\Huser\\Desktop\\Brian SDET Files\\Test Output\\shoppingDataResults.csv";

		testdata = new CsvReader(csvInputData);
	}

	@Test
	public void testShoppingSession() throws IOException {

		testdata.readHeaders();
		// get total numbers of header column
		int numberOfHeaders = testdata.getHeaderCount();
		// print header column
		for (int i = 0; i < numberOfHeaders; i++) {
			System.out.print(testdata.getHeader(i) + ",  ");
		}

		while (testdata.readRecord()) {
			driver = ReusableFunctions.OpenBrowser(runTestInBrowser, AUT_URL);

			System.out.println("Step1: Search Class/Page Object Called - Perform a Search");
			SearchPage sp = new SearchPage();
			sp.searchForItem(driver, testdata.get("product"));

			System.out.println("Step2: Add to Cart");
			sp.addItem2Cart(driver);

			System.out.println("Step3: Modify Cart");
			ShoppingCartPage sc = new ShoppingCartPage();
			sc.modifyCartRowQty(driver, Integer.valueOf(testdata.get("qty")), 1);
			sc.recalculate(driver);
			sc.proceed2Checkout(driver);

			System.out.println("Step4: Check Out");
			CheckoutPage co = new CheckoutPage();
			co.provideCustomerInfo(driver, 
					testdata.get("name"),
					"123 Main St", "Manhattan", "NY", "20121", "7035551414");
			co.providePaymentMethod(driver, "412365896541", "123", "02/2019");
			co.provideShippingInfo(driver, "Trump", "1600 Penn Ave", "Washington", "DC", "20888", "2021114455");

			System.out.println("Step5: Confirm Order & Submit");
			co.submitOrder(driver);

			System.out.println("Step6: Verify Order Placed");
			OrderConfirmationPage oc = new OrderConfirmationPage();
			try {
				oc.verifyOrder(driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterClass
	public void teardown() {
		System.out.println("Browser get closed here.");
		driver.quit();
	}

}
