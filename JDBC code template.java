package jdbc;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1/jdbc_practice";
        String username = "root";
        String password = "";
        String query = "SELECT * FROM info WHERE id = 2";
        
        Statement stmt;
        try (Connection con = (Connection) DriverManager.getConnection(url, username, password)) {
            stmt = con.createStatement();
            ResultSet result;
            result = stmt.executeQuery(query);
            result.next();
            String name = result.getString("name");
            System.out.println("Answer is: " + name);
        }
        stmt.close();
    }
}
