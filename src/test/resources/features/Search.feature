# language: en
# encoding: utf-8

Feature: Search

  @Search
  Scenario: Check public note for a movie searched
    Given the user access the movies tab
    When the user search for "Titanic 1997"
    Then public grade should be "97%"
