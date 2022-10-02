@regression
Feature: login functionlity


Background:
Given user should be on login page


Scenario: TC01_InvalidLogin
When user enters invalid userid and enters invalid password
And Click on login button
Then user can see error message on login page
And close browser


Scenario Outline: Test login with given list
When user enters invalid userid as "<userid>" and enters invalid password as "<password>"
And Click on login button
Then user can see error message on login page
And close browser
Examples:
|userid | password |
|admin1 |pass1  |
|admin2 |pass2 |
|admin3 | pass3|


@onlythis
Scenario: TC02_validLogin
When user enters valid userid and enters valid password
And Click on login button
Then user should be navigated to home page
And logout link should be appear on right top corner
And close browser