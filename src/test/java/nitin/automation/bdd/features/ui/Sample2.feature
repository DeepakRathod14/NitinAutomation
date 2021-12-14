# This is just your test case name and description
Feature: This is sample-2 feature file for learning
  this is description line-1
  line-2

  #Example-3 for scenario outline
  @Regression @System
  Scenario Outline: Example of DataProvider
    Given Open browser
    When load expected page
    And enter username as <username> and password as <password>
    But click on submit button

    Examples: 
      | username           | password |
      | "nitin@gmail.com"  | "abc"    |
      | "deepak@gmail.com" | "def"    |
      | "qa@gmail.com"     | "xyz"    |

  #Example-4 for data table
  @System
  Scenario: this is scenario01
    Given Open browser
    When load expected page
    And enter username and password
    But click on submit button
    Then verify list of options should be display
      | Dashboard | ABC | Testing | QA  |
      | Wiki      | XYZ | manual  | DEV |
      | File      | DEF | java    | AI  |
      | Isheet    | KEF | python  | ML  |

  #| Dashboard     | 1 |
  #| Wiki          | 2 |
  #| Isheet        | 3 |
  #| File          | 3 |
  #| Admin         | 2 |
  #| Configuration | 1 |
 
  #Example-5 for parameterized scenario <Integer, Float, char>
  @System
  Scenario: this is scenario02
    Given Open browser
    When load expected page
    And parameter of integer is 10 and float is 10.24 and char 'a'
