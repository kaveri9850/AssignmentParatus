package Assignment;
/*
 Assignment2:
- go to triphobo.com website
- Click "Later" in be updated box (this may not appear, then ignore)
- Click on "PLAN YOUR NEXT VACATION" button on the homepage
- Type Where do you want to go? field, Houston in Texas
- Select Start and End date of your journey
- Click on button "Start Planning"
- Click on "Next - About Your Trip"
- Click on "Suggest an itinerary with "Things to do ""
- Click on "Next" thrice
- Click on "Wandering Solo"
- Click on "Next Trip Overview"
 */
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Assignment2 {
	WebDriver driver;
	
  @Test
  public void f() {
	  driver.findElement(By.xpath("//a[@id='plan-my-trip']")).click();
	
	driver.findElement(By.xpath("//body[1]/main[1]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Houston");
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-name='Houston, United States']"))).click();
	
	  driver.findElement(By.xpath("//span[@class='start-date-control']")).click();
	  driver.findElement(By.linkText("23")).click();
	  driver.findElement(By.xpath("//span[@class='end-date-control']")).click();
	  driver.findElement(By.linkText("9")).click();
	 
	  driver.findElement(By.xpath("//body[1]/main[1]/div[5]/div[1]/div[3]/div[1]/section[1]/div[3]/div[1]/span[1]")).click();
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.step-name.next-btn-dsk"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/main[1]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]"))).click();
	
	  WebDriverWait wait1=new WebDriverWait(driver,20);
	  List<WebElement> list=driver.findElements(By.xpath("//span[contains(text(),'Next')]"));
	  
	wait1.until(ExpectedConditions.elementToBeClickable(list.get(0) )).click();
	wait1.until(ExpectedConditions.elementToBeClickable(list.get(0) )).click();
	wait1.until(ExpectedConditions.elementToBeClickable(list.get(0) )).click();
	
	driver.findElement(By.cssSelector("div.entry-point.solo-ep")).click();
	driver.findElement(By.xpath("//div[contains(text(),'Trip Overview')]")).click();
	driver.findElement(By.cssSelector("li.view-tab.calendar")).click();
	Actions a=new Actions(driver);
	WebElement source=driver.findElement(By.xpath("//body[1]/main[1]/div[5]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/div[2]/a[4]"));
	WebElement target=driver.findElement(By.xpath("//tbody/tr[10]/td[2]"));
	a.dragAndDrop(source, target);
	
	
	
	driver.findElement(By.cssSelector("span.buttonp-size p-colorsave-to-plan")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Finish Planning')]")).click();
	  
  }
  

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Chrome91\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://www.triphobo.com/");
  }

  @AfterTest
  public void afterTest() {
  }

}
