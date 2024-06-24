Feature: Navigate to Contact object and attach the PDF document

  Scenario: Verify the user is able to attach the PDF document

    Given User should be able to click contact hyperlink
    When User should be able to click of upload files and attach the PDF document in notes and attachment
    Then User should be able to navigate inside PDF and verify the name
