package Projects.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice2 {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
		driver.findElement(By.name("firstname")).sendKeys("Jayavenkat");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Shreenivasan");
		driver.findElement(By.cssSelector("input#sex-0")).click();
		driver.findElement(By.xpath("//input[@id='exp-2']")).click();
		driver.findElement(By.id("datepicker")).sendKeys("12/12/22");
		driver.findElement(By.id("profession-1")).click();
		driver.findElement(By.id("tool-0")).click();
		driver.findElement(By.id("tool-2")).click();
		Select conti = new Select(driver.findElement(By.id("continents")));
		conti.selectByVisibleText("Europe");
		Select selcom = new Select(driver.findElement(By.id("selenium_commands")));
		selcom.selectByVisibleText("Browser Commands");
		selcom.selectByIndex(1);
		driver.findElement(By.className("input-file")).sendKeys("C:\\Users\\jayavenkat_s\\Downloads\\training-images\\apple\\IMG_20200229_164759.jpg");
		driver.findElement(By.linkText("Click here to Download File")).click();
		//driver.findElement(By.cssSelector(".btn-info")).click();
		/*Robot rb = new Robot();
		 StringSelection str = new StringSelection("C:\\Users\\jayavenkat_s\\Downloads\\training-images\\apple\\IMG_20200229_164759.jpg");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		    
		     // press Contol+V for pasting
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		 
		    // release Contol+V for pasting
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		    rb.keyRelease(KeyEvent.VK_V);
		 
		    // for pressing and releasing Enter
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
		*/
	}

}
