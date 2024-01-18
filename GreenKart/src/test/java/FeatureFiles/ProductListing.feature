Feature: Product Listing should be correct
  Scenario: Verify that product's image are not broken
    Given user is on landingPage
    When all products appears
    Then product images are not broken

#  Scenario: Verify that product's details are correct with test data
#    Given user is on landingPage
#    When all products appears
#    Then product details are same as jsonData

