package com.FMHerndonBrian.pom_shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.FMHerndonSMI.Tests.MyLog;

public class CheckoutPage {
	// TODO Create a Customer Object, maybe
	public void provideCustomerInfo(WebDriver driver, String name, String address, String city, String state,
			String zip, String phone) {
		driver.findElement(By.name("txtCustomerName")).clear();
		driver.findElement(By.name("txtCustomerName")).sendKeys(name);
		driver.findElement(By.name("txtAddress")).clear();
		driver.findElement(By.name("txtAddress")).sendKeys(address);
		driver.findElement(By.name("txtCity")).clear();
		driver.findElement(By.name("txtCity")).sendKeys(city);
		driver.findElement(By.name("txtState")).clear();
		driver.findElement(By.name("txtState")).sendKeys(state);
		driver.findElement(By.name("txtZIP")).clear();
		driver.findElement(By.name("txtZIP")).sendKeys(zip);
		driver.findElement(By.name("txtPhone")).clear();
		driver.findElement(By.name("txtPhone")).sendKeys(phone);
		// MyLog.info("Customer Information Provided");
	}

	public void providePaymentMethod(WebDriver driver, String acctNo, String secCode, String expDate) {
		driver.findElement(By.name("optPaymentType")).click();
		driver.findElement(By.name("txtAcctNo")).clear();
		driver.findElement(By.name("txtAcctNo")).sendKeys(acctNo);
		driver.findElement(By.name("txtCVV2No")).clear();
		driver.findElement(By.name("txtCVV2No")).sendKeys(secCode);
		driver.findElement(By.name("txtExpDate")).clear();
		driver.findElement(By.name("txtExpDate")).sendKeys(expDate);
	}

	public void provideShippingInfo(WebDriver driver, String name, String address, String city, String state,
			String zip, String phone) {
		driver.findElement(By.name("txtshipCustomerName")).clear();
		driver.findElement(By.name("txtshipCustomerName")).sendKeys(name);
		driver.findElement(By.name("txtshipAddress")).clear();
		driver.findElement(By.name("txtshipAddress")).sendKeys(address);
		driver.findElement(By.name("txtshipCity")).clear();
		driver.findElement(By.name("txtshipCity")).sendKeys(city);
		driver.findElement(By.name("txtshipState")).clear();
		driver.findElement(By.name("txtshipState")).sendKeys(state);
		driver.findElement(By.name("txtshipZIP")).clear();
		driver.findElement(By.name("txtshipZIP")).sendKeys(zip);
		driver.findElement(By.name("txtshipPhone")).clear();
		driver.findElement(By.name("txtshipPhone")).sendKeys(phone  );
	}
	
	public void submitOrder(WebDriver driver) {
		driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();
	}

}
