# Java-Project-ATMSystemGUI

Here’s a README file for your Enhanced ATM System with a GUI:

The Enhanced ATM System is a Java-based graphical user interface (GUI) application that simulates an ATM machine. Users can perform basic banking operations, such as checking the balance, depositing money, and withdrawing funds. The system allows interaction with a simple interface, and the transaction history is displayed in real-time.

**Features**
Check Balance: View the current account balance.
Deposit: Add funds to the account.
Withdraw: Withdraw money from the account (if sufficient balance is available).
Transaction History: Displays a log of all performed transactions (deposits and withdrawals).
Error Handling: Displays error messages for invalid inputs or insufficient funds.

**Code Explanation**

**BankAccount Class**
Manages the balance of the account and provides methods to:
getBalance(): Get the current balance.
deposit(double amount): Deposit a positive amount into the account.
withdraw(double amount): Withdraw an amount, ensuring sufficient balance.

**ATMSystemGUI Class**
This class handles the graphical user interface (GUI) and user interactions:

Balance Label: Displays the current balance.
Amount Field: Input field for entering deposit or withdrawal amounts.
Buttons: Three buttons for depositing, withdrawing, and checking the balance.
Transaction History: A text area that displays the transaction history.

**Methods:**
createGUI(): Creates the GUI layout using GridBagLayout.
updateBalanceLabel(): Updates the displayed balance.
deposit(): Handles deposit operations, validates the input, and updates the transaction history.
withdraw(): Handles withdrawal operations, checks for sufficient funds, and updates the transaction history.
checkBalance(): Displays the current balance in the transaction area.
main() Method
Initializes the BankAccount with a starting balance (e.g., $1000) and launches the ATM GUI.
