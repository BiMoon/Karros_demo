package page_object;
/* Elements and functions on Home_page
 * shoud be defind here.
 * For demo, just list  element of Student link 
 * to access Student page
 * Assuming we are already in HomePage
 */
import org.openqa.selenium.WebDriver;
import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class home_page extends BasePage{
	
	@FindBy(xpath = "//*[@routerlink='/student-management/student']") //student link
	private WebElement student;
	
	@FindBy(xpath = "//button[@class='mat-raised-button mat-button-base mat-primary']") //add_student
	private WebElement add_student;
	public home_page(WebDriver driver) throws Exception {
		super(driver);
	
	}
	public void click_student_link() {
		
		try {
			Thread.sleep(5);
			System.out.print("Click on Student link, wait for page load complete" + "\n");
			student.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
