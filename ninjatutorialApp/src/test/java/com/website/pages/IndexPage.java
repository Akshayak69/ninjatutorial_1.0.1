package com.website.pages;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.website.drivers.BaseDriver;

public class IndexPage extends BaseDriver {
	public void indexpage() 
	{
		driverWait = new WebDriverWait(driver,Duration.ofMillis(8000));
		try 
		{
			inputstream = new FileInputStream("C:\\Users\\Admin\\Desktop\\Project\\ninjatutorialApp\\src\\test\\resources\\website\\files\\website.properties");
			p = new Properties();
			p.load(inputstream);
			String url = p.getProperty("url");
			driver.get(url);		
			driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
			

			WebElement testMyAccount = driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a"));
			Thread.sleep(3000);
			testMyAccount.click();
			Thread.sleep(3000);
			driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Login")));
			WebElement testLogin = driver.findElement(By.linkText("Login"));
			Thread.sleep(3000);
			testLogin.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
