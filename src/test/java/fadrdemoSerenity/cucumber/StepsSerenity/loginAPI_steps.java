package fadrdemoSerenity.cucumber.StepsSerenity;

import fadrdemoSerenity.pages.loginPageObject;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class loginAPI_steps {

	loginPageObject login_page_object;
	static ValidatableResponse response_all;

	@Step
	public void prepare_request_body(String response) {

	}

	@Step
	public void post_request_to_endpoint() {
		response_all = (SerenityRest.given().contentType("application/json").when().post(login_page_object.getter("login_endpoint")).then());
	}

	@Step
	public void validate_the_statuscode() {

	}

	@Step
	public void validate_the_statusline() {

	}

	@Step
	public void validate_the_errorcode() {

	}

	@Step
	public void validate_the_errordescription() {

	}
}
