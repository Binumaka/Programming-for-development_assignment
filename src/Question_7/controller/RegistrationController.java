package Question_7.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

import Question_7.UI.RegistrationUI;
import Question_7.model.RegistrationModel;

public class RegistrationController {
    RegistrationModel model;
    RegistrationUI UI;
    ResultSet rs;
    PreparedStatement pst = null;

    public RegistrationController(RegistrationUI UI) {
        this.UI = UI;
        new RegisterListener().actionPerformed();
    }


    class RegisterListener {
        
        public void actionPerformed() {
            try {
                model = UI.getUser();
                if (model.getUsername().isEmpty() || model.getFname().isEmpty() || model.getLname().isEmpty()
                        || model.getEmail().isEmpty() || model.getGender().isEmpty()
                        || model.getPassword().isEmpty() || model.getconfirmPassword().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill up the form properly.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!model.getPassword().equals(model.getconfirmPassword())) {
                    JOptionPane.showMessageDialog(null, "Password Mismatch.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isUsernameUnique(model.getUsername())) {
                    JOptionPane.showMessageDialog(null, "Username already exists.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (checkUser(model)) {
                        UI.setMessage("Registered Successfully");
                    } else {
                        UI.setMessage("Error");
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public boolean checkUser(RegistrationModel user) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p_a", "root", "Binumaka9@!");
            String sql = "INSERT INTO users (username, password, fname, lname, gender, email) VALUES (?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFname());
            pst.setString(4, user.getLname());
            pst.setString(5, user.getGender());
            pst.setString(6, user.getEmail());

            int rs = pst.executeUpdate();

            System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null, "Data Registered Successfully");

            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }

    public boolean isUsernameUnique(String username) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/p_a", "root",
                "Binumaka9@!");
                PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?")) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 0;
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return false;
    }
}
