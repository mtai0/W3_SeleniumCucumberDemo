package com.revature.cucumber.selenium.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private static WebDriver driver;

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @When("User navigates to login page")
    public void userNavigatesToLoginPage() {
        driver.get("https://demoqa.com/login");
    }

    @And("User enters Username and Password")
    public void userEntersUsernameAndPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(
                        driver.findElement(By.cssSelector("input[id='userName']"))
                )
        ).sendKeys("testuser");
        wait.until(ExpectedConditions.elementToBeClickable(
                        driver.findElement(By.cssSelector("input[id='password']"))
                )
        ).sendKeys("Password@123");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.elementToBeClickable(
                        driver.findElement(By.cssSelector("button[id='login']"))
                )
        ).click();
    }

    @Then("Message displayed Login Successful")
    public void messageDisplayedLoginSuccessful() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement uname = driver.findElement(By.cssSelector("label[id='userName-value']"));
        String unameValue = uname.getText();
        System.out.println("User: " + unameValue);

        driver.quit();
    }

    @And("User enters {string} and {string}")
    public void userEntersAnd(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.cssSelector("input[id='userName']"))
                )
        ).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(
                        driver.findElement(By.cssSelector("input[id='password']"))
                )
        ).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(
                        driver.findElement(By.cssSelector("button[id='login']"))
                )
        ).click();
    }
}
