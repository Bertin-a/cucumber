Feature: Login Functionality Feature
  In order to do internet banking
  As a valid Para Bank Customer
  I want to login successfully

  Scenario:
    Given I am in the login page of the Para Bank Application
    When I enter valid credentials
    Then I should be taken to the overview page
