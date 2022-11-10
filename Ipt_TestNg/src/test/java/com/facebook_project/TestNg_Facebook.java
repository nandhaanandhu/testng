package com.facebook_project;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.LoginPage;
import com.pom.SingleTonDesign;
import com.property.ConfigurationHelper;

import Baseclass.Base_class_A;

public class TestNg_Facebook extends Base_class_A {
	public static WebDriver driver;
	public static SingleTonDesign std = new SingleTonDesign(driver);

	@BeforeClass
	private void browerlaunch() throws Throwable {
		String browser = ConfigurationHelper.getinstance().getbrowser();
		driver = setpro(browser);
		SingleTonDesign std = new SingleTonDesign(driver);
		String url = ConfigurationHelper.getinstance().geturl();
		geturl(url);
		maxi();
	}

	@DataProvider()

	public String[][] LoginPage() {
		return new String[][] { { "mail2nandh@gmail.com", "nandhaa" }

		};
	}

	@Test(dataProvider = "LoginPage")
	private void signup(String user, String pass) throws IOException, Exception {
		// String username= ConfigurationHelper.getinstance().getusername();

		sendkey(std.getLoginPage().getUsername(), user);

		// String pass= ConfigurationHelper.getinstance().getpass();
		sendkey(std.getLoginPage().getPassword(), pass);

		click(std.getLoginPage().getLogin());

		sleep();
	}

	@AfterClass
	private void teatdown() {
		close();
	}

}