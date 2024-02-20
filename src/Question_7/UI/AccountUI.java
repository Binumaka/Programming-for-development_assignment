package Question_7.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton saveButton;

    public AccountUI(String username) {
        setTitle("Account Page");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(username);
        usernameField.setEditable(false); // Username is not editable

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });

        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(new JLabel()); // Empty label for spacing
        mainPanel.add(saveButton);

        add(mainPanel);
    }

    private void saveChanges() {
        // Get the updated password from the password field
        char[] newPasswordChars = passwordField.getPassword();
        String newPassword = new String(newPasswordChars); // Convert char[] to String

        // Save the updated password to the database or perform any other necessary actions
        // Example: dbConnection.updatePassword(username, newPassword);

        JOptionPane.showMessageDialog(this, "Changes saved successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AccountUI accountPage = new AccountUI("User123");
                accountPage.setVisible(true);
            }
        });
    }
}

