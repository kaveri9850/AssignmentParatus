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
	String expTitle="Institute For Ocean Management";
	
  @Test
  public void f()throws InterruptedException {
	WebElement w1 = driver.findElement(By.xpath("//a[contains(text(),'Departments')]"));
     WebDriverWait wait=new WebDriverWait(driver,10);
       ((JavascriptExecutor)driver).executeScript("arguments[0].click();", w1);
	  Actions a=new Actions(driver);
	 
		 WebElement w= driver.findElement(By.xpath("//strong[contains(text(),'Faculty of Civil Engineering')]"));
	 
	// wait.until(ExpectedConditions.elementToBeClickable(w));
	 
	 a.moveToElement(w).build().perform(); 
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Institute\\u00a0for\\u00a0Ocean\\u00a0Managment')]"))).click();
	
	 
	//String actualtilte=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Institute\\u00a0for\\u00a0Ocean\\u00a0Managment')]")));
		
 //Assert.assertEquals(expTitle,actualtilte);
	 WebElement w3=driver.findElement(By.xpath("//a[@id='link3']"));
	 a.moveToElement(w).click().build().perform();
	 
	
  }
 

  @BeforeTest
  public void beforeTest() {	  System.setProperty("webdriver.chrome.driver", "D:\\Chrome91\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://annauniv.edu/");
		 driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
