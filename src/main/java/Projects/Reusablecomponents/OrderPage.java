package Projects.Reusablecomponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends abstractComponents {

WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		//Initialization from stadalonetest. bringing the driver object to this page.
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= "tr td:nth child(3)")
	private List<WebElement> productNames;
	
	public boolean verifyOrderDisply(String productname) {
		Boolean match = productNames.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productname));
		return match;
		
	}
}
