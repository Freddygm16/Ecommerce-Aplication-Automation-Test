package GridTestsPackage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class InvokeSecondGridTest {

	@Test
	public void invokeCompanyPage() throws MalformedURLException, URISyntaxException {
		DesiredCapabilities caps = new DesiredCapabilities();
		// TODO Auto-generated method stub
		caps.setCapability(CapabilityType.BROWSER_NAME, "edge");
			
		WebDriver driver = new RemoteWebDriver(new URI("http://192.168.100.159:4444").toURL(), caps);
		
		driver.get("https://www.constructoramgcr.com/es/");

		System.out.println(driver.getTitle());
	
	}

}
