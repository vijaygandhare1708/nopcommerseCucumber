package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	

	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
		
	}

	By customersMenu=By.xpath("//a[@href='#']/i[@class='nav-icon far fa-user']");
	By customerOpt=By.xpath("//li[@class='nav-item']//a[@href='/Admin/Customer/List']");
	
	By expandToggleBtn=By.xpath("//i[@class='fa toggle-icon fa-plus']");
	
	By addNewCust=By.xpath("//a[@href='/Admin/Customer/Create']");
	
	By email=By.xpath("//input[@id='Email']");
	
	By password=By.xpath("//input[@id='Password']");
	
	By firstName=By.xpath("//input[@id='FirstName']");
	
	By lastName=By.xpath("//input[@id='LastName']");
	
	By genderMale=By.xpath("//input[@id='Gender_Male']");
	By genderFemale=By.xpath("//input[@id='Gender_Female']");
	
	
	//calender
	By dob=By.xpath("//input[@id='DateOfBirth']");
	
	By company=By.xpath("//input[@id='Company']");
	
	By chckboxTaxEx=By.xpath("//input[@id='IsTaxExempt']");
	
	By newsLetter=By.xpath("//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']");

	By newsLetFirstOpt=By.xpath("//li[contains(text(),'Your store name')]");
	
	By custRoles=By.cssSelector("div.input-group-append.input-group-required");
	
	By lstitemRegistred=By.xpath("//li[contains(text(),'Registered')]");
	
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	

	By lstitemForumModerator=By.xpath("//li[contains(text(),'Forum Moderators')]");
	
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	
	By drpVendorId=By.xpath("//select[@id='VendorId']");//write select class code in funtion
	By adminComment=By.xpath("//textarea[@name='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	
	
	public String getTitle() {
		return ldriver.getTitle();
	}
	
	public void clickCustomerMenu() {
		ldriver.findElement(customersMenu).click();
	}
	public void clickCustomerOption() {
		ldriver.findElement(customerOpt).click();
	}
	public void clicktoggleBtn() {
		ldriver.findElement(expandToggleBtn).click();
	}
	public void addNewCustomer() {
		ldriver.findElement(addNewCust).click();
		
	}
	public void setNewCustomerEmail(String custemail) {
		ldriver.findElement(email).sendKeys(custemail);
		
	}
	public void setNewCustomerPassword(String pass) {
		ldriver.findElement(password).sendKeys(pass);
		
	}
	public void setFirstName(String name) {
		ldriver.findElement(firstName).sendKeys(name);
		
	}
	public void setLastName(String lname) {
		ldriver.findElement(lastName).sendKeys(lname);
		
	}

	/*
	 * public void clickGender() { ldriver.findElement(gender).click();
	 * 
	 * }
	 */
	public void setCompany(String companyName) {
		ldriver.findElement(company).sendKeys(companyName);
		
	}
	public void clickChckBoxTaxExempted() {
		ldriver.findElement(chckboxTaxEx).click();
		
	}

	/*
	 * public void clickNeweLetter() {
	 * 
	 * ldriver.findElement(newsLetFirstOpt).click();
	 * 
	 * }
	 */
	public void clickNeweLetterFirstOption() {
		ldriver.findElement(newsLetFirstOpt).click();
		
	}
	public void clickCustomerRoles(String role) {
		
		if(role!="Vendors") {
			
			ldriver.findElement(By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']"));
			//ldriver.findElement(By.css("div.input-group-append.input-group-required")); need to be used check this again
			}
		
          ldriver.findElement(custRoles).click();
          WebElement listitem = null;
          if(role.equals("Administrators")) {
        	  listitem=ldriver.findElement(lstitemAdministrators);
          }
          else if(role.equals("Forum Moderators")){
        	  listitem=ldriver.findElement(lstitemForumModerator);
          }
          else if(role.equals("Guests")){
        	  listitem=ldriver.findElement(lstitemGuests);
          }
          else if(role.equals("Vendors")){
        	  listitem=ldriver.findElement(lstitemVendors);
          }
          else if(role.equals("Registered")){
        	  listitem=ldriver.findElement(lstitemRegistred);
          }
          listitem.click();// when webdriver unable to click below code will work
          JavascriptExecutor js= (JavascriptExecutor)ldriver;
          js.executeScript("arguments[0].click;",listitem);
	}
	public void setManagerOfvendor(String value) {
		Select drpOptions=new Select(ldriver.findElement(drpVendorId));
		drpOptions.selectByVisibleText(value);
		
	}
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			ldriver.findElement(genderMale).click();
		}
		else if(gender.equals("Female")) {
			ldriver.findElement(genderFemale).click();
		}
		else {
			//default conditions
			ldriver.findElement(genderMale).click();
		}
		
	}
	public void setDob(String date) {
		ldriver.findElement(dob).sendKeys(date);
	}
	public void setAdminComment(String aComment) {
		ldriver.findElement(adminComment).sendKeys(aComment);
	}
	public void clickSave() {
		ldriver.findElement(btnSave).click();
	}
	public void clicknewwletterdrp() {
		JavascriptExecutor js= (JavascriptExecutor)ldriver;
		js.executeScript("window.scrollBy(0,250)", "");
		ldriver.findElement(newsLetter).click();
	}
}
