Feature: Search functionality
  Background:
    Given user is on landingPage
    Then user click on search input field

  Scenario: Verify that user is able to search the product by entering full name of product
    When user enter "cucumber" in search input
    Then that product should appear in result.


