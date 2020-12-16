package StepsSerenity;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import net.thucydides.core.annotations.Step;
import pages.loginPage;

public class loginUI_steps {
	
	static loginPage loginpage_object;
	
	@Step
	public void open_login() throws InterruptedException {
		loginpage_object.open();
	}
	
	@Step
	public void enter_credentials(String email, String password) throws InterruptedException {
		loginpage_object.enter_email_and_password(email, password);
	}
	
	@Step
	public void login() {
		if(loginpage_object.if_login_button_enabled() == false) {
			loginpage_object.click_on_login_button();
		}
	}
	
	@Step
	public void eaton_support_link_open() {
		loginpage_object.click_on_eaton_support();
	}
	
	@Step
	public void forgot_password() {
		loginpage_object.click_on_forgot_password();
	}
	
	@Step
	public void forgot_password_page_opening_validation() {
		assertThat(loginpage_object.find_if_forgot_password_page_is_Open(), equalTo("Forgot Password"));
	}
	
	@Step
	public void help_section_dialog_box_opening_validation() {
		assertThat(loginpage_object.find_if_eaton_support_help_page_is_Open(), equalTo("General Questions"));
	}
	
	@Step
	public void eye_button_clicked(int time) {
		loginpage_object.click_on_eye_button(time);
	}
	
	@Step
	public void password_visibility(String visibility) {
		assertThat(loginpage_object.find_the_password_visibility(), equalTo(visibility));
	}
	
	@Step
	public void login_fail_validation(String errormessage){
		List<String> all_error_msgs = loginpage_object.getResultTitles();
		boolean if_present = all_error_msgs.contains(errormessage);
		assertThat(if_present, equalTo(true));	
	}
	
	@Step
	public void back_from_forgot_password() {
		loginpage_object.click_on_back_from_forgot_password();
	}
	
	@Step
	public void login_button_state_check() {
		assertThat(loginpage_object.if_login_button_enabled(), equalTo(false));
	}
	
	@Step
	public void redirect_to_dashboard() {
		assertThat(loginpage_object.if_logged_in(), equalTo("View reports"));
	}
	
	@Step
	public void logout_of_application() {
		loginpage_object.click_on_user_menu();
		loginpage_object.click_on_log_out();
	}
}
