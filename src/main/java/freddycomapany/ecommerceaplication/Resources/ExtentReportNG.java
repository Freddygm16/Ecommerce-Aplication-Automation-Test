package freddycomapany.ecommerceaplication.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportedObject() {
		
		ExtentSparkReporter report = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//index.html");
		report.config().setDocumentTitle("Ecommerce Aplication");
		report.config().setReportName("Test Reports");
		
		ExtentReports extent =  new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Freddy García");
		
		return extent;
	}

}
