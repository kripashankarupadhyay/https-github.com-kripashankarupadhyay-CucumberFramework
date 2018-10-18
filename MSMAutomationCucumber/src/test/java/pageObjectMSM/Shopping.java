package pageObjectMSM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utillity.BaseClass;

public class Shopping 
{

	//WebElement class object define statically
			private static WebElement element = null;
			private static String title,product,productTitle;
			
			//Webelement for Menu
			public static WebElement menu(WebDriver driver, String menu)
			 {
			    try
			    {
			    	element = driver.findElement(By.linkText(menu));
			    }catch(Exception e)
			    {
			    	System.out.println("Shopping - - Menu not find");
			    }
			    return element;
			 }
			
			
			//Webelement for SubMenu
			public static WebElement subMenu(WebDriver driver, String subMenu)
			 {
			    try
			    {
			    	element = BaseClass.WaitTimeVisible(driver,"//li[@class='uk-aside-menu-category__sub-menu-item ']//*[contains(text(),'"+subMenu+"')]"); 
			    }catch(Exception e)
			    {
			    	System.out.println("Shopping - - Submenu Menu not find");
			    }
			    return element;
			 }
			
			//Webelement for SelectProduct
			public static WebElement selectProduct(WebDriver driver)
			 {
			    try
			    {
			    	element = BaseClass.WaitTimeVisible(driver,"//div[@class='row widget product_list_widget product_list_widget--banner column list ng-scope three-in-row']//child::article[2]//descendant::a[1]//following-sibling::a[1]"); 
			    }catch(Exception e)
			    {
			    	System.out.println("Shopping - - Select Product not find");
			    }
			    return element;
			 }
			
			
			//Webelement for SelectProduct
			public static WebElement productTitle(WebDriver driver)
			 {
			    try
			    {
			    	element = BaseClass.WaitTimeVisible(driver,"//h1[@class=\"product_title_widget no-margin-top mbottom-10\"]"); 
			    }catch(Exception e)
			    {
			    	System.out.println("Shopping - - Product Title not find");
			    }
			    return element;
			 }
			
			
			
			
			//h1[@class="product_title_widget no-margin-top mbottom-10"]
			
			
			
			
			/*--------------------------------------------------------
			 *															*
			 *			********************************				*
			 *															*
			 * ************ GoToCategory Page Action ****************** *
			 *			********************************				*
			 *															*		
			 *---------------------------------------------------------*/
			 
			 public static String selectCateory(WebDriver driver, String menu, String subMenu)
			 {
				 
			    try
			 	 {
					 BaseClass.waitFor(3);
					 
					 Shopping.menu(driver,menu).click();
					 Shopping.subMenu(driver, subMenu).click();
					 
					 title = driver.getTitle();
					 
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
				 * ************ Select Product Action ****************** *
				 *			********************************				*
				 *															*		
				 *---------------------------------------------------------*/
				 
				 public static String selectProductAction(WebDriver driver)
				 {
					 
				    try
				 	 {
						 BaseClass.waitFor(3);
						 product = Shopping.selectProduct(driver).getText();
						 Shopping.selectProduct(driver).click();
					 }
					 catch(Exception e)
					 {
						 e.printStackTrace();
					 }
				  
				    return product;
				 }
				 
				 
				     /*--------------------------------------------------------
					 *															*
					 *			********************************				*
					 *															*
					 * ************ Verify Product Action ****************** *
					 *			********************************				*
					 *															*		
					 *---------------------------------------------------------*/
					 
					 public static String verifyProductAction(WebDriver driver)
					 {
						 
					    try
					 	 {
							 BaseClass.waitFor(3);
							 productTitle = Shopping.productTitle(driver).getText();
						 }
						 catch(Exception e)
						 {
							 e.printStackTrace();
						 }
					  
					    return productTitle;
					 }
			
			
	
			
			
	
}
