package com.tap.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.tap.test.util.Utilities;

/**
 * 
 * @author Sowmiya
 *
 */
public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;

	/**
	 * Constructor to initialize property file
	 */
	public BaseTest(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\com\\tap\\test\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to initialize WebDriver and launch url
	 */
	public static void initialization(){
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.IMPLICIT_WAIT)); 
		driver.get(prop.getProperty("url"));
	}

	/**
	 * Method to select value from dropdown by visible text
	 * @param element
	 * @param value
	 */
	public void selectFromDropdownVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	/**
	 * Method to switch to frame by index
	 * @param index
	 */
	public void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * Method to switch to main window from frame
	 */
	public void switchFrameToDefault() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Method to switch to alert
	 * @return instance of alert
	 */
	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}	

	/**
	 * Method to get first selected option from dropdown
	 * @param element
	 * @return first selected option from dropdown
	 */
	public String getFirstSelectedOptionFromDropdown(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}	
}
