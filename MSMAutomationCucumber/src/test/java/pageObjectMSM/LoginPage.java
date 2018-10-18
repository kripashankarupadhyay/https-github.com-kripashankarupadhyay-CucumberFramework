package pageObjectMSM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testDataMSM.ExcelWork;
import utillity.BaseClass;
import utillity.Constant;

public class LoginPage
{

	    //WebElement class object define statically
		private static WebElement element = null;
		private static String user;
		
		//Webelement for email/ username textbox
		public static WebElement Email_Address(WebDriver driver)
		 {
		    try{
		    	element = BaseClass.WaitTimeVisible(driver,"//input[@type='email']");
		    }catch(Exception e)
		    {
		    	System.out.println("Login_Page-Email address text box not found");
		    }
		    return element;
		 }
		
		//Webelement for password textbox
		public static WebElement Password(WebDriver driver)
		{
			try {
				element=driver.findElement(By.xpath("//input[@type='password']"));
			}catch(Exception e)
			{
				System.out.println("Login_Page - Password textbox not found");
			}
			return element;
		}
		
		//Webelement for Sign Button - login page
		public static WebElement SignButton(WebDriver driver)
		{
			try {
				element=driver.findElement(By.xpath("//button[@button-text='trans.LoginForm_signin']"));
				}catch(Exception e)
				{
				System.out.println("Login_Page - Submit button not found");
				}
			return element;
		}
		
		//WebElement for Fogot password link - login page
		public static WebElement ForgotPassword(WebDriver driver)
		{
			try {
				element = driver.findElement(By.xpath("//a[@class='left forgot_password']"));
			}catch(Exception e)
			{
				System.out.println("LoginPage - forgot password link text not found");
			}
			return element;
		}
		
		//WebElement for Create new account - login page
		public static WebElement CreateAccount(WebDriver driver)
		{
			try {
				element = driver.findElement(By.xpath("//a[@class='button right']"));
			}catch(Exception e)
			{
				System.out.println("LoginPage - Create account button not found");
			}
			return element;
		}
		
		
		//Element for Sign_In dropdown - home page
		 public static WebElement Sign_In(WebDriver driver)
		 {
		    try{
		    	element = BaseClass.WaitTimePresence(driver, "//i[@class='fa fa-chevron-down uk-login-menu__icon']");
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Home_Page-Sign in drop down not found");
		    	e.printStackTrace();
		    }
		    return element;
		 }
		 
		 
		//Element for Logout - signin drop down
		 public static WebElement Logout(WebDriver driver)
		 {
		    try
		    {
		    	element = BaseClass.WaitTimePresence(driver, "//a[@ng-href='/en/Home/Logout/']");
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Logout button not found in dropdown");
		    	e.printStackTrace();
		    }
		    return element;
		 }
		 
		 //Element for user login information.
		 public static WebElement signInUser(WebDriver driver)
		 {
		    try{
		    	element = BaseClass.WaitTimePresence(driver, "//span[@class='ng-binding ng-scope']");
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Sign in user information label not found in dropdown");
		    	e.printStackTrace();
		    }
		    return element;
		 }
		
		 
		 //Element for Sign_In button - home page sign in drop down
		 public static WebElement SignIn_btn(WebDriver driver)
		 {
		    try{
		    	element = BaseClass.WaitTimeVisible(driver,"//a[@href='/en/Home/Login/']");
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
		    try
		    {
		    	element = BaseClass.WaitTimeVisible(driver,"//div[@id='close-button']"); 	
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Home_Page- PopUp button not found");
		    	e.printStackTrace();
		    }
		    return element;
		 }
		
			 
			 
			 /*--------------------------------------------------------
			 *															*
			 *			********************************				*
			 *															*
			 * ****************** lOGIN ACTION *******************		*
			 *			********************************				*
			 *															*		
			 *---------------------------------------------------------*/
			 
			 public static String loginAction(WebDriver driver, String username, String password)
			 {
				 
				   element=LoginPage.PopUp_btn(driver);
				   if(element.isDisplayed())
					{
						System.out.println("popup available");
						element.click();	
					}
				 
			    try
			 	 {
					 BaseClass.waitFor(3);
					 LoginPage.Sign_In(driver).click();
					 LoginPage.SignIn_btn(driver).click();
					 LoginPage.Email_Address(driver).sendKeys(username);
					 LoginPage.Password(driver).sendKeys(password);
					 LoginPage.SignButton(driver).click();
					 BaseClass.waitFor(10);
					 user = LoginPage.signInUser(driver).getText();
					 
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
			  
			    return user;
			 }
			 
			 
			 

			 /*-*********************************************************
			 *															*
			 *			********************************				*
			 *															*
			 * ****************** lOG_OUT Action *******************    *
			 *			********************************				*
			 *															*		
			 ************************************************************/
			 
			 public static String logoutAction(WebDriver driver)
			 {
				 System.out.println("User logOut Process.....");
				 user = LoginPage.signInUser(driver).getText();
				 if(user.equalsIgnoreCase("SIGN IN"))
				 {
					 System.out.println("User not logged In....");		 
				 }
				 else
				 {
					 LoginPage.Sign_In(driver).click();
					 LoginPage.Logout(driver).click();
					 BaseClass.waitFor(5);
					 user = LoginPage.signInUser(driver).getText();
			     }
				 return user;
			}
			 
			 
		
		
}
