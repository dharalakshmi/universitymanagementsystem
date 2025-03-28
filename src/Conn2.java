package university.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn2 implements AutoCloseable {
    Connection connection;
    Statement s;

    Conn2() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "pranavi235223");
            s = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData(String name, String fname, String empId, String dob, String address, String phone, String email, String x, String xii, String aadhar, String qualification, String department) {
        try {
            String query = "INSERT INTO teacher VALUES('" + name + "', '" + fname + "','" + empId + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + x + "','" + xii + "','" + aadhar + "','" + qualification + "','" + department + "')";
            s.executeUpdate(query);
            System.out.println("Teacher Details Inserted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws SQLException {
        if (s != null) {
            s.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
