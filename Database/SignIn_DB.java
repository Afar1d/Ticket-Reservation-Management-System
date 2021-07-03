package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SignIn_DB {

    public static Connection Connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:Project.db");
    }

    public static int y = 0;

    public static void Check_Admin(String n, String p) {

        try ( Connection c = Connect();
           
            PreparedStatement s = c.prepareStatement("select * from Admin where A_Name=? and Password=? ");) {
            s.setString(1, n);
            s.setString(2, p);
            try (ResultSet r = s.executeQuery()) {
                if (r.next()) {
                    y = 1;
                } else {
                    y = 2;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       

                    }
    

    public static void Check_Employee(String n, String p) {

        try ( Connection c = Connect();
           
            PreparedStatement s = c.prepareStatement("select * from Employee where E_Name=? and Password=? ");){
            s.setString(1, n);
            s.setString(2, p);
            try (ResultSet r = s.executeQuery()) {
                if (r.next()) {
                    y = 1;
                } else {
                    y = 2;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    } 
}
