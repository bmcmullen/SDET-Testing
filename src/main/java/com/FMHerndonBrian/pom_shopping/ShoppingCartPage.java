package com.FMHerndonBrian.pom_shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

	public void modifyCartRowQty(WebDriver driver, int qty, int cartRow) {
		driver.findElement(By.name("txtItemQty" + cartRow)).clear();
		driver.findElement(By.name("txtItemQty" + cartRow)).sendKeys(String.valueOf(qty));
	}

	public void recalculate(WebDriver driver) {
		driver.findElement(By.id("Recalc")).click();
	}
	
	public void proceed2Checkout(WebDriver driver) {
		driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click(); 
	}

}
