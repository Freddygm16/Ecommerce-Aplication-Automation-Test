package Taks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tarea8AutocompleteDropdownAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Write a code that manage autosugestion dropdown and selected option that displayed with keys
		
		//https://rahulshettyacademy.com/AutomationPractice/
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("cos");
		Thread.sleep(2000);
		
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
		
		
				
	}

}
