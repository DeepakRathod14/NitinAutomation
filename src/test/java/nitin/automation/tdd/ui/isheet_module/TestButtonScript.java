package nitin.automation.tdd.ui.isheet_module;

import org.testng.annotations.Test;
import nitin.automation.base.BasePageObject;
import nitin.automation.base.BaseTestScript;
import nitin.automation.pageobjects.ui.ButtonPage;

public class TestButtonScript extends BaseTestScript{

	@Test(enabled = true)
	public void scenario01() {
		ButtonPage button = (ButtonPage) BasePageObject.getPageObject(ButtonPage.class);
		button.doubleClick();
		String actualVal = button.verifyDoubleClick();
		String expectedVal = "You have done a double click";
		
		//Assert.assertEquals(expectedVal,actualVal);//Hard Assert
		//Assert.assertEquals(expectedVal, actualVal, "Get text from button click is not display relevant message..!!");
		//Assert.assertFalse(false);//Mostly for visibility verification [ isNotDisplay=false (expected)]
		//Assert.assertTrue(true);//Mostly for visibility verification [isdisplay=true (expected)]
		//Assert.assertNotNull(s1);
		
		button.rightClick();
		button.dynamicClick();
	}
}
