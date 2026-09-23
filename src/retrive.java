import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class retrive {
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
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student");
            System.out.println("ID\tName\tCourse");

            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("name")+"    "+rs.getString("course"));
            }
            // Close Connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}