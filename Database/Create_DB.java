package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create_DB {

    public static Connection Connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:Project.db");
    }

    public static void Insert_Admin(String n, String p) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("insert into admin (A_Name , Password) values (? ,?)");) {
            s.setString(1, n);
            s.setString(2, p);
            s.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Insert_Employee(String n, String p) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("insert into employee (E_Name , Password) values (? ,?)");) {
            s.setString(1, n);
            s.setString(2, p);
            s.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
