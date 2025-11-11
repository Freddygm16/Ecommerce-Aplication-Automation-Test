package freddycomapany.ecommerceaplication.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freddycomapany.ecommerceaplication.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	WebDriver driver;
	
	@FindBy(css=".card-body")
	List<WebElement> products;
	
	@FindBy(tagName = "b")
	WebElement cardsTitle;

	@FindBy(css= "ngx-spinner[class*='ng-star-inserted']>div")
	WebElement spinner;

	By productBy = By.className("card-body");
	
	By addToCard = By.cssSelector(".card-body button:last-of-type");
	
	By succesMessages = By.cssSelector("div#toast-container>div");

	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	
	public List<WebElement> getProductsList() {
		waitToElementsAppear(productBy);
		
		return products;
	}
	
	public WebElement getProductName(String productName) {
	 /*	for (WebElement p: getProductsList()) {
			
			String title = p.findElement(By.tagName("b")).getText();	
			
			if(title.equalsIgnoreCase(productName)) {
				System.out.println(title);
				break;
			}else {
				if (products.get(products.size()).getText().equalsIgnoreCase(title)) {
					Assert.assertTrue(false, "The product: ZARA COAT 3, isn't present in the products ");
				}
			}			
		}*/
		
		WebElement product =  getProductsList().stream().filter(s -> s.findElement(By.tagName("b")).getText().equals(productName))
				.findFirst().map(s -> {
					WebElement card = s.findElement(By.xpath(".//parent::h5/parent::div"));
					
					return card.findElement(addToCard);
				}).orElse(null);
		
		return product;
	}
	
	public void addToCard(String productName) throws InterruptedException {
		getProductName(productName).click();
		waitToElementsAppear(succesMessages);
		waitToElementsDisappear(spinner);
	}
	
}
