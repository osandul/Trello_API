Feature: Board management

#  Scenario: Create a new board
#
#    When I create a new board with name BOARD
#    Then I check that server handles it and returns a success status
#    And I check that the name BOARD is set correctly
#    And I get id of board and save to context
#
#
#  Scenario: Create a new list in the created board
#
#    When I create a new list with name TO_DO
#    Then I check that server handles it and returns a success status
#    And I check that the name TO_DO is set correctly
#    And I get id of the list and save to context
#
#  Scenario: Create a new card in the created list
#
#    When I create a new card with name CARD
#    Then I check that server handles it and returns a success status
#    And I check that the name CARD is set correctly
#    And I get id of the card and save to context

    Scenario: Delete all board

      When I get all board
