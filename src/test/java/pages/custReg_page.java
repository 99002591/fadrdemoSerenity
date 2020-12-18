package pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromBy;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromElement;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.components.Dropdown;

@DefaultUrl("https://smpservices-qa.eastus.cloudapp.azure.com/#/factoryreset/register_customer")
public class custReg_page extends PageObject {

	//////////////// PRE MAIN SITE LOAD ELEMENTS ////////////////////
	@FindBy(xpath = "//div[@class = \"ng-star-inserted\"]")
	private WebElementFacade factory_rest_drop_down;

	@FindBy(xpath = "//*[@routerlink=\"/factoryreset/register_customer\"]")
	private WebElementFacade register_customer;

	@FindBy(xpath = "//mat-toolbar[contains(text(),' Register Customer ')]")
	private WebElementFacade registerCustomer_page_header;
	///////////////////////////////////////////////////////////////////////

	////////////////// MAIN SITE INPUT FIELDS WEBELEMENTS/////////////////////////
	@FindBy(id = "customerName")
	private WebElementFacade customer_name;

	@FindBy(id = "customerContactName")
	private WebElementFacade contact_name;

	@FindBy(id = "customerContactPhone")
	private WebElementFacade contact_phone;

	@FindBy(id = "customerContactEmail")
	private WebElementFacade contact_email;

	@FindBy(id = "customerApprovedContactMethod")
	private WebElementFacade contactMethod_dropdown;

	@FindBy(id = "customerTextArea")
	private WebElementFacade additional_Info;

	@FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'E-mail')]")
	private WebElementFacade dropdown_email;

	@FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'Telephone')]")
	private WebElementFacade dropdown_phone;

	@FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'Other')]")
	private WebElementFacade dropdown_other;
	
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'Select contact method')]")
	private WebElementFacade dropdown_no_method;
	/////////////////////////////////////////////////////////////////////

	///////////////// MAIN SITE BUTTONS //////////////////////////
	@FindBy(id = "submitBtn")
	private WebElementFacade submit_button;

	@FindBy(id = "resetBtn")
	private WebElementFacade reset_button;
	/////////////////////////////////////////////////////////////////////

	///////////////// BUTTON STATE CHECKS //////////////////////////
	public boolean state_of_submit_button() {
		return (submit_button.isDisabled());
	}

	public boolean state_of_reset_button() {
		return (reset_button.isClickable());
	}
	/////////////////////////////////////////////////////////////////////

	////////////////// BUTTON & FIELDS CLICKS ////////////////////
	public void click_factoryReset_dropdown() {
		clickOn(factory_rest_drop_down);
	}

	public void click_customer_registration() {
		clickOn(register_customer);
	}

	public void click_submit() {
		if (!submit_button.isDisabled()) {
			clickOn(submit_button);
		}
	}

	public void click_reset() {
		clickOn(reset_button);
	}

	public void click_customer_name() {
		clickOn(customer_name);
	}

	public void click_contact_name() {
		clickOn(contact_name);
	}

	public void click_contact_phone() {
		clickOn(contact_phone);
	}

	public void click_contact_email() {
		clickOn(contact_email);
	}

	public void click_contact_method() {
		clickOn(contactMethod_dropdown);
	}

	public void choose_contact_method(String method) {
		if (method.equals("email")) {
			clickOn(dropdown_email);
		} else if (method.equals("phone")) {
			clickOn(dropdown_phone);
		} else if (method.equals("other")) {
			clickOn(dropdown_other);
		} else {
			clickOn(dropdown_no_method);
		}
	}

	public void click_additonal_info() {
		clickOn(additional_Info);
	}
	//////////////////////////////////////////////////////////////////////

	///////////////////// DATA INPUT METHODS //////////////////////////
	public void enter_customer_name(String customername) {
		typeInto(customer_name, customername);
	}

	public void enter_contact_name(String contactname) {
		typeInto(contact_name, contactname);
	}

	public void enter_contact_phone(String contactphone) {
		typeInto(contact_phone, contactphone);
	}

	public void enter_contact_email(String contactemail) {
		typeInto(contact_email, contactemail);
	}

	///////////////////////////////////////////////////////////////////////

	////////////// DATA RETRIEVING FROM TEXT FIELDS ///////////////
	public String get_customerName() {
		System.out.println(customer_name);
		return (customer_name.getValue());
	}

	public String get_contactName() {
		return (contact_name.getValue());
	}

	public String get_contactPhone() {
		return (contact_phone.getValue());
	}

	public String get_contactEmail() {
		return (contact_email.getValue());
	}

	public boolean get_header(String header) {
		return ((registerCustomer_page_header.getText()).contains(header));
	}
	
	public int get_all_fields_text() {
		int total_length = get_customerName().length() + get_contactName().length() + get_contactPhone().length() + get_contactEmail().length();
		return(total_length);
	}
	
	public int get_customerName_length() {
		return(get_customerName().length());
	}
	
	public int get_contactName_length() {
		return(get_contactName().length());
	}
	
	public int get_contactPhone_length() {
		return(get_contactPhone().length());
	}
	////////////////////////////////////////////////////////////////////////
}
