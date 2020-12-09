package StepDefinitions;

import StepsSerenity.custRegAPI_steps;
import StepsSerenity.logoutAPI_steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

public class logoutAPI {
	static logoutAPI_steps logoutAPI_steps_object = new logoutAPI_steps();
	static commonAssertions commonAssertions_object = new commonAssertions();
	
	static ValidatableResponse response_all;
	
	@Given("Login successfully and generate authorisation token")
	public void login_successfully_and_generate_authorisation_token() {
		logoutAPI_steps_object.generate_token_and_id();
	}

	@When("DELETE request on Logout API")
	public void delete_request_on_logout_api() {
		response_all = logoutAPI_steps_object.delete_request();
		commonAssertions_object.set_response_all(response_all);
	}
}
