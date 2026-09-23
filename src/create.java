import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class create {
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
            String query = "CREATE TABLE stdd(" + "id INT PRIMARY KEY, " + "name VARCHAR(50), " + "course VARCHAR(50), " + "age INT)";
            st.executeUpdate(query);
            System.out.println("Table Created Successfully!");
            ResultSet rs=st.executeQuery("select * from stdd");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("course")+" "+rs.getInt("age"));
            }
            // Close Connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
