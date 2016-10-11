Feature: Website should have secured login for collection


  Scenario: Check collection page can only accessed when login so you get redirected to login screen
    Given I'm on my website
    Then i click on "About" tab
    Then i click on "Contact" tab
    Then i click on "Collection" tab
    Then i get redirected to login page
    And  i fill in my username and password
      | fields   | value |
      | username | mark  |
      | password | test  |

    Then i see my collection
    Then i click on "About" tab
    Then i click on "Contact" tab
    Then i click on "Logout" tab
    And i close the browser
