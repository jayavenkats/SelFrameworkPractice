package Projects.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Projects.Reusablecomponents.OrderPage;
import Projects.SeleniumFramework.CartPage;
import Projects.SeleniumFramework.CheckoutPage;
import Projects.SeleniumFramework.ConfirmationPage;
import Projects.SeleniumFramework.LandingPage;
import Projects.SeleniumFramework.Productcatalog;
import Projects.TestComponents.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class orderSubmitTest extends baseTest {
	String productname ="ZARA COAT 3";
	@Test
	public void submitOrder() throws IOException
	
	{
		
		String countryName ="India";
		


		
		Productcatalog prdctlg = landingpage.loginApplication("jay@abc.com", "Mercury1!");
		
		List<WebElement> products = prdctlg.getproductlist();
		prdctlg.addtocart(productname);
		CartPage crtpg=prdctlg.gotocartpage();
				
		Boolean match = crtpg.verifyproductdisply(productname);
				
		Assert.assertFalse(match);
		crtpg.gotocheckout();
		
		CheckoutPage chkpg = crtpg.gotocheckout();
		chkpg.selectCountry(countryName);
		ConfirmationPage conpg = chkpg.submitOrder();
				
		String confirmmsg = conpg.getConfText();
		Assert.assertTrue(confirmmsg.equalsIgnoreCase("Thankyou for the order"));
		
		}
	
	@Test(dependsOnMethods = {"submitOrder"})
	
	public void orderHistoryTest() {
		Productcatalog prdctlg = landingpage.loginApplication("jay@abc.com", "Mercury1!");
		OrderPage ordpg = prdctlg.gotoOrderPage();
		Assert.assertTrue(ordpg.verifyOrderDisply(productname));
	}
	
	
}
