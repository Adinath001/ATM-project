package AWTPrank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountSelectionWindow extends JFrame {
    private int customerNumber;

    public AccountSelectionWindow(int customerNumber) {
        this.customerNumber = customerNumber;

        // Frame settings
        setTitle("Account Selection");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Create buttons for account selection
        JButton checkingButton = new JButton("Checking Account");
        JButton savingButton = new JButton("Saving Account");
        JButton exitButton = new JButton("Exit");

        // Add buttons to the frame
        add(checkingButton);
        add(savingButton);
        add(exitButton);

        // Add action listeners to buttons
        checkingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AccountOperationsWindow(customerNumber, "checking");
                dispose(); // Close the account selection window
            }
        });

        savingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AccountOperationsWindow(customerNumber, "saving");
                dispose(); // Close the account selection window
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
