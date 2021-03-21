package student;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import dataProvider.ConfigFileReader;
import core.open_browser;
import page_object.login_page;
import page_object.student_page;
import page_object.home_page;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import dataProvider.student_reader;

public class Karros_demo_test extends open_browser{
	
	ConfigFileReader configFileReader_test;
	
	student_reader studentReader_test;
	
	WebDriver driver;
	
	@BeforeTest
	
	//Launch login page and login with correct user/pass before any testing
	
	public void LoginFirefox() throws Exception {
		
		configFileReader_test= new ConfigFileReader();
	
		String url = "https://systemmanagement-stage.karrostech.io/login";
		//Open web browser with given URL
		driver = open_browser.getDriver("E", url); //"F" with under Firefox, "C" Chrome
	    
		System.out.print("Open " + url + " in Firefox");
	    //Create login instant.
		login_page login = new login_page(driver);
	    
		//Get user and password from user_pass.properties, and fill to login
		
		Boolean result = login.login(configFileReader_test.getUsername(),configFileReader_test.getPassword());
	    
		Thread.sleep(3000);
	    
		if (result == false) {
	    
			System.out.print("Could not reach Login page, exit test");
	    	
			open_browser.quitDriver();
	    	
		}
	}
	
@Test
	public void verify_student() throws Exception {

	try {
		
		studentReader_test = new student_reader();
		
		Thread.sleep(2000);
		
		home_page home = new home_page(driver);
		
		student_page student = new student_page(driver);
		
		home.click_student_link();
		
		Boolean result = student.verify_student();
		
		/* check if all stduent_id are in the list 
		 * PASSED: found 
		 * FAILED Otherwise
		 */
			assertEquals(result, true);
		
	}
		catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
@Test
	public void filter_school() throws Exception {
	
	try {
		Thread.sleep(2000);
		
		studentReader_test = new student_reader();
		
		home_page home = new home_page(driver);
		
		student_page student = new student_page(driver);
		
		home.click_student_link();
		
		Boolean result = student.filter_school(studentReader_test.get_school_name());
		
		/* check if table is empty >>> no student in this school
		 * PASSED: all entries list should be equal to input School name 
		 * FAILED Otherwise
		 */
		assertEquals(result, true);
	}
		catch (InterruptedException e) {
	
			e.printStackTrace();
	}
}
	@AfterTest
	public void tearDown() throws Exception {
		// Close the browser
		
		Thread.sleep(3000);
		
		open_browser.quitDriver();//closes the browser window which is currently in focus.
	}
}
