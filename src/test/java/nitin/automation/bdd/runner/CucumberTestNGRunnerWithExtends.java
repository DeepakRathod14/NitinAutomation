package nitin.automation.bdd.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import nitin.automation.base.BaseTestScript;
import nitin.automation.base.DriverConfig;

@CucumberOptions(features = "./src/test/java/nitin/automation/bdd/features", 
			glue = {"nitin.automation.bdd.stepdef.ui" }, 
			plugin = { "pretty",
				"html:C:\\Users\\deepak.rathod\\eclipse-workspace-Nikhil\\automation\\report",
				"json:C:\\Users\\deepak.rathod\\eclipse-workspace-Nikhil\\automation\\reportcucumber.json"},
			tags = {"@POC" })

public class CucumberTestNGRunnerWithExtends extends DriverConfig{

//	private ThreadLocal<TestNGCucumberRunner> tlRunner = new ThreadLocal<>();
	private TestNGCucumberRunner tlRunner;
	public static WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeSuite
	public void loadDriver(@Optional("chrome") String browser) {
		loadBrowser(browser);
		driver = super.driver;
	}
	
	@Parameters({"url"})
	@BeforeTest
	public void loadUrlLink(@Optional("https://demoqa.com/buttons") String url) {
		loadUrl(url);
	}

	@AfterSuite
	public void closeBrowser() {
		closeDriver();
	}
	
	//---------------------------- NO CHANGES REQUIRED IN ALL BELOW METHODS ------------------------	
	@BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
		tlRunner = new TestNGCucumberRunner(this.getClass());
    }
	
	@Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
		tlRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
	
	@DataProvider
    public Object[][] features() {
        return tlRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
    	tlRunner.finish();
    }
}
