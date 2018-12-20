package com.FMHerndonBrian.pom_shopping;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.FMHerndonSMI.Tests.MyLog;

public class ShoppingTestDriver {
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.out.println("Brower gets prepared her and will navigate to the AUT.");

		String url = "http://www.sdettraining.com/online";		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test
	public void testShoppingSession() {
		System.out.println("Step1: Search Class/Page Object Called - Perform a Search");
		SearchPage sp = new SearchPage();
		sp.searchForItem(driver, "Echo");
		
		System.out.println("Step2: Add to Cart");
		sp.addItem2Cart(driver);
		
		System.out.println("Step3: Modify Cart");
		ShoppingCartPage sc = new ShoppingCartPage();
		sc.modifyCartRowQty(driver, 3, 1);
		sc.recalculate(driver);
		sc.proceed2Checkout(driver);
		
		System.out.println("Step4: Check Out");
		CheckoutPage co = new CheckoutPage();
		co.provideCustomerInfo(driver, "Brett", "123 Main St", "Manhattan", "NY", "20121", "7035551414");
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

	@AfterClass
	public void teardown() {
		System.out.println("Browser get closed here.");
//		driver.quit();
	}

}
