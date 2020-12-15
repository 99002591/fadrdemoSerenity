package pages;

import StepDefinitions.hooks;
//import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.PageObject;
//import net.serenitybdd.core.pages.WebElementFacade;
//import net.serenitybdd.screenplay.actions.Enter;
//import net.serenitybdd.screenplay.actions.SendKeystoElement;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
 
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webelements.Checkbox;;

@DefaultUrl("https://smpservices-qa.eastus.cloudapp.azure.com/#/")

public class loginPage extends PageObject {

	hooks hook = new hooks();
	
	////////////// ADVANCED  ///////////////////
	@FindBy(xpath = "//[@id=\"details-button\"]")
	private WebElementFacade advanced_button;

	@FindBy(xpath = "//*[@id=\"proceed-link\"]")
	private WebElementFacade proceed_to_link;	
	////////////////////////////////////////////
	
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
	
	@FindBy(xpath = "//div[@class=\"mat-form-field-subscript-wrapper\"]")
	private WebElementFacade under_email_validator;

	@FindBy(xpath = "//div[@class=\"ng-tns-c16-1 ng-trigger ng-trigger-transitionMessages ng-star-inserted\"]")
	private WebElementFacade under_password_validator;

	@FindBy(xpath = "//mat-icon[@class='matIcon mat-icon notranslate material-icons mat-icon-no-color']")
	private WebElementFacade password_visibility_attribute;

	@FindBy(xpath = "//*[@class=\"mat-card-title\"]")
	private WebElementFacade forgot_password_page_title;
	
	@FindBy(xpath = "//span[contains(text(),'Back')]")
	private WebElementFacade forgot_password_back_button;

	@FindBy(xpath = "//h6[contains(text(),'General Questions')]")
	private WebElementFacade eaton_support_page_title;
	////////////////////////////////////////////////////////////////
	
	/////////////////// BYPASSING WARNING ///////////////////////////
	public void check_and_proceed() {
		if(advanced_button.isVisible()) {
			clickOn(advanced_button);
			clickOn(proceed_to_link);
		}
		else {
			//DO NOTHING
		}
	}
	/////////////////////////////////////////////////////////////////
	

	/////////////// Text Input and Click actions ///////////////////
	public void enter_email_and_password(String email, String password) throws InterruptedException {
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
	
	public void click_on_back_from_forgot_password() {
		clickOn(forgot_password_back_button);
	}
	//////////////////////////////////////////////////////////////////////////////////

	///////////////// RETRIEVING VALUES FOR ASSERTION ///////////////////
	public String find_the_error_message_for_failed_login() {
		if(under_email_validator.isVisible()) {
			return(under_email_validator.getText());
		}
		else if(under_password_validator.isVisible()) {
			return(under_password_validator.getText());
		}
		else {
			return ("NO ELEMENTS FOUND");
		}
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
