package StepDefinitions;

import StepsSerenity.loginUI_steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class commonStepDefs_for_UI {
	
	@Steps
	static loginUI_steps loginUI_steps_object;
	
	@Given("^User navigates to login page$")
	public void homepage(){
		loginUI_steps_object.open_login();
	}

	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_the_email_and_password(String email, String password){
		loginUI_steps_object.enter_credentials(email, password);
	}
	
	@And("^User clicks Login button$")
	public void user_clicks_login_button() {
		loginUI_steps_object.login();
	}

}
