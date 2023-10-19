@FeatureLoginPage
Feature: Login functionlity

  Scenario Outline: SignIn with with valid credentials
    Given Launch Browser and Navigate to website
    When User enter username "<username>" and valid password "<password>"
    And click on signin button
    Then Navigate to Home page
    When Clicks on validate Member button

    Examples: 
      | username               | password     |
      | shardha.sharma@ust.com | Welcome2k23 |
