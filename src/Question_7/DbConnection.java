package Question_7;

import javax.swing.*;

import java.sql.*;

public class DbConnection {

    public Connection connection;

    Statement statement;

    ResultSet resultSet;

    int value;

    public DbConnection(){

        try {

            String username = "root";

            String password = "Binumaka9@!";

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/p_a",username,password);



            if(connection!=null){

                System.out.println("Connected to database");

            }else{

                System.out.println("Error connecting to database");

            }

            statement = connection.createStatement();

        }catch (Exception e){

            e.printStackTrace();

        }

    }

    public Connection dbConnect(){
        try {

            System.out.println("There");
            String username = "root";

            String password = "Binumaka9@!";

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/p_a",username,password);



            if(connection!=null){
                System.out.println("There");

                System.out.println("Connected to database");

            }else{
                System.out.println("There");

                System.out.println("Error connecting to database");

            }

            statement = connection.createStatement();

        }catch (Exception e){

            e.printStackTrace();

        }
        return  connection;

    }

    // Via the use of sql query

    // insert, update and delete

    public int manipulate(String query){

        try {

            value = statement.executeUpdate(query);

            connection.close();

        }catch (SQLIntegrityConstraintViolationException ex){

            JOptionPane.showMessageDialog(null, "These details already exist!");

        }catch (SQLException e){

            e.printStackTrace();

        }

        return value;

    }



    public ResultSet retrieve(String query){

        try {

            resultSet = statement.executeQuery(query);

        }catch (SQLException e){

            e.printStackTrace();

        }

        return resultSet;

    }



    public static void main(String[] args) {

        new DbConnection();

    }

}
