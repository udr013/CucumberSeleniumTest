package cucumbertest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by udr013 on 11-10-16.
 */
public class RecordLoginSteps {

    WebDriver webdriver = null;

    @Given("^I'm on my website$")
    public void iMOnMyWebsite() throws Throwable {
        webdriver = new FirefoxDriver();
        webdriver.navigate().to("https://recordcollector.herokuapp.com/");
    }

    @When("^i click on collection tab$")
    public void iClickOnCollectionTab() throws Throwable {
        webdriver.findElement(By.linkText("Collection")).click();
    }

    @Then("^i get redirected to login page$")
    public void iGetRedirectedToLoginPage() throws Throwable {
            System.out.println("I'm on login page");
    }

    @Then("^i fill in my username and password$")
    public void iFillInMyUsernameAndPassword() throws Throwable {
        webdriver.findElement(By.name("username")).sendKeys("mark");
        webdriver.findElement(By.name("password")).sendKeys("test");
        webdriver.findElement(By.className("button")).click();
    }

    @Then("^i see my collection$")
    public void iSeeMyCollection() throws Throwable {
        webdriver.findElement(By.className("overviewTitle")).getText().equals("Collection overview:");
    }

}
