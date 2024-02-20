package Question_7.UI;

import javax.swing.*;

import Question_7.DbConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUI extends JFrame {

    private JLabel lblUserName;
    private JTextArea textAreaRecommendations;
    private String initialHomeContent;
    private String username;
    private SocialGraph socialGraph;
    private DbConnection database;
    private User loggedInUser; 

    public HomeUI(String username, SocialGraph socialGraph, DbConnection database) {
        this.username = username;
        this.socialGraph = socialGraph;
        this.database = database;
        this.loggedInUser = socialGraph.getUser(username); 
    }

    public HomeUI() {
        //TODO Auto-generated constructor stub
    }

    public void initialize(String userName, SocialGraph socialGraph) {
        this.socialGraph = socialGraph;

        setTitle("Home ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Navigation Bar
        JPanel navBar = new JPanel(new GridLayout(1, 3, 10, 0));
        JButton btnAddFriend = new JButton("Add Friend", new ImageIcon("add_friend_icon.png"));
        JButton btnPost = new JButton("Post", new ImageIcon("post_icon.png"));
        JButton btnAccount = new JButton("Account", new ImageIcon("account_icon.png"));

        // btnAddFriend.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         openFriendpage(loggedInUser); // 
        //     }
        // });

        btnPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPostPage(username);
            }
        });

        // btnAccount.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         openAccountPage(username);
        //     }
        // });

        navBar.add(btnAddFriend);
        navBar.add(btnPost);
        navBar.add(btnAccount);

        // User Info Panel
        JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblUserName = new JLabel("Welcome, " + userName);
        userInfoPanel.add(lblUserName);

        // Recommendations Panel
        JPanel recommendationsPanel = new JPanel(new BorderLayout());
        JLabel lblRecommendations = new JLabel("Recommended Images:");
        textAreaRecommendations = new JTextArea();
        textAreaRecommendations.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textAreaRecommendations);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        recommendationsPanel.add(lblRecommendations, BorderLayout.NORTH);
        recommendationsPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(navBar, BorderLayout.NORTH);
        mainPanel.add(userInfoPanel, BorderLayout.CENTER);
        mainPanel.add(recommendationsPanel, BorderLayout.SOUTH);

        initialHomeContent = textAreaRecommendations.getText();

        add(mainPanel);
        setVisible(true);
    }

    // private void openFriendpage(User loggedInUser) {
    //     Friendpage friendpage = new Friendpage(loggedInUser, socialGraph, database);
    //     friendpage.initialize();
    //     friendpage.setVisible(true);
    // }

    private void openPostPage(String username) {
        PostPage postPage = new PostPage(username, database);
        postPage.initialize();
        postPage.setVisible(true);
    }

    // private void openAccountPage(String username) {
    //     AccountUI accountPage = new AccountUI(username, database);
    //     accountPage.initialize();
    //     accountPage.setVisible(true);
    // }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SocialGraph socialGraph = new SocialGraph();
                DbConnection database = new DbConnection();
                HomeUI home = new HomeUI();
                home.initialize("User", socialGraph);
            }
        });
    }
}