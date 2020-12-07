package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.hooks;

public class loginPageObject {
	
	hooks hook = new hooks();
	WebDriver driver = hooks.driver;
	static String login_endpoint = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/security/login";

	public String getLogin_endpoint() {
		return login_endpoint;
	}
	
	public WebElement find_the_email_field(){
		return(driver.findElement(By.id("email")));
	}
	public WebElement find_the_password_field() {
		return(driver.findElement(By.id("password")));
	}

	public WebElement find_the_remember_Me_checkbox() {
		return(driver.findElement(By.xpath("//div[@class=\"mat-checkbox-inner-container\"]")));
	}

	public WebElement find_the_eye_button() {
			return(driver.findElement(By.xpath("//mat-icon[@class='matIcon mat-icon notranslate material-icons mat-icon-no-color']")));
	}

	public WebElement find_the_forgot_password_link() {
		return(driver.findElement(By.xpath("//a[@class='forgot-password']")));
	}

	public WebElement find_the_EATON_support_link() {
		return(driver.findElement(By.xpath("//a[@class='contact-eaton']")));
	}
	
	public String find_the_error_message_for_failed_login() {
		return(driver.findElement(By.xpath("//*[@class=\"mat-error ng-star-inserted\"]")).getText());
	}

	public String find_the_password_visibility() {
			return(driver.findElement(By.xpath("//mat-icon[@class='matIcon mat-icon notranslate material-icons mat-icon-no-color']")).getText());
	}

	public String find_if_forgot_password_page_is_Open() {
		return(driver.findElement(By.xpath("//*[@class=\"mat-card-title\"]")).getText());
		//ASSERT THE RETURNED STRING WITH WITH "Forgot Password"
	}

	public String find_if_eaton_support_help_page_is_Open() {
		return(driver.findElement(By.xpath("//h6[contains(text(),'General Questions')]")).getText());
		//ASSERT THE RETURNED STRING WITH "General Questions"
	}

	public WebElement find_the_login_button() {
		return(driver.findElement(By.xpath("//span[contains(text(),'LOG IN')]")));
	}

	/*
	 * Not Implemented
	 */
//	public String find_the_logout_button() {
//	findthelogoutbutton
//	}
}
