package cucumbertest;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by udr013 on 11-10-16.
 */
public class RecordLoginSteps {

    WebDriver webdriver = null;

    @Given("^I'm on my website$")
    public void iMOnMyWebsite() throws Throwable {
        webdriver = new FirefoxDriver();
        webdriver.navigate().to("https://recordcollector.herokuapp.com/");
        webdriver.manage().window().maximize();
    }

//    @When("^i click on collection tab$")
//    public void iClickOnCollectionTab() throws Throwable {
//        webdriver.findElement(By.linkText("Collection")).click();
//    }

    @When("^i click on \"([^\"]*)\"$")
    public void iClickOnTab(String tabLink) throws Throwable {

        webdriver.findElement(By.linkText(tabLink)).click();
        Thread.sleep(1000);
    }

    @Then("^i click on ([^\"]*)$")
    public void iClickOnTabLink(String link) throws Throwable {

        webdriver.findElement(By.linkText(link)).click();
        Thread.sleep(1000);
    }


    @Then("^i get redirected to login page$")
    public void iGetRedirectedToLoginPage() throws Throwable {
            System.out.println("I'm on login page");
    }

    @Then("^i fill in my username and password$")
    public void iFillInMyUsernameAndPassword(DataTable table) throws Throwable {

        List<List<String>> data = table.raw();
//        webdriver.findElement(By.name("username")).sendKeys("mark");
//        webdriver.findElement(By.name("password")).sendKeys("test");

//            column 1 row 1 / colomn 2 row 1
        webdriver.findElement(By.name("username")).sendKeys(data.get(1).get(1));
        webdriver.findElement(By.name("password")).sendKeys(data.get(2).get(1));
        webdriver.findElement(By.className("button")).click();
    }

    @Then("^i see my collection$")
    public void iSeeMyCollection() throws Throwable {
        //Assert.assertEquals("we expect",String);
        webdriver.findElement(By.className("overviewTitle")).getText().equals("Collection overview:");
        //Assert.assertEquals("we expect",(webdriver.findElement(By.className("overviewTitle")).getText().equals("Collection overview:")==false));
        Thread.sleep(4000);

    }
    @And("^i close the browser")
    public void closeBrowser()  throws Throwable{
        webdriver.close();
    }

}
