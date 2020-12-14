package StepsSerenity;

import StepDefinitions.hooks;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.commonMethods;

public class logoutAPI_steps {
	static custRegAPI_steps custRegAPI_steps_object = new custRegAPI_steps();
	static hooks hooks_object = new hooks();
	static commonMethods commonMethods_object = new commonMethods();
	static ValidatableResponse response_all;
	static String auth, id;
	static String auth_expired = "sgfwqujgjaslfgsauilfgslaufgsuair934234792305bjxzkvba";
	static String auth_invalid = auth + "ashdsjkfhsk2371249jdfsdfdsfdsfdsfsd3w43rf52353523kcns";
	static String auth_blank = "";
	static String id_blank = "";
	
	@Step
	public void generate_token_and_id() {
		response_all = custRegAPI_steps_object.get_token();
		auth = response_all.extract().response().jsonPath().getString("data.token");
		id = response_all.extract().response().jsonPath().getString("data.id");
	}

	@Step
	public ValidatableResponse delete_request() {
		response_all = SerenityRest.given().auth().oauth2(auth).when()
				.delete(hooks_object.base_url + "security/logoff/" + id).then();
		return response_all;
	}

	@Step
	public ValidatableResponse delete_request(String authtype, String useridtype) {
		if (authtype.equals("invalid")) {
			if (useridtype.equals("valid")) {
				response_all = commonMethods_object.delete_request_valid_userID(auth_invalid, id);
			} else if (useridtype.equals("invalid")) {
				response_all = commonMethods_object.delete_request_invalid_userID(auth_invalid,id+"uhfishfaih213");
			} else if (useridtype.equals("blank")) {
				response_all = commonMethods_object.delete_request_blank_userID(auth_invalid, id_blank);
			}
		} else if (authtype.equals("blank")) {
			if (useridtype.equals("valid")) {
				response_all = commonMethods_object.delete_request_valid_userID(auth_invalid, id);
			} else if (useridtype.equals("invalid")) {
				response_all = commonMethods_object.delete_request_invalid_userID(auth_invalid,id+"uhfishfaih213");
			} else if (useridtype.equals("blank")) {
				response_all = commonMethods_object.delete_request_blank_userID(auth_invalid, id_blank);
			}
		} else if (authtype.equals("expired")) {
			if (useridtype.equals("valid")) {
				response_all = commonMethods_object.delete_request_valid_userID(auth_expired, id);
			} else if (useridtype.equals("invalid")) {
				response_all = commonMethods_object.delete_request_invalid_userID(auth_expired,id+"uhfishfaih213");
			} else if (useridtype.equals("blank")) {
				response_all = commonMethods_object.delete_request_blank_userID(auth_expired, id_blank);
			}
		} else if (authtype.equals("valid")) {
			if (useridtype.equals("valid")) {
				response_all = commonMethods_object.delete_request_valid_userID(auth, id);
			} else if (useridtype.equals("invalid")) {
				response_all = commonMethods_object.delete_request_invalid_userID(auth,id+"uhfishfaih213");
			} else if (useridtype.equals("blank")) {
				response_all = commonMethods_object.delete_request_blank_userID(auth, id_blank);
			}
		}
	return response_all;
	}
}
