package AWTPrank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JTextField customerNumberField;
    private JPasswordField pinField;
    private JButton loginButton;

    private HashMap<Integer, Integer> data = new HashMap<Integer,Integer>();

    public LoginWindow() {
        // Hardcoded customer data
        data.put(123456, 2005);
        data.put(654321, 2004);

        // Frame settings
        setTitle("ATM Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Create UI elements
        JLabel customerNumberLabel = new JLabel("Customer Number:");
        customerNumberField = new JTextField();
        
        JLabel pinLabel = new JLabel("PIN Number:");
        pinField = new JPasswordField();
        
        loginButton = new JButton("Login");

        // Add components to the frame
        add(customerNumberLabel);
        add(customerNumberField);
        add(pinLabel);
        add(pinField);
        add(loginButton);

        // Add button action listener
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int customerNumber = Integer.parseInt(customerNumberField.getText());
                int pinNumber = Integer.parseInt(new String(pinField.getPassword()));

                // Check login credentials
                if (data.containsKey(customerNumber) && data.get(customerNumber).equals(pinNumber)) {
                    // Proceed to next window (Account Type Selection)
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    new AccountSelectionWindow(customerNumber);
                    dispose(); // Close the login window
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid customer number or pin.");
                }
            }
        });

        // Set frame visible
        setVisible(true);
    }
}
