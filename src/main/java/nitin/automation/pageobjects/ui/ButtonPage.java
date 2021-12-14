package nitin.automation.pageobjects.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import nitin.automation.base.BasePageObject;

public class ButtonPage extends BasePageObject{

	public ButtonPage(WebDriver driver) {
		super(driver);
	}

			
	public void doubleClick() {
		WebElement ele = getElement(By.id("doubleClickBtn"));
		action.doubleClick(ele).build().perform();
	}

	public void rightClick() {
		WebElement rightClick = getElement(By.id("rightClickBtn"));
		action.contextClick(rightClick).build().perform();
	}

	public void dynamicClick() {
		click(By.xpath("//button[text()='Click Me']"));
	}
	
	public String verifyDoubleClick() {
		return getText(By.id("doubleClickMessage"));
	}
}
