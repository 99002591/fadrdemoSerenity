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
	static String auth_expired = "sgfwqujgjaslfgsauilfgslaufgsuair934234792305bjxzkvba";
	String auth_invalid = auth + "ashdsjkfhsk2371249jdfsdfdsfdsfdsfsd3w43rf52353523kcns";

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
	
	@Step
	public ValidatableResponse delete_request(String authtype, String useridtype) {
		if(authtype.equals("valid") && useridtype.equals("invalid")) {
			response_all = SerenityRest.given().auth().oauth2(auth).when()
					.delete(hooks_object.base_url +"security/logoff/" + id + "invalid_addition").then();
		}
		else if(authtype.equals("invalid")) {
			response_all = SerenityRest.given().auth().oauth2(auth_invalid).when()
					.delete(hooks_object.base_url +"security/logoff/" + id).then();
		}
		else if(authtype.equals("blank") && useridtype.equals("valid")) {
			response_all = SerenityRest.given().auth().oauth2("").when()
					.delete(hooks_object.base_url +"security/logoff/" + id).then();
		}
		else if(authtype.equals("expired")) {
			response_all = SerenityRest.given().auth().oauth2(auth_expired).when()
					.delete(hooks_object.base_url +"security/logoff/" + id).then();
		}
		else if (authtype.equals("valid") && useridtype.equals("blank")) {
			response_all = SerenityRest.given().auth().oauth2(auth).when()
					.delete(hooks_object.base_url +"security/logoff/").then();
		}
		else if(authtype.equals("blank") && useridtype.equals("blank")) {
			response_all = SerenityRest.given().auth().oauth2("").when()
					.delete(hooks_object.base_url +"security/logoff/").then();
		}
		return response_all;
	}
}
