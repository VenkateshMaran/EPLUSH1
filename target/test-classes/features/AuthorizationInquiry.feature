@AuthorizationInquiry
Feature: Authorization Inquiry form
  #Ctrl + Alt + L ==== Formatting for feature file or right click on file go to Reformat code

  Background: Launch the browser and navigate to Member search page
    Given Launch Browser and Navigate to website
    When User enter User Name and Password
    And click on signin button
    Then Navigate to Home page
    When clicks on the navigate icons
    And clicks on member search menu
    Given user enter the memberId
      | memberID     |
      | 200004221-01 |
    And click on Search button
    When Clicks on validate Member button
    And Validate member verification popup is displayed
    Then Select case origin and select Inbound Phonecall
    Then select member type
    And Verify member verification pop
    When Select 4 member options
    Then Clicks on Verify button
      | memberType |
      | Member     |


  @Scenario
  Scenario Outline: Fill out details in Authorization inquiry page and generate case
    Given Collect the details from sheet "<sheetName>" and rowNum <rowNum>
    And click on Authorization inquiry page
    When Enter Inquiry Details
    And Save the Details
    Then Verify whether case is generated
    Examples:
      | sheetName             | rowNum |
      | Authorization Inquiry | 18     |


