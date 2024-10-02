@FanCodeTestOne
Feature: To Check Fan code Completed task percentage

  @TC_01
  Scenario Outline: All the users of City FanCode should have more than half of their todos task completed
    Given User has the todo tasks
    And User belongs to the city FanCode
    Then User Completed task percentage should be greater than 50%
    Examples:
      | browser | Page  | Username      | Password              |
      | Chrome  | Login | HudlLoginUser | HudlLoginUserPassword |

