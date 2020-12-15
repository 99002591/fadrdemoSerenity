package StepsSerenity;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utils.fileReader;

public class common_steps {

	@Steps
	static loginAPI_steps loginAPI_steps;

	static fileReader fileReader_object = new fileReader();

	static ValidatableResponse response_all;
	static String auth, id;
	static String id_invalid = id + "fjhasjfaklsfh";
	static String id_blank = "";
	static String auth_blank = "";
	static String auth_expired;
	static String auth_invalid = "ashdsjkfhsk2371249jdfsdfdsfdsfdsfsd3w43rf52353523kcns";
	static String login_URL = "security/login";

	@Step
	public void generate_token_and_id() {
		loginAPI_steps.prepare_request_body("fadr_support_technician@eaton.com", "Form7@22");
		response_all = (SerenityRest.given().contentType("application/json").body(loginAPI_steps.return_pojo_object()).when().post(login_URL).then());
		auth = response_all.extract().response().jsonPath().getString("data.token");
		id = response_all.extract().response().jsonPath().getString("data.id");
		try {
			auth_expired = fileReader_object.readfile("expired_token");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step
	public String get_id() {
		return(id);
	}
	
	@Step
	public String get_id_invalid() {
		return(id_invalid);
	}
	
	@Step
	public String get_id_blank() {
		return(id_blank);
	}
	
	@Step
	public String get_auth() {
		return(auth);
	}
	
	@Step
	public String get_auth_expired() {
		return(auth_expired);
	}
	
	@Step
	public String get_auth_invalid() {
		return(auth_invalid);
	}
	
	@Step
	public String get_auth_blank() {
		return(auth_blank);
	}
}
