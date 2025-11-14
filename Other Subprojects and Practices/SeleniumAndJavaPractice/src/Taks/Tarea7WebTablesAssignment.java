package Taks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tarea7WebTablesAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO 1 - Print the total numbers of rows present in the table with title: "Web Table Example" 
		//      2 - Print the total numbers of columns present in the table with title: "Web Table Example" 
		//      3 - Print all information preset in the columns of the second row of the table whit title: "Web Table Example"
	
		// Url: https://rahulshettyacademy.com/AutomationPractice/
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		
		//product
		
		int totalRows= driver.findElements(By.cssSelector("table[name='courses']>tbody>tr")).size();
		
		int totalcolunms= driver.findElements(By.cssSelector("table[name='courses']>tbody>tr>th")).size();
		
		System.out.println(totalRows);
		System.out.println(totalcolunms);
		//table[name='courses']>tbody>tr:nth-child(3)>td
		
		List<WebElement> informtation = driver.findElements(By.cssSelector("table[name='courses']>tbody>tr:nth-child(3)>td"));
		
		for (WebElement data : informtation) {
			
			System.out.println(data.getText());
		}
		
		Thread.sleep(3000);
		
		driver.quit();
	
	}

}
