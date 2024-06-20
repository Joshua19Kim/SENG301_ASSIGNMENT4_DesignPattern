Feature: As Alex, I want to be able to simulate a battle between two teams so that I can have my pets fighting.
  Scenario: I can start a battle between two distinct teams.
    Given I create a player named "Josh"
    And Player "Josh" has a pack "My 5 pet Pack" with 5 unique pets
    When I, "Josh", build two teams with "My 5 pet Pack" named "firstTeam" and "secondTeam"
    And I start a battle with "firstTeam" and "secondTeam"
    Then the battle should successfully start


  Scenario: AC2 - A battle can not last longer than 20 turns
    Given I create a player named "Josh"
    And Player "Josh" has a pack "My 5 pet Pack" with 5 unique pets
    When I, "Josh", build two teams with "My 5 pet Pack" named "My first team" and "My second team"
    And I start a battle with "My first team" and "My second team"
    And the battle lasts for more than 20 rounds
    Then the battle should end in a draw

  Scenario: AC3 - The team who loses all their pets first loses the battle
    Given I create a player named "Josh"
    And Player "Josh" has a pack "My 5 pet Pack" with 5 unique pets
    When I, "Josh", build two teams with "My 5 pet Pack" named "My first team" and "My second team"
    And I start a battle with "My first team" and "My second team"
    And one team loses all their pets
    Then the other team should win the battle