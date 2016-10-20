@NewRecord
Feature: Test if new record gets saved

  Background:
    Given I'am on the RecordCollector Website
    And Logged in to the website
    And I'm on the Collection Page

    Scenario: populate the record form and submit
      When I enter "Jimi Hendrix" into the artist field
      And I enter "Rainbow Bridge" into the album field
      And I enter "1969-07-18" into the year_of_release field
      And I enter "blabla " into the label field
      And I select "LP" into the format field
      And I enter "10.50" into the price field
      And I hit the submit button
      Then I see the newly added record in the database table
      And I close the browser


