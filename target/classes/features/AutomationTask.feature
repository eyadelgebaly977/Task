@smoke
Feature: Automation Task
  Scenario:An automation task is needed to simulate the search for a lesson on nagwa website then opening the lesson worksheet to count the number of questions in this worksheet
    Given Use the search icon to start searching on Nagwa lessons
    And Write any lesson name for example “addition” then search
    And A list with all lessons in Nagwa that match this name will appear
    And Click on 2nd lesson in the search results to open its home page
    And Go to worksheet section then click preview button
    Then print the count