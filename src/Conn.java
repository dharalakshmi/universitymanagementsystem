package university.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conn implements AutoCloseable {
    Connection connection;

     
    Conn(){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver"); 
          connection  = DriverManager.getConnection("jdbc:mysql://localhost@3306/universitymanagementsystem","root","pranavi235223");
          
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void insertData(String username, String password) {
        String query = "INSERT INTO login (username, password) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("Data inserted into login table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
   