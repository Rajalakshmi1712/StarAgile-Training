package Selenium_Grid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {
  public WebDriver driver;
  @SuppressWarnings("deprecation")
  @Parameters({"browser_name"})
  
	@Test
  public void crossBrowserTest(String browser_name) throws InterruptedException, MalformedURLException 
  {
	  System.out.println("Remote Connectivity is started");
	  URL url=new URL("http://localhost:4444");
	  if(browser_name.equals("Chrome"))
	  {
		  ChromeOptions options=new ChromeOptions(); 
		  driver=new RemoteWebDriver(url,options);
	  }
	  else if(browser_name.equals("Firefox"))
	  {
		  FirefoxOptions options=new FirefoxOptions();
		  driver=new RemoteWebDriver(url,options);
	  }
	  else if(browser_name.equals("Edge"))
	  {
		  EdgeOptions options=new EdgeOptions();
		  driver=new RemoteWebDriver(url,options);
	  }
	  System.out.println("Remote Driver Connectivity is completed");
	  Thread.sleep(1000);
	  driver.get("https://www.amazon.in/");
	  Thread.sleep(6000);
	  System.out.println("Title of the Page is:"+driver.getTitle());
	  driver.quit();
  }
}
