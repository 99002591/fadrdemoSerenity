package fadrdemoSerenity.pages;

public class loginPageObject {
	
	String login_endpoint = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/security/login";
	
	public String getter(String query) {
		if (query.equals("login_endpoint")) {
			return this.login_endpoint;
		}
		else {
			return "BLAH";
		}
	}
}
