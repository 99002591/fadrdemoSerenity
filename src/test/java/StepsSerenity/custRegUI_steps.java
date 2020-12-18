package StepsSerenity;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import pages.commonPage;
import pages.custReg_page;
import utils.fileReader;

public class custRegUI_steps {

	static custReg_page custReg_pageObj;
	static commonPage common_pageObj;
	static fileReader f_read = new fileReader();

	public void open_custReg_page() {
		custReg_pageObj.open();
	}

	public void fill_test_details(String customername, String contactname, String contactphone, String contactemail, String contactmethod) {
		String temporary = null;
		if (customername.equals("break_limit_customer")) {
			try {
				temporary = f_read.readfile("name_too_long");
				custReg_pageObj.click_customer_name();
				custReg_pageObj.enter_customer_name(temporary);
				custReg_pageObj.click_contact_name();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		else if (contactname.equals("break_limit_contact")) {
			try {
				temporary = f_read.readfile("name_too_long");
				custReg_pageObj.click_contact_name();
				custReg_pageObj.enter_contact_name(temporary);
				custReg_pageObj.click_contact_phone();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		else if (contactphone.equals("break_limit_phone")) {
			try {
				temporary = f_read.readfile("phonenumber_too_long");
				custReg_pageObj.click_contact_phone();
				custReg_pageObj.enter_contact_phone(temporary);
				custReg_pageObj.click_contact_email();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		else {
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

	public void all_fields_reset() {
		assertThat(custReg_pageObj.get_all_fields_text(), equalTo(0));
	}

	public void check_if_custReg_page_open() {
		assertThat(custReg_pageObj.get_header("Register Customer"), equalTo(true));
	}

	public void error_message_validation(String errormessage) {
		assertThat(common_pageObj.getResultTitles(errormessage), equalTo(true));
	}
	
	public void too_long_validation(String field) {
		if (field.equals("customer_name")) {
			assertThat(custReg_pageObj.get_customerName_length(), equalTo(256));
		}
		else if (field.equals("contact_name")) {
			assertThat(custReg_pageObj.get_contactName_length(), equalTo(256));
		}
		else if (field.equals("phone_number")) {
			assertThat(custReg_pageObj.get_contactPhone_length(), equalTo(16));
		}
	}
}
