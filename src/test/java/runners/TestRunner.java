package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources",
        glue = {"steps"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-results/main/failed_eld.txt"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
}

