package nitin.automation.bdd.stepdef.ui;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import nitin.automation.bdd.runner.CucumberTestNGRunnerWithExtends;

public class Hook {

	@Before
	public void beforeMethod() {
		System.out.println("Before method call...");
	}
	
	@After
	public void afterMethod(Scenario scenario) {
		System.out.println("After method call...");
		if (scenario.isFailed()) {
		      // Take a screenshot...
		      final byte[] screenshot = ((TakesScreenshot) CucumberTestNGRunnerWithExtends.driver).getScreenshotAs(OutputType.BYTES);
		   // embed it in the report.
		      scenario.embed(screenshot, "image/png"); 
		    }
	}
	
}
