@A&GInquiryFeatureOpt

Background: Launch the browser and navigate to Member search page
Given Launch Browser and Navigate to website
When User enter username and valid password
| username               | password     |
| shardha.sharma@ust.com | Welcome2k23# |
And click on signin button
Then Navigate to Home page
When clicks on the navigate icons
And clicks on member search menu
Given user enter the member id
And click on Search button
When Clicks on validate Member button
And Validate member verification popup is displayed
Then Select case origin and select Inbound Phonecall
And select member type
And Verify member verification pop
When Select 4 member options
Then Clicks on Verify button
| memberType |
| Member     |

@A&GInquiryScenarioExternalOpt
Scenario Outline: Navigate A&G inquiry page and fill the details1
Given Collect the details from sheet "<sheetName>" and  rowNum <rowNum>
When Clicks on A&G Inquiry button
When Validate whether A&G inquiry page is open
Then Validate Member Name
When Enter value on Appeals_Grievances ID
Then Validate Primary Reason
And Select Secondary Reason value
When Select Tertiary Reason value
And Validate Route to Department text
And Click Mark as Complaint?
And Select Value from Mark as Complaint
And Select member Priority
And Enter value in member Subject
And Enter value in member Description
And Click on Save Button
Then Print Case Id

Examples:
| sheetName      | rowNum |
| Member Inquiry | 0      |
| Member Inquiry | 1      |
| Member Inquiry | 2      |
