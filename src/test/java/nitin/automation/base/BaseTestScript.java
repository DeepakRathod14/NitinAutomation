package nitin.automation.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTestScript extends DriverConfig{
	@Parameters({"browser"})
	@BeforeTest()
	public void setUpBrowser(@Optional("chrome") String browser) {
		loadBrowser(browser);
	}
	
	@Parameters({"url"})
	@BeforeTest(dependsOnMethods = {"setUpBrowser"})
	public void loadAddress(@Optional("https://demoqa.com/buttons") String url) {
		loadUrl(url);
	}
	
	@AfterTest
	public void closeBrowser() {
		closeDriver();
	}
}	
