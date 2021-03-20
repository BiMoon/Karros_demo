Feature: The happy path for the API:
Desciption: This purepose to validate the PATH of the given endpoint URL
            GET https://my-json-server.typicode.com/typicode/demo/posts/

Scenario Outline:
	Given I am in the base page 
	When I go to endpoint by entering number as <id>
	Then The new page open and display id as <id> and title as <title> 

Examples: 
| id   |title| 
| 1    |1	|
| 2    |2	|
| 3    |3	|
