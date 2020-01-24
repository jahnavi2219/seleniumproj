Feature: Loan information functionality of member

	@loansinformation
	Scenario: Displays loan information of member
	Given User should launch the application by valid url with valid admin credentials and admin should grant the loan
	When User should be logged and should be in homepage and should display information if it is available
	Then Loans information of member is displayed
	
	@loansrepay
	Scenario: Verify and displays whether application allows member to repay loan amount
	Given User should launch the application by valid url and user should be logged as member and should present in homepage
	When Loans information is displayed and select amount to repay
	Then Amount is repaid and the remaining amount is displayed
	
	@otherpayment
	Scenario: Verify whether application allows member to pay to other registered member
	Given User should launch the application by valid url and he should be logged as member recepient member name should be known
	When Valid credentials for login,amount and description should be given 
	Then Payment has been performed and message should be displayed
	
	@messages
	Scenario: Application allows member to view the messages
	Given User should launch the application by valid url and he should be logged and present in home page
	When User opens proper personal and message link
	Then Message details are displayed  
	
	@msgtrash
	Scenario: Verify whether application allows member to view remaining messages after deleting
	Given  User should launch cyclos application by valid url and he should be logged and present in home page
	When User opens proper personal and message link and then deletes
	Then Selected message should be deleted and shows remaining messages 
	
	@accinformation
	Scenario: Verify whether application allows member to perform system payment details in account information module
	Given User should launch application by valid url and he should be logged and present in home page 
	When User gives proper credentials in system payment in accounts link
	Then Payment is done and transaction details are displayed