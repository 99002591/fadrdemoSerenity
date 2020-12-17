package StepDefinitions;

import StepsSerenity.customerRegsitration_steps_UI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class customerRegistration_UI {
	
	@Steps
	static customerRegsitration_steps_UI custReg_steps_object;
	
	@Given("^Navigated to customer registration$")
    public void customer_registration_page_opens(){
		
    }

    @Then("^User Navigates to customer registration$")
    public void open_customerReg_page(){

    }

	@When("^Enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_test_data(String customername, String contactname,
			String contactphone, String contactemail, String contactmethod){
		
	}

	@Then("^Submit button is disabled$")
	public void submit_button_is_disabled(){

	}

	@Then("^Submission fails with \"([^\"]*)\"$")
	public void submission_fails_with_error(String errormessages){

	}

	@And("^User clicks on factory reset dropdown$")
	public void user_clicks_on_factory_reset_dropdown(){

	}

	@And("^User clicks on customer registration option$")
	public void user_clicks_on_customer_registration_option(){

	}

	@And("^Click on submit button$")
	public void click_on_submit_button(){

	}

}
