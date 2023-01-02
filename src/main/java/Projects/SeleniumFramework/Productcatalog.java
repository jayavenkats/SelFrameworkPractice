package Projects.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Projects.Reusablecomponents.abstractComponents;

public class Productcatalog extends abstractComponents {
	
	WebDriver driver;
	
	public Productcatalog(WebDriver driver) {
		super(driver);
		//Initialization from stadalonetest. bringing the driver object to this page.
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Page Factory
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productsBy= By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getproductlist() {
		
		waitforelementToAppear(productsBy);
		return products;
		}
	
	public WebElement getproductbyname(String productname) {
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
	public void addtocart(String productname) {
		WebElement prod= getproductbyname(productname);
		prod.findElement(addtocart).click();
		waitforelementToAppear(toastmessage);
		waitforelementtodisappear(spinner);
	}

}
