package com.website.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends IndexPage {
	public void login() throws IOException, InterruptedException
	{
		
		inputstream = new FileInputStream("C:\\Users\\Admin\\Desktop\\Project\\ninjatutorialApp\\src\\test\\resources\\website\\files\\website.properties");
			p = new Properties();
			p.load(inputstream);
			String sqlPass = p.getProperty("sqlPass");
			String sqlQuery = p.getProperty("sqlQuery");
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root",sqlPass);  
			
			System.out.println("connect to db");  
	
			String sql = sqlQuery;		
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				
				WebElement Username = driver.findElement(By.cssSelector("#input-email"));
				driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#input-email")));
				Username.sendKeys(rs.getString(1));
				
				WebElement Password = driver.findElement(By.cssSelector("#input-password"));
				driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#input-password")));
				Password.sendKeys(rs.getString(2));
				
				WebElement Loginbtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
				driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")));
			
				
				Loginbtn.submit();
				
				if (rs.getString(1).contentEquals("akshayc619@gmail.com") && rs.getString(2).contentEquals("Akshay@1"))  
				{
					break;
				}
				
				else {
				try {
					Username = driver.findElement(By.cssSelector("#input-email"));
					driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#input-email")));
					Username.clear();
					 Password = driver.findElement(By.cssSelector("#input-password"));
					driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#input-password")));
					Password.clear();
				}
				catch(StaleElementReferenceException e)
				{
					 Username = driver.findElement(By.cssSelector("#input-email"));
					driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#input-email")));
					Username.clear();
					 Password = driver.findElement(By.cssSelector("#input-password"));
					driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#input-password")));
					Password.clear();
					
				}
			}
				System.out.println(rs.getString(1)+ " " + rs.getString(2));	
			}
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		
}
}
