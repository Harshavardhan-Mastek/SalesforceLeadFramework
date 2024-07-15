package edu.mastek.runnerPackage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

features = {"src\\test\\java\\edu\\mastek\\featurePackage"},
        glue = "edu.mastek.stepdefinitionPackage",
        publish = true,
        plugin = {"pretty","html:target/cucumber-reports/report.html" },
        monochrome = true
)
//Runner class
public class RunnerTestClass  {


}

