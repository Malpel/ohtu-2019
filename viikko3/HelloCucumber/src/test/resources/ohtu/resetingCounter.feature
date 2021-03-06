Feature: As a user I want to be able to set the counter to value zero

    Scenario: Resetting after one incerement
        Given Counter is initialized
        When it is incremented
        And it is reset
        Then the value should be 0

    Scenario: Resetting after incrementing with several values
        Given Counter is initialized
        When it is incremented by 5
        And it is reset
        Then the value should be 0