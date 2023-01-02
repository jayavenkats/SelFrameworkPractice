package Projects.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wilpauto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://wilp.wheebox.com/");
		
		driver.findElement(By.id("login")).sendKeys("eval.jayavenkatshreenivasan@wilp.bits-pilani.ac.in");
		driver.findElement(By.id("password")).sendKeys("password@123");
		driver.findElement(By.id("submitButton")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		Actions a= new Actions(driver);
		
		a.moveToElement(driver.findElement(By.cssSelector(".fa-laptop"))).build().perform();
		driver.findElement(By.cssSelector(".fa-file-text")).click();
		
		driver.findElement(By.xpath("//*[@id=\"sample_1\"]/tbody/tr[4]/td[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"sample_1\"]/tbody/tr[5]/td/ul/li/span[2]/a")).click();
		
		
		
		driver.findElement(By.xpath("//*[@id=\"subjectiveDashboard\"]/div/div[3]")).click();
		Thread.sleep(5000);
		
		List<WebElement> bitsid= driver.findElements(By.cssSelector(".feeds li"));
		int stuClick = bitsid.size();
		//java.util.Iterator<WebElement> clickstu = bitsid.iterator();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//while(clickstu.hasNext()) {
		
		for(int i=0;i<stuClick;i++) {
		js.executeScript("arguments[0].scrollIntoView();" , bitsid.get(i));
		bitsid.get(i).click();
		
		//driver.findElement(By.xpath("//ul[@class='feeds']/li")).click();
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitButton")));
		//to do these 3 in loop
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/button[2]")).click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.elementToBeClickable (By.cssSelector(".confirm")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/button[2]")).click();
		//}
		}
		
		driver.findElement(By.linkText("Dashboard")).click();
		String remaining = driver.findElement(By.xpath("//*[@id=\"subjectiveDashboard\"]/div/div[3]/div/div/div/span[2]")).getText();
		
		Assert.assertEquals(remaining, "0");
		System.out.println("Successfully completed the submission");
		
	}

}
