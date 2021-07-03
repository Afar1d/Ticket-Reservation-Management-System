package Database;

import static Database.Employee_DB.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crew {

    private String name;
    private int id;
    private String password;


    public static int z = 0;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void Check_category(String n) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("select * from category where C_Name=? ");) {
            s.setString(1, n);

            try (ResultSet r = s.executeQuery()) {
                if (r.next()) {
                    z = 1;
                } else {
                    z = 2;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void Check_Event(String b) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("select * from Events where Event_Name=? ");) {

            s.setString(1, b);

            try (ResultSet r = s.executeQuery()) {
                if (r.next()) {
                    z = 1;
                } else {
                    z = 2;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Overriding 
    //delete_Category
    public void delete(String b) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("delete from Category where C_Name=?");) {

            s.setString(1, b);
            s.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
