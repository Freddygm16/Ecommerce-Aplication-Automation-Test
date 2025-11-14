package ReviewTutorialPractice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateMoveToNewTabWindow {

	public static void main(String[] args) throws InterruptedException, IOException {
		/* TODO 1- Create and swith in new tab
		 * 		3- Create a swith  a new windos
		 *      4. Copy the information of a course
		 *      5- Swith to parewindow a put grap text in to the name input
		 * 		6-Take a partial screenshtot fot input name
		 *      7-Take dimension of web elemnt with geReact
		 * */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	    driver.switchTo().newWindow(WindowType.TAB);
	    
	    Set<String> windows = driver.getWindowHandles();
	    Iterator<String> it = windows.iterator();
	    
	    String parentId = it.next();
	    String childId = it.next();

        driver.switchTo().window(childId);
        
	    driver.get("https://rahulshettyacademy.com/");
        
	    String courseName = "";
	    
	    Thread.sleep(300);
	    
	    if (driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).size() > 1) {
	        courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
	    } else {
	        System.out.println("No se encontraron suficientes cursos para tomar el índice 1. Encontrados = " + driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).size());
	    }
	    
	    driver.switchTo().window(parentId);
	    
	    driver.findElement(By.cssSelector("[name=\"name\"]")).sendKeys(courseName);
	    
	    File src =  driver.findElement(By.cssSelector("[name=\"name\"]")).getScreenshotAs(OutputType.FILE);
	    
	    FileUtils.copyFile(src, new File("C:\\Users\\fredd\\OneDrive\\Escritorio\\Documentos\\prueba.png"));
	    
	    System.out.println(driver.findElement(By.cssSelector("[name=\"name\"]")).getRect().getDimension().getWidth());

	    driver.quit();
	}

}

/*
public class CreateMoveToNewTabWindow {

	public static void main(String[] args) throws IOException {

// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

//Switching Window

		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		String parentWindowId = it.next();

		String childWindow = it.next();

		driver.switchTo().window(childWindow);

		driver.get("https://rahulshettyacademy.com/");

		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))

				.get(1).getText();

		driver.switchTo().window(parentWindowId);

		WebElement name = driver.findElement(By.cssSelector("[name='name']"));

		name.sendKeys(courseName);

//Screenshot

		File file = name.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("logo.png"));

//driver.quit();

//GEt Height & Width

		System.out.println(name.getRect().getDimension().getHeight());

		System.out.println(name.getRect().getDimension().getWidth());

	}

}*/

