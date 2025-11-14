package Taks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Tarea3SynchronizationwithExplicitwait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Web Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		
		////span[contains(text(),"User")]//following-sibling::input
		driver.findElement(By.xpath("//input[@type=\"radio\"][@value=\"user\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type=\"radio\"][@value=\"user\"]")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[@type=\"radio\"][@value=\"user\"]")).isSelected());
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));

		dropdown.selectByVisibleText("Consultant");
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		
		driver.findElement(By.id("okayBtn")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myModal")));
		
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("terms")));
		
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-footer']/child::button"));
		
		for (WebElement product : products) {
			product.click();
		}
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		
		driver.quit();
	}

}
