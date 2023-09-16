package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemoblaze {
	
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		//ExtentSparkReporter reporter;
		report.config().setReportName("DemoBlaze Automation Report");
		report.config().setDocumentTitle("DemoBlaze Report");
		 
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Performed By:", "Neha");
		return extent;
	}

}
