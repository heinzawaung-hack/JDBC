package heinzawaung;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/linux";
        String userName = "root";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Connected to MySQL Database.");

            Statement statement = connection.createStatement();
            String sql = "create table if not exists users (id int auto_increment primary key,name varchar(50),email varchar(50));";
            String insert = "insert into users (name,email) values ('Apple','info@apple.com')";
            String retrieve = "select * from users;";

            //     statement.execute(insert);
            //     System.out.println("MySQL Database Insert created successful.");

            ResultSet resultSet = statement.executeQuery(retrieve);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println(id + " : " + name + " : " + email);
            }

        } catch (SQLException throwables) {
            System.out.println("Can't connect to database.");
            throwables.printStackTrace();
        }
    }
}

