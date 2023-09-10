# QX-DAY-2023
Code examples - QX Day 2023 - Presentation- When Shakespeare became an automation engineer
The code examples are based upon the website: 
* https://www.hypotheker.nl/zelf-berekenen/wat-worden-mijn-maandlasten <br />
This website is a real website so the calculation of the mothly cost fluctuate because of changing parameters.
So the assertions in the examples might fail, because in time parameters have changed.


# Guidance
This repo contain the following example testcases:
* Raw testcase
* Page Object Model
* Screenplay pattern

## Raw testcase
This simple JUnit test example can be found in:
* src\test\java\nl\sogeti\raw

## Page Object Model
This example is setup with cucumber
* features: src\test\resources\features\pageobjects
* step definitions: src\test\java\nl\sogeti\pageobjects\steps
* page objects: src\main\java\nl\sogeti\pageobjects

## Screenplay pattern
This example is setup with cucumber and Serenity
* features: src\test\resources\features\screenplay
* tasks: src\test\java\nl\sogeti\screenplay\tasks
* step definitions: src\test\java\nl\sogeti\screenplay\steps
* page objects: src\main\java\nl\sogeti\screenplay
