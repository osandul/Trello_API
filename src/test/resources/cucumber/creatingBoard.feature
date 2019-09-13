Feature: Board management

  Scenario: Create a new board

    When I create a new board with name BOARD
    Then I check that the board name BOARD is set correctly
    Then I get id of board and save to context


  Scenario: Create a new list in the created board

    When I create a new list with name TO_DO
    Then I check that the list name TO_DO is set correctly
    Then I get id of the list and save to context

  Scenario: Create a new card in the created list

    When I create a new card with name CARD
    Then I check that the card name CARD is set correctly
    Then I get id of the card and save to context


  Scenario: Delete all boards

    When I get response data and set it into list
    Then I get board ids and delete all the boards
    Then I get response data and set it into list
    Then Check that the list of boards is empty

  Scenario: Get error while trying to create a new board without authorization credentials

    When I try to create a new board BOARD without adding authorization credentials
    Then I check that status code is 401

