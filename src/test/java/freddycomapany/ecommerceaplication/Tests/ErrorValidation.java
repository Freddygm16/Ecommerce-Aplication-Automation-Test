package freddycomapany.ecommerceaplication.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import freddycomapany.ecommerceaplication.PageObjects.CardPage;
import freddycomapany.ecommerceaplication.PageObjects.ProductCatalogue;
import freddycomapany.ecommerceaplication.TestsComponents.BaseTest;
import freddycomapany.ecommerceaplication.TestsComponents.Retry;

public class ErrorValidation extends BaseTest{
	
	@Test(groups = "ErrorValidationTest", retryAnalyzer = Retry.class)
	public void validationLoginFailed() throws InterruptedException, IOException {
		getLandingPageManager().login("ADSA@asdasd.com", "123314");
	//	Thread.sleep(5000); //IF dont wait the correct time appear exception dont| -----
	    String text = getLandingPageManager().getFailedLoginMessajes();
		Assert.assertEquals(text, "Incorrect email or password.");
	}
	
	@Test
	public void validateProductIsAddInCard() throws InterruptedException {
		String nameProduct = "ZARA COAT 3";
		
		ProductCatalogue productManaged = getLandingPageManager().login(formValues.get("Email"), formValues.get("Password"));
		
		productManaged.addToCard(nameProduct);
		
		productManaged.goToCardHead();
		
		CardPage card = productManaged.goToCardHead();
		
		boolean match = card.validateElementIsDisplayed(nameProduct);
		
		Assert.assertTrue(match);
	}
}
