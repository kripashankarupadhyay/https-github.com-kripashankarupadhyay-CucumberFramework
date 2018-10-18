package stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class LoginVerify 


{
	
	public static WebDriver driver = null;
	
	@Then("^Verify User should be \"([^\"]*)\"$")
	public void verify_User_should_be(String status) throws Throwable
	{
	    if(status.equalsIgnoreCase("LOGIN"))
	    {
	    	Assert.assertNotEquals(MSMEndToEnd.user, "SIGN IN", "USer Not Login successfully");
	    }
	    else if(status.equals("NOT LOGIN"))
	    {
	    	Assert.assertEquals(MSMEndToEnd.user, "SIGN IN", "USer Not Login successfully");
	    }
    }
}
