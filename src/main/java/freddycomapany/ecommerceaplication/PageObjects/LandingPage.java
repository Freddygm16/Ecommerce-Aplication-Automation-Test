package freddycomapany.ecommerceaplication.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freddycomapany.ecommerceaplication.AbstractComponents.AbstractComponents;

public class LandingPage  extends AbstractComponents{
	
	WebDriver driver;
	
	@FindBy(id="userEmail")
	WebElement loginUser;

	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(id="toast-container")
	public WebElement failedLoginMessages;
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public ProductCatalogue login(String email, String password)  {
	    loginUser.sendKeys(email);
	    userPassword.sendKeys(password);

	    waitToElementsClickable(login);
	    
	    headLessScrollToElement(login);

	    headLessElementClic(login);
	    
	    return new ProductCatalogue(driver);
	}
	
	public RegisterPage register() {
		return new RegisterPage(driver);
	}
	
	public String getFailedLoginMessajes() {
		waitToElementsAppear(failedLoginMessages);
		return failedLoginMessages.getText();
	}
}
