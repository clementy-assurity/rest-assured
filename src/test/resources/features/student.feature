Feature: Current student details are available

  Scenario: Verify student details
    When I check the details of student 2
    Then I can see that their name is 'Jane Jones'
    And they have a 'BSc Computer Science' from 'Sydney Tech School'
