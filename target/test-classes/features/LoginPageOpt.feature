@FeatureLoginPage
Feature: Login functionality

Scenario: SignIn with valid credentials
Given Launch Browser and Navigate to website
When User enter User Name and Password
And click on signin button
Then Navigate to Home page