package utils;

import StepDefinitions.hooks;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

public class commonMethods {
	static hooks hooks_object = new hooks();

	public ValidatableResponse delete_request_invalid_userID(String auth_token, String userid) {
		return (SerenityRest.given().auth().oauth2(auth_token).when()
				.delete(hooks_object.base_url + "security/logoff/" + userid).then());
	}
	
	public ValidatableResponse delete_request_blank_userID(String auth_token, String userid) {
		return(SerenityRest.given().auth().oauth2(auth_token).when()
				.delete(hooks_object.base_url + "security/logoff/" + userid).then());
	}
	
	public ValidatableResponse delete_request_valid_userID(String auth_token, String userid) {
		return(SerenityRest.given().auth().oauth2(auth_token).when()
				.delete(hooks_object.base_url + "security/logoff/" + userid).then());
	}
}
