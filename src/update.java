import java.sql.*;

public class update {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/mysql1",
                    "root",
                    "jaya@2297"
            );

            System.out.println("Connection Successful!");

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE student SET course = ? WHERE id = ?"
            );

            // Set values
            ps.setString(1, "MECH");
            ps.setInt(2, 4);

            // Execute query only once
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Row inserted successfully");
            }

            // Close connection
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}