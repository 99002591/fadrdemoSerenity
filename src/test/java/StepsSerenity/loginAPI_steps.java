package StepsSerenity;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import pages.loginPageObject;
import pojoClasses.LoginPOJO;

@SuppressWarnings("deprecation")
public class loginAPI_steps {

	LoginPOJO loginPOJO_object = new LoginPOJO();
	static loginPageObject login_page_object = new loginPageObject();
	static ValidatableResponse response_all;

	@Step
	public void prepare_request_body(String email, String password) {
		loginPOJO_object.setEmail(email);
		loginPOJO_object.setPassword(password);
	}

	@Step
	public void post_request_to_endpoint() {
		response_all = (SerenityRest.given().contentType("application/json").body(loginPOJO_object).when().post(login_page_object.getLogin_endpoint()).then());
//		System.out.println(response_all.extract().response().body().asString());
	}

	@Step
	public void validate_the_statuscode(int statuscode) {
		assertThat(response_all.extract().statusCode(), equalTo(statuscode));
	}

	@Step
	public void validate_the_statusline(int statuscode) {
		if (statuscode == 400) {
			assertThat(response_all.extract().statusLine(), equalTo("HTTP/1.1 " + statuscode + " Bad Request"));
		} else if (statuscode == 401) {
			assertThat(response_all.extract().statusLine(), equalTo("HTTP/1.1 " + statuscode + " Unauthorized"));
		}
	}

	@Step
	public void validate_the_errorcode(String errorcode) {
		assertThat(response_all.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
	}

	@Step
	public void validate_the_errordescription(String errordescription) {
		assertThat(response_all.extract().jsonPath().getString("errorDescription"), equalTo(errordescription));
	}
}
