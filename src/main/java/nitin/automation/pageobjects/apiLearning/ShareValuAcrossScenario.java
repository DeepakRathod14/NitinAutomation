package nitin.automation.pageobjects.apiLearning;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class ShareValuAcrossScenario {

	@Test
	public void sample1(ITestContext context) {
		context.setAttribute("Nitin", "Hello Nitin");
	}
	
	
	@Test
	public void sample2(ITestContext context) {
		System.out.println("Share Value : "+context.getAttribute("Nitin"));
	}
}
