Feature: Add items to cart and place the order

@placeOrder
Scenario Outline: Add more quantity of product and add to cart and place order
Given User is be on GreenKart landing page
When User searched with shortname <Name> and extracted actual name of the product
Then Add the product 3 times
And Clik on ADD to Cart button
Then Click on cart icon on top right corner
And Click on Proceed to checkout button
Then Check if Product Name which has been extracted from GreenKart page is visible in Checkout Page
And Apply and PlaceOrder buttons also visible.

Examples:
|Name|
|Tom |
|Beet|