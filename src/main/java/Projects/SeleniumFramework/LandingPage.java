package Projects.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Projects.Reusablecomponents.abstractComponents;

public class LandingPage extends abstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		//Initialization from stadalonetest. bringing the driver object to this page.
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Page Factory
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css= "[class*='flyInOut']")
	WebElement errormsg;
	
	public Productcatalog loginApplication(String email, String password) {
		
		useremail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		Productcatalog prdctlg= new Productcatalog(driver);
		return prdctlg;
		
	}
	public String getErrorMessage() {
		waitforWebelementToAppear(errormsg);
		return errormsg.getText();
		
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
