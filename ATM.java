package Prank;

import javax.swing.*;

public class ATM {
    public static void main(String[] args) {
        // Create and display the login window
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow(); // Initialize the login window
            }
        });
    }
}
