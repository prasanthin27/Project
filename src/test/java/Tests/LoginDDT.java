package Tests;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.XLUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

public class LoginDDT extends BaseClass
{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		Thread.sleep(2000);
		lp.setUsername(user);
		logger.info("Username entered");
		Thread.sleep(2000);
		lp.setPassword(pwd);
		logger.info("Password entered");
		Thread.sleep(2000);
		lp.loginClick();		
		logger.info("LoggedIN!!");
		
		Thread.sleep(5000);
		
		System.out.println("Verify Home Page");
		Boolean home = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div/a")).isDisplayed();
		
		if(home==true)
		{
			System.out.println("Logged in successfully");
		}
		
		else
		{
			System.out.println("Not Logged in successfully");
		}
		
	}
			
	@DataProvider(name="LoginData")
	public static Object[][] logincred()
	{
		return new Object[][] {{"prasanthin27@yahoo.com","pranav27"},{"prasanthin27@yahoo.com","pranav27*"}};
	}
/*	String[][] getData() throws Exception
	{
		String path = System.getProperty("user.dir")+"/src/test/java/TestData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);
		System.out.println("Rows are :"+ rownum+" And" + "Col are :"+ colcount);
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		
		return logindata;*/
		
	
}
	

