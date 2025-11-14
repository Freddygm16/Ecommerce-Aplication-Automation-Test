package freddycompany.ExtendReportsTutorial;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportsTest {

	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "//reports//index.html"));
		reporter.config().setReportName("Extend Report Tutorial");
		reporter.config().setDocumentTitle("Extend Report Tutorial");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Freddy García");
		
		
	}

	@Test
    public void InitialTest() {
		ExtentTest test =  extent.createTest("ExtendReportsTest");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.constructoramgcr.com/");
		test.fail("The test is fail");
		
		extent.flush();
    }
}
