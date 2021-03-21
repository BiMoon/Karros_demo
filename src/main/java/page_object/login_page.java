package page_object;
/* Open login Page 
 * Use Findby to declare webElement of Login page
 * Define function for button, link text ... of Login page
 * 
 */
import org.openqa.selenium.WebDriver;
import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

public class login_page extends BasePage {
	
	@FindBy(xpath = "//*[@id='mat-input-0']") //user name
	private WebElement user_send;
	
	@FindBy(xpath = "//*[@id='mat-input-1']") //password
	private WebElement pass_send;
	
	@FindBy(xpath = "//button[@type='submit']") //login button
	private WebElement login_bt;
	
	@FindBy(xpath = "//*[@routerlink='/student-management/student']") //student link
	private WebElement student;
	
	public login_page(WebDriver driver) throws Exception {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public Boolean login(String user, String pass) throws Exception {
		///////////////////////////////////////////////////////////
		/* get user pass from properties file
		 * As in login page, entering correct user/pass
		 * Try Click LOGIN button every 3s
		 * until Home page does appear
		 */
		///////////////////////////////////////////////////////////
		WebDriverWait wait = new WebDriverWait(driver, 15, 30);
		wait.until(ExpectedConditions.elementToBeClickable(login_bt));
	
		if (login_bt.isDisplayed()){
			
			System.out.println("\n" +"Login page is displayed");
			
			System.out.println("\n" +"Entering username/password");
			
			user_send.sendKeys(user);
			
			pass_send.sendKeys(pass);
			
			while (driver.getTitle().contains("Login"))
				{
					login_bt.click();
					Thread.sleep(4000);
					}
			
			return true;
		 }
		
		else 
		{
			System.out.println("\n" +"Login page could not be displayed");
			return false;
		}

	}
	public Boolean verify_login_ok () throws Exception {
		
		 /*//////////////////////////////////////////////////////// 
		 * verify the next page after clicking Login button
		 * Return true if The page title be show as "Home ..."
		 * Return false otherwise 
		 *////////////////////////////////////////////////////////
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("\n" + title);
		return true;
	}

}
