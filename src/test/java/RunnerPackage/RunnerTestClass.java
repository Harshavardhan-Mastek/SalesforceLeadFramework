package RunnerPackage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

features = {"src\\test\\java\\FeatureFolder"},
        glue = "StepDefinitionPackage",
        publish = true,
        plugin = "pretty"
)
public class RunnerTestClass extends AbstractTestNGCucumberTests {


}

