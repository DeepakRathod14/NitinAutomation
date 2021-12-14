package nitin.automation.bdd.stepdef.ui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nitin.automation.base.BasePageObject;
import nitin.automation.pageobjects.ui.TextBoxPage;

public class SampleStepDef2 {

	@Given("^Open browser$")
	public void open_browser() {
		System.out.println("Open Browser method call...");
	}

	@When("^load expected page$")
	public void load_expected_page() {
		System.out.println("Load expected page");
		TextBoxPage tb = (TextBoxPage) BasePageObject.getPageObject(TextBoxPage.class);
		tb.enterData("Automation", "automation@gmail.com", "QA", "Testing");
		tb.submit();
	}

	@When("^enter username and password$")
	public void enter_username_and_password() {
		System.out.println("Enter Username and password");
	}

	@When("^enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void enter_username_as_and_password_as(String username, String password) {
		System.out.println("Enter Username as :" + username);
		System.out.println("Your password as  : " + password);
	}

	@Then("^click on submit button$")
	public void click_on_submit_button() {
		System.out.println("click on submit button");
	}

	@Then("^Verify login successfull$")
	public void verify_login_successfull() {
		System.out.println("verify login success page");
	}
	
	@Given("^some precondition$")
	public void some_precondition() throws Throwable {
		System.out.println("Precondition: for scenario");
	}

	@Given("^perform steps before each scenario$")
	public void perform_steps_before_each_scenario() throws Throwable {
		System.out.println("Precondition: Action performed for scenario");
	}

}
