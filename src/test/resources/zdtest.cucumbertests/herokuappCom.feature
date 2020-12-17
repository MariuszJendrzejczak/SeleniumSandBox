Feature: internet.herokuapp.com. feature
  Scenario: Login to herokuapp.com
    Given Open herokuapp.com page
    When Type valid userneme
    And Typ valid password
    And Click login button
    Then Move to user dashboard
    And Click logout button
