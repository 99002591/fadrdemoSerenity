package StepDefinitions;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;

public class commonAssertions {
	static ValidatableResponse response_all;

	public void set_response_all(ValidatableResponse response) {
		this.response_all = response;
	}

	@Then("^Status code returned is \"([^\"]*)\"$")
	public void status_code_returned_validation(int statuscode) {
		assertThat(response_all.extract().statusCode(), equalTo(statuscode));
		if (statuscode == 400) {
			assertThat(response_all.extract().statusLine(), equalTo("HTTP/1.1 " + statuscode + " Bad Request"));
		} else if (statuscode == 401) {
			assertThat(response_all.extract().statusLine(), equalTo("HTTP/1.1 " + statuscode + " Unauthorized"));
		} else if (statuscode == 200) {
			assertThat(response_all.extract().statusLine(), equalTo("HTTP/1.1 " + statuscode + " OK"));
		}
	}

	@And("^Error code returned is \"([^\"]*)\"$")
	public boolean error_code_returned_validation(String errorcode) {
		if (errorcode.equals("")) {
			return false;
		}
		assertThat(response_all.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
		return true;

	}

	@And("^Response body returned is \"([^\"]*)\"$")
	public boolean response_body_returned_validation(String errordescription) {
		if (errordescription.equals("")) {
			return false;
		}
		assertThat(response_all.extract().jsonPath().getString("errorDescription"), equalTo(errordescription));
		return true;
	}
	
	@And("^Response message returned \"([^\"]*)\"$")
    public void response_message_returned_something(String message) {
		assertThat(response_all.extract().jsonPath().getString("message"), equalTo(message));
    }
}
