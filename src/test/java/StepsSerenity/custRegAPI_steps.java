package StepsSerenity;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pojoClasses.custRegPOJO;
import utils.fileReader;

public class custRegAPI_steps {

	@Steps
	loginAPI_steps loginAPI_steps;
	commonSteps common_steps_objects = new commonSteps();
	
	static custRegPOJO pojo_custReg = new custRegPOJO();
	static fileReader fileReader_object = new fileReader();
	static String customer_reg_endpoint = "site/account/register";
	static ValidatableResponse response_all;


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
		response_all = SerenityRest.given().auth().oauth2(common_steps_objects.get_auth()).contentType("application/json").body(pojo_custReg).when().post(customer_reg_endpoint).then();
		return response_all;
	}

	@Step
	public ValidatableResponse post_bad_custReg_request(String bad_auth_type) {
		if (bad_auth_type.equalsIgnoreCase("invalid")) {
			response_all = SerenityRest.given().auth().oauth2(common_steps_objects.get_auth_invalid()).contentType("application/json")
					.body(pojo_custReg).when().post(customer_reg_endpoint).then();
		} else if (bad_auth_type.equalsIgnoreCase("expired")) {
			response_all = SerenityRest.given().auth().oauth2(common_steps_objects.get_auth_expired()).contentType("application/json")
					.body(pojo_custReg).when().post(customer_reg_endpoint).then();
		} else if (bad_auth_type.equalsIgnoreCase("blank")) {
			response_all = SerenityRest.given().auth().oauth2(common_steps_objects.get_auth_blank()).contentType("application/json")
					.body(pojo_custReg).when().post(customer_reg_endpoint).then();
		}
		return response_all;
	}
}
