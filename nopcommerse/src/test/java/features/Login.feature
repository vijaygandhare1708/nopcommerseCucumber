@Login
Feature: user login
 Scenario: successful login with valid credentials
    Given user launch the chorme browser
    When user opens the url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enter the email as "admin@yourstore.com" and  password as "admin"
    And clicks on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on logout link
    Then page title should be "Your store. Login"
    And close browser
    
Scenario Outline: login data driven

Given user launch the chorme browser
    When user opens the url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enter the email as "<email>" and  password as "<password>"
    And clicks on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on logout link
    Then page title should be "Your store. Login"
    And close browser

    Examples:
    |email        |password|
    |admin@yourstore.com|admin|
    |admin@yourstore.com|admin|