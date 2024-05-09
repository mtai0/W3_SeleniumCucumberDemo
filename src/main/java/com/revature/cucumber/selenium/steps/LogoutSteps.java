package com.revature.cucumber.selenium.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutSteps {
    private static WebDriver driver;

    @Given("user is on the site homepage")
    public void userIsOnTheSiteHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @When("user navigates to the login page")
    public void userNavigatesToTheLoginPage() {
        driver.get("https://demoqa.com/login");
    }

    @And("user enters {string} and {string}")
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

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.elementToBeClickable(
                        driver.findElement(By.cssSelector("button[id='login']"))
                )
        ).click();
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement uname = driver.findElement(By.cssSelector("label[id='userName-value']"));
        System.out.println("Username found, login confirmed.");
    }

    @Given("user is on their profile page")
    public void userIsOnTheirProfilePage() {
        driver.get("https://demoqa.com/profile");
    }

    @When("user clicks the logout button")
    public void userClicksTheLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement logoutButton = driver.findElement(By.xpath("//button[text()='Log out']"));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    @Then("user is logged out")
    public void userIsLoggedOut() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement uname = driver.findElement(By.cssSelector("button[id='login']"));
        System.out.println("Login button found, logout confirmed!");
        driver.quit();
    }
}
