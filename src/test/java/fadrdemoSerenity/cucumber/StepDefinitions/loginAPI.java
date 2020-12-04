package fadrdemoSerenity.cucumber.StepDefinitions;

import fadrdemoSerenity.cucumber.StepsSerenity.loginAPI_steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class loginAPI {

	@Steps
	loginAPI_steps login_actions;
	
	@Given("^Prepare \"([^\"]*)\" for Login API$")
	public void prepare_something_for_login_api(String requestbody) throws Exception {
		login_actions.prepare_request_body(requestbody);
	}

	@When("^POST request on Login API$")
	public void post_request_on_login_api() {
		login_actions.post_request_to_endpoint();
	}

	@Then("^Status code returned is \"([^\"]*)\"$")
	public void status_code_returned_is_something(int statuscode) {
		login_actions.validate_the_statuscode();
		login_actions.validate_the_statusline();
	}

	@And("^Error code returned is \"([^\"]*)\"$")
	public void error_code_returned_is_something(String errorcode) {
		login_actions.validate_the_errorcode();
	}

	@And("^Response body returned is \"([^\"]*)\"$")
	public void response_body_returned_is_something(String errordescription) {
		login_actions.validate_the_errordescription();
	}
}
