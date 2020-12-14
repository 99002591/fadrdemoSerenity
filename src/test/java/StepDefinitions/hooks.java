package StepDefinitions;

import io.cucumber.java.Before;

public class hooks {
	
	public static String url = "https://smpservices-qa.eastus.cloudapp.azure.com/#/";
	public static String base_url = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	public static String base_url_site = "https://fadr-site-afx-eus-dev.azurewebsites.net/api/v1/";

	
	@Before("@API_SECURITY")
	public void set_base_url_security() {

	}
	
	@Before("@API_SITE")
	public void set_base_url_site() {
		
	}
}
