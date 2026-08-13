package Taks;

import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.openqa.selenium.Credentials;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

public class PopUpLoginBrowserTest {
	
	@Test
	public void PopUpLoginBrowserTest() {

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
		DevTools tools = driver.getDevTools();

		tools.createSession();
		
		Predicate<URI> predicate = uri -> uri.getHost().contains("httpbin.org");
		
		// Supplier<Credentials> credential = (Supplier<Credentials>) new UsernameAndPassword("foo","bar");
		
		((HasAuthentication) driver).register(predicate, UsernameAndPassword.of("foo","bar"));
		
        driver.get("http://httpbin.org/basic-auth/foo/bar");

        
	}
}
