package pageObjectMSM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utillity.BaseClass;

public class CheckoutProcess
{

	private static WebElement element = null,size,colorfont;
	private static String number=null,title;
	private static Action act;
	private static Actions builder;
	private static Select month,year;


	//Element for Process To Payment 
	public static WebElement processPayment_btn(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeClickable(driver,"//button[@class='button button--expanded success ng-binding ng-isolate-scope']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Checkout Process - processPayment_btn button not found");
			e.printStackTrace();
		}
		return element;
	}

	//Element for checkbox of same address 
	public static WebElement sameAddress_cbx(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeVisible(driver,"//label[@for='IsBillingSameAsShipping']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Checkout Process - sameAddress_cbx button not found");
			e.printStackTrace();
		}
		return element;
	}

	//Element for Credit card number 
	public static WebElement creditCard_tbx(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeVisible(driver,"//input[@name='cardNumber']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Checkout Process - cardNumber text box not found");
			e.printStackTrace();
		}
		return element;
	}


	//Element for Card Type 
	public static WebElement cardType_ddn(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeVisible(driver,"//select[@name='cardType']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Checkout Process - cardType dropdown not found");
			e.printStackTrace();
		}
		return element;
	}

	//Element for Payment Month
	public static WebElement month_ddn(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeVisible(driver,"//select[@name='expirationMonth']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Checkout Process - payment month not found");
			e.printStackTrace();
		}
		return element;
	}

	//Element for Payment Year
	public static WebElement year_ddn(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeVisible(driver,"//select[@name='expirationYear']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Checkout Process - payment year not found");
			e.printStackTrace();
		}
		return element;
	}


	//Element for Payment Security code
	public static WebElement securityCode_tbx(WebDriver driver)
	{
		try
		{
			element = BaseClass.WaitTimeVisible(driver,"//input[@name='securityCode']"); 	
		}
		catch(Exception e)
		{
			System.err.println("Checkout Process - payment Security Code not found");
			e.printStackTrace();
		}
		return element;
	}		

	
	//Element for Payment Review Order Button
		public static WebElement reviewOrder_button(WebDriver driver)
		{
			try
			{
				element = BaseClass.WaitTimeVisible(driver,"//button[@button-text='trans.Checkout_ReviewOrder']"); 	
			}
			catch(Exception e)
			{
				System.err.println("Checkout Process - payment review Order button not found");
				e.printStackTrace();
			}
			return element;
		}		
	



	/*--------------------------------------------------------
	 *															*
	 *			********************************				*
	 *															*
	 * ************ Process to payment Action *******************
	 *			********************************				*
	 *															*		
	 *---------------------------------------------------------*/


	public static void processToPayment(WebDriver driver)
	{
		builder = new Actions(driver);

		try
		{	
			BaseClass.waitFor(3);
			CheckoutProcess.sameAddress_cbx(driver).click();
			BaseClass.waitFor(3);
			CheckoutProcess.processPayment_btn(driver).click();
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
	 * ************ Payment Page Action *******************
	 *			********************************				*
	 *															*		
	 *---------------------------------------------------------*/


	public static void paymentAction(WebDriver driver,String cardNumber,String cardType,String mont,String yea,String sCode)
	{
		

		try
		{	
			
			CheckoutProcess.creditCard_tbx(driver).sendKeys(cardNumber);
			
			month = new Select(CheckoutProcess.month_ddn(driver));
			month.selectByIndex(Integer.parseInt(mont));
			
			year=new Select(CheckoutProcess.year_ddn(driver));
			year.selectByVisibleText(yea);
			
			CheckoutProcess.securityCode_tbx(driver).sendKeys(sCode);
			
			 /*if(CheckoutProcess.reviewOrder_button(driver).isEnabled())
				{
				System.out.println("button enable");
				act=builder.moveToElement(CheckoutProcess.reviewOrder_button(driver)).build();
				act.perform();
				BaseClass.waitFor(3);
				CheckoutProcess.reviewOrder_button(driver).click();
				}*/
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
	 * ************ Review Order Button Action *******************
	 *			********************************				*
	 *															*		
	 *---------------------------------------------------------*/


	public static void reviewButtonAction(WebDriver driver)
	{
		

		try
		{	
						
			if(CheckoutProcess.reviewOrder_button(driver).isEnabled())
				{
				System.out.println("button enable");
				act=builder.moveToElement(CheckoutProcess.reviewOrder_button(driver)).build();
				act.perform();
				BaseClass.waitFor(3);
				CheckoutProcess.reviewOrder_button(driver).click();
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
