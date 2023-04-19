package lesson20230419.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {

    public static Connection getConnection() throws SQLException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        String url = resourceBundle.getString("db.url");
        String dbName = resourceBundle.getString("db.name");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");
        return DriverManager.getConnection(url + dbName, user, password);
    }

}
