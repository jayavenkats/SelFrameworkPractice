package Projects.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Projects.resources.ExtentReportsNG;

public class Listeners extends baseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extrpt1 = ExtentReportsNG.getReportObject();
	ThreadLocal<ExtentTest> loctest = new ThreadLocal<ExtentTest>(); //Thread safe
	
	@Override
	public void onTestStart (ITestResult result) {
		extrpt1.createTest(result.getMethod().getMethodName());
		loctest.set(test);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		//default it will give the result
		loctest.get().log(Status.PASS, "Test is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		loctest.get().fail(result.getThrowable());
		
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
		String filepath = null;
		try {
			 filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loctest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
		//take screeshot and attach
	}
	@Override
	public void onFinish(ITestContext context) {
		extrpt1.flush();
	}
}
