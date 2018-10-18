package pageObjectMSM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utillity.BaseClass;

public class AddToBag 
{

	//WebElement class object define statically
	private static WebElement element = null,size,colorfont;
	private static List<WebElement> getlist,sizeList;
	private static String title,product,productTitle,sizel;
	private static int i=0;
	private static Action mo;
	private static Actions builder;
	
	//Webelement for SubMenu
	public static List<WebElement> selectSize(WebDriver driver)
	 {
	    try
	    {
	    	getlist = driver.findElements(By.xpath("//ul[@class='uk-size-list']//child::li")); 
	    	System.out.println("Size of list:- "+getlist.size());
	    	for (WebElement webElement : getlist)
			{	
	    		System.out.println(getlist.get(i));
	    		//i++;
			}
	    	
	    }catch(Exception e)
	    {
	    	System.err.println("Add to bag - - Size list not find");
	    }
	    return getlist;
	 }
	
	
	
	//Element for Add to Bag button
	 public static WebElement addBag_btn(WebDriver driver)
	 {
	    try
	    {
	    	element = BaseClass.WaitTimeVisible(driver,"//button[@ng-click='ppc.addToCart()']"); 	
	    }
	    catch(Exception e)
	    {
	    	System.err.println("Add To Bag- addBag_btn button not found");
	    	e.printStackTrace();
	    }
	    return element;
	 }
	 
	 
	 
	//Element for Continue shopping button
		 public static WebElement contShop_btn(WebDriver driver)
		 {
		    try
		    {
		    	element = BaseClass.WaitTimeVisible(driver,"//button[contains(text(),'Continue Shopping')]"); 	
		    }
		    catch(Exception e)
		    {
		    	System.err.println("Add To Bag- Continue shopping_btn button not found");
		    	e.printStackTrace();
		    }
		    return element;
		 }
	 
	
	
	/*--------------------------------------------------------
	 *															*
	 *			********************************				*
	 *															*
	 * ************ Add to bag button Action ****************** *
	 *			********************************				*
	 *															*		
	 *---------------------------------------------------------*/
	 
	public static void selectSizeAction(WebDriver driver)
	{
		builder = new Actions(driver);
		try
		{
			BaseClass.waitFor(3);

			sizeList=AddToBag.selectSize(driver);
			
			for (WebElement webElement : sizeList)
			{	
				
				System.out.println("Size in method of list:- "+sizeList.size());
				System.out.println("Size of i :- "+i);
				i=i+1;
				System.out.println("Size of i :- "+i);
				sizel="//ul[@class='uk-size-list']//child::li["+i+"]";
				System.out.println("Size of i :- "+sizel);
				size=driver.findElement(By.xpath(sizel));

				mo=builder.moveToElement(size).build();
				mo.perform();

				BaseClass.waitFor(1);
				//System.out.println("this is tooltip :- "+tooltip.get(i));

				colorfont = driver.findElement(By.xpath("(//ul[@class='uk-size-list']//span[@class='ng-scope'])["+i+"]"));
				String si = colorfont.getCssValue("color");
				System.out.println(si);

				// Color myBlack = new Color(0, 0, 0, 1); // Color black
				//Color myWhite = new Color(255, 255, 255);
				String black="rgba(0, 0, 0, 1)";

				if(black.equals(si))
				{
					size.click();
					System.out.println("Click on-> "+i);
					System.out.println("Size Selected-:"+size.getText());
					break;

				}
				else
				{
					System.out.println("out of stock"+i);

				}

			}// End of for loop---- size availaible or not.

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		
	}
	
	
	public static void clickAddToBag(WebDriver driver)
	 {
		 
	    try
	 	 {
			 AddToBag.addBag_btn(driver).click();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	  
	 }
	
	
	public static void continueShop(WebDriver driver)
	 {
		 
	    try
	 	 {
			 AddToBag.contShop_btn(driver).click();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	  
	 }
	
	
	
	
	
	
	
	
	
}
