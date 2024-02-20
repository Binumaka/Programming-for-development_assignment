package Question_7.controller;

import java.sql.*;

import Question_7.UI.RegistrationUI;
import Question_7.model.RegistrationModel;

public class RegistrationController {
    private RegistrationUI ui;
    private Connection conn;
    private PreparedStatement pst;

    public RegistrationController(RegistrationUI ui) {
        this.ui = ui;
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p_a", "root", "Binumaka9@!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void registerUser(RegistrationModel model) {
        try {
            String sql = "INSERT INTO users (username, password, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, model.getUsername());
            pst.setString(2, model.getPassword());
            pst.setString(3, model.getFirst_name());
            pst.setString(4, model.getLast_name());
            pst.setString(5, model.getEmail());

            int result = pst.executeUpdate();

            if (result > 0) {
                ui.displayMessage("User registered successfully!");
            } else {
                ui.displayMessage("Failed to register user.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ui.displayMessage("Error: " + ex.getMessage());
        }
    }
}
