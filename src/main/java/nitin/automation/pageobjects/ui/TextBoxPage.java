package nitin.automation.pageobjects.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import nitin.automation.base.BasePageObject;


public class TextBoxPage extends BasePageObject{

	public TextBoxPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterData(String fullName, String email, String cAdd, String pAdd) {
		System.out.println("Value : "+fullName);
		System.out.println("Value : "+email);
		System.out.println("Value : "+cAdd);
		System.out.println("Value : "+pAdd);
		
		sendKey(By.id("userName"), fullName);
		sendKey(By.id("userEmail"), email, true);
		sendKey(By.id("currentAddress"), cAdd);
		sendKey(By.id("permanentAddress"), pAdd);
	}

	public void submit() {
		System.out.println("Submit...");
		scrollHorizontal(500);
		click(By.id("submit"));
	}
}
