package com.website.Main;

import java.io.IOException;

import com.website.pages.IndexPage;
import com.website.pages.LoginPage;
import com.website.pages.OrderPage;

public class MainPage {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		OrderPage Page = new OrderPage();
		Page.indexpage();
		Page.takescreenshot("Login");
		Page.login();
		Page.product();
		Page.addtocart();
		Page.takescreenshot("Logout");
		Page.logout();
		Page.close();
		
	}

}
