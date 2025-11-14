package ReviewTutorialPractice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitAndImplicitWay {
	
	public static void main(String[] args) {
		WebDriver wdriver = new ChromeDriver();
		wdriver.manage().window().maximize();
		wdriver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		ExplicitAndImplicitWay listProducts = new ExplicitAndImplicitWay();
		listProducts.explicitWaitUse(wdriver);
		
		wdriver.quit();
	}
	
	public void implicitWaitUse(WebDriver driver) {
		//TODO: Managed a complex list of products and clicked one of them in the “Add to Cart” button. 
		// This button doesn’t have an easy selector to manage this.
		//TODO Compare the element from the list of products with the array elements,
		// and check if the selected element's text exists in the array.
		//TODO Split the get text obtain to the web element to match with texts in array
		//TODO: Write code that allows breaking a loop when three elements of the array are found
		// TODO: Write code that allows dynamically selecting an element in a list and fixing the detail
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		String[] arrayNeeded = {"Brocolli", "Cauliflower", "Beetroot"};
		List<WebElement> listProducts = driver.findElements(By.xpath("//h4[@class='product-name']"));	
		
		// TODO: Wrap the code in a method to improve code cleanliness
		ExplicitAndImplicitWay products = new ExplicitAndImplicitWay();
		
		products.selectProduct(listProducts, driver, arrayNeeded);

		// TODO: Wrap the code to handle payment manipulation using CSS selectors.
		// Select the card icon using CSS or XPath,
		// use the 'contains' function to manage the click on the button containing the text "Proceed to PAY",
		// and finally send keys to the promo code input using a CSS selector.
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"PROCEED\")]")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("fjack");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}
	
	public void explicitWaitUse(WebDriver driver) {
		// TODO: Write the same code using only explicit wait, and ensure it gets displayed when we click the Apply button.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String[] arrayNeeded = {"Brocolli", "Cauliflower", "Beetroot"};
		List<WebElement> listProducts = driver.findElements(By.xpath("//h4[@class='product-name']"));	
		
		// TODO: Wrap the code in a method to improve code cleanliness
		ExplicitAndImplicitWay products = new ExplicitAndImplicitWay();
		
		products.selectProduct(listProducts, driver, arrayNeeded);

		// TODO: Wrap the code to handle payment manipulation using CSS selectors.
		// Select the card icon using CSS or XPath,
		// use the 'contains' function to manage the click on the button containing the text "Proceed to PAY",
		// and finally send keys to the promo code input using a CSS selector.
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"PROCEED\")]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}
	
	
	public void selectProduct(List<WebElement> listProducts, WebDriver driver, String[] arrayNeeded) {
		int j=0;
		
		for (int i = 0; i < listProducts.size(); i++) {
			List<String> listNeeded = Arrays.asList(arrayNeeded);
			
			String named  = listProducts.get(i).getText();
			
			System.out.println(i +  " " + named);
			
			if (listNeeded.contains(named.split("-")[0].trim())) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j == arrayNeeded.length) {
					break;
				}
			}
			
		}
		
	}
	
}