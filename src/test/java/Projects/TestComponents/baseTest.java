package Projects.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Projects.SeleniumFramework.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	
	
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException {
		
		//properties class used to read globaldata file.
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Workspace\\SeleniumFramework\\src\\main\\java\\Projects\\resources\\Globaldata.properties");
		//D:\\Workspace\\SeleniumFramework\\src\\main\\java\\Projects\\resources\\Globaldata.properties
		prop.load(fis);
		
		// to connect global variable during runtime using maven command
		String browsername = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browsername.contains("chrome")) 
		{
			ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		
		
		if(browsername.contains("headless")) {
			options.addArguments("headless");
		}
		driver = new ChromeDriver(options);
		
		} 
		else if(browsername.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir") + "\\reports\\"+ testcasename + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "\\reports\\" + testcasename+".png";
	}
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;

	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
