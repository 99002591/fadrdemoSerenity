package pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://smpservices-qa.eastus.cloudapp.azure.com/#/factoryreset/register_customer")
public class custReg_page extends PageObject {

	////////////////      PRE MAIN SITE LOAD ELEMENTS     ////////////////////
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

	@FindBy(id = "mat-option-5")
	private WebElementFacade contactMethod_email;

	@FindBy(id = "mat-option-6")
	private WebElementFacade contactMethod_phone;

	@FindBy(id = "mat-option-7")
	private WebElementFacade contactMethod_other;
	/////////////////////////////////////////////////////////////////////

	///////////////// MAIN SITE BUTTONS //////////////////////////
	@FindBy(id = "submitBtn")
	private WebElementFacade submit_button;

	@FindBy(id = "resetBtn")
	private WebElementFacade reset_button;
	/////////////////////////////////////////////////////////////////////

	///////////////// BUTTON STATE CHECKS //////////////////////////
	public boolean state_of_submit_button() {
		return (submit_button.isClickable());
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
		clickOn(submit_button);
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
		System.out.println("CONTACT METHOD = " + method);
		if (method.equals("email")) {
			clickOn(contactMethod_email);
		} else if (method.equals("phone")) {
			clickOn(contactMethod_phone);
		} else if (method.equals("other")) {
			clickOn(contactMethod_other);
		} else {
			//DO Nothing
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
		return(customer_name.getText());
	}
	public String get_contactName() {
		return(contact_name.getText());
	}
	public String get_contactPhone() {
		return(contact_phone.getText());
	}
	public String get_contactEmail() {
		return(contact_email.getText());
	}
	
	public boolean get_header(String header) {
		return((registerCustomer_page_header.getText()).contains(header));
	}
	////////////////////////////////////////////////////////////////////////
}
