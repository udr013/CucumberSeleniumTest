package cucumbertest.cucumberSteps.abstractSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AbstractSteps {

	//Singleton pattern now handles quit correctly
	private  static WebDriver webDriver;

	protected   WebDriver getWebDriver() {
		if (webDriver == null) {  //instanciated driver for the first time
			webDriver = new FirefoxDriver();
		}
		return webDriver;
	}

	protected WebDriver closeDriver() {
		if (webDriver != null){
			webDriver.quit();
		}
		return webDriver=null;
	}
}
