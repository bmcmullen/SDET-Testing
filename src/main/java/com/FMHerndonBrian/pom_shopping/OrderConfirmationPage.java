package com.FMHerndonBrian.pom_shopping;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.FMHerndonSMI.Tests.MyLog;

public class OrderConfirmationPage {
	public void verifyOrder(WebDriver driver) throws IOException {
		String orderConfirmation = driver.findElement(By.cssSelector("h2")).getText();
		MyLog.info("orderConfirmation: " + orderConfirmation);

		Assert.assertEquals(orderConfirmation,"Thank you for ordering with us!");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(
				"C://Users//Huser//Desktop//Brian SDET Files//Test Output//orderConfirmation.jpg"));
	}
}
