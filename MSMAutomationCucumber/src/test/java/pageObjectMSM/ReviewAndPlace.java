package pageObjectMSM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utillity.BaseClass;

public class ReviewAndPlace
{

	
	private static WebElement element = null,size,colorfont;
	private static String number=null,title;
	private static Action act;
	private static Actions builder;
	private static Select month,year;


	//Element for Process To Payment 
	public static WebElement placeOrder_btn(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeClickable(driver,"//button[@button-text='trans.Checkout_PlaceOrderMSM']"); 	
		}
		catch(Exception e)
		{
			System.err.println("ReviewAndPlace - placeOrder_btn button not found");
			e.printStackTrace();
		}
		return element;
	}
	
	
}
