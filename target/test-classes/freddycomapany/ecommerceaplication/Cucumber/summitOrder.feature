@Tags
Feature: Summit Order

  Background:
	Given  landing to ecommerce page
	
  @Regression		
  Scenario Outline: Check Out Order Process
    Given that user login with <username> and <password>
    When add product <productname> to card and go it
    And check out the product <productname> in country <intialLetters> and finally <country>
    Then must displayed "THANKYOU FOR THE ORDER." susses messages
    
  Examples:
      | username   | password   | productname | intialLetters | country |
      | prueba2@hotmail.comX   | g3sUYi@2NmPHT67  | ZARA COAT 3  | ind  | india |
	
   