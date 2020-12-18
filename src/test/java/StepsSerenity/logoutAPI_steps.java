package StepsSerenity;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utils.fileReader;

public class logoutAPI_steps {
	@Steps
	commonSteps common_steps_object;
	
	static String logoff_endpoint = "security/logoff/";
	
	static custRegAPI_steps custRegAPI_steps_object = new custRegAPI_steps();
	static fileReader fileReader_object = new fileReader();
	
	static ValidatableResponse response_all;	

	@Step
	public ValidatableResponse delete_request() {
		response_all = SerenityRest.given().auth().oauth2(common_steps_object.get_auth()).when().delete(logoff_endpoint+common_steps_object.get_id()).then();
		return response_all;
	}

	@Step
	public ValidatableResponse delete_request(String authtype, String useridtype) {
		if (authtype.equals("invalid")) {
			if (useridtype.equals("valid")) {
				response_all = delete_request_valid_userID(common_steps_object.get_auth_invalid(), common_steps_object.get_id());
			} else if (useridtype.equals("invalid")) {
				response_all = delete_request_invalid_userID(common_steps_object.get_auth_invalid(), common_steps_object.get_id_invalid());
			} else if (useridtype.equals("blank")) {
				response_all = delete_request_blank_userID(common_steps_object.get_auth_invalid(), common_steps_object.get_id_blank());
			}
		} else if (authtype.equals("blank")) {
			if (useridtype.equals("valid")) {
				response_all = delete_request_valid_userID(common_steps_object.get_auth_blank(), common_steps_object.get_id());
			} else if (useridtype.equals("invalid")) {
				response_all = delete_request_invalid_userID(common_steps_object.get_auth_blank(), common_steps_object.get_id_invalid());
			} else if (useridtype.equals("blank")) {
				response_all = delete_request_blank_userID(common_steps_object.get_auth_blank(), common_steps_object.get_id_blank());
			}
		} else if (authtype.equals("expired")) {
			if (useridtype.equals("valid")) {
				response_all = delete_request_valid_userID(common_steps_object.get_auth_expired(), common_steps_object.get_id());
			} else if (useridtype.equals("invalid")) {
				response_all = delete_request_invalid_userID(common_steps_object.get_auth_expired(), common_steps_object.get_id_invalid());
			} else if (useridtype.equals("blank")) {
				response_all = delete_request_blank_userID(common_steps_object.get_auth_expired(), common_steps_object.get_id_blank());
			}
		} else if (authtype.equals("valid")) {
			if (useridtype.equals("valid")) {
				response_all = delete_request_valid_userID(common_steps_object.get_auth(), common_steps_object.get_id());
			} else if (useridtype.equals("invalid")) {
				response_all = delete_request_invalid_userID(common_steps_object.get_auth(), common_steps_object.get_id_invalid());
			} else if (useridtype.equals("blank")) {
				response_all = delete_request_blank_userID(common_steps_object.get_auth(), common_steps_object.get_id_blank());
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
