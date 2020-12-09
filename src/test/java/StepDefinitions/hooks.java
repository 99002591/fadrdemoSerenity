package StepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	
	public static WebDriver driver;
	public static String base_url = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	
	@Before("@BrowserAction")
    public void open_the_chrome_browser() {
    	System.setProperty("webdriver.chrome.driver", "/fadrdemoSerenity/src/test/resources/drivers/chromedriver_87.exe");
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
