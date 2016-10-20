package cucumbertest.cucumberSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumbertest.cucumberSteps.abstractSteps.AbstractSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewRecordSteps extends AbstractSteps {

	private WebDriver driver = getWebDriver();
	private int count;

	@Given("^I'am on the RecordCollector Website$")
	public void iAmOnTheRecordCollectorWebsite() throws Throwable {
		driver.navigate().to("https://recordcollector.herokuapp.com/");
	}

	@Given("^Logged in to the website$")
	public void loggedInToTheWebsite() throws Throwable {
		driver.navigate().to("https://recordcollector.herokuapp.com/login");
		driver.findElement(By.name("username")).sendKeys("mark");
      	driver.findElement(By.name("password")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.className("button")).click();

	}

	@Given("^I'm on the Collection Page$")
	public void iMOnTheCollectionPage() throws Throwable {
//		driver.navigate().to("https://recordcollector.herokuapp.com/collection");
		Assert.assertEquals("If on collection page this is equal",driver.findElement(By.className("overviewTitle"))
						.getText(),
				"Collection overview:");
		count =driver.findElements(By.tagName("tr")).size();
	}

	@When("^I enter \"([^\"]*)\" into the artist field$")
	public void iEnterIntoTheArtistField(String input) throws Throwable {
		driver.findElement(By.id("artist")).sendKeys(input);
	}

	@When("^I enter \"([^\"]*)\" into the album field$")
	public void iEnterIntoTheAlbumField(String input) throws Throwable {
		driver.findElement(By.id("album")).sendKeys(input);
	}

	@When("^I enter \"([^\"]*)\" into the year_of_release field$")
	public void iEnterIntoTheYear_of_releaseField(String input) throws Throwable {
		driver.findElement(By.id("date_of_release")).sendKeys(input);
	}

	@When("^I enter \"([^\"]*)\" into the label field$")
	public void iEnterIntoTheLabelField(String input) throws Throwable {
		driver.findElement(By.id("label")).sendKeys(input);
	}

	@When("^I select \"([^\"]*)\" into the format field$")
	public void iSelectIntoTheFormatField(String input) throws Throwable {
		driver.findElement(By.id("format")).sendKeys(input);
	}

	@When("^I enter \"([^\"]*)\" into the price field$")
	public void iEnterIntoThePriceField(String input) throws Throwable {
		driver.findElement(By.id("price")).sendKeys(input);
	}

	@When("^I hit the submit button$")
	public void iHitTheSubmitButton() throws Throwable {
		driver.findElement(By.id("submit")).click();
	}

	@Then("^I see the newly added record in the database table$")
	public void iSeeTheNewlyAddedRecordInTheDatabaseTable() throws Throwable {
		Assert.assertEquals(" We now have" +count++ +"in the datatbase",count ,driver.findElements(By.tagName("tr"))
				.size());
	}

	@Then("^I close the browser$")
	public void iCloseTheBrowser() throws Throwable {
		closeDriver();
	}

}
