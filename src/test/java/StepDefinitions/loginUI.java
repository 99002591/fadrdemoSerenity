package StepDefinitions;

import StepsSerenity.loginUI_steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class loginUI {

	hooks hooks_obj = new hooks();
	
	@Steps
	loginUI_steps loginUI_actions;

	@Given("^Start the required browser$")
	public void start_the_required_browser() {
	}

	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_the_email_and_password(String email, String password) {
		System.out.println("Email = " + email + "password = " + password);
	}

	@When("^Eye button is clicked (.+)$")
	public void eye_button_is_clicked(String times) {
		System.out.println("Eye button is clicked = " + times);
	}

	@When("^Forgot password link is clicked$")
	public void forgot_password_link_is_clicked() {
		System.out.println("Forgot password");
	}

	@When("^Contact EATON support representative link is clicked$")
	public void contact_eaton_support_representative_link_is_clicked() {
		System.out.println("Eaton support link clicked");
	}

	@Then("^Login fails with error message \"([^\"]*)\"$")
	public void login_fails_with_error_message_something(String errormessage) {
		System.out.println("Login fail validation");
	}

	@Then("^Password should be (.+)$")
	public void password_should_be(String visibility) {
		System.out.println("password is" + visibility);
	}

	@Then("^Redirect to Forgot password page$")
	public void redirect_to_forgot_password_page() {
		System.out.println("Redirect to forgot password page");
	}

	@Then("^Help section dialog box opens up$")
	public void help_section_dialog_box_opens_up() {
		System.out.println("Help section dialog box opens");
	}

	@And("^User clicks Login button$")
	public void user_clicks_login_button() {
		System.out.println("Login button clicked");
	}
}
