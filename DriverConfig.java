package nitin.automation.base;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfig {

	protected WebDriver driver;
	private long startTime;
	//private ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public void loadBrowser(@Optional("chrome") String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();//FF Browser Open
		}
		else {
			System.out.println("Given browser is not supported... "+browser);
		}
		
		//tlDriver.set(driver);
		driver.manage().window().maximize();
		new BasePageObject(driver).initMapping();
	}
	
	public void loadUrl(@Optional("https://demoqa.com/buttons") String url) {
		startTime();
		driver.get(url);//Load url
		endTime();
	}
	
	public void closeDriver() {
		startTime();
		driver.quit();
		endTime();
	}
		
	public void startTime() {
		startTime = System.currentTimeMillis();
		System.out.println("Start Time : "+startTime);
	}
	
	public void endTime() {
		long endTime = System.currentTimeMillis()-startTime;
		System.out.println("End Time : "+endTime);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
