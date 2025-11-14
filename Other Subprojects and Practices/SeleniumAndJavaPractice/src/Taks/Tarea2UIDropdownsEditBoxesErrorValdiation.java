package Taks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Tarea2UIDropdownsEditBoxesErrorValdiation{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.xpath("//div[@class='form-group']/label[text()='Name']/following-sibling::input")).sendKeys("Freddy");
		
		driver.findElement(By.xpath("//div[@class='form-group']/label[text()='Email']/following-sibling::input")).sendKeys("freddy@hotmail.com");
		
		driver.findElement(By.xpath("//div[@class='form-group']/label[text()='Password']/following-sibling::input")).sendKeys("prueba1234");
		
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement staticDropDown = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select dropDownHelper = new Select(staticDropDown);
		
		for (WebElement option  : dropDownHelper.getOptions()) {
			if (option.getText().equalsIgnoreCase("Famale")) {
				option.click();
			}
		}
		
		try {
			System.out.println(dropDownHelper.getFirstSelectedOption().getText());
		} catch (Exception NoSuchElementException) {
			Assert.fail("The gender list don't have a selected option");
		}
		
		driver.findElement(By.id("inlineRadio1")).click(); 
		
		//driver.findElement(By.xpath("//div[@class='form-group']/label[text()='Date of Birth']/following-sibling::input")).click();
		
		driver.findElement(By.xpath("//div[@class='form-group']/label[text()='Date of Birth']/following-sibling::input")).sendKeys("5899");
		
		driver.findElement(By.className("btn-success")).click();
		
		String message = driver.findElement(By.className("alert-success")).getText();
		
		System.out.println(message.split("×")[1]);
			
	}
	
}
