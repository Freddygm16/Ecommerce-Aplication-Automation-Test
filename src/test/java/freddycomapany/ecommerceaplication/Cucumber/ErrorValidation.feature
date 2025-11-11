@Tags
Feature: Summit Order
	
  @Smoked
  Scenario Outline: Error Validation Test
    Given landing to ecommerce page
    When that user login with <username> and <password>
    Then must displayed "Incorrect email or password." error messages
    
  Examples:
      | username   | password   | productname |
      | prueba2@hotmaasawsl.comX   | g3sUYi@2NmPHT67  | ZARA COAT   |
	
   