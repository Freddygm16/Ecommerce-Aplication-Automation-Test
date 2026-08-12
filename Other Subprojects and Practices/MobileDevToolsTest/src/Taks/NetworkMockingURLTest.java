package Taks;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v147.fetch.Fetch;
import org.openqa.selenium.devtools.v147.network.Network;
import org.testng.annotations.Test;

public class NetworkMockingURLTest {
	@Test
	public void MovileDevToolsTest() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
		DevTools tools = driver.getDevTools();

		tools.createSession();
		
		tools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		tools.addListener(Fetch.requestPaused(), request ->{			
			try {
				if(request.getRequest().getUrl().contains("=shetty")) {
					String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
					System.out.println("Request URL modified: " + mockedUrl);
					
					tools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.of(request.getRequest().getMethod()), 
							Optional.empty(), Optional.empty(), Optional.empty()));	
				}else {
					tools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()), 
							Optional.empty(), Optional.empty(), Optional.empty()));
				}	
			}catch (Exception e) {
				e.printStackTrace();
				tools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()), 
						Optional.empty(), Optional.empty(), Optional.empty()));
			}

		});
		
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector("button[routerlink=\"/library\"]")).click();
		
		
//		driver.quit();
		
	}
}



/*Fetch.continueRequest(
request.getRequestId(),
Optional.of("https://api.ejemplo.com/data"),   // mockedUrl
Optional.of("POST"),                           // método HTTP
Optional.of("{\"id\":123,\"nombre\":\"Freddy\"}"), // cuerpo de la petición
Optional.of(new HashMap<String, Object>() {{   // headers modificados
    put("Content-Type", "application/json");
    put("Authorization", "Bearer tokenDePrueba");
}}),
Optional.of(new HashMap<String, Object>() {{   // postDataHeaders
    put("Content-Length", "35");
    put("Content-Encoding", "utf-8");
}})
);
Explicación:
mockedUrl → redirige la petición.

method → sobrescribe el método HTTP.

postData → cuerpo de la petición.

headers → cabeceras generales de la petición.

postDataHeaders (ese último Optional) → cabeceras específicas para el cuerpo de la petición, como Content-Length, Content-Encoding, etc.

👉 Si no necesitas modificar esos encabezados, puedes dejarlo como Optional.empty().*/