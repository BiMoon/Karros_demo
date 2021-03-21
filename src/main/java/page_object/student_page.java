package page_object;

/* Elements and functions on student_page
 * shoud be defind here.
 * For demo, just list  elements of Student link 
 * to access Student page
 * Assuming we are already in Student_Page
 */
import org.openqa.selenium.WebDriver;
import core.BasePage;
import core.open_browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class student_page extends BasePage{
	
	public student_page(WebDriver driver) throws Exception {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@routerlink='/student-management/student']") //student link
	private WebElement student;
	
	@FindBy(xpath = "//button[@class='mat-raised-button mat-button-base mat-primary']") //add_student
	private WebElement add_student;
	
	@FindBy(xpath = "//button[@class='sm-button mat-raised-button mat-button-base']") //cancel button
	private WebElement cancel_bt;
	
	@FindBy(xpath = "//button[@class='sm-button mat-raised-button mat-button-base mat-primary']") //cancel button
	private WebElement add_bt;
	
	@FindBy(xpath = "//input[@placeholder='Enter first name']") //firstname
	private WebElement first_name;
	
	@FindBy(xpath = "//input[@placeholder='Choose a date']") //birthday
	private WebElement birth_day;
	
	@FindBy(xpath = "//input[@placeholder='Enter student ID']") //student_id
	private WebElement student_id;
	
	@FindBy(xpath = "//input[@placeholder='Enter last name']") //last name
	private WebElement last_name;
	
	@FindBy(xpath = "//input[@placeholder='Enter School']") //school name
	private WebElement school_name;
	
	@FindBy(xpath = "//input[@placeholder='Enter legacy student ID']") //Enter legacy student ID
	private WebElement legacy_student_ID;
	
	@FindBy(xpath = "//input[@placeholder='Enter grade']") //Enter legacy student ID
	private WebElement grade;
	
	@FindBy(xpath = "//input[@id='schoolName']") //school filer 
	private WebElement sh_filter;
	
	@FindBy(xpath = "//mat-icon[@aria-label='Filter']") //search filter button
	private WebElement search_bt;
	
	@FindBy(xpath = "//mat-icon[@aria-label='Clear all filters']") //clear filter button
	private WebElement clear_bt;
	
	@FindBy(xpath = "//button[@aria-label='Next page']") //button next page available
	private WebElement next_bt;
	
	
	public void click_student() {
		
		try {
			
			Thread.sleep(5);
			
			System.out.print("clicking Student link, wait for page load completed");
			
			student.click();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}
	public void click_add_student() {
		
		try {
			
			Thread.sleep(5);
			
			System.out.print("Clicking ADD STUDENT button ");
			
			add_student.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void fill_student(String input_f_name, String input_l_name,String input_b_day , String input_grade, String input_student_id, String input_school_name, String input_lagacy_id) {
		
		try {
			Thread.sleep(5);
			System.out.print("Filling STUDENT info ");
			first_name.sendKeys(input_f_name);
			grade.sendKeys(input_grade);
			birth_day.sendKeys(input_b_day);
			student_id.sendKeys(input_student_id);
			last_name.sendKeys(input_l_name);
			legacy_student_ID.sendKeys(input_lagacy_id);
			school_name.sendKeys(input_school_name);
			//cancel_bt.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean filter_school(String school_name) {
			
			/* check if table is empty >>> Print no student in this school
			 * PASSED: all entries list should be equal to input School name 
			 * Otherwise FAILED	
			 */
			Boolean found = true;
			
					
			try {
			
				Thread.sleep(2000);
				sh_filter.clear();
	
				sh_filter.sendKeys(school_name);
	
				search_bt.click();
				try {
					
					Thread.sleep(3000);
					List rows_table = driver.findElements(By.tagName("mat-row"));
					//System.out.println("No of cols are : " +rows_table.size()); 
					
					int rows_count = rows_table.size();
					
					if (rows_count == 0) {System.out.println("There is no such School found");}
					
					else {	
						//Loop will execute till the last row of table.
					    for (int row=0; row<rows_count; row++){
					    	//To locate columns(cells) of that specific row.
					    	List<WebElement> Columns_row = ((WebElement) rows_table.get(row)).findElements(By.tagName("mat-cell"));
					    	//Get School name of each listed entries
					    	String id_school = Columns_row.get(4).getText();
					    	
					    	
					    	if (!school_name.equals(id_school))
					        
					        {  found = true; // expect all entries have same school name as school_name parameter, if not result FAILED
					         	break;
					         }
					    }
					}
				    if (!found) {System.out.println("Something wrong with filter");}
					else 
						{ System.out.println("Filter works correctly");}
					}
			    finally {};
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return found;
		}
	
	public Boolean verify_student() throws CsvValidationException, Exception {
	
		String CSV_PATH="src//test//resources//data_input//Student_input.csv";
	
		//Clear filter first before query col/row of student 
		clear_bt.click();
		
		CSVReader reader_id = new CSVReader(new FileReader(CSV_PATH));
		
		List<String> list_id = new ArrayList<String>(); 
		
		Boolean found = true;
		
		Boolean next;
		
		try {
		
			Thread.sleep(3000);
		
			do {
			
				try {
				
					Thread.sleep(3000);
					  
					List rows_table_temp = driver.findElements(By.tagName("mat-row"));
					//number of rows Student after table is loaded.
					int rows_count_id = rows_table_temp.size();
				    //Iterator each row to reach col of Student id
					for (int row_id = 0; row_id <rows_count_id; row_id ++)
				    	{
				    	List<WebElement> Columns_row_id = ((WebElement) rows_table_temp.get(row_id)).findElements(By.tagName("mat-cell"));
				    	//Get Student ID
				    	String id_row = Columns_row_id.get(5).getText();
				    	// Add the Student_id to the a temp list of iD.
				    	list_id.add(id_row);
				    	}
				    //Get status of next page button
					next = next_bt.isEnabled();
				    //Go to next page if any
				    next_bt.click();
					}
				    finally {};
				
			} while (next == true);
		    
			String[] csvCell;
			//Iterator each row of student_id input in CVS file until null
			while ((csvCell = reader_id.readNext()) != null) {   
				  
				 String id_search = csvCell[0];
				 //Return True if student_id of current row matches element in list of Student_id, false otherwise  
				 Boolean found_id = list_id.contains(id_search);
				 
				 System.out.print("Searching student ID: "+ id_search +" pls wait ...");
					
				 	if (found_id == true) {System.out.print("Student " + id_search +" is added successfully" +"\n");}
				 	else 
				 	{
				 		System.out.println("Student is " +id_search + " NOT added successfully");
				 
				 		found = false;
				 	}
				 }
			 

		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return found;
		}
}
	
