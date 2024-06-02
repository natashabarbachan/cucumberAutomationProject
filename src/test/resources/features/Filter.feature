# language: en
# encoding: utf-8

Feature: Filter

  Background: User should be on TV shows tab and Audience Score filter should be applied
    Given the user is on TV Shows tab
    And the user selects Audience Score filter

  @Filter
  Scenario: Verify audience score filter when it is greater than or equal to 60%
    When the user selects Fresh option
    And the user clicks on Apply button
    Then percentage should be greater than or equal to 60 percent

  @Filter
  Scenario: Verify audience score filter when it is less than 60%
    When the user selects Rotten option
    And the user clicks on Apply button
    Then percentage should be less than 60 percent

  @Filter
  Scenario Outline: Verify application of Streaming filters
    When the user selects Fresh option
    And the user clicks on Apply button
    And the user selects <streaming> option
    Then the <title> should be displayed

    Examples:
      | streaming | title     |
      | "netflix"   | "Netflix"   |
      | "disney-plus-us"   | "Disney+"   |