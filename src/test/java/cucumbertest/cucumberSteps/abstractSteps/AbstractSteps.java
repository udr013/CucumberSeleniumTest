package cucumbertest.cucumberSteps.abstractSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AbstractSteps {

	//Singleton pattern, though tests fail when static....
	private  WebDriver webDriver;

	public  WebDriver getWebDriver() {
		if (webDriver == null) {
			webDriver = new FirefoxDriver();
		}
		return webDriver;
	}

}
