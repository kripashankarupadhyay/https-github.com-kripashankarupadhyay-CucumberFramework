package pageObjectMSM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccount

{
	//WebElement class object define statically
		private static WebElement element = null;
		
		
		//Element for Sign_In button
		 public static WebElement SignIn_btn(WebDriver driver)
		 {
		    try
		    {
		    	element = driver.findElement(By.xpath("//a[@href='/en/Home/Login/']"));
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Home_Page-Sign in button not found");
		    	e.printStackTrace();
		    }
		    return element;
		 }

}
