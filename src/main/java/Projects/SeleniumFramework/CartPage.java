package Projects.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Projects.Reusablecomponents.abstractComponents;

public class CartPage extends abstractComponents {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		//Initialization from stadalonetest. bringing the driver object to this page.
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Page Factory
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css= ".cartsection h3")
	private List<WebElement> cartproducts;
	
	public boolean verifyproductdisply(String productname) {
		Boolean match = cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productname));
		return match;
		
	}
	public CheckoutPage gotocheckout() {
		checkoutEle.click();
		CheckoutPage chkpg = new CheckoutPage(driver);
		return chkpg;
		
	}
	
	

}
