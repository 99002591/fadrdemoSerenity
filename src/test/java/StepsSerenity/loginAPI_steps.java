package StepsSerenity;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import pojoClasses.LoginPOJO;

public class loginAPI_steps {
	
	static String login_endpoint = "security/login";
	LoginPOJO loginPOJO_object = new LoginPOJO();

	public static ValidatableResponse response_all;

	@Step
	public void prepare_request_body(String email, String password) {
		loginPOJO_object.setEmail(email);
		loginPOJO_object.setPassword(password);
	}

	@Step
	public ValidatableResponse post_request_to_endpoint() {
		response_all = (SerenityRest.given().contentType("application/json").body(loginPOJO_object).when()
				.post(login_endpoint).then());
		System.out.println("SUCCESS");
		return response_all;

	}

	@Step
	public LoginPOJO return_pojo_object() {
		return loginPOJO_object;
	}
}
