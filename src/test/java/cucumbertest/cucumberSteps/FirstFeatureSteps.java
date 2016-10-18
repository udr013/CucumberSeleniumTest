package cucumbertest.cucumberSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class FirstFeatureSteps {

	@Given("^this is the first step$")
	public void thisIsTheFirstStep() throws Throwable {
		System.out.println("working");
	}

	@When("^this is the second step$")
	public void thisIsTheSecondStep() throws Throwable {
		System.out.println("this is the second step");
		;
	}

	@Then("^this is the third and final step$")
	public void thisIsTheThirdAndFinalStep() throws Throwable {
		System.out.println("This is the final step and only tested when the others passed");
	}


}
