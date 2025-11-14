package ReviewTutorialPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class DetectBrokenLinksAndManagedSoftAssert {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// Write a code that detect broken link present in the page, 
		// first select link use regular expression whit cssselector for example *=
		// then use URL object HTTp
		// then check all links present in the footer an use assertion to terminated the program.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1800)");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li']>a"));
		
		SoftAssert a = new SoftAssert();
		
		for (WebElement link : links) {
			
			@SuppressWarnings("deprecation")
			HttpURLConnection url = (HttpURLConnection) new URL(link.getAttribute("href")).openConnection();
			url.setRequestMethod("HEAD");
			url.connect();
			int reponseCode = url.getResponseCode();
			
			System.out.println(reponseCode);
			
			a.assertTrue(reponseCode < 400, "The link whit text " + link.getText() + " is broken whit code " + reponseCode + ".");
			
			//if (reponseCode >= 400) {
			//	System.out.println(link.getText());
			//	Assert.assertTrue(false);
			//}
			
		}
		
		a.assertAll();
		
		driver.quit();
		
	}

}
