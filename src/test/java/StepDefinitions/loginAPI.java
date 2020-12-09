package StepDefinitions;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import StepsSerenity.loginAPI_steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings("deprecation")
public class loginAPI {
	
	static custRegAPI custRegAPI_object = new custRegAPI();
	
	@Steps
	static loginAPI_steps login_actions;
	ValidatableResponse response_all;
	@Given("^Prepare Request Body for Login API with email = \"([^\"]*)\" and password = \"([^\"]*)\"$")
	public void prepare_request_body_for_login_api(String email,String password) {
		login_actions.prepare_request_body(email, password);
	}

	@When("^POST request on Login API$")
	public void post_request_on_login_api() {
		response_all = login_actions.post_request_to_endpoint();
	}

	@Then("^Status code returned is \"([^\"]*)\"$")
	public void status_code_returned_validation(int statuscode) {
		if(response_all == null) {
			response_all = custRegAPI_object.response_all;
		}
		assertThat(response_all.extract().statusCode(), equalTo(statuscode));
		if (statuscode == 400) {
			assertThat(response_all.extract().statusLine(), equalTo("HTTP/1.1 " + statuscode + " Bad Request"));
		} else if (statuscode == 401) {
			assertThat(response_all.extract().statusLine(), equalTo("HTTP/1.1 " + statuscode + " Unauthorized"));
		}		
	}

	@And("^Error code returned is \"([^\"]*)\"$")
	public void error_code_returned_validation(String errorcode) {
		assertThat(response_all.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
	}

	@And("^Response body returned is \"([^\"]*)\"$")
	public void response_body_returned_validation(String errordescription) {
		assertThat(response_all.extract().jsonPath().getString("errorDescription"), equalTo(errordescription));
	}

}
