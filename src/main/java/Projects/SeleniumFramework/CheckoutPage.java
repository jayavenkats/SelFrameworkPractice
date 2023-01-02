package Projects.SeleniumFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Projects.Reusablecomponents.abstractComponents;

public class CheckoutPage extends abstractComponents {
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css = ".action_submit")
	WebElement submit;
	
	@FindBy(xpath= "//button[contains(@class,'ta-item')])[2]")
	WebElement selcntry;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitforelementToAppear(results);
		selcntry.click();
		
	}
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}

}
