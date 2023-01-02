package Projects.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Projects.SeleniumFramework.CartPage;
import Projects.SeleniumFramework.Productcatalog;
import Projects.TestComponents.baseTest;

public class errorValidationTest extends baseTest {

	@Test
	
	public void loginErrorValidation() {
		
		String productname ="ZARA COAT 3";
		String countryName ="India";
			
		landingpage.loginApplication("jay@abc.com", "Me3cury1!");
		Assert.assertEquals( landingpage.getErrorMessage() , "Incorrect email or password." );		
	}
	
	@Test
	
	public void productErrorValidation() {
		String productname ="ZARA COAT 3";
		String countryName ="India";
	
		Productcatalog prdctlg = landingpage.loginApplication("jay@abc.com", "Mercury1!");
		
		List<WebElement> products = prdctlg.getproductlist();
		prdctlg.addtocart(productname);
		CartPage crtpg=prdctlg.gotocartpage();
				
		Boolean match = crtpg.verifyproductdisply("ZARA COAT 33");
				
		Assert.assertFalse(match);
		
	}
	
	}
