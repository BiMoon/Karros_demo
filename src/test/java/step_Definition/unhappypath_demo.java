package step_Definition;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class unhappypath_demo {
	private static final String BASE_URL = "https://my-json-server.typicode.com/typicode/demo/posts";
	private static final String Home_URL = "https://my-json-server.typicode.com";
	
	 private static Response response, response_home;
	 private static String jsonString;
	 private static String responseBody;
	 
	 @When("^I go to endpoint by entering a string as \"([^\"]*)\"$")
	 public void i_go_to_endpoint_by_entering_a_string_as(String arg1) throws Throwable {
		 	System.out.println(" ======== Going to entering "+arg1);
			RequestSpecification request = RestAssured.given();
			response = request.request(Method.GET, arg1);
	 }

	 @Then("^the return page should have code (\\d+)xx and the page should not redirect\\.$")
	 public void the_return_page_should_have_code_xx_and_the_page_should_not_redirect(int arg1) throws Throwable {
		 responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		 Assert.assertEquals(404, response.getStatusCode());
	 }

	 @When("^I go to endpoint by entering a minus number as \"([^\"]*)\"$")
	 public void i_go_to_endpoint_by_entering_a_minus_number_as(String arg1) throws Throwable {
		 	System.out.println(" ======== Going to entering "+arg1);
			RequestSpecification request = RestAssured.given();
			response = request.request(Method.GET, arg1);
	 }
	 @Given("^I am in based domain page$")
	 public void i_am_in_based_domain_page() throws Throwable {
		 RestAssured.baseURI = Home_URL;
		 RequestSpecification request_home = RestAssured.given();
		 response_home = request_home.request(Method.GET, "/");
		 responseBody = response_home.getBody().asString();
		 //Assert.assertEquals(200, response_home.getStatusCode());
		 //System.out.println("Response Body is =>  " + responseBody);
	 }

	 @When("^I go to next resoure page as \"([^\"]*)\"$")
	 public void i_go_to_next_resoure_page_as(String arg1) throws Throwable {
		 RequestSpecification request_home = RestAssured.given();
		 response_home = request_home.request(Method.GET, arg1);
		 responseBody = response_home.getBody().asString();
		 System.out.println(arg1);
	 }

	 @Then("^the return code should be (\\d+)$")
	 public void the_return_code_should_be(int arg1) throws Throwable {
		 
		 Assert.assertEquals(arg1, response_home.getStatusCode());
		 
	 }

	 @Then("^the next page should show resource of next pages as \"([^\"]*)\"$")
	 public void the_next_page_should_show_resource_of_next_pages_as(String arg1) throws Throwable {
		 //JsonPath jsonPathEvaluator = response.jsonPath();
		 System.out.println("Response Body is =>  " + responseBody);
		 //System.out.println(arg1);
		 Assert.assertTrue(responseBody.contains(arg1));
	 }
	 

	
}
