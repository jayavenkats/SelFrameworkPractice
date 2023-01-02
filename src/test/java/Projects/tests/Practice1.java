package Projects.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		String url = "https://www.godaddy.com/";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Test01");
		openAndMaximize(driver, url);
		System.out.println("Test02");
		openUrlAndPrintTitle(driver, url);
		System.out.println("Test03");
		openUrlAndValidateTitle(driver, url);
		driver.close();
	}

	public static void openAndMaximize(WebDriver driver, String url){
	
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("url opened");
		
	}
	public static void openUrlAndPrintTitle(WebDriver driver, String url) {
		
		System.out.println("the page title is " + driver.getTitle());
		System.out.println("the current url is "+ driver.getCurrentUrl());
		
	}
	public static void openUrlAndValidateTitle(WebDriver driver, String url) {
	
		String pgtitl= "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		String curUrl = "https://www.godaddy.com/en-in";
		Assert.assertEquals(driver.getTitle(), pgtitl);
		Assert.assertEquals(driver.getCurrentUrl(), curUrl);
		//System.out.println("page source " + driver.getPageSource());
		
		
	}
}
