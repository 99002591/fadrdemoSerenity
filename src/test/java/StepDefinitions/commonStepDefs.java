package StepDefinitions;

import StepsSerenity.common_steps;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class commonStepDefs {
	
	@Steps
	common_steps common_steps_object;
	
	@Given("Login successfully and generate authorisation token")
	public void login_successfully_and_generate_authorisation_token() {
		common_steps_object.generate_token_and_id();
	}
}
