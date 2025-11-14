package freddycomapany.ecommerceaplication.TestsComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import freddycomapany.ecommerceaplication.PageObjects.LandingPage;

public class BaseTest {

	public Map<String, String> formValues = new HashMap<String, String>();
	
	public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

	public static final ThreadLocal<LandingPage> threadlandingPage = new ThreadLocal<>();

	
	//@BeforeTest(alwaysRun = true)
	public void initializeDriver() throws IOException {
		String browser= "";
	
		if (System.getProperty("browser") != null) { 
			browser = System.getProperty("browser");
		} else {
			Properties prop = new Properties();
			FileInputStream fls = new FileInputStream(System.getProperty("user.dir")
					+ "//src//main//java//freddycomapany//ecommerceaplication//Resources//GlobalData.properties");
			prop.load(fls);
			browser = prop.getProperty("browser");
		}
		
		//String browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

		if (browser.contains("chrome")) {			
		    ChromeOptions options = new ChromeOptions();
		    
		    if (browser.contains("headless")) {
		    	options.addArguments("--headless=new");
			    //options.addArguments("--disable-gpu");
			    //options.addArguments("--window-size=2560, 1440");
			    //options.addArguments("--no-sandbox");
			    //options.addArguments("--disable-dev-shm-usage");
			    //options.addArguments("--disable-animations");
		    } 

		    WebDriver driver = new ChromeDriver(options);
		    driver.manage().window().setSize(new Dimension(2560, 1440)); 
		    threadDriver.set(ThreadGuard.protect(driver));
		} else if (browser.contains("firefox")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")
					+ "//src//src//test//java//freddycomapany//ecommerceaplication//TestsComponents//msedgedriver.exe");
			threadDriver.set(ThreadGuard.protect(new FirefoxDriver()));
		} else if (browser.contains("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")
					+ "//src//src//test//java//freddycomapany//ecommerceaplication//TestsComponents//msedgedriver.exe");
			threadDriver.set(ThreadGuard.protect(new EdgeDriver()));
		}

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().window().maximize();

		formValues.put("First Name", "Freddy");
		formValues.put("Last Name", "Freddy");
		formValues.put("Email", "prueba2@hotmail.comX");
		formValues.put("Phone Number", "1234567891");
		formValues.put("Occupation", "Engineer");
		formValues.put("Gender", "Male");
		formValues.put("Password", "g3sUYi@2NmPHT67");
		formValues.put("Confirm Password", "g3sUYi@2NmPHT67");
	}
	

    public static WebDriver getDriver() {
        return threadDriver.get(); // Devuelve el driver del hilo actual.
    }
    
    public static LandingPage getLandingPageManager() {
        return threadlandingPage.get(); // Devuelve el driver del hilo actual.
    }
    
    
	@BeforeMethod(alwaysRun = true)
	public void launchAplication() throws IOException {	
		initializeDriver();
		threadlandingPage.set(new LandingPage(getDriver()));
		getLandingPageManager().goTo("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void closeAplication() throws InterruptedException {
		//Thread.sleep(3000);
        getDriver().quit();
        threadDriver.remove(); // Limpieza del ThreadLocal
        threadlandingPage.remove();
	}

	//@AfterTest(alwaysRun = true)
	public void FinalizeTest() throws InterruptedException{
		//Thread.sleep(3000);
        getDriver().quit();
        threadDriver.remove(); // Limpieza del ThreadLocal
	}

	
	public List<HashMap<String, String>> getJsonDataToMap(String UrlFile) throws IOException { 
		File fls = new File(UrlFile);
		String file = FileUtils.readFileToString(fls, StandardCharsets.UTF_8);
		//OR FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//java//freddycomapany//ecommerceaplication//TestsComponents"), StandardCharsets.UTF_8)
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(file, new TypeReference<List<HashMap<String, String>>>(){});
	
		return data;
	}
	
	
	public String getScreenShot(String testcase, WebDriver driver) throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//reports//" + testcase + ".png"));
		
		return System.getProperty("user.dir") + "//reports//" + testcase + ".png";		
	}

}