package config;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/java/features/TC3-Login User with incorrect email and password.feature"
//                ,"src/test/java/features/TC2-Login User with correct email and password.feature"
//                ,"src/test/java/features/TC3-Login User with incorrect email and password.feature"

        },
        glue = {"stepDefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-html-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml"
        },
        monochrome = true
)
public class RunCucumberTest {
}
