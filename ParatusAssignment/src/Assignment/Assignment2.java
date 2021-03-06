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
 Click on "Editable View"
- Drag "Children's museum to day 3"
- Click on Save plan -> Finish Planning


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
	driver.findElement(By.cssSelector("input.input-control.js_city_search")).sendKeys("Houston");
	

	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-name='Houston, United States']"))).click();
	
	  driver.findElement(By.xpath("//span[@class='start-date-control']")).click();
	  driver.findElement(By.linkText("25")).click();
	  driver.findElement(By.xpath("//span[@class='end-date-control']")).click();
	  driver.findElement(By.linkText("15")).click();
	 
	
	driver.findElement(By.cssSelector("[class='button p-color full-width start-planning']")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.p-color.p-size.button.next-btn-dsk"))).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'itinerary')]/parent::div/div[2]/div[2]/child::span[contains(text(),'Things')]"))).click();
	
	 WebDriverWait wait1=new WebDriverWait(driver,20);
	 WebElement element=driver.findElement(By.cssSelector("span.button.s-size.p-color.as-next.js-next-alreadybooked"));
	 JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
	 
	
    
    
		 WebElement element1=driver.findElement(By.cssSelector("span.button.s-size.p-color.as-next.js-next-alreadybooked"));
		
			jse.executeScript("arguments[0].click()", element1);
     
    
   WebElement element2= driver.findElement(By.cssSelector("span.button.s-size.p-color.as-next.js-next-alreadybooked"));
    jse.executeScript("arguments[0].click()", element2);
    
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.entry-point.solo-ep"))).click();
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Trip Overview')]"))).click();
	
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Editable')]"))).click();
	Actions a=new Actions(driver);
	WebElement source= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Childrens Museum Of Houston']")));
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
