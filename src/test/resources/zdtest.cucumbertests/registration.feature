Feature: Registration feature
  Scenario: Register account on automationpractice.com
    Given Open automationpractice.com page
    When  User type "daliah17@zwwaltered.com" as email
    And User click Submit button
    And User select male in gender selector radio button
    And User type "Mariusz" as customer username
    And User type "Jakistam" as customer lastname
    And User click on email fieald to confirm provided addres
    And User type "qwerty1234" as password
    And User select 24 as days value
    And User select 3 as months value
    And User select 1999 as years value
    And User mark newslater checkbox
    And User type Mariusz as username
    And User type Jakistam as lastname
    And User type Przyokopowa 17 as adress
    And User select America as coutry value
    And User type Szczecin as city
    And User type 123456798 as phone number
    And User type razdwatrzy as alias
    And User click registration button
    Then User get verification email