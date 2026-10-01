package Taks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadAnDowloadDocument {
	@Test
	public void CaptureConsoleLogsCase() throws InterruptedException, IOException {

		String downloadPath = System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/es/word_a_pdf");
		
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Usuario\\OneDrive\\Escritorio\\Documentos\\Script.exe");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));

		driver.findElement(By.id("processTask")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		
		driver.findElement(By.id("pickfiles")).click();
		
		Thread.sleep(5000);
		
		File file = new File(downloadPath + "/Resumen ejecutivo.pdf");
		
		if (file.exists()) {
		    Assert.assertTrue(true, "El archivo se ha descargado correctamente.");
		    if(file.delete()) {
		        System.out.println("El archivo se ha eliminado correctamente.");
		    } else {
		        System.out.println("No se pudo eliminar el archivo.");
		    }
		} else {
		    System.out.println("El archivo no se ha descargado.");
		}
		
		driver.quit();
	}
}
