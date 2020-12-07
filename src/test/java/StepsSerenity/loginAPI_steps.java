package StepsSerenity;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import pages.loginPageObject;
import pojoClasses.LoginPOJO;

public class loginAPI_steps {

	static String base_url = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	LoginPOJO loginPOJO_object = new LoginPOJO();
	static loginPageObject login_page_object = new loginPageObject();
	public static ValidatableResponse response_all;

	@Step
	public void prepare_request_body(String email, String password) {
		loginPOJO_object.setEmail(email);
		loginPOJO_object.setPassword(password);
	}

	@Step
	public void post_request_to_endpoint() {
		response_all = (SerenityRest.given().contentType("application/json").body(loginPOJO_object).when().post(base_url+"security/login").then());
	}
}
