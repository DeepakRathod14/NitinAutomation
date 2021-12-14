# This is just your test case name and description
Feature: This is sample-1 feature file for learning
  this is description line-1
  line-2
  
  Background: this is background call
		Given some precondition
		And perform steps before each scenario
		
  #Example-1 for default steps
  @Sanity @Regression @System @POC
  Scenario: this is scenario01
    Given Open browser
    When load expected page
    And enter username and password
    But click on submit button
    And Verify login successfull
    Then close Browser

  #Example-2 for parameterized scenario
  @Sanity @Regression @System @POC
  Scenario: this is scenario02
    Given Open browser
    When load expected page
    And enter username as "deepak.rathod@gmail.com" and password as "abc"
