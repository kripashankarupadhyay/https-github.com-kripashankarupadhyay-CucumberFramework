package stepDefination;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectMSM.AddToBag;
import pageObjectMSM.CheckoutProcess;
import pageObjectMSM.LoginPage;
import pageObjectMSM.ReviewAndPlace;
import pageObjectMSM.Shopping;
import pageObjectMSM.ShoppingCart;
import utillity.BaseClass;

public class MSMEndToEnd 
{

	public static WebDriver driver = null;
	public static String user,title,product,productTitle,cartItem,cartProduct;
    public static boolean value; 
	
	@Given("^Open \"([^\"]*)\" and  Open \"([^\"]*)\"$")
	public void open_and_Open(String browser, String website) throws Throwable
	{

		driver=BaseClass.OpenBrowser(browser,website);
	}

	@When("^User navigate to login page$")
	public void user_navigate_to_login_page() throws Throwable
	{

		System.out.println("User moving to LogIN page");
	}

	@Then("^User enter the valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_the_valid_and(String username, String password) throws Throwable 
	{

		user= LoginPage.loginAction(driver,username,password);
		System.out.println("User login ---> "+user);

	}

	@Then("^User should be successully login$")
	public void user_should_be_successully_login() throws Throwable 
	{
		Assert.assertEquals("Hi, test_aashish", user, "user not login successfully");
		System.out.println("User login successfully");
	}

	@When("^User navigate to category page \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_navigate_to_category_page_and(String menu, String submenu) throws Throwable
	{
		title=Shopping.selectCateory(driver, menu, submenu);
	}

	@Then("^User should navigate to right category page$")
	public void user_should_navigate_to_right_category_page() throws Throwable 
	{
		Assert.assertEquals(title, title, "user not on right category page");
		System.out.println("User moved on right category page");
	}

	@Then("^Click on first product$")
	public void click_on_first_product() throws Throwable 
	{
		product =Shopping.selectProductAction(driver);
	}

	@Then("^User should move to same product page$")
	public void user_should_move_to_same_product_page() throws Throwable
	{
		productTitle=Shopping.verifyProductAction(driver);
		Assert.assertEquals(productTitle, product, "user not on right product page");
		System.out.println("Product Title:-"+productTitle);
	}

	@When("^User add product to cart$")
	public void user_add_product_to_cart() throws Throwable 
	{
		AddToBag.selectSizeAction(driver);
		AddToBag.clickAddToBag(driver);
		AddToBag.continueShop(driver);
	}

	@Then("^Product should add in minicart$")
	public void product_should_add_in_minicart() throws Throwable 
	{

		cartItem=ShoppingCart.getMiniCart(driver);
		int num=Integer.parseInt(cartItem);
		if(num>0)
		{
			System.out.println("Mini Cart Verified successfully...");
		}else
		{
			System.err.println("Mini Cart Not Working...");
			 Assert.fail("Mini Cart Not working");
		}

	}

	@When("^User move to MyCart page$")
	public void user_move_to_MyCart_page() throws Throwable 
	{
		ShoppingCart.viewCartAndCheckout(driver);
		//driver.manage().deleteAllCookies();
	}

	@Then("^User can see added product on$")
	public void user_can_see_added_product_on() throws Throwable 
	{
		cartProduct=ShoppingCart.productTitle(driver);
		Assert.assertEquals(productTitle, cartProduct, "USER CAN SEE PRODUCT ON CART");

	}

	@When("^Click on checkout button$")
	public void click_on_checkout_button() throws Throwable 
	{
         ShoppingCart.checkOutClick(driver); 
       
	}

	@Then("^User navigate to shipping page$")
	public void user_navigate_to_shipping_page() throws Throwable
	{

		Assert.assertEquals(driver.getTitle(),"SECURE CHECKOUT | Medical Scrubs Mall", "USER NOT ON SHIPPING PAGE");
	}

	@When("^Click on Proceed to Payment button$")
	public void click_on_Proceed_to_Payment_button() throws Throwable
	{
        CheckoutProcess.processToPayment(driver);
	}

	@Then("^User navigate to Payment page$")
	public void user_navigate_to_Payment_page() throws Throwable
	{
		value=CheckoutProcess.reviewOrder_button(driver).isDisplayed();
		if(value==true)
		{
			System.out.println("user on right payment page");
		}
		else
		{
			Assert.fail("User not on payment page...");
		}
	}

	@Then("^Fill all card details \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void fill_all_card_details_and_and_and(String cardNumber, String cardType, String month, String year, String sCode) throws Throwable 
	{
		CheckoutProcess.paymentAction(driver,cardNumber,cardType,month,year,sCode);
	}

	@Then("^Click on Review Order button$")
	public void click_on_Review_Order_button() throws Throwable 
	{

		CheckoutProcess.reviewButtonAction(driver);
	}

	@Then("^User navigate to Review and Place Order page$")
	public void user_navigate_to_Review_and_Place_Order_page() throws Throwable 
	{

		value=ReviewAndPlace.placeOrder_btn(driver).isDisplayed();
		if(value==true)
		{
			System.out.println("user on right review and order place page");
		}
		else
		{
			Assert.fail("User not on payment page...");
		}
		
	}

	@Then("^Validate the Amount and Product$")
	public void validate_the_Amount_and_Product() throws Throwable 
	{

		throw new PendingException();
	}

	@When("^LogOut from MSM$")
	public void logout_from_MSM() throws Throwable 
	{
		 user= LoginPage.logoutAction(driver);
	}

	@Then("^Validate the successfully logout$")
	public void validate_the_successfully_logout() throws Throwable 
	{
		Assert.assertEquals("SIGN IN", user, "user not logout successfully");
	}
	
	@When("^Close the browser$")
	public void close_the_browser() throws Throwable 
	{
		
	driver.close();
	
	}

}
