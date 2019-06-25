Feature: Board management

Scenario: Create a new board

  When I create a new board with name "Board Test"
  Then Server handles it and returns a success status
  And Checks that the name is set correctly