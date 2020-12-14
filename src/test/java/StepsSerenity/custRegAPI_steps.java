package StepsSerenity;

import StepDefinitions.hooks;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pojoClasses.LoginPOJO;
import pojoClasses.custRegPOJO;

public class custRegAPI_steps {

	static custRegPOJO pojo_custReg = new custRegPOJO();
	@Steps
	loginAPI_steps loginAPI_steps;
	hooks hooks_Object = new hooks();

	static ValidatableResponse response_all;
	static String Auth_token;
	static String expired_auth_token = "qwihwfjkbsajflh8347134hjb421kj4b"; //change to file reader

	@Step
	public ValidatableResponse get_token() {
		loginAPI_steps = new loginAPI_steps();
		loginAPI_steps.prepare_request_body("fadr_support_technician@eaton.com", "Form7@22");
		response_all = (SerenityRest.given().contentType("application/json").body(loginAPI_steps.return_pojo_object())
				.when().post(hooks.base_url + "security/login").then());
		Auth_token = response_all.extract().response().jsonPath().getString("data.token");
		return response_all;
	}

	@Step
	public void prep_request_body(String name, String contactname, String phonenumber, String emailid,
			String contactmethod, String additionalinfo) {
		pojo_custReg.setName(name);
		pojo_custReg.setContactname(contactname);
		pojo_custReg.setPhonenumber(phonenumber);
		pojo_custReg.setEmailid(emailid);
		pojo_custReg.setContactmethod(contactmethod);
		pojo_custReg.setAdditionalinfo(additionalinfo);
	}

	@Step
	public ValidatableResponse post_custReg_request() {
		response_all = SerenityRest.given().auth().oauth2(Auth_token).contentType("application/json").body(pojo_custReg)
				.when().post(hooks_Object.base_url_site + "site/account/register").then();
		return response_all;
	}

	@Step
	public ValidatableResponse post_bad_custReg_request(String bad_auth_type) {
		if (bad_auth_type.equalsIgnoreCase("invalid")) {
			response_all = SerenityRest.given().auth().oauth2(Auth_token + "invalid").contentType("application/json")
					.body(pojo_custReg).when().post(hooks_Object.base_url_site + "site/account/register").then();
		} else if (bad_auth_type.equalsIgnoreCase("expired")) {
			response_all = SerenityRest.given().auth().oauth2(expired_auth_token).contentType("application/json")
					.body(pojo_custReg).when().post(hooks_Object.base_url_site + "site/account/register").then();
		} else if (bad_auth_type.equalsIgnoreCase("blank")) {
			response_all = SerenityRest.given().auth().oauth2("").contentType("application/json")
					.body(pojo_custReg).when().post(hooks_Object.base_url_site + "site/account/register").then();
		}
		return response_all;
	}
}
