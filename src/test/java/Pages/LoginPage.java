package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
	}

	By uname = By.id("email");
	By paswd = By.id("pass");
	By login = By.id("loginbutton");
	
	public void setUsername(String un) throws InterruptedException
	{
		ldriver.findElement(uname).clear();
		ldriver.findElement(uname).sendKeys(un);
		
	}
	public void setPassword(String pw)
	{
		ldriver.findElement(paswd).sendKeys(pw);
	}
	
	public void loginClick()
	{
		ldriver.findElement(login).click();
	}
	
	
	
}
