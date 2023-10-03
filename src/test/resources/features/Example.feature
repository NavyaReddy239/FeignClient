Feature: Get person data

  Scenario: Get person data with success
    Given Get Call to url
    Then Response Code status is validated
    And verify response content type is "<contentType>"
    And print out the response body to console
    
    Examples: 
      | contentType      |
      | application/json |
      