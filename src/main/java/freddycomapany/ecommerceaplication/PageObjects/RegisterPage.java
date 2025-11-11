package freddycomapany.ecommerceaplication.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import freddycomapany.ecommerceaplication.AbstractComponents.AbstractComponents;

public class RegisterPage extends AbstractComponents{
	
	public WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
}
