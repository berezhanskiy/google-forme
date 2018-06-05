# google-forme
The autotests project for checking google-form

Class HelperBase - super class for other helpers, contain basic functions IsElementPresent and Type.  
Class GooglFormHelper - contain a set of functions for interaction with GooglForm webelements, filling the form.   
Class ResponsFormHelper - for weblements from result page.

Class BaseTest - for initialization browser and helpers.
Class PositiveFormTests - for checking form with valid user-data, checking form submitting.
Class NegativeFormTests - for negative form checks, such empty and invalid user-data.

Used: java, maven, testNG, selenium
