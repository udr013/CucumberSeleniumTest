@WebFeature
Feature: Website should have secured login for collection

#  Background:
#    Given I'm on my website

  @Web
  Scenario Outline: Check collection page can only accessed when login so you get redirected to login screen

    Then i click on <link>
#    Then i click on "Contact" tab
#    Then i click on "Collection" tab
#    Then i get redirected to login page
#    And i close the browser



    When i click on "Collection" tab
    And i fill in my username and password
      | fields   | value |
      | username | mark  |
      | password | test  |
    Then i see my collection

    Examples:
      | link       |
      | About      |
      | Contact    |
      | News       |
      | Login      |
      | Logout     |
      | Collection |


