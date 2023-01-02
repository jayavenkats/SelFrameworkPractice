package StepDefenitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Projects.SeleniumFramework.CartPage;
import Projects.SeleniumFramework.CheckoutPage;
import Projects.SeleniumFramework.ConfirmationPage;
import Projects.SeleniumFramework.LandingPage;
import Projects.SeleniumFramework.Productcatalog;
import Projects.TestComponents.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefenitionImplementation extends baseTest {

	public LandingPage landingpage;
	public Productcatalog prdctlg;
	public ConfirmationPage conpg;
	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException {
		landingpage = launchApplication();
	}
	@Given("^Login with username(.+) and password (.+)$")
	public void loggedin_username_and_password(String username, String password) {
		
		prdctlg= landingpage.loginApplication(username, password);
	}
	@When("^Add product (.+) to cart$")
	public void add_product_to_cart(String productname) {
		
		List<WebElement> products = prdctlg.getproductlist();
		prdctlg.addtocart(productname);
		
	}
	@And("^Checkout (.+) and Submit the order$")
	public void checkout_submit_order(String productname) {
		CartPage crtpg=prdctlg.gotocartpage();
		
		Boolean match = crtpg.verifyproductdisply(productname);
				
		Assert.assertFalse(match);
		crtpg.gotocheckout();
		
		CheckoutPage chkpg = crtpg.gotocheckout();
		chkpg.selectCountry("India");
		ConfirmationPage conpg = chkpg.submitOrder();
	}
	@Then("{string} dislplayed on the confirmation page")
	public void message_confirmation_displayed(String string) {
		String confirmmsg = conpg.getConfText();
		Assert.assertTrue(confirmmsg.equalsIgnoreCase(string));
		
	}
}

