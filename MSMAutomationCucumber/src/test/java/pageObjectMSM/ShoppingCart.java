package pageObjectMSM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utillity.BaseClass;

public class ShoppingCart
{

	private static WebElement element = null,size,colorfont;
	private static String number=null,title;
	private static Action act;
	private static Actions builder;


	//Element for Mini cart number 
	public static WebElement miniCart_btn(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeVisible(driver,"//span[@data-analytics='cartItems']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Shopping Cart - miniCart_btn button not found");
			e.printStackTrace();
		}
		return element;
	}



	//Element for View order and cart button
	public static WebElement viewCart_btn(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeVisible(driver,"//a[@class='button success uk-minicart__submit-button ng-binding']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Shopping Cart - minicart View cart and Checkout_btn button not found");
			e.printStackTrace();
		}
		return element;
	}


	//Element for product name/title on cart page
	public static WebElement productTitle_lbl(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeVisible(driver,"//div[@class='group ng-scope']//child::a[@ng-bind='variant.name']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Shopping Cart - minicart View cart and Checkout_btn button not found");
			e.printStackTrace();
		}
		return element;
	}

	//Element for My Cart Checkout button
	public static WebElement checkout_btn(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeVisible(driver,"//button[@button-text='trans.MyCartItems_Checkout']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Shopping Cart - My Cart Page Checkout button not found");
			e.printStackTrace();
		}
		return element;
	}






	/*--------------------------------------------------------
	 *															*
	 *			********************************				*
	 *															*
	 * ************ MiniCart Number get Action ****************** *
	 *			********************************				*
	 *															*		
	 *---------------------------------------------------------*/


	public static String getMiniCart(WebDriver driver)
	{

		try
		{
			number=ShoppingCart.miniCart_btn(driver).getText();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return number;
	}




	/*--------------------------------------------------------
	 *															*
	 *			********************************				*
	 *															*
	 * ************ MiniCart -> MyCart Page Action  *********** *
	 *			********************************				*
	 *															*		
	 *---------------------------------------------------------*/


	public static void viewCartAndCheckout(WebDriver driver)
	{
		builder = new Actions(driver);
		try
		{
			act=builder.moveToElement(ShoppingCart.miniCart_btn(driver)).build();
			act.perform();
			ShoppingCart.viewCart_btn(driver).click();	

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}



	/*--------------------------------------------------------
	 *															*
	 *			********************************				*
	 *															*
	 * ************ My Cart Page Product title Action  *********** *
	 *			********************************				*
	 *															*		
	 *---------------------------------------------------------*/


	public static String productTitle(WebDriver driver)
	{

		try
		{

			title=ShoppingCart.productTitle_lbl(driver).getText();	

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return title;
	}


	/*--------------------------------------------------------
	 *															*
	 *			********************************				*
	 *															*
	 * ****** My Cart Page Checkout Button Click Action  ****** *
	 *			********************************				*
	 *															*		
	 *---------------------------------------------------------*/


	public static void checkOutClick(WebDriver driver)
	{

		try
		{
			BaseClass.waitFor(5);
			ShoppingCart.checkout_btn(driver).click();
			BaseClass.waitFor(5);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


}
