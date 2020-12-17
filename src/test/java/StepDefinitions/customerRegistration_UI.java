package StepDefinitions;

import StepsSerenity.customerRegsitration_steps_UI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.commonPage;

public class customerRegistration_UI {
	static commonPage commonpage_object;

	@Steps
	static customerRegsitration_steps_UI custReg_steps_object;

	@Given("^Navigated to customer registration$")
	public void customer_registration_page_opens() {
		custReg_steps_object.click_dropdown();
		custReg_steps_object.choose_customer_reg();
		custReg_steps_object.check_if_custReg_page_open();
	}

	@Then("^User Navigates to customer registration$")
	public void open_customerReg_page() {
		custReg_steps_object.open_custReg_page();
	}

	@When("^Enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_test_data(String customername, String contactname, String contactphone, String contactemail,
			String contactmethod) {
		custReg_steps_object.fill_test_details(customername, contactname, contactphone, contactemail, contactmethod);
	}

	@Then("^Submit button is disabled$")
	public void submit_button_is_disabled() {
		custReg_steps_object.state_check_of_submit();
	}

	@Then("^Submission fails with \"([^\"]*)\"$")
	public void submission_fails_with_error(String errormessages) {
		if (errormessages.contains(",")) {
			String[] List_error = errormessages.split(",", 0);
			for (int count = 0; count < List_error.length; count++) {
				custReg_steps_object.error_message_validation(List_error[count]);
			}
		} else {
			custReg_steps_object.error_message_validation(errormessages);
		}
	}

	@And("^User clicks on factory reset dropdown$")
	public void user_clicks_on_factory_reset_dropdown() {
		custReg_steps_object.click_dropdown();
	}

	@And("^User clicks on customer registration option$")
	public void user_clicks_on_customer_registration_option() {
		custReg_steps_object.choose_customer_reg();
	}

	@And("^Click on submit button$")
	public void click_on_submit_button() {
		custReg_steps_object.submit();
	}

}
