Feature: Buttons are clickable on landingPage
  Background:
    Given user is on landingPage

  Scenario: Verify the AddToCart button is clickable
    When  user click on AddToCart button Once
    Then product count should be 1

  Scenario: Verify user is able to increase product qty
    When user increase the product quantity by 2
    Then quantity should appear 2
    When user click on AddToCart button Once
    Then product count should be 1


#  -------------------------------------
#    Then quantity should appear 2
#    And user should able to decrease quantity to minimum
