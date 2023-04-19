package lesson20230419.jdbc;

import java.sql.*;

public class JDBCConnectionExample {

    public static void main(String[] args) {

//        Class.forName("com.mysql.jdbc.Driver");
        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
            Statement statement = connection.createStatement();
        ) {
            statement.setFetchSize(100);
            ResultSet resultSet = statement.executeQuery("select * from city");
            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()){
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.print("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
