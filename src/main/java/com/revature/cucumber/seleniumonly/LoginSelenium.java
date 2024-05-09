package com.revature.cucumber.seleniumonly;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSelenium {
    private static WebDriver driver;

    public static void main (String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        //driver.manage().window().maximize();

        //Get the page title
        String title = driver.getTitle();
        System.out.println("The page title :: " + title);

        WebElement uname = driver.findElement(By.cssSelector("input[id='userName']"));
        WebElement pwd = driver.findElement(By.cssSelector("input[id='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[id='login']"));

        uname.sendKeys("testuser");
        pwd.sendKeys("Password@123");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginButton.click();
    }
}
