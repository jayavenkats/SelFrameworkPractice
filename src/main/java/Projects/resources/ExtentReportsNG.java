package Projects.resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;

public class ExtentReportsNG {

	static ExtentReports extrpt1;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter1 = new ExtentSparkReporter(path);
		reporter1.config().setDocumentTitle("Test Results");
		reporter1.config().setReportName("Automation Test Results");
		
		extrpt1 = new ExtentReports();
		extrpt1.attachReporter(reporter1);
		extrpt1.setSystemInfo("Tester", "Jayavenkat");
		return extrpt1;
		
}
}
