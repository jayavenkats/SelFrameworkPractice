package Projects.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Projects.Reusablecomponents.abstractComponents;

public class ConfirmationPage extends abstractComponents{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		 super(driver);
		 
		 this.driver = driver ;
		 PageFactory.initElements(driver, this);
		}
	
	@FindBy(css = ".hero-primary")
	WebElement conmsg;
	
	public String getConfText() {
		return conmsg.getText();
	}
}
