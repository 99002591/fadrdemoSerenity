package StepDefinitions;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import net.thucydides.core.util.EnvironmentVariables;

public class hooks {
	
	@Before("@API_SECURITY")
	public void set_base_url_security() {
		RestAssured.baseURI = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	}
	
	@Before("@API_SITE")
	public void set_base_url_site() {
		RestAssured.baseURI = "https://fadr-site-afx-eus-dev.azurewebsites.net/api/v1/";
	}
}
