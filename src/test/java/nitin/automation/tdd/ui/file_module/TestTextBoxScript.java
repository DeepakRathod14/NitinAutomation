package nitin.automation.tdd.ui.file_module;

import org.testng.annotations.Test;

import nitin.automation.base.BasePageObject;
import nitin.automation.base.BaseTestScript;
import nitin.automation.pageobjects.ui.TextBoxPage;

public class TestTextBoxScript extends BaseTestScript{

	@Test
	public void scenario02() {
		TextBoxPage tb = (TextBoxPage) BasePageObject.getPageObject(TextBoxPage.class);
		tb.enterData("Deepak", "deepak@gmail.com", "Autoamtion", "QA");
		tb.submit();
	}
	
}
