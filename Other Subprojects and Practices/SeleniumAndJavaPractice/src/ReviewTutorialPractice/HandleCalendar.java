package ReviewTutorialPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleCalendar {
	public static void main(String[] args) {
		//TODO Manage a calendar an selected the date 15/6/2027 then comparated this is the corre
		String day = "15";
		String month = "6";
		String year = "2027";
		String[] date = {month,day,year};
		
        WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        
        driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();
        
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        
        driver.findElement(By.xpath("//button[text()='2027']")).click();

        //.react-calendar__year-view__months__month
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
       
        
        driver.findElement(By.xpath("//button[@class='react-calendar__tile react-calendar__month-view__days__day']/child::abbr[text()='"+ day +"']")).click();
        
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        
        for (int i = 0; i < actualList.size(); i++) {
        	System.out.println(actualList.get(i).getAttribute("value"));
        	
        	Assert.assertEquals(actualList.get(i).getAttribute("value"), date[i]);
        }
        
        driver.quit();
        
	}
}
