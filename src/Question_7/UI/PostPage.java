
package Question_7.UI;

import javax.swing.*;

import Question_7.DbConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PostPage extends JFrame {

    private JLabel lblSelectedImage;
    private String selectedImagePath;
    private DbConnection database;
    private String username;

    public PostPage(String username, DbConnection database) {
        this.username = username;
        this.database = database;
    }

    public void initialize() {
        setTitle("Post Page");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Image Selection
        JButton btnSelectImage = new JButton("Select Image");
        btnSelectImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showOpenDialog(PostPage.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    selectedImagePath = selectedFile.getAbsolutePath();

                    // Display the selected image
                    displaySelectedImage(selectedImagePath);
                }
            }
        });

        lblSelectedImage = new JLabel("No image selected", SwingConstants.CENTER);

        mainPanel.add(btnSelectImage, BorderLayout.NORTH);
        mainPanel.add(lblSelectedImage, BorderLayout.CENTER);

        // Submit Button
        JButton btnSubmitPost = new JButton("Submit Post");
        btnSubmitPost.addActionListener(e -> {
            // Save the post and image to the database
            savePostToDatabase(username, selectedImagePath);

            // You can add logic to save the post, update the social graph, etc.
            dispose(); // Close the post page after submission
        });

        mainPanel.add(btnSubmitPost, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void displaySelectedImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lblSelectedImage.setIcon(imageIcon);
        lblSelectedImage.setText(""); // Clear any previous text
    }

    private void savePostToDatabase(String username, String imagePath) {
        if (database != null) {
            int result = insertImageIntoDatabase(username, imagePath);
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Post saved to database!");
            } else {
                JOptionPane.showMessageDialog(null, "Error saving post to database");
            }
        }
    }

    private int insertImageIntoDatabase(String username, String imagePath) {
    String query = "INSERT INTO posts (username, image_path, photo) VALUES (?, ?, ?)";
    try (PreparedStatement preparedStatement = database.connection.prepareStatement(query)) {
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, imagePath);

        // Read the image file as a byte array
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        preparedStatement.setBytes(3, imageBytes);

        return preparedStatement.executeUpdate();
    } catch (SQLException | IOException e) {
        e.printStackTrace();
        return -1;
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               
                DbConnection database = new DbConnection();
                PostPage postPage = new PostPage("User123", database);
                postPage.initialize();
                postPage.setVisible(true);
            }
        });
    }
}