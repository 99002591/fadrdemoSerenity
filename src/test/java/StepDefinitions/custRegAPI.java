package StepDefinitions;

import StepsSerenity.custRegAPI_steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;

public class custRegAPI {
	static custRegAPI_steps custRegAPI_steps_object = new custRegAPI_steps();
	static commonAssertions commonAssertions_object = new commonAssertions();
	static ValidatableResponse response_all;

	@Given("Login successfully to generate authorisation token")
	public void login_successfully_to_generate_authorisation_token() {
		custRegAPI_steps_object.get_token();
	}

	@And("^Prepare the request body with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void prepare_the_request_body(String name, String contactname, String phonenumber, String emailid, String contactmethod, String additionalinfo) {
		custRegAPI_steps_object.prep_request_body(name, contactname, phonenumber, emailid, contactmethod, additionalinfo);
	}

	@When("^POST request on Customer Registration API$")
	public void post_request_on_customer_registration_api() {
		response_all = custRegAPI_steps_object.post_custReg_request();
		commonAssertions_object.set_response_all(response_all);
	}
}
