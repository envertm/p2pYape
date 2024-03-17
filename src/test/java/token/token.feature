Feature: Token

Background: 
#* url 'https://apiqas.vnforappstest.com/api.security/v1/security'

Scenario: creacion de token Api
Given url 'https://apiqas.vnforappstest.com/api.security/v1/security'
And header Authorization = 'Basic Z2lhbmNhZ2FsbGFyZG9AZ21haWwuY29tOkF2MyR0cnV6'
When method Get
Then status 201
And print response
* def token = response
