package utillity;

import java.io.File;
import java.util.concurrent.TimeUnit;

//import org.apache.tools.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testDataMSM.ExcelWork;
public class BaseClass 

{
	static WebDriver driver = null;
	static WebDriverWait wait;
	static WebElement element;
	
	public static WebDriver OpenBrowser(String browser, String url){
		 
	//String url=Constant.URLMSM;
	
 
		try{
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
				
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("open browser Successfully !");
				//ExcelWork.setExcelFile(Constant.Path_TestData + Constant.File_TestData,sheet);
			}
		}
 
		catch (Exception e)
		{
			System.out.println("Problem in open browser !");
			e.printStackTrace();	
		
		}
 
		return driver;
 
	}
	
	//wait time with presence of element condition.
	public static WebElement WaitTimePresence(WebDriver driver, String xpath)
	{
		try 
		{
			wait=new WebDriverWait(driver, 20);	
			element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));	
		}
		catch(Exception e)
		{
			System.out.println("Problem in WebDriverWait Presence !");
			e.printStackTrace();
		}
		return element;
		//sreturn wait;
	}
	
	
	//wait time with visible of element condition.
		public static WebElement WaitTimeVisible(WebDriver driver, String xpath)
		{
			try 
			{
				wait=new WebDriverWait(driver, 20);
				element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			}
			catch(Exception e)
			{
				System.out.println("Problem in WebDriverWait Visible !");
				e.printStackTrace();
			}
			return element;
			//sreturn wait;
		}
		
		
		//wait time with Clickable of element condition.
				public static WebElement WaitTimeClickable(WebDriver driver, String xpath)
				{
					try 
					{
						wait=new WebDriverWait(driver, 20);
						element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
					}
					catch(Exception e)
					{
						System.out.println("Problem in WebDriverWait Clickable !");
						e.printStackTrace();
					}
					return element;
					
				}
		
		
	//Use of thread.sleep 
		public static boolean waitFor(int iSeconds) {
			try 
			{
				Thread.sleep(iSeconds * 1000);
			} catch (Exception e) 
			{
				System.out.println("Not able to Wait --- " + e.getMessage());
				return false;
			}
			return true;
		}
	
 
	
	//TO TAKE SCREEN_SHOT
	/*public static void takeScreenshot(WebDriver driver, String sTestCaseName) 
	{
		 
		try{

			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			System.out.println("in screenshot");
			System.out.println(scrFile);
			System.out.println(Constant.pathScreenShot + sTestCaseName +".jpg");
			FileUtils.copyFile(scrFile, new File(Constant.pathScreenShot + sTestCaseName +".jpg"));	

		} catch (Exception e){

		e.printStackTrace();

		}

	}*/
	
}
	

