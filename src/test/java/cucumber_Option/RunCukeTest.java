package cucumber_Option;


import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
//import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(
		features = "src/test/resources/cucumber_Features/",
		glue = "step_Definition",
		plugin = {
				"pretty","html:target/cucumber",
				}
	)
public class RunCukeTest {
	
}