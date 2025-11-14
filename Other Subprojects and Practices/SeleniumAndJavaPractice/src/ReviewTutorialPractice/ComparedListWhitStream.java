package ReviewTutorialPractice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparedListWhitStream {
	
	@Test
	public void regular() {
		/* TODO 
		 * 1- Click in the header of the first column with "[1]"
		 * 2- Get all rows of the first column
		 * 3- Created a Stream with elements unsorted
		 * 4- Create a Stream whit element sorted
		 * 5- compared the values whit assert with assert true a list.equal
		 * 6- Create a stream that shear column with Beans value, and get the price, this use with map an custom method that your parameter receive WebElement		 
		 * 7- Shear in the all pagination of the table the element that name's is rice, an print the price
		 * 8- Write a code that that type in filter input of the pages
		 *  6.1- Save the result filtered with input filtered list
		 *  8.2- Create a new list with stream that filtered the rice text
		 *  8.3- Compared the result of the size of the two list with assert and verify the input filter correctly
		 * */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]")); 

		List<String> originalList =  products.stream().map(s-> s.getText()).collect(Collectors.toList());
		
		List<String> listSorted =  products.stream().map(s-> s.getText()).sorted().collect(Collectors.toList());

		Assert.assertTrue(originalList.equals(listSorted));
		
		products.stream().filter(s -> s.getText().contains("Beans")).map(s -> getPriceVeggie(s));

	    products.stream().filter(s -> s.getText().contains("Beans")).map(s -> getPriceVeggie(s)).forEach(s -> System.out.println(s));
	    
	    List<String> price;
	    
	    do {
	    	List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]")); 
	    	
	    	price =  rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
	    	
	    	if (price.size() < 1) {
	    		driver.findElement(By.cssSelector("a[aria-label=\"Next\"]")).click();
	    	}
	    	
	    }while(price.size()<1);
	    
	    for (String p : price) {
	    	System.out.println(p);
	    }
		
		driver.quit();
	}
	
	public static String getPriceVeggie(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return price;
	}
	
	@Test
	public void filterInput() {
		/* TODO 
		 * 8- Write a code that that type in filter input of the pages
		 *  6.1- Save the result filtered with input filtered list
		 *  8.2- Create a new list with stream that filtered the rice text
		 *  8.3- Compared the result of the size of the two list with assert and verify the input filter correctly
		 * */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]")); 
		
		List<WebElement> filterd = veggies.stream().filter(s -> s.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(filterd.size(), veggies.size());

		driver.quit();
	}
}
