package StepDefinitions;

import StepsSerenity.loginAPI_steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class loginAPI {

	@Steps
	loginAPI_steps login_actions;

	@Given("^Prepare Request Body for Login API with email = \"([^\"]*)\" and password = \"([^\"]*)\"$")
	public void prepare_request_body_for_login_api(String email,String password) {
		login_actions.prepare_request_body(email, password);
	}

	@When("^POST request on Login API$")
	public void post_request_on_login_api() {
		login_actions.post_request_to_endpoint();
	}

	@Then("^Status code returned is \"([^\"]*)\"$")
	public void status_code_returned_validation(int statuscode) {
		login_actions.validate_the_statuscode(statuscode);
		login_actions.validate_the_statusline(statuscode);
		
	}

	@And("^Error code returned is \"([^\"]*)\"$")
	public void error_code_returned_validation(String errorcode) {
		login_actions.validate_the_errorcode(errorcode);
	}

	@And("^Response body returned is \"([^\"]*)\"$")
	public void response_body_returned_validation(String errordescription) {
		login_actions.validate_the_errordescription(errordescription);
	}

}
