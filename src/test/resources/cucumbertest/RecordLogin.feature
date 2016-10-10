Feature: Website should have secured login for collection


  Scenario: Check collection page can only accessed when login so you get redirected to login screen
    Given I'm on my website
    When i click on collection tab
    Then i get redirected to login page
    And  i fill in my username and password
    Then i see my collection

