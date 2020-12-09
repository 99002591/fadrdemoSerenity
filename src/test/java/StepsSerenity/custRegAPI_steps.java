package StepsSerenity;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import pojoClasses.LoginPOJO;
import pojoClasses.custRegPOJO;

public class custRegAPI_steps {
	LoginPOJO pojo = new LoginPOJO();
	static custRegPOJO pojo_custReg = new custRegPOJO();
	loginAPI_steps loginAPI_steps;
	static ValidatableResponse response_all;
	static String Auth_token;

	@Step
	public void get_token() {
		loginAPI_steps = new loginAPI_steps();
		loginAPI_steps.prepare_request_body("fadr_support_technician@eaton.com", "Form7@22");
		response_all = (SerenityRest.given().contentType("application/json").body(loginAPI_steps.return_pojo_object())
				.when().post("https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/security/login").then());
		Auth_token = response_all.extract().response().jsonPath().getString("data.token");
	}
	
	@Step
	public void prep_request_body(String name, String contactname, String phonenumber, String emailid, String contactmethod, String additionalinfo) {
		pojo_custReg.setName(name);
		pojo_custReg.setContactname(contactname);
		pojo_custReg.setPhonenumber(phonenumber);
		pojo_custReg.setEmailid(emailid);
		pojo_custReg.setContactmethod(contactmethod);
		pojo_custReg.setAdditionalinfo(additionalinfo);
	}
	
	@Step
	public ValidatableResponse post_custReg_request() {
		System.out.println("name:"+pojo_custReg.getName()+" |contactname:"+pojo_custReg.getContactname()+" |phone:"+pojo_custReg.getPhonenumber()+" |email:"+pojo_custReg.getEmailid()+" |contactMethod:"+pojo_custReg.getContactmethod()+" |additonal:"+pojo_custReg.getAdditionalinfo());
		response_all = SerenityRest.given().auth().oauth2(Auth_token).contentType("application/json").body(pojo_custReg).when().post("https://fadr-site-afx-eus-dev.azurewebsites.net/api/v1/site/account/register").then();
		System.out.println(response_all.extract().response().body().asString());
		return response_all;
	}
}
