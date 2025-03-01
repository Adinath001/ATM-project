package AWTPrank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountOperationsWindow extends JFrame {
    private int customerNumber;
    private String accountType;

    private double checkingBalance = 0;
    private double savingBalance = 0;

    public AccountOperationsWindow(int customerNumber, String accountType) {
        this.customerNumber = customerNumber;
        this.accountType = accountType;

        // Frame settings
        setTitle(accountType.substring(0, 1).toUpperCase() + accountType.substring(1) + " Account Operations");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Create buttons for account operations
        JButton viewBalanceButton = new JButton("View Balance");
        JButton withdrawButton = new JButton("Withdraw Funds");
        JButton depositButton = new JButton("Deposit Funds");
        JButton exitButton = new JButton("Exit");

        // Add buttons to the frame
        add(viewBalanceButton);
        add(withdrawButton);
        add(depositButton);
        add(exitButton);

        // Add action listeners to buttons
        viewBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = accountType.equals("checking") ? checkingBalance : savingBalance;
                JOptionPane.showMessageDialog(null, accountType.substring(0, 1).toUpperCase() + accountType.substring(1) + " Account Balance: ₹" + balance);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (accountType.equals("checking")) {
                        if (amount <= checkingBalance) {
                            checkingBalance -= amount;
                            JOptionPane.showMessageDialog(null, "Withdrawal successful! New Checking Balance: ₹" + checkingBalance);
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient funds.");
                        }
                    } else {
                        if (amount <= savingBalance) {
                            savingBalance -= amount;
                            JOptionPane.showMessageDialog(null, "Withdrawal successful! New Saving Balance: ₹" + savingBalance);
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient funds.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid amount.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (accountType.equals("checking")) {
                        checkingBalance += amount;
                        JOptionPane.showMessageDialog(null, "Deposit successful! New Checking Balance: ₹" + checkingBalance);
                    } else {
                        savingBalance += amount;
                        JOptionPane.showMessageDialog(null, "Deposit successful! New Saving Balance: ₹" + savingBalance);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid amount.");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank you for using the ATM, bye.");
                System.exit(0); // Close the application
            }
        });

        // Set frame visible
        setVisible(true);
    }
}
