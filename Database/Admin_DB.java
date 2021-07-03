package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//Inheritance
public class Admin_DB extends Crew {

    public static Connection Connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:Project.db");
    }
// Overloading

    public static void insert(String n) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("insert into Category (C_Name) values (?)");) {
            s.setString(1, n);
            s.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void insert(String n, String p, String t, String d, int ti, String ca) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("insert into Events (Event_Name , Place , Time , Description ,Tickets, Category_Name) values (? ,? , ? , ? ,?, ?)");) {
            s.setString(1, n);
            s.setString(2, p);
            s.setString(3, t);
            s.setString(4, d);
            s.setInt(5, ti);
            s.setString(6, ca);
            s.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void update_Category(String b, String n) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("update Category set C_Name=? where C_Name=?");) {
            s.setString(1, n);
            s.setString(2, b);
            s.execute();
            
                PreparedStatement s1 = c.prepareStatement("update Events set Category_Name=? where Category_Name=?");
            s1.setString(1, n);
            s1.setString(2, b);
            s1.execute();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void update_Events(String event, String n, String p, String t, String d, String ca) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("update Events set Event_Name=? , Place=?, Time=? , Description=? , Category_Name=? where Event_Name=? ");) {
            s.setString(1, n);
            s.setString(2, p);
            s.setString(3, t);
            s.setString(4, d);
            s.setString(5, ca);
            s.setString(6, event);
            s.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//Overriding 
    //delete_Event
    @Override
    public void delete(String n) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("delete from Events where Event_Name=? ");) {
            s.setString(1, n);

            s.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
