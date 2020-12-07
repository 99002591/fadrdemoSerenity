package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	
	public static WebDriver driver;
	public static String base_url = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	
	@Before("@BrowserAction")
    public void open_the_chrome_browser() {
    	System.setProperty("webdriver.chrome.driver", "D:/Eclipse_Workspace/Selenium/WebDrivers/chromedriver_87.exe");
    	driver = new ChromeDriver();
		driver.get("https://dev-portal.eastus.cloudapp.azure.com/#/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
    }

    @After("@BrowserAction")
    public void close_the_chrome_broswer() throws InterruptedException {
    	//Thread.sleep(3000);
    	driver.close();
    }
}
