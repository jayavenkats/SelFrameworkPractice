package Projects.Reusablecomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Projects.SeleniumFramework.CartPage;

public class abstractComponents {

	WebDriver driver;
	
	public abstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	@FindBy(css="[routerlink*='myOrders']")
	WebElement orderHeader;
	
	public CartPage gotocartpage() {
		cartheader.click(); 
		CartPage crtpg = new CartPage(driver);
		return crtpg;
	}
	
	public OrderPage gotoOrderPage() {
		orderHeader.click(); 
		OrderPage ordpg = new OrderPage(driver);
		return ordpg;
	}
	
	public void waitforelementToAppear(By findby) {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}
	
	public void waitforWebelementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	public void waitforelementtodisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}

}
