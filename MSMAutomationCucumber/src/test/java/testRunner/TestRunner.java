package testRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features= "features",
				 glue= {"stepDefination"},
				 tags= {"@EndToEnd"},
				 plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/reports.html"}
				)

public class TestRunner 
{
	@AfterClass
	public static void writeExtentReport() {
		System.out.println("this is extent report");
		Reporter.loadXMLConfig(new File("C:\\Workspace\\CucumberTest\\extent-config.xml"));
		System.out.println("this is extent report END");
	}
}
