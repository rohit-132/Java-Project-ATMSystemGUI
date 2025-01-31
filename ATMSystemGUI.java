import java.awt.*;
import javax.swing.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

public class ATMSystemGUI {
    private BankAccount account;
    private JFrame frame;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JTextArea transactionArea;

    public ATMSystemGUI(BankAccount account) {
        this.account = account;
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Enhanced ATM System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title label
        JLabel titleLabel = new JLabel("ATM System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(titleLabel, gbc);

        // Balance label
        balanceLabel = new JLabel("Current Balance: $0.00");
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(balanceLabel, gbc);

        // Amount input field
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        frame.add(amountLabel, gbc);

        amountField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(amountField, gbc);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 0));

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> deposit());
        buttonPanel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> withdraw());
        buttonPanel.add(withdrawButton);

        JButton balanceButton = new JButton("Check Balance");
        balanceButton.addActionListener(e -> checkBalance());
        buttonPanel.add(balanceButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(buttonPanel, gbc);

        // Transaction history area
        JLabel transactionLabel = new JLabel("Transaction History:");
        transactionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame.add(transactionLabel, gbc);

        transactionArea = new JTextArea(8, 30);
        transactionArea.setEditable(false);
        transactionArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(transactionArea);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(scrollPane, gbc);

        frame.setVisible(true);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Current Balance: $" + String.format("%.2f", account.getBalance()));
    }

    private void checkBalance() {
        transactionArea.append("Balance Checked: $" + String.format("%.2f", account.getBalance()) + "\n");
        updateBalanceLabel();
    }

    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0) {
                account.deposit(amount);
                transactionArea.append("Deposited: $" + String.format("%.2f", amount) + "\n");
                updateBalanceLabel();
                amountField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a positive amount!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a valid number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0 && account.withdraw(amount)) {
                transactionArea.append("Withdraw: $" + String.format("%.2f", amount) + "\n");
                updateBalanceLabel();
                amountField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Insufficient funds or invalid amount.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a valid number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00); // Starting balance of $1000
        new ATMSystemGUI(userAccount); // Launch the GUI
    }
}
