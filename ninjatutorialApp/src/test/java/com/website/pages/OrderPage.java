package com.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage extends LoginPage {
		public void product() throws InterruptedException {
			
			WebElement Phonesctg = driver.findElement(By.linkText("Phones & PDAs"));
			Phonesctg.click();

			WebElement selectitem = driver.findElement(By.cssSelector("#content > div:nth-child(3) > div:nth-child(2) > div > div.image > a > img"));
			selectitem.click();
			
		
		}
		public void addtocart() throws InterruptedException 
		{	
			WebElement AddQuantity = driver.findElement(By.cssSelector("#input-quantity")); 
			AddQuantity.clear();
			WebElement Itemviewcart = driver.findElement(By.cssSelector("#cart > button"));
			Thread.sleep(2000);
			Itemviewcart.click();
			WebElement deleteitem = driver.findElement(By.cssSelector("#cart > ul > li:nth-child(1) > table > tbody > tr > td:nth-child(5) > button"));
			Thread.sleep(2000);
			deleteitem.click();
			AddQuantity.sendKeys("4");
			WebElement Addtocartbtn = driver.findElement(By.cssSelector("#button-cart"));
			Addtocartbtn.click();
			WebElement Itemcart = driver.findElement(By.cssSelector("#cart > button"));
			Itemcart.click();
			WebElement Viewcart = driver.findElement(By.cssSelector("#cart > ul > li:nth-child(2) > div > p > a:nth-child(1)"));
			Viewcart.click();
		}
		public void logout() throws InterruptedException {
			WebElement testMyAccount3 = driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a"));
			Thread.sleep(3000);
			testMyAccount3.click();
			Thread.sleep(3000);
			driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Logout")));
			WebElement testLogout = driver.findElement(By.linkText("Logout"));
			Thread.sleep(3000);
			testLogout.click();
			
		
		}
		
}

