package BookingFligs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class HomeBooking {

	public static void main(String[] args) throws InterruptedException {
		//jl
		System.setProperty("webdriver.edge.driver", "C:\\Web Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		
		// WebElement staticDrowdown = driver.findElement(By.xpath("//div[@id='marketCityPair_1']/div/div[1]/input[contains(@id,'ddl_originStation1')]"));
		
		//TODO: Write a code that selects dynamic dropdowns, for example, when exists elements that your information loads only when I open, 
		//and write a code that if one locator has two elements to interact and gives a failure because of this.
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='IXG']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		//TODO: Write the correct form to select elements that have the same selector, or that locators identify with the same traverse.
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
		
		Thread.sleep(1000);
		// TODO: Write code that allows selecting the current date 
		System.out.println(driver.findElement(By.className("ui-state-active")).getText());
		driver.findElement(By.className("ui-state-active")).click();
		

		// TODO: Manage complex lists that allow select 5 adult
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		for (int i = 0; i < 4; i ++ ) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		Thread.sleep(1000);
		
		WebElement staticDrowdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select drowdown =  new Select(staticDrowdown);
		drowdown.selectByIndex(3);
		System.out.println(drowdown.getFirstSelectedOption().getText());
		drowdown.selectByVisibleText("AED");
		System.out.println(drowdown.getFirstSelectedOption().getText());
		
		
		Thread.sleep(1000);
		//TODO Write a code that uses assertions to compare whether the checkbox is selected or not
		//TODO: Write a code that allow select a check box, an print it state before and after that are selected
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).isSelected());
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).isSelected());
		
		Thread.sleep(1000);
		//TODO: Write code that allows managing autosuggestion dropdowns when typing “Indian,” and finally select the option displayed with the name “India.”
		driver.findElement(By.id("autosuggest")).sendKeys("Indi");
		List<WebElement> autosuggest = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		for (WebElement WE : autosuggest) {
			System.out.println(WE.getText());
			if (WE.getText().equalsIgnoreCase( "India")) {
				WE.click();
				break;
			}
		};
		
		
		//TODO: Write a code that allow print the size of elements in the page
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());


		//TODO Write a code that uses assertions to compare the script result with the expected result
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// TODO: Write code that checks if this WebElement is enabled or disabled using only attributes
		if (driver.findElement(By.id("Div1")).getDomAttribute("Style").contains("0.5")) {
			System.out.println("Is disabled");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}

		// TODO: Write an end-to-end case that begins by choosing when the flight goes out and ends at the "Sheard" button.
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
	//	driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
	//	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	}
}
