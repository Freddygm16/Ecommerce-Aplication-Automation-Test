package freddycomapany.ecommerceaplication.StepsDefinitions;

import java.io.IOException;

import org.testng.Assert;

import freddycomapany.ecommerceaplication.PageObjects.CardPage;
import freddycomapany.ecommerceaplication.PageObjects.CheckOutPage;
import freddycomapany.ecommerceaplication.PageObjects.ProductCatalogue;
import freddycomapany.ecommerceaplication.TestsComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsImple extends BaseTest{
	
	ProductCatalogue productManaged;
	CheckOutPage checkOut;
	
	@Given("landing to ecommerce page")
	public void landing_to_ecommerce_page() throws IOException {
		launchAplication();
	}
	
	@Given("^that user login with (.+) and (.+)$")
	public void that_user_login_with_username_and_password(String username, String password) {
		productManaged = getLandingPageManager().login(username, password);
	}
	
	@When("^add product (.+) to card and go it$")
	public void add_product_productname_to_card_and_go_it(String productname) throws InterruptedException {
		productManaged.addToCard(productname);
	}
	
	@And("^check out the product (.+) in country (.+) and finally (.+)$")
	public void check_out_the_product_vars_in_country_intial_vars_and_finally_vars(String productname,String intialLetters, String country) {
		productManaged.goToCardHead();
		
		CardPage card = productManaged.goToCardHead();
		
		boolean match = card.validateElementIsDisplayed(productname);
		
		Assert.assertTrue(match); 
		
		checkOut = card.goToCheckOut();
		
		checkOut.typeCountry(intialLetters);
		
		checkOut.selectCountry(country);
	}
	
	@Then("must displayed {string} susses messages")
	public void must_displayed_string_susses_messages(String messajes) {
		Assert.assertTrue(checkOut.getSuccesMessajes().equalsIgnoreCase((messajes).toUpperCase()));
	}
	
	@Then("must displayed {string} error messages")
	public void must_displayed_string_error_messages(String messajes) throws InterruptedException {
	    String text = getLandingPageManager().getFailedLoginMessajes();
		Assert.assertEquals(text, "Incorrect email or password.");
	}
	
}
