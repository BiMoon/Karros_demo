package step_Definition;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class happypath_demo {

	 private static final String BASE_URL = "https://my-json-server.typicode.com/typicode/demo/posts";
	
	 private static Response response;
	 @Given("^I am in the base page$")
	public void i_am_in_the_base_page() {

		RestAssured.baseURI = BASE_URL;
		 RequestSpecification request = RestAssured.given();
		 response = request.request(Method.GET, "/");
		 response.getBody().asString();
		 Assert.assertEquals(200, response.getStatusCode());
		 //System.out.println("Response Body is =>  " + responseBody);
		
	}

	@When("^I go to endpoint by entering number as (\\d+)$")
	public void i_go_to_endpoint_by_entering_number_as(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(" ======== Going to entering "+arg1);
		RequestSpecification request = RestAssured.given();
		response = request.request(Method.GET, ""+arg1);
	    
	}

	@Then("^The new page open and display id as (\\d+) and title as (\\d+)$")
	public void the_new_page_open_and_display_id_as_and_title_as(int arg1, int arg2) throws Throwable {
		response.getBody().asString();
		Assert.assertEquals(200, response.getStatusCode()); 
		//System.out.println("Response Body is =>  " + responseBody);
		//Assert.assertTrue(responseBody.contains("Post "+ String.valueOf(arg1)));
		
		JsonPath jsonPathEvaluator = response.jsonPath();
	
		int id = jsonPathEvaluator.get("id");
		//System.out.println(id);
		Assert.assertEquals(arg1, id);
	    
		// Get specific element from JSON document 
	    
		String title = jsonPathEvaluator.get("title");
		//System.out.println(title);
		//System.out.println("Post "+arg2);
	    
	    Assert.assertTrue(title.equalsIgnoreCase("Post "+arg2));
	    
	  
	}
	


}
