package Projects.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testClass {
	ExtentReports extrpt;
	WebDriver driver;
	@BeforeTest
	public void browserInitiation() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Automation Test Results");
		
		extrpt = new ExtentReports();
		extrpt.attachReporter(reporter);
		extrpt.setSystemInfo("Tester", "Jayavenkat");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://google.com");
	}
	
	@Test
	public void getPageTitle() {
		extrpt.createTest("Page Title");
		String pgtitle =driver.getTitle();
		System.out.println("The page title is "+pgtitle);
		extrpt.flush();
	}
	
	@Test
	public void getPageLinks() {
		extrpt.createTest("Page Links");
		List links=driver.findElements(By.tagName("a"));
		int noOfElements = links.size();
		System.out.println("number of links "+noOfElements);
		extrpt.flush();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
