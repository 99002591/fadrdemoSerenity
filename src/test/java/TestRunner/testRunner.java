package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)


@CucumberOptions(
        features = "src/test/resources/features/loginUI.feature",
        glue= "StepDefinitions",
        plugin =  "html:target/Report-html",
        monochrome = true )
public class testRunner {

}
