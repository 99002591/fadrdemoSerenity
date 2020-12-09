package StepsSerenity;

import StepDefinitions.hooks;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class logoutAPI_steps {
	static custRegAPI_steps custRegAPI_steps_object = new custRegAPI_steps();
	static hooks hooks_object = new hooks();
	static ValidatableResponse response_all;
	static String auth, id;

	@Step
	public void generate_token_and_id() {
		response_all = custRegAPI_steps_object.get_token();
		auth = response_all.extract().response().jsonPath().getString("data.token");
		id = response_all.extract().response().jsonPath().getString("data.id");
	}

	@Step
	public ValidatableResponse delete_request() {
		response_all = SerenityRest.given().auth().oauth2(auth).when()
				.delete(hooks_object.base_url +"security/logoff/" + id).then();
		return response_all;
	}
}
