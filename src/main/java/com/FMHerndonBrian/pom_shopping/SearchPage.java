package com.FMHerndonBrian.pom_shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	
	public void searchForItem(WebDriver driver, String item) {
		driver.findElement(By.name("txtSearch")).clear();
		driver.findElement(By.name("txtSearch")).sendKeys(item);
		driver.findElement(By.id("Go")).click();
	}
	
	// Add Item - Currently takes the 1st item in the search results list.
	public void addItem2Cart(WebDriver driver) {
		driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[1]/td[3]/a/img")).click();
		
	}
}
