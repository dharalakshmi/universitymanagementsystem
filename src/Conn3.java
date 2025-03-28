package university.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn3 {
    Connection c;
    Statement s;

    public Conn3() {
        try {
            // Replace "your_database_url", "your_username", and "your_password" with your database information
            String url = "jdbc:mysql://localhost:3306/universitymanagementsystem";
            String username = "root";
            String password = "pranavi235223";

            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return s.executeQuery(query);
    }

    public void close() {
        try {
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
