package ReviewTutorialPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class RelativeLocators {

	
	public static void main(String[] args) {
		/* 1-Write a code that use relative locator whit methods: with, above, belove, toRightof, toLefthof   
		 * 2-Use separated instruction to declararated the elemnt binding to relative locators
		 * */
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

		WebElement dateBirth = driver.findElement(By.xpath("//label[@for='dateofBirth']"));

		driver.findElement(with(By.tagName("input")).below(dateBirth)).click();
		
		WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		
		//inlineRadio1
		
		WebElement person = driver.findElement(By.id("inlineRadio1"));


		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(person)).getText());
		
		////label[@for='dateofBirth']
		
		driver.quit();
	}
}
