package ma.esi.jfxapp.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/stockadmin";
    private static final String user = "stockadmin";
    private static final String password = "admin";


    private static Connection connection ;


    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url,user,password);
            return connection;
        }
        return connection;
    }
    public void closeConnection() throws SQLException {
        if (!(connection == null)) {
            connection.close();
        }
    }
}
