package ReviewTutorialPractice;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ManagedBrowserOptions {

	public static void main(String[] args) {
		// TODO Configure a options of google chrome, set a proxy, set a dowloand directory url: "https://sites.google.com/chromium.org/driver/capabilities"
		// TODO Write a code that alllow delete all cookieas int the browser and speciofic cookies for example: sessionóKey
		
		ChromeOptions options = new ChromeOptions();
		@SuppressWarnings("unused")
		Proxy proxy = new Proxy();
		//proxy.setHttpProxy("ipaddress:4444");
		//options.setCapability("Proxy", proxy);
		options.setAcceptInsecureCerts(true);
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "C:\\Users\\fredd\\OneDrive\\Escritorio\\Documentos");

		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver =  new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("sessionKeu");
		
		driver.get("https://expired.badssl.com/");
		
		
	}

}
