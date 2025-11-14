package ReviewTutorialPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AccepExpriredSSL {
	public static void main(String[] args) {
		// TODO Write a selenium aplication that allow managed page that expired ssl certification for example: https://expired.badssl.com/
	
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver =  new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		
		
	}

}
