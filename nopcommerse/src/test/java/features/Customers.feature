@AddCustomer
Feature: Customer feature
Background:
    Given user launch the chorme browser
    
    When user opens the url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enter the email as "admin@yourstore.com" and  password as "admin"
    And clicks on login
    
    Then user able to see the dashboard
 Scenario: add new customer
    
    When user clicks on customer menu
    And user clicks on customer menu item
    And click on add new button
    Then user is able to view the add new customer page
    When user enters the new customer info
    And clicks on save button
    Then user can view the confirmation message "The new customer has been added successfully"
    And close browser
@SearchCustomer  
Scenario: search customer by email id
  
    When user clicks on customer menu
    And user clicks on customer menu item
    And enter customer email
    When click on search button
    Then user should be able to find the email in search table
    And close browser
@SearchCustomerName
Scenario: search customer by name
     
    When user clicks on customer menu
    And user clicks on customer menu item
    And enter customer firstName
    And enter customer lastName
    When click on search button
    Then user should be able to find the name in search table
    And close browser

