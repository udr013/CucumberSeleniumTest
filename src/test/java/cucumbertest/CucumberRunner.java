package cucumbertest; //never call this package cucumber  or it will backfire on you

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by udr013 on 9-10-16.
 */

    @RunWith(Cucumber.class)
    @CucumberOptions(
            snippets = SnippetType.CAMELCASE,  // UNDERSCORE IS DEFAULT
            format = {"pretty", "html:target/TestResults/cucumber"}

    )
    public class CucumberRunner {

    }

