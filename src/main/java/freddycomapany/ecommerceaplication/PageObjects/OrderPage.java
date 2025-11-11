package freddycomapany.ecommerceaplication.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import freddycomapany.ecommerceaplication.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	WebDriver driver;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productsNamesHistory;
	
	
	public OrderPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateProductDisplayedInHistory(String productName) {
		Boolean isLocated = productsNamesHistory.stream().anyMatch(s -> s.getText().equals(productName));
		
		return isLocated;
	}
}
