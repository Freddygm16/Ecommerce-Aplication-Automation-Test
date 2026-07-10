package Taks;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GeolocalizationTest {

	@Test
	public void GeolocalizationTestRun() throws InterruptedException {
		
        ChromeOptions options = new ChromeOptions();
	  //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 1);
        
        // Argumentos para reducir detección de bot
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("prefs", prefs);

        ChromeDriver driver = new ChromeDriver(options);
        
	    DevTools tools = driver.getDevTools();
	    
	    tools.createSession();
	    
	    Map<String, Object> params = new HashMap<String, Object>();
	    double lat = 20.605;     // latitud
	    double lon = 78.879;     // longitud
	    float acc = 5.0f;        // precisión en metros
	    //double lat = 40.000;     // latitud
	    //double lon = 3.00;     // longitud
	    //float acc = 1.0f;        // precisión en metros

	    
	    params.put("latitude", lat);
	    params.put("longitude", lon);
	    params.put("accuracy", acc);
	    
        // ✅ Setear geo ANTES de navegar
        driver.executeCdpCommand("Emulation.setGeolocationOverride", params);
        
        // Ocultar webdriver para evitar detección por bot
        driver.executeCdpCommand("Page.addScriptToEvaluateOnNewDocument",
            Map.of("source",
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined});"
            )
        );
        
        driver.manage().window().maximize();

        Thread.sleep(5000); // Esperar a que se cargue la página y muestre la ubicación

        driver.get("https://www.google.com/");
		
	    
		driver.findElement(By.id("APjFqb")).sendKeys("Netflix");
		
		
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);

		
	    driver.findElement(By.className("zReHs")).click();
	    
	    String title =driver.findElement(By.className("default-ltr-iqcdef-cache-slza4h")).getText();
	    
	    System.out.println(title);
	    
	    driver.quit();
	
	}

}
