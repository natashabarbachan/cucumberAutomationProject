# language: en
# encoding: utf-8

Feature: Trailer

  @Trailer
  Scenario:
  Given the user is on "Grey's Anatomy" page details
  When the user clicks on Trailer button
  Then the trailer is displayed