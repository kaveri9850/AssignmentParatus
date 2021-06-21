package Assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Assignment3 {
	WebDriver driver;
  @Test
  public void GoogleTest() {
	  String googlewin=driver.getWindowHandle();
	  WebDriverWait wait=new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Gmail"))).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
	  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	  // switch to gmail
	  for(String winhandle:driver.getWindowHandles())
	  {
		    if(!googlewin.contentEquals(winhandle))
		    {
		    	driver.switchTo().window(winhandle);
		    	break;
		    }
		  
	  }
	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in"))).click();
	  //gmail sign code
	  driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("enter gmail");//google restricted automation policy so this code not running 
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("enter password");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		//switch  back to google page
		driver.switchTo().window(googlewin);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys("Selenium webdriver");
		driver.quit();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  public void beforeTest() {
  
  System.setProperty("webdriver.chrome.driver", "D:\\Chrome91\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("https://www.google.com/");
	 driver.manage().window().maximize();
  }
  @AfterTest
  public void afterTest() {
  }

}
