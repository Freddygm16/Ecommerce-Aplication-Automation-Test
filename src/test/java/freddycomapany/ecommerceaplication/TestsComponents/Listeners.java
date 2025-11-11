package freddycomapany.ecommerceaplication.TestsComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import freddycomapany.ecommerceaplication.Resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentReports extent = ExtentReportNG.getReportedObject();
	ThreadLocal<ExtentTest> threadTest = new ThreadLocal<>();
	String capturePath;
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		threadTest.set(extent.createTest(result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//test.pass("The test pass correclty");
		threadTest.get().log(Status.PASS, "The test pass correctly");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		threadTest.get().fail(result.getThrowable());
		//test.generateLog(Status.FAIL, "The test fail");

		try {
			/*To return a public variable of the object in the class scope level and to specific instances that call this method*/
			//driver = (WebDriver) result.getTestClass().getRealClass().getField("getDriver").get(result.getInstance()); 
			driver = (WebDriver) result.getTestClass().getRealClass().getMethod("getDriver").invoke(result.getInstance()); // Is better this option in parrallel test because the method return the specific driver of the thread that managed test
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			capturePath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		threadTest.get().addScreenCaptureFromPath(capturePath);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
