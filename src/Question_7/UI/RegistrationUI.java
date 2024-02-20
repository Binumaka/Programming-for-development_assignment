package Question_7.UI;

import javax.swing.*;

import Question_7.controller.RegistrationController;
import Question_7.model.RegistrationModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationUI extends JFrame {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    private RegistrationController controller;
    RegistrationModel model;

    public RegistrationUI() {
        initComponents();
        controller = new RegistrationController(this);
    }

    private void initComponents() {
        setTitle("Simple Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        usernameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);

        panel.add(createFormField("First Name:", firstNameField));
        panel.add(createFormField("Last Name:", lastNameField));
        panel.add(createFormField("Username:", usernameField));
        panel.add(createFormField("Email:", emailField));
        panel.add(createFormField("Password:", passwordField));
        panel.add(createFormField("Confirm Password:", confirmPasswordField));

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerButtonClicked();
            }
        });
        panel.add(registerButton);

        add(panel);
    }

    private JPanel createFormField(String label, JTextField textField) {
        JPanel panel = new JPanel();
        JLabel jLabel = new JLabel(label);
        panel.add(jLabel);
        panel.add(textField);
        return panel;
    }

    private void registerButtonClicked() {
        // Retrieve user input values
        RegistrationModel model = getUser();
    
        // Pass the model to the controller for registration
        controller.registerUser(model); 
        
        // Close the current RegistrationUI window
        dispose();
    
        // Open the HomeUI window
        HomeUI homeUI = new HomeUI();
        homeUI.setVisible(true);
    }

    // Method to retrieve user input values
    public RegistrationModel getUser() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // Create and return a RegistrationModel object
        return new RegistrationModel(username, password, firstName, lastName, email, confirmPassword);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationUI().setVisible(true);
            }
        });
    }
}
