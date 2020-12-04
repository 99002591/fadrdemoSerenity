package fadrdemoSerenity.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)


@CucumberOptions(
        features = "/fadrdemoSerenity/src/test/resources/features",
        glue= "/fadrdemoSerenity/src/test/java/com.fadrdemoSerenity.cucumber.StepDefinitions",
        plugin =  "html:target/Report-html",
        monochrome = true )
public class testRunner {

}
