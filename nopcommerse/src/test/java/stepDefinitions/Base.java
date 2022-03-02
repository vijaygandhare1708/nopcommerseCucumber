package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Base 
{
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addcust;
	public SearchCustomerPage searchCust;
	public Properties prop;
	public static Logger logger;
	
	public WebDriver initializer() throws IOException {
		 prop=new Properties();
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\utilitities\\data.properties");
		 
		 prop.load(fis);
		 String browserName = prop.getProperty("browser");
		 
		 if (browserName.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\chromedriver.exe");
				
				driver = new ChromeDriver();
				//driver.manage().window().maximize();

			} else if (browserName.equals("firefox")) {

				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\geckodriver.exe");
				
				driver = new FirefoxDriver();
			}
		 
		 
		 return driver;
	}
	
	//for the random email string creation.
	public static String randomString() {
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

}
