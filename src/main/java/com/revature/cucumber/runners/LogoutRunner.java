package com.revature.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/Logout.feature",
        glue = {"com.revature.cucumber.selenium.steps"}
)
public class LogoutRunner {

}