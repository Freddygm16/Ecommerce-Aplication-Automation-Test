package Taks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Tarea6PracticeExerciseAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		String value="";
		int j=0;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Grab the text in checkbox selected in checkbox examples element
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));
		
		for (WebElement o : options) {
			
			
			if(o.getAttribute("value").equalsIgnoreCase("Option2")) {
				o.click();
				value =  driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input/parent::label")).get(j).getText();
				break;
			}
			j++;
		}
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select selectorList = new Select(dropdown);
		
		selectorList.selectByContainsVisibleText(value);

		driver.findElement(By.id("name")).sendKeys(value);
		
		driver.findElement(By.id("alertbtn")).click();
		//Hello Option2, share this practice page and share your knowledge
		
		String textMessage = driver.switchTo().alert().getText().split(",")[0];
		String text = textMessage.split(" ")[1];
	
		Assert.assertEquals(text, value);
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
