Feature: Hypotheker monthly mortgage costs calculator
  As a user
  I want to calculate my monthly mortgage costs

  Scenario: Calculate with minimum provided data
    Given user is on start page
    When he enters total mortgage amount of 300000
    Then he should see monthly costs
      | bruto   | netto   |
      | € 1.447 | € 1.103 |

  Scenario: Calculate including income data
    Given user is on start page
    When he enters total mortgage amount of 300000
    When he enters income data
      | yearly_income | age | single |
      | 40000         | 45  | y      |
    Then he should see monthly costs
      | bruto   | netto   |
      | € 1.447 | € 1.103 |
