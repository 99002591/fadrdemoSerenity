package StepDefinitions;

import StepsSerenity.loginUI_steps;
import io.cucumber.java.Before;
import pages.loginPage;

public class hooks {
	
	public static String url = "https://smpservices-qa.eastus.cloudapp.azure.com/#/";
	public static String base_url = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	public static String base_url_site = "https://fadr-site-afx-eus-dev.azurewebsites.net/api/v1/";
	
	static loginUI_steps loginUI_steps_object = new loginUI_steps();
	static loginPage loginpage_object = new loginPage();
	
	@Before("@BrowserAction")
    public void open_the_chrome_browser() throws InterruptedException {
//		loginpage_object.open();
//		Thread.sleep(3000);
//		loginpage_object.check_and_proceed();
//    	System.setProperty("webdriver.chrome.driver", "/fadrdemoSerenity/src/test/resources/drivers/chromedriver_87.exe");
//    	loginUI_steps_object.open_the_loginPage();
//    	driver = new ChromeDriver();
//		driver.get("https://dev-portal.eastus.cloudapp.azure.com/#/");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
    }

//    @After("@BrowserAction")
//    public void close_the_chrome_broswer() throws InterruptedException {
//    	//Thread.sleep(3000);
//    	driver.close();
//    }
}
