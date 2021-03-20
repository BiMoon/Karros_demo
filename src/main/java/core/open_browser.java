package core;

/**
 * Open a selected Browser, pass "F" or "E" and url as argument when calling
 *     "F" open Firefox
 *     "E" open Ms Edge
 *     "C" open Chrome
 * Return a open browser with url of home page need to test       
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class open_browser {
	private static WebDriver webdriver;
    private static final String operatingSystem =	System.getProperty("os.name").toUpperCase();
    private static final String systemArchitecture = System.getProperty("os.arch");
    
    public static WebDriver getDriver(String br, String request) throws Exception {
    	
        if (null == webdriver) {
            System.out.println(" ");
            System.out.println("Current Operating System: " + operatingSystem);
            System.out.println("Current Architecture: " + systemArchitecture);

            System.out.println(" ");
            
            // Open FireFox if "F" as argument 
            if (br == "F") {
                System.out.println("Current Browser Selection:Firefox" +"\n");
                System.setProperty("webdriver.gecko.driver",
                		"src\\test\\resources\\driver\\geckodriver.exe");
                webdriver = new FirefoxDriver();
                webdriver.manage().window().maximize();

            }
            // Open MS Edge if "E" as argument  
            else if (br == "E") {
                System.out.println("Current Browser Selection:MS_Egde" + "\n");
                System.setProperty("webdriver.edge.driver",
                		"src\\test\\resources\\driver\\msedgedriver.exe");
                EdgeOptions options = new EdgeOptions();
                options.setPageLoadStrategy("eager");
                // Launch a new Edge instance
                webdriver = new EdgeDriver(options);
                webdriver.manage().window().maximize();
            }
            // Open Chrome if "C" as argument 
            else {
            	
            	System.out.println("Current Browser Selection:Chrome" + "\n");
                System.setProperty("webdriver.chrome.driver",
                		"./src/test/resources/drivers/chromedriver.exe");
                webdriver = new ChromeDriver();
                webdriver.manage().window().maximize();
            }
                   }
        
        else {
        	System.out.println("\n" +"Already have Webdriver instant");
        	System.out.println(" ");
            if (br == "F") {
                System.out.println("Current Browser Selection:Firefox" + "\n");
                webdriver = new FirefoxDriver();
                webdriver.manage().window().maximize();

            }
            else {
                System.out.println("Current Browser Selection:MS_Egde" + "\n");
                System.setProperty("webdriver.edge.driver","msedgedriver.exe");
                EdgeOptions options = new EdgeOptions();
                options.setPageLoadStrategy("eager");
                // Launch a new Edge instance
                webdriver = new EdgeDriver(options);
                webdriver.manage().window().maximize();
            }

        }
        
        webdriver.get(request);
        return webdriver;
    }

    public static void quitDriver() {
        if (null != webdriver) {
            webdriver.close(); //closes the browser window which is currently in focus.
     
        }
    }
}
