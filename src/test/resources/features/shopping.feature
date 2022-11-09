@shopping
Feature: Shopping

  Scenario: Check the shopping cart
    Given input "drills" in "#mainSearch-input"
    And click on "#search_submit_button"
    And click on "#product_add_button_412XT"
    And click on "#continue_button_btn"
    And click on "#add_for_collection_button_268FX"
 #   And click on "#checkout_now"
    And input "BA22 8RT" in "#search_branch_textbox"
    And click on "#search_branch_button"
    And click on "#add_for_collection_button_1"
    And click on "//button[@class='lb-btn-cancel']"
    And click on "//a[@href='/jsp/trolley/trolleyPage.jsp?reprice=true']"
    And User checks if the Delivery button is selected for the first product
    And User checks if the Click And Collect button is selected for the second product
    And User checks Sub Total Field
    And the "#trolley_page_delivery" text equals to "FREE"
    And User checks if the Total Field is the same as the Sub Total Field
