package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listerners extends Utils implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent=ExtentReportDemoblaze.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		

	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String filePath=null;
		try {
			filePath=getScreenshot(result.getMethod().getMethodName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
