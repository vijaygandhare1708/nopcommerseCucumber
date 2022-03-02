package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilitities.WaitHelper;

public class SearchCustomerPage 
{
	public WebDriver ldriver;
	public WaitHelper waithelper;
	public SearchCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
	}

	@FindBy(how= How.ID,using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how= How.ID,using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how= How.ID,using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how= How.ID,using="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpDobMonth;
	
	@FindBy(how= How.ID,using="SearchDayOfBirth")
	@CacheLookup
	WebElement drpDayOfMonth;
	
	@FindBy(how= How.ID,using="SearchCompany")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(how= How.ID,using="SearchIpAddress")
	@CacheLookup
	WebElement txtIpAddress;
	
	@FindBy(how= How.ID,using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	
	@FindBy(how= How.XPATH,using="//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtCustomerRoles;
	
	
	@FindBy(how= How.XPATH,using="//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement lstItemAdministrator;
	
	@FindBy(how= How.XPATH,using="//li[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement lstItemForumModerators;
	
	@FindBy(how= How.XPATH,using="//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement lstItemGuests;
	
	@FindBy(how= How.XPATH,using="//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement lstItemVendors;
	
	@FindBy(how= How.XPATH,using="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how= How.XPATH,using="//div[@id='customers-grid_wrapper']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how= How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tblRows;
	
	@FindBy(how= How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tblColumns;
	
	//for firstname and lastname
	@FindBy(how= How.XPATH,using="//input[@id='SearchFirstName']")
	@CacheLookup
	WebElement SearchFirstName;
	
	@FindBy(how= How.XPATH,using="//input[@id='SearchLastName']")
	@CacheLookup
	WebElement SearchLastName;
	
	public void setEmailToSearch(String email) {
		waithelper.waitForElement(txtEmail, 15);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void setFirstName(String fname) {
		waithelper.waitForElement(txtEmail, 15);
		txtEmail.clear();
		txtEmail.sendKeys(fname);
	}
	public void setLastName(String lname) {
		waithelper.waitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(lname);
	}
	
	public void serachWithFirstName(String fname) {
		//SearchFirstName.clear();
		SearchFirstName.sendKeys(fname);
	}
	
	public void serachWithLastName(String lname) {
		//SearchFirstName.clear();
		SearchLastName.sendKeys(lname);
	}
	
	public void clickOnSearch() {
		waithelper.waitForElement(btnSearch, 30);
		//btnSearch.clear();
		btnSearch.click();
		/*
		 * JavascriptExecutor js= (JavascriptExecutor)ldriver;
		 * js.executeScript("window.scrollBy(0,250)", "");
		 */
	}
	
	public int getNoOfRows() {
		return(tblRows.size());
		
	}
	
	public int getNoOfColumns() {
		return(tblColumns.size());
		
		}
	public boolean searchCustomerByEmailId(String email) {
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++) {
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr")).getText();
			
			System.out.println(emailid);
			System.out.println("===============================================");
			
			if(emailid.equals("brenda_lindgren@nopCommerce.com Brenda Lindgren Registered Edit")) {
				flag=true;
			}
		}
		
		
		
		return flag;
	}
	
	
	public boolean searchCustomerByName(String Name) {
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++) {
			String name=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			
			
			String names[]=name.split(" ");// to separate the firstname and last name
			
			System.out.println("===============================================");
			
			if(names[0].equals("Victoria") && names[1].equals("Terces")) {
				flag=true;
			}
		}
		
		
		
		return flag;
}

}
