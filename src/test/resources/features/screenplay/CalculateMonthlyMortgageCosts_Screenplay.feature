Feature: Hypotheker monthly mortgage costs calculator
  As a user
  I want to calculate my monthly mortgage costs

  Scenario: Calculate with minimum provided data
    Given Romeo starts hypotheker calculator
    When he calculates monthly mortgage costs for 300000 mortgage
    Then he sees monthly costs
      | gross   | netto   |
      | € 1.448 | € 1.104 |
