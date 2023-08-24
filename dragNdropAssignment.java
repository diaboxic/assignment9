package assignment9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dragNdropAssignment {
	
	WebDriver driver;
	
	@BeforeMethod
	void setup() {
		WebDriverManager.edgedriver().setup();
		this.driver = new EdgeDriver();
		this.driver.manage().window().maximize();
		this.driver.get("https://jqueryui.com/droppable/");
	}
	
	@AfterMethod
	void end() throws InterruptedException {
		Thread.sleep(2000);
		this.driver.quit();
	}

	@Test
	void dragNdropTest() throws InterruptedException {
		WebElement frame = this.driver.findElement(By.xpath("//iframe"));
		
		this.driver.switchTo().frame(frame);
		
		WebElement sourceElement = this.driver.findElement(By.id("draggable"));
		WebElement targetElement = this.driver.findElement(By.id("droppable"));
		
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(sourceElement, targetElement).perform();
		
		Thread.sleep(2000);
	}
}
