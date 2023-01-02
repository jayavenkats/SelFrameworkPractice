
Feature: Purchase from Ecommerce Website

Background:
 Given: I landed on ecommerce page
 
Scenario Outline:
	Given Login with username<username> and password <password>
	When Add product <productName> to cart
	And Checkout <productName> and Submit the order
	Then "Thank you for the order" dislplayed on the confirmation page
	Examples:
	   | username    | password  | productName |
	   | jay@abc.com | Mercury1! | ZARA COAT 3 |
	
	
	 