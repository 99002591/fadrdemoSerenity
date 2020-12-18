package StepDefinitions;

import StepsSerenity.loginAPI_steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings("deprecation")
public class loginAPI {

	@Steps
	static loginAPI_steps login_actions;

	static commonStepDef commonStepDef_object = new commonStepDef();
	static ValidatableResponse response_all;

	@Given("^Prepare Request Body for Login API with email = \"([^\"]*)\" and password = \"([^\"]*)\"$")
	public void prepare_request_body_for_login_api(String email, String password) {
		login_actions.prepare_request_body(email, password);
	}

	@When("^POST request on Login API$")
	public void post_request_on_login_api() {
		response_all = login_actions.post_request_to_endpoint();
		commonStepDef_object.set_response_all(response_all);
	}

}
