package core;
/* PageFactory API is initializing WebElement to support FindBy annotation
 * 
 * 
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    protected WebDriver driver;
    private WebDriverWait wait;
      
    public BasePage(WebDriver driver) throws Exception {
        this.driver = driver;
      
        PageFactory.initElements(driver, this);
    }
}