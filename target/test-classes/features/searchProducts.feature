Feature: Search and place the order for products

#Scenario: Search Experience for product search in both home and offers page
#Given User is be on GreenKart landing page
#When User searched with shortname "Tom" and extracted actual name of the product
#Then User searched for "Tom" shortname in offers page
#And validate product name in offers page with landing page

@searchProducts
Scenario Outline: Search Experience for product search in both home and offers page
Given User is be on GreenKart landing page
When User searched with shortname <Name> and extracted actual name of the product
Then User searched for <Name> shortname in offers page
And validate product name in offers page with landing page

Examples:
|Name|
|Tom |
|Beet|