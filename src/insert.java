import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class insert {
    public static void main(String[] args){
        try {
            // Load driver (optional in newer versions, but safe)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Correct URL format
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/mysql1",
                    "root",
                    "jaya@2297"
            );
            System.out.println("Datbase connected");
            PreparedStatement ps = con.prepareStatement("insert into student(id,name,course) values(?,?,?)");
            ps.setInt(1, 3);
            ps.setString(2, "Karthikeya");
            ps.setString(3, "CSM");

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("row inserted successfully");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}