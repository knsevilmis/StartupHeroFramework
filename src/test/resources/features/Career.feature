Feature: Career Module Functionality

 ## Background:
  ##  Given user is on the main page

@wip
Scenario: User should not be able to apply without resume/cv attached
  Given user navigates the "Careers" page
  When user clicks to "Software Test Engineer" position
  And user clicks to apply position button
  Then user should see the "Software Test Engineer" application form
  When user enters information into boxes and not attach resume
  Then user should see "This field is required." as a warning message


