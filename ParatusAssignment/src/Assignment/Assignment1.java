package Assignment;

/*Assignment1 
- Anna assignment
1. goto http://annauniv.edu/
2. click on "Departments" link
3. Goto "Faculty Of Civil Engineering" and click on "Institute for Ocean Management"
4. Verify the page title.
5. Goto "Research Themes" options and Click "Coastal Pollution Monitoring and Hazards"
6. Verify the page title. */
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Assignment1  {
	WebDriver driver;
	String expTitle="Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts";
	
  @Test
  public void f()throws InterruptedException {
	WebElement w1 = driver.findElement(By.xpath("//a[contains(text(),'Departments')]"));
     WebDriverWait wait=new WebDriverWait(driver,10);
       ((JavascriptExecutor)driver).executeScript("arguments[0].click();", w1);
	  Actions a=new Actions(driver);
	 
		 WebElement w= driver.findElement(By.xpath("//strong[contains(text(),'Faculty of Civil Engineering')]"));
	 
	
	 
	 a.moveToElement(w).build().perform(); 
	
driver.findElement(By.xpath("//div[@id='menuItem33']")).click();// finding xpath through dubbgging mode 
	String actualtitle=driver.getTitle();
	
	System.out.println(driver.getTitle());
	Assert.assertEquals(expTitle, actualtitle);
	WebElement w2=driver.findElement(By.cssSelector("a#link3.toplink"));
	a.moveToElement(w2).build().perform();
	driver.findElement(By.cssSelector("div#menuItem13")).click();
	System.out.println(driver.getTitle());
	String exp=":: IOM - Institute For Ocean Management - Anna University ::";
	String actual =driver.getTitle();
	Assert.assertEquals(exp, actual);
  }
 

  @BeforeTest
  public void beforeTest() {	  System.setProperty("webdriver.chrome.driver", "D:\\Chrome91\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://annauniv.edu/");
		 driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
