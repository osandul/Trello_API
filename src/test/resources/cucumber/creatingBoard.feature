Feature: Board management

Scenario: Create a new board

  When I create a new board with name BOARD
  Then I check that server handles it and returns a success status
  And I check that the name BOARD is set correctly
  And I get id of board BOARD

  Scenario: Create a list


    When I create a new list with name "To do:"
    Then I check that server handles it and returns a success status
    And I check that the {name} is set correctly