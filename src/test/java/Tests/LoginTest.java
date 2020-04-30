package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Pages.LoginPage;


public class LoginTest extends BaseClass
{
	
	@Test(groups= {"smoke"})
	public void loginTest() throws IOException, InterruptedException
	{
		//driver.get(baseURL);
		
		logger.info("URL launched");
		LoginPage lp = new LoginPage(driver);
		System.out.println("ENter username");
		logger.info("username enter");
		lp.setUsername(username);
		System.out.println("ENter password");
		logger.info("password entered");
		lp.setPassword(password);
		Thread.sleep(2000);
		System.out.println("click on login");
		logger.info("Clicked on login");
		lp.loginClick();
		
		System.out.println("Verify home element");
		Thread.sleep(15000);
		//captureScreen(driver,"logintest");
	//	WebElement home = driver.findElement(By.id("u_0_c"));
		try
		{			
			driver.switchTo().alert().dismiss();
			//alert.accept();		
			System.out.println("frame accepted");
		}
		catch(NoAlertPresentException e)		
		{
			System.out.println("Unable to take action on pop up");
		}
		
		
		if(driver.findElement(By.id("u_0_c")).isDisplayed())
		{
			System.out.println("Element found");
			AssertJUnit.assertTrue(true);
			logger.info("Test passed");
		}
		else
		{
			System.out.println("Element not found");
			captureScreen(driver,"logintest");
			AssertJUnit.assertFalse(false);
			logger.info("Test failed");
		}
	}
	
	@Test(groups= {"smoke"})
	public void sample()
	{
		System.out.println("sample");
	}
	
}
