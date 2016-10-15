package cucumbertest;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class RecordLoginSteps {


	WebDriver webdriver = null;

	//Hooks like @Before and @After always run regardless of test results
	@Before
	public void openMyWebsite() throws Throwable {
		System.out.println("using default @Before");
		webdriver = new FirefoxDriver();
		webdriver.navigate().to("https://recordcollector.herokuapp.com/");
		webdriver.manage().window().maximize();
	}

	@After
	public void closeBrowser() throws Throwable {
		System.out.println("using default @After");
		webdriver.close();
	}

	//notice tests with Senarios with @web tag will also execute the defaults they always run!!!
	// this tagged @Before("@Web) runs AFTER the default @Before
//    @Before("@Web")
//    public void openMyWebsiteWeb() throws Throwable {
//        System.out.println("!!! using @Before(\"@Web\") !!!");
//        webdriver = new FirefoxDriver();
//        webdriver.navigate().to("https://recordcollector.herokuapp.com/");
//        webdriver.manage().window().maximize();
//    }
//    // this tagged @After("@Web) runs BEFORE the default @After
//    @After("@Web")
//    public void closeBrowserWeb() throws Throwable{
//        System.out.println("!!! using @After(\"@Web\") !!!");
//        webdriver.close();
//    }

	@When("^i click on \"([^\"]*)\" tab$")
	public void i_click_on_tab(String arg1) throws Throwable {
		webdriver.findElement(By.linkText(arg1)).click();
		;
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
		webdriver.findElement(By.className("overviewTitle")).getText().equals("Collection overvie:");
		Assert.assertEquals("we expect", (!webdriver.findElement(By.className("overviewTitle")).getText().equals
				("Collection overview:")));
		Thread.sleep(4000);

	}


}
