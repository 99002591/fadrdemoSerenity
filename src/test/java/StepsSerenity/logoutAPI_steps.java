package StepsSerenity;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.fileReader;

public class logoutAPI_steps {
	static String logoff_endpoint = "security/logoff/";
	
	static custRegAPI_steps custRegAPI_steps_object = new custRegAPI_steps();
	static fileReader fileReader_object = new fileReader();
	
	static ValidatableResponse response_all;
	static String auth, id;
	static String auth_expired;
	static String auth_invalid = "ashdsjkfhsk2371249jdfsdfdsfdsfdsfsd3w43rf52353523kcns";
	static String auth_blank = "";
	static String id_blank = "";

	@Step
	public void generate_token_and_id() {
		response_all = custRegAPI_steps_object.get_token();
		auth = response_all.extract().response().jsonPath().getString("data.token");
		id = response_all.extract().response().jsonPath().getString("data.id");
		try {
			auth_expired = fileReader_object.readfile("expired_token");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step
	public ValidatableResponse delete_request() {
		response_all = SerenityRest.given().auth().oauth2(auth).when().delete(logoff_endpoint+id).then();
		return response_all;
	}

	@Step
	public ValidatableResponse delete_request(String authtype, String useridtype) {
		if (authtype.equals("invalid")) {
			if (useridtype.equals("valid")) {
				response_all = delete_request_valid_userID(auth_invalid, id);
			} else if (useridtype.equals("invalid")) {
				response_all = delete_request_invalid_userID(auth_invalid, id + "uhfishfaih213");
			} else if (useridtype.equals("blank")) {
				response_all = delete_request_blank_userID(auth_invalid, id_blank);
			}
		} else if (authtype.equals("blank")) {
			if (useridtype.equals("valid")) {
				response_all = delete_request_valid_userID(auth_invalid, id);
			} else if (useridtype.equals("invalid")) {
				response_all = delete_request_invalid_userID(auth_invalid, id + "uhfishfaih213");
			} else if (useridtype.equals("blank")) {
				response_all = delete_request_blank_userID(auth_invalid, id_blank);
			}
		} else if (authtype.equals("expired")) {
			if (useridtype.equals("valid")) {
				response_all = delete_request_valid_userID(auth_expired, id);
			} else if (useridtype.equals("invalid")) {
				response_all = delete_request_invalid_userID(auth_expired, id + "uhfishfaih213");
			} else if (useridtype.equals("blank")) {
				response_all = delete_request_blank_userID(auth_expired, id_blank);
			}
		} else if (authtype.equals("valid")) {
			if (useridtype.equals("valid")) {
				response_all = delete_request_valid_userID(auth, id);
			} else if (useridtype.equals("invalid")) {
				response_all = delete_request_invalid_userID(auth, id + "uhfishfaih213");
			} else if (useridtype.equals("blank")) {
				response_all = delete_request_blank_userID(auth, id_blank);
			}
		}
		return response_all;
	}

	//////////////////////////////// BAD REQUESTS ///////////////////////////////////
	public ValidatableResponse delete_request_invalid_userID(String auth_token, String userid) {
		return (SerenityRest.given().auth().oauth2(auth_token).when()
				.delete(logoff_endpoint + userid).then());
	}

	public ValidatableResponse delete_request_blank_userID(String auth_token, String userid) {
		return (SerenityRest.given().auth().oauth2(auth_token).when()
				.delete(logoff_endpoint + userid).then());
	}

	public ValidatableResponse delete_request_valid_userID(String auth_token, String userid) {
		return (SerenityRest.given().auth().oauth2(auth_token).when()
				.delete(logoff_endpoint + userid).then());
	}
	///////////////////////////////////////////////////////////////////////////////////////
//		SerenityRest.given().header("Authorization", "Bearer " + auth_token );

}
