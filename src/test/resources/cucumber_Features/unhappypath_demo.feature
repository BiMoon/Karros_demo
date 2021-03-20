Feature: The unhappy path for the API:
Desciption: This purepose to validate the PATH resource of each level of the given endpoint URL
            GET https://my-json-server.typicode.com/typicode/demo/posts/1

Scenario Outline:
	Given I am in the base page 
	When I go to endpoint by entering a string as "<id>"
	Then the return page should have code 4xx and the page should not redirect.
	
Examples: 
| id   | 
| a    |
| b    |
| c    |

Scenario Outline:
	Given I am in the base page 
	When I go to endpoint by entering a minus number as "<id>"
	Then the return page should have code 4xx and the page should not redirect.

Examples: 
| id   | 
| -1    |
| -2    |
| -3    |

Scenario Outline:
	Given I am in based domain page
	When I go to next resoure page as "<nextpage>"
	Then the return code should be 200 
	Then the next page should show resource of next pages as "<expected>"
	
Examples: 
|		nextpage		|	expected	|
|	/typicode/			|	typicode	|
|	/typicode/demo/		|	demo		|
|	/typicode/demo/posts/|	Post		|
