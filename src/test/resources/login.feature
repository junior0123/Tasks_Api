Feature: login in the website test-api.k6.io
  
  Scenario: Login with valid credentials
    Given a user with valid credentials
    When the user enters his name "junior0123" and password "test123" 
    And send the information to the website
    Then the user see a status code is ok
    And and see correct login information

  Scenario: Login with invalid credentials
    Given a user with invalid credentials
    When the user enters his invalid username "junior0123" and password "junior012" 
    And send the invalid information to the website
    Then the user see a bad request 
    

