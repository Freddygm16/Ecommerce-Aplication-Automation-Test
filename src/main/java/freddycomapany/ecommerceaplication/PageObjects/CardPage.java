package freddycomapany.ecommerceaplication.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freddycomapany.ecommerceaplication.AbstractComponents.AbstractComponents;

public class CardPage extends AbstractComponents{
	
	@FindBy(css="li.items")
	private List<WebElement> productsBuy;
	
	@FindBy(xpath="//button[contains(text(), \"Checkout\")]")
	WebElement checkOutButton;
	
	WebDriver driver;
	
	public CardPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public Boolean validateElementIsDisplayed(String productName) {
		Boolean isLocated = productsBuy.stream().anyMatch(s -> s.findElement(By.tagName("h3")).getText().equals(productName));
		
		return isLocated;
	}
	
	public CheckOutPage goToCheckOut() {
		waitToElementsClickable(checkOutButton);
		
		headLessScrollToElement(checkOutButton);
		
		headLessElementClic(checkOutButton);
		
		return new CheckOutPage(driver);
	}
	
}
