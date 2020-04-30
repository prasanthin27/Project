package Tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import com.beust.jcommander.Parameters;

import Utilities.ReagConfig;

public class BaseClass
{
	ReagConfig readconfig = new ReagConfig();	
	protected String baseURL=readconfig.getApplicationURL();
	protected String username =readconfig.getUsername();
	protected String password = readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
		driver=new ChromeDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		logger = Logger.getLogger("Prasanthi");
		PropertyConfigurator.configure("Log4j.properties");
		
		driver.get(baseURL);
	}
	
/*	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}*/
	
	
		public void captureScreen(WebDriver driver, String tname) throws IOException
			{
				TakesScreenshot ts= ((TakesScreenshot)driver);
				File source = ts.getScreenshotAs(OutputType.FILE);
				File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
				FileUtils.copyFile(source, target);
				System.out.println("Screenshot taken");
			}
		
}
