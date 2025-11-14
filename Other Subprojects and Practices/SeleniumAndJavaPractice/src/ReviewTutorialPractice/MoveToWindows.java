package ReviewTutorialPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoveToWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Write a code that allow move selenium to another window and give text related to email
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.xpath(" //div[@class='float-right']/a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).click();
		
	    Set<String> windows = driver.getWindowHandles();
	    
	    Iterator<String> it = windows.iterator();
	    
	    String paretId = it.next();
	    
	    String childId = it.next();
	    
	    driver.switchTo().window(childId);
	    
	    System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0]);
	    
	    String email =  driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	    

	    //TODO Write code that extract the email of the string and swicht the window and put the email in the username input 
		
	    driver.switchTo().window(paretId);

	    driver.findElement(By.id("username")).sendKeys(email);
	    
	    Thread.sleep(2000);
	    
	    driver.quit();
	    
	    
	}

}
