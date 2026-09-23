import java.sql.*;
public class delete {

    public static void main(String[] args) {

        try {

            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/mysql1",
                    "root",
                    "jaya@2297"
            );

            System.out.println("Connection Successful!");

            // Delete query
            String sql = "DELETE FROM student WHERE id = ?";

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,3);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

            // Close
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
