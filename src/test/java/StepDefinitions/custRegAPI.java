package StepDefinitions;

import StepsSerenity.custRegAPI_steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class custRegAPI {

	@Steps
	static custRegAPI_steps custRegAPI_steps_object;
	
	static commonStepDef commonStepDef_object = new commonStepDef();
	static ValidatableResponse response_all;

	@And("^Prepare the request body with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void prepare_the_request_body(String name, String contactname, String phonenumber, String emailid,
			String contactmethod, String additionalinfo) {
		custRegAPI_steps_object.prep_request_body(name, contactname, phonenumber, emailid, contactmethod,
				additionalinfo);
	}

	@When("^POST request on Customer Registration API$")
	public void post_request_on_customer_registration_api() {
		response_all = custRegAPI_steps_object.post_custReg_request();
		commonStepDef_object.set_response_all(response_all);
	}

	@When("^POST request on Customer Registration API with incorrect authentication of type \"([^\"]*)\"$")
	public void post_request_on_customer_registration_api_with_incorrect_authentication(String badauthtype) {
		response_all = custRegAPI_steps_object.post_bad_custReg_request(badauthtype);
		commonStepDef_object.set_response_all(response_all);
	}
}
