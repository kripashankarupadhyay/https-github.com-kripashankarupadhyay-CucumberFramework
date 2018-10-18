package pageObjectMSM;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utillity.BaseClass;
public class HomePage
{
	//WebElement class object define statically
	private static WebElement element = null;
	 
	//Element for Sign_In dropdown 
	 public static WebElement Sign_In(WebDriver driver)
	 {
	    try{
	    	element = driver.findElement(By.xpath("//i[@class='fa fa-chevron-down uk-login-menu__icon']"));
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Home_Page-Sign in drop down not found");
	    	e.printStackTrace();
	    }
	    return element;
	 }
	
	 
	 //Element for Sign_In button
	 public static WebElement SignIn_btn(WebDriver driver)
	 {
	    try{
	    	element = driver.findElement(By.xpath("//a[@href='/en/Home/Login/']"));
	    }catch(Exception e)
	    {
	    	System.out.println("Home_Page-Sign in button not found");
	    	e.printStackTrace();
	    }
	    return element;
	 }
	 
	 
	//Element for POP_UP close button
		 public static WebElement PopUp_btn(WebDriver driver)
		 {
		    try{
		    	element = BaseClass.WaitTimePresence(driver,"//div[@id='close-button']"); 
		    	
		    }catch(Exception e)
		    {
		    	System.out.println("Home_Page- PopUp button not found");
		    	e.printStackTrace();
		    }
		    return element;
		 }
}
