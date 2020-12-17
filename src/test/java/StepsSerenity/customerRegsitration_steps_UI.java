package StepsSerenity;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import pages.commonPage;
import pages.custReg_page;

public class customerRegsitration_steps_UI {

	static custReg_page custReg_pageObj;
	static commonPage common_pageObj;

	public void open_custReg_page() {
		custReg_pageObj.open();
	}

	public void fill_test_details(String customername, String contactname, String contactphone, String contactemail,
			String contactmethod) {
		custReg_pageObj.click_customer_name();
		custReg_pageObj.enter_customer_name(customername);
		custReg_pageObj.click_contact_name();
		custReg_pageObj.enter_contact_name(contactname);
		custReg_pageObj.click_contact_phone();
		custReg_pageObj.enter_contact_phone(contactphone);
		custReg_pageObj.click_contact_email();
		custReg_pageObj.enter_contact_email(contactemail);
		custReg_pageObj.click_contact_method();
		custReg_pageObj.choose_contact_method(contactmethod);
		custReg_pageObj.click_additonal_info();
	}

	public void state_check_of_submit() {
		assertThat(custReg_pageObj.state_of_submit_button(), equalTo(true));
	}

	public void click_dropdown() {
		custReg_pageObj.click_factoryReset_dropdown();
	}

	public void choose_customer_reg() {
		custReg_pageObj.click_customer_registration();
	}

	public void submit() {
		custReg_pageObj.click_submit();
	}

	public void reset() {
		custReg_pageObj.click_reset();
	}

	public void check_if_custReg_page_open() {
		assertThat(custReg_pageObj.get_header("Register Customer"), equalTo(true));
	}

	public void error_message_validation(String errormessage) {
		assertThat(common_pageObj.getResultTitles(errormessage), equalTo(true));
	}
}
