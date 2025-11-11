package freddycomapany.ecommerceaplication.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import freddycomapany.ecommerceaplication.PageObjects.CardPage;
import freddycomapany.ecommerceaplication.PageObjects.CheckOutPage;
import freddycomapany.ecommerceaplication.PageObjects.OrderPage;
import freddycomapany.ecommerceaplication.PageObjects.ProductCatalogue;
import freddycomapany.ecommerceaplication.TestsComponents.BaseTest;


public class BuyPath extends BaseTest{	
	
	//@Test(dependsOnMethods = "RegisterUser")
	@Test(dataProvider = "productsToAddJson", groups = "Purchase")
	public void ReadAndBuyProducts(HashMap<String, String> testdata) throws InterruptedException {//(String nameProduct, String initialLetters,String country) throws InterruptedException {
		
		ProductCatalogue productManaged = getLandingPageManager().login(formValues.get("Email"), formValues.get("Password")); //landingPage object extend of BaseTest in public attribute.  
		
		productManaged.addToCard(testdata.get("Product"));
		
		productManaged.goToCardHead();
		
		CardPage card = productManaged.goToCardHead();
		
		boolean match = card.validateElementIsDisplayed(testdata.get("Product"));
		
		Assert.assertTrue(match); 
		
		CheckOutPage checkOut = card.goToCheckOut();
		
		checkOut.typeCountry(testdata.get("InputCountry"));
		
		checkOut.selectCountry(testdata.get("Country"));
				
		Assert.assertTrue(checkOut.getSuccesMessajes().equalsIgnoreCase(("Thankyou for the order.").toUpperCase()));
		
		//OR Assert.assertEquals(checkOut.succesTitle.getText(), ("Thankyou for the order.").toUpperCase());
	}
	
	@Test(dependsOnMethods = "ReadAndBuyProducts") //, groups = "ErrorValidationTest")
	public void ValidateProductHistory(){
		String productName = "ZARA COAT 3";
		ProductCatalogue productManaged = getLandingPageManager().login(formValues.get("Email"), formValues.get("Password"));
		OrderPage orderPage = productManaged.goToOrderHistory();
		boolean inHistory = orderPage.validateProductDisplayedInHistory(productName);
		
		Assert.assertTrue(inHistory);
	}
	

	@DataProvider
	public Object productsToAddOneLine() {
		Object[][] userInfo = new Object[2][3];
		userInfo[0][0] = "ZARA COAT 3";
		userInfo[0][1] = "cos";
		userInfo[0][2] = "Costa Rica";
		userInfo[1][0] = "ADIDAS ORIGINAL";
		userInfo[1][1] = "ind";
		userInfo[1][2] = "India";
				
		return userInfo;
	}
	
	@DataProvider
	public Object productsToAddMultiline() {

		return new Object[][] {{"ZARA COAT 3","cos","Costa Rica"},{"ADIDAS ORIGINAL","ind","India"}};
	}
	
	@DataProvider 
	public Object[][] productsToAddHasMap() { //Is the most recomendend since manage dynamically parameters
		HashMap<String, String> testData1 = new HashMap<String, String>();
		testData1.put("product", "ZARA COAT 3");
		testData1.put("inputCountry", "cos");
		testData1.put("country", "Costa Rica");
		HashMap<String, String> testData2 = new HashMap<String, String>();
		testData2.put("product", "ADIDAS ORIGINAL");
		testData2.put("inputCountry", "ind");
		testData2.put("country", "India");
		
		return new Object[][] {{testData1},{testData2}};
	}
	
	@DataProvider 
	public Object[][] productsToAddJson() throws IOException { //Is the most recommended since manage dynamically parameters and data

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//freddycomapany//ecommerceaplication//Data//PurchaseOrderData.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
