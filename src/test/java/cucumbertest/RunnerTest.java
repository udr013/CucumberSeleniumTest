package cucumbertest; //never call this package cucumber  or it will backfire on you

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		snippets = SnippetType.CAMELCASE,  // UNDERSCORE IS DEFAULT
		format = {"pretty", "html:target/TestResults/html", "json:target/TestResults/json/"},
		features = {"src/test/resources"},
		tags = {"@NewRecord"}
)

/**
 * Because we use postfix Test for the classname maven will pick it up when running
 * mvn test/clean/package/install or install:)
 */

public class RunnerTest {

}

