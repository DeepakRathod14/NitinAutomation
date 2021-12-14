package nitin.automation.base;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nitin.automation.pageobjects.ui.ButtonPage;
import nitin.automation.pageobjects.ui.TextBoxPage;


public class BasePageObject {
	
	protected WebDriver driver;
	@SuppressWarnings("rawtypes")
	private static Map<Class, Object> mapping = new LinkedHashMap<>();
	protected Actions action;
	private WebDriverWait explicitWait;
	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		explicitWait = new WebDriverWait(driver, 20);
	}
	
	public void initMapping() {
		BasePageObject.mapping.put(ButtonPage.class, new ButtonPage(this.driver));
		BasePageObject.mapping.put(TextBoxPage.class, new TextBoxPage(this.driver));
	}
	
	public static Object getPageObject(Class classz) {
		return BasePageObject.mapping.getOrDefault(classz, new Exception("NoSuchClassFound"));
	}
	
	protected void sendKey(By by, String value) {
		getElement(by).sendKeys(value);
	}
	
	protected void sendKey(By by, String value, boolean isClear) {
		getElement(by).clear();
		getElement(by).sendKeys(value);
	}
	
	protected void click(By by) {
		getElement(by).click();
	}
	
	protected String getText(By by) {
		return getElement(by).getText();
	}
	
	public WebElement getElement(By by) {
		if(waitForElementTobeVisible(by)==null) {
			throw new NoSuchElementException("Given element is not found on UI : "+by);
		}
		return waitForElementTobeVisible(by);
	}
	
	public WebElement waitForElementTobeVisible(By by) {
		WebElement element = null;
		try {
			element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public void scrollHorizontal(int scrollValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+scrollValue+")", "");
	}

}
