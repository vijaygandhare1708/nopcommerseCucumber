package stepDefinitions;

import java.io.IOException;
import java.sql.Driver;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends Base {

	@Given("user launch the chorme browser")
	public void user_launch_the_chorme_browser() throws IOException {

		/*
		 * //log4j properties logger=(org.apache.logging.log4j.Logger)
		 * Logger.getLogger("nopcommerse");
		 * PropertyConfigurator.configure("log4j.properties");
		 */
		
		
		/*
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + "\\src\\test\\java\\drivers\\chromedriver.exe"); driver = new
		 * ChromeDriver();
		 */
		driver=initializer();
		
		//logger.info("******************browser lanuched successfully");
		
		lp = new LoginPage(driver);

		
	}

	@When("user opens the url {string}")
	public void user_opens_the_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}

	@When("user enter the email as {string} and  password as {string}")
	public void user_enter_the_email_as_and_password_as(String email, String password) {
		//logger.info("******************user able to see login page");
		lp.setUsername(email);
		lp.setPassword(password);

	}

	@When("clicks on login")
	public void clicks_on_login() {
		lp.clicklogin();

		//logger.info("******************user able to click on login ");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		if (driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.")) {
			driver.close();

			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}

		//needed wait in firefox
		Thread.sleep(5000);
	}

	@When("user clicks on logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
		lp.clicklogout();
		//logger.info("******************user able to click on  logout link");
		Thread.sleep(3000);

	}

	@Then("close browser")
	public void close_browser() {

		driver.quit();
	}
//Customer features step definitions.

	@Then("user able to see the dashboard")
	public void user_able_to_see_the_dashboard() throws InterruptedException {
		addcust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getTitle());
		Thread.sleep(5000);
		//logger.info("******************user able to see dashboard page");

	}

	@When("user clicks on customer menu")
	public void user_clicks_on_customer_menu() throws InterruptedException {
		Thread.sleep(5000);
		addcust.clickCustomerMenu();
		//logger.info("******************user able to click on customer menu ");
	}

	@When("user clicks on customer menu item")
	public void user_clicks_on_customer_menu_item() throws InterruptedException {
		addcust.clickCustomerOption();
		Thread.sleep(5000);
	}

	@When("click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addcust.addNewCustomer();
		Thread.sleep(2000);
		// addcust.clicktoggleBtn();
		//logger.info("******************user able to click on add customer button");
	}

	@Then("user is able to view the add new customer page")
	public void user_is_able_to_view_the_add_new_customer_page() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getTitle());
	}

	@When("user enters the new customer info")
	public void user_enters_the_new_customer_info() throws InterruptedException {
		String email = randomString() + "@gmail.com";
		addcust.setNewCustomerEmail(email);
		addcust.setNewCustomerPassword("12132");
		addcust.setFirstName("vijay");
		addcust.setLastName("gandhare");
		addcust.setGender("Male");
		addcust.setDob("08/17/1992");// mm-dd-yyy
		addcust.setCompany("LTI");
		addcust.clickChckBoxTaxExempted();
		Thread.sleep(10000);
		// addcust.clicknewwletterdrp();
		// addcust.clickNeweLetter();
		// addcust.clickNeweLetterFirstOption();
		/*
		 * for the role:registered is default and it can't be both guest and registered
		 * 
		 */
	
		addcust.clickCustomerRoles("Administrators");
		Thread.sleep(10000);
		addcust.setManagerOfvendor("Vendor 1");
		addcust.setAdminComment("test data");
		Thread.sleep(5000);
		//logger.info("******************user able to add the details");

	}

	@When("clicks on save button")
	public void clicks_on_save_button() throws InterruptedException {
		addcust.clickSave();
		Thread.sleep(10000);
		//logger.info("******************user able to add customer details and save");
	}

	@Then("user can view the confirmation message {string}")
	public void user_can_view_the_confirmation_message(String successMsg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));

	}
	
	//searching customer using email id
	
	@When("enter customer email")
	public void enter_customer_email() throws InterruptedException {
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmailToSearch("brenda_lindgren@nopCommerce.com");
		Thread.sleep(3000);
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickOnSearch();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
	}

	@Then("user should be able to find the email in search table")
	public void user_should_be_able_to_find_the_email_in_search_table() {
		boolean status=searchCust.searchCustomerByEmailId("brenda_lindgren@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	//search customer using the firstName and lastName
	@When("enter customer firstName")
	public void enter_customer_firstName() {
		searchCust=new SearchCustomerPage(driver);
		searchCust.serachWithFirstName("Victoria");
		
	}

	@When("enter customer lastName")
	public void enter_customer_lastName() {
		searchCust.serachWithLastName("Terces");
	}
	
	@Then("user should be able to find the name in search table")
	public void user_should_be_able_to_find_the_name_in_search_table() {
		boolean status=searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true,status);
	}
}
