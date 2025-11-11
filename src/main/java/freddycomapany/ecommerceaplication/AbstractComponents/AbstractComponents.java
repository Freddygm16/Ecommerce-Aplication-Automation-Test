package freddycomapany.ecommerceaplication.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freddycomapany.ecommerceaplication.PageObjects.CardPage;
import freddycomapany.ecommerceaplication.PageObjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;
	
	@FindBy(css="[routerlink='/dashboard/cart']")
	WebElement cardButton;
	
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement orderHistoryButton;

	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitToElementsAppear(By findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	    w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitToElementsAppear(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	    w.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitToElementsDisappear(WebElement element) throws InterruptedException {
		Thread.sleep(2000);
		//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		//w.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitToElementsClickable(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	    w.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void headLessScrollToElement(WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}
	
	
	public void headLessElementClic(WebElement element) {
	    try {
	    	element.click();
	    } catch (ElementClickInterceptedException e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	    }
	}
	

	public void goTo(String url) {
		driver.get(url);
	}
	
	public CardPage goToCardHead() {
		

	    waitToElementsClickable(cardButton);

	    headLessScrollToElement(cardButton);
	    
	    headLessElementClic(cardButton);

		return new CardPage(driver);
	}
	
	public OrderPage goToOrderHistory() {
	

	    waitToElementsClickable(orderHistoryButton);

	    headLessScrollToElement(orderHistoryButton);
	    
	    headLessElementClic(orderHistoryButton);
		//orderHistoryButton.click();
		
		return new OrderPage(driver);
	}

}
