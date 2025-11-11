package freddycomapany.ecommerceaplication.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freddycomapany.ecommerceaplication.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{

	@FindBy(css="input[placeholder*='Select Country']")
	WebElement countryInput;
	
	@FindBy(css="section.ta-results button span")
	List<WebElement> dropDownSuggestOptions;
	
	@FindBy(css="div.actions a")
	WebElement placeOrderButton;
	
	@FindBy(tagName="h1")
	public WebElement succesTitle;
	
	WebDriver driver;
	
	By resultSection = By.cssSelector("section.ta-results");
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void typeCountry(String initialLetters) {
		Actions a = new Actions(driver);
		
		a.sendKeys(countryInput, initialLetters).build().perform();
		
		waitToElementsAppear(resultSection);
	}
	
	public void selectCountry(String country) {

		WebElement selectionCountry = dropDownSuggestOptions.stream().filter(s -> s.getText().equalsIgnoreCase(country))
		.map(s ->{
			return s.findElement(By.xpath(".//parent::button"));
		}).findFirst().orElse(null);
		
		waitToElementsClickable(selectionCountry);
		
		headLessScrollToElement(selectionCountry);
		
		headLessElementClic(selectionCountry);
		
		
		waitToElementsClickable(placeOrderButton);
		
		headLessScrollToElement(placeOrderButton);
		
		headLessElementClic(placeOrderButton);
		
		//placeOrderButton.click();
	}
	
	public String getSuccesMessajes() {
		return succesTitle.getText();
	}
	
}
