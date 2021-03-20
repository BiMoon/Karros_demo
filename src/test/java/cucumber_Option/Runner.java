package cucumber_Option;
import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = "src/test/resources/cucumber_Features/",
		glue = "step_Definition",
		plugin = {
				"pretty","html:target/cucumber",
				}
	)
public class Runner extends AbstractTestNGCucumberTests{
}
