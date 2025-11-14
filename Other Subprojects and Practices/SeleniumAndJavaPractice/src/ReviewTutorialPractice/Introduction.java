package ReviewTutorialPractice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Introduction {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// Invoking Browser

		// Chrome - ChromeDriver exten->Methods close get

		// Firefox- FirefoxDriver ->methods close get

		// WebDriver close get

		// WebDriver methods + class methods

		// Chrome

//		// Firefox
//
//		System.setProperty("webdriver.gecko.driver", "/Users/rahulshetty/Documents/geckodriver");
//
//		WebDriver driver1 = new FirefoxDriver();
//
//		// Microsoft Edge
//
//		System.setProperty("webdriver.edge.driver", "/Users/rahulshetty/Documents/msedgedriver");
//
//		WebDriver driver2 = new EdgeDriver();

		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
//		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String name = "rahul";
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Jhon");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		driver.findElement(By.xpath(("//input[@type='text'][2]"))).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("jhon@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("316516918941");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']//button[1]")).click();
		
		Thread.sleep(1000); // Before we need write this line Xbecause the executtion couldn't be continuie , because appear error intersection error, the buttón is not display in the view
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		System.out.println(password);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();// When the element has more SXthan two classes in the class attribute, we can't choose just one of them with a CSS locator. We should filter both using the contains function to search in all classes.
		
		Thread.sleep(2000); // Before we need write this line Xbecause the executtion couldn't be continuie , because appear error intersection error, the buttón is not display in the view
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
		
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
		Thread.sleep(1000); // Before we need write this line Xbecause the executtion couldn't be continuie , because appear error intersection error, the buttón is not display in the view
		driver.quit();
		
		
	}


	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.linkText("Forgot your password?")).click();		
		Thread.sleep(2000);              
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwaord = driver.findElement(By.cssSelector("form p")).getText();
		String password2 = passwaord.split("'")[1];	
		String password3 = password2.split("'")[0];
		
		return password3;
		
	}
}
