package pages;

import org.openqa.selenium.WebDriver;

import StepDefinitions.hooks;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://dev-portal.eastus.cloudapp.azure.com/#/")
public class loginPageObject extends PageObject {

	hooks hook = new hooks();
	WebDriver driver = hooks.driver;

	////////////// WEB ELEMENTS ////////////////
	@FindBy(id = "email")
	private WebElementFacade email_input_field;

	@FindBy(id = "password")
	private WebElementFacade password_input_field;

	@FindBy(xpath = "//span[contains(text(),'LOG IN')]")
	private WebElementFacade login_button;

	@FindBy(xpath = "//div[@class=\"mat-checkbox-inner-container\"]")
	private WebElementFacade remember_me_checkbox;

	@FindBy(xpath = "//mat-icon[@class='matIcon mat-icon notranslate material-icons mat-icon-no-color']")
	private WebElementFacade eye_button;

	@FindBy(xpath = "//a[@class='forgot-password']")
	private WebElementFacade forgot_password_link;

	@FindBy(xpath = "//a[@class='contact-eaton']")
	private WebElementFacade eaton_support_link;

	@FindBy(xpath = "//*[@class=\\\"mat-error ng-star-inserted\\\"]")
	private WebElementFacade failed_login_error_message;

	@FindBy(xpath = "//mat-icon[@class='matIcon mat-icon notranslate material-icons mat-icon-no-color']")
	private WebElementFacade password_visibility_attribute;

	@FindBy(xpath = "//*[@class=\"mat-card-title\"]")
	private WebElementFacade forgot_password_page_title;

	@FindBy(xpath = "//h6[contains(text(),'General Questions')]")
	private WebElementFacade eaton_support_page_title;
	////////////////////////////////////////////////////////////////

	/////////////// Text Input and Click actions ///////////////////
	public void enter_email_and_password(String email, String password) {
		typeInto(email_input_field, email);
		typeInto(password_input_field, password);
	}

	public void click_on_rememberMe_N_times() {
		clickOn(remember_me_checkbox);
	}

	public void click_on_eye_button(int times) {
		for (int i = 1; i <= times; i++) {
			clickOn(eye_button);
		}
	}

	public void click_on_forgot_password() {
		clickOn(forgot_password_link);
	}

	public void click_on_eaton_support() {
		clickOn(eaton_support_link);
	}

	public void click_on_login_button() {
		clickOn(login_button);
	}
	//////////////////////////////////////////////////////////////////////////////////

	///////////////// RETRIEVING VALUES FOR ASSERTION ///////////////////
	public String find_the_error_message_for_failed_login() {
		return (failed_login_error_message.getText());
	}

	public String find_the_password_visibility() {
		return (password_visibility_attribute.getText());
	}

	public String find_if_forgot_password_page_is_Open() {
		return (forgot_password_page_title.getText());
		// ASSERT THE RETURNED STRING WITH WITH "Forgot Password"
	}

	public String find_if_eaton_support_help_page_is_Open() {
		return (eaton_support_page_title.getText());
		// ASSERT THE RETURNED STRING WITH "General Questions"
	}

	public boolean if_login_button_enabled() {
		return (login_button.isEnabled());
	}
	/////////////////////////////////////////////////////////////////////////////////////////

}
