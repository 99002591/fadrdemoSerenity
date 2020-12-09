package StepsSerenity;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class logoutAPI_steps {
	custRegAPI_steps custRegAPI_steps_object = new custRegAPI_steps();
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
		response_all = SerenityRest.given().queryParam(id).auth().oauth2(auth).when()
				.delete("https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/security/logoff/").then();
		System.out.println("Message");
		System.out.println(response_all.extract().body().asString());
		return response_all;
	}
}
