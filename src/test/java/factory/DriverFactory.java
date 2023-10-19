package factory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	//For sequencial driver we can run this way
	//private static WebDriver driver;
	
	//private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver initializeDriver(String browser)
	{   
		//For parallel execution
		WebDriver driver=null;
	        switch (browser) {
			case "firefox":

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				break;
			case "ie":

				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				break;

			case "edge":

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				// driver.manage().deleteAllCookies();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				options.addArguments("--remote-allow-origins=*"); //when chrome throw error "Unable to establish"
				// options.addArguments("--incognito");

				// Additional options
				options.addArguments("chrome.switches", "--disable-extensions");
				options.addArguments("--start-maximized");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("test-type", "start-maximized", "no-default-browser-check");

				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				break;
			}

	        //DriverFactory.driver.set(driver);
	        return driver;
	        
	        
	}
	

	
	//now directly user call getDriver method it will return WebDriver value, no need to double check for
	//wether driver is null or not
	/*public static WebDriver getDriver()
	{
		return driver.get();
	}*/
	

}
