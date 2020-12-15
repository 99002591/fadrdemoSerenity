package StepDefinitions;

import StepsSerenity.logoutAPI_steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class logoutAPI {

	@Steps
	static logoutAPI_steps logoutAPI_steps_object;

	static commonAssertions commonAssertions_object = new commonAssertions();
	static ValidatableResponse response_all;

	@When("DELETE request on Logout API")
	public void delete_request_on_logout_api() {
		response_all = logoutAPI_steps_object.delete_request();
		commonAssertions_object.set_response_all(response_all);
	}

	@When("^DELETE request on Logout API with invalid scene \"([^\"]*)\" \"([^\"]*)\"$")
	public void delete_request_on_logout_api_with_invalid_condition(String authtype, String useridtype) {
		response_all = logoutAPI_steps_object.delete_request(authtype, useridtype);
		commonAssertions_object.set_response_all(response_all);
	}
}
