package FreddyCompany.UploadDowloadTestProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/upload-download-test/");
		
		
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileinput")));
		
		WebElement upload = driver.findElement(By.id("fileinput"));
		
		upload.sendKeys(System.getProperty("user.home")
				+ "//Downloads//download.xlsx");
		
		driver.close();
		
    }
}
