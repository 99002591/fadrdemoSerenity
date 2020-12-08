package StepsSerenity;

import net.thucydides.core.annotations.Step;
import pages.loginPageObject;

public class loginUI_steps {
	
	static loginPageObject loginpage_object = new loginPageObject();
	
	@Step
	public void enter_credentials(String email, String password) {
		loginpage_object.enter_email_and_password(email, password);
	}
	
	@Step
	public boolean login() {
		boolean state_of_login_button = loginpage_object.if_login_button_enabled();
		if(state_of_login_button == true) {
			loginpage_object.click_on_login_button();
			return state_of_login_button;
		}
		else {
			return state_of_login_button;
		}
	}
	
	@Step
	public void forgot_password() {
		loginpage_object.click_on_forgot_password();
	}
	
	@Step
	public String forgot_password_page_opening_validation() {
		return(loginpage_object.find_if_forgot_password_page_is_Open());
	}
	
	@Step
	public void eye_button_clicked(int times) {
		loginpage_object.click_on_eye_button(times);
	}
	
	@Step
	public String password_visibility() {
		return loginpage_object.find_the_password_visibility();
	}
	
	@Step
	public String login_fail_validation() {
		return(loginpage_object.find_the_error_message_for_failed_login());
	}
}
