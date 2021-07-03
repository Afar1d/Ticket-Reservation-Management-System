package Database;

import static Database.Crew.Check_Event;
import static Database.Crew.z;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//Inheritance
public class Employee_DB extends Crew {

    public static int Ticket;

    public static Connection Connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:Project.db");
    }

    public static void insert_Client(String n, int cl) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("insert into Clients (Client_Name,Serial) values (? , ?)");) {
            s.setString(1, n);
            s.setInt(2, cl);
            s.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void delete_Client(int cl) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("delete from Clients where Serial=? ");) {
            s.setInt(1, cl);

            s.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int z1 = 0;

    public static void Check_Client(int cl) {

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("select * from Clients where Serial=? ");) {
            s.setInt(1, cl);

            try (ResultSet r = s.executeQuery()) {
                if (r.next()) {
                    z1 = 1;
                } else {
                    z1 = 2;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int Get_Tickets(String n) {
        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("select Tickets from Events where Event_Name=? ");) {
            s.setString(1, n);

            try (ResultSet r = s.executeQuery()) {
                if (r.next()) {
                    Ticket = r.getInt(1);
                } else {
                    z1 = 2;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Ticket;
    }

    public static void Book(int se, String na) {
        Check_Event(na);
        Check_Client(se);
        Get_Tickets(na);
        if (z1 == 1 && z == 1) {

            try (Connection c = Connect();
                    PreparedStatement s2 = c.prepareStatement("update Clients set Previous_Events=Up_Comming_Events where Serial=? ");) {

                s2.setInt(1, se);
                s2.execute();

                PreparedStatement s = c.prepareStatement("update Clients set Up_Comming_Events=? where Serial=?   ");
                s.setString(1, na);
                s.setInt(2, se);
                s.execute();
                Ticket = Ticket - 1;

                PreparedStatement s1 = c.prepareStatement("update Events set Tickets=? where Event_Name =?  ");
                s1.setInt(1, Ticket);
                s1.setString(2, na);
                s1.execute();
                JOptionPane.showMessageDialog(null, "Done ", "Book", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, " Error  ", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void UnBook(int se, String na) {
        Check_Event(na);
        Check_Client(se);

        if (z1 == 1 && z == 1) {

            try (Connection c = Connect();
                    PreparedStatement s = c.prepareStatement("update Clients set Up_Comming_Events=Null  where Serial=? ");) {
                s.setInt(1, se);
                s.execute();

                PreparedStatement s1 = c.prepareStatement("update Events set Tickets=? where Event_Name =?  ");
                s1.setInt(1, Ticket);
                s1.setString(2, na);
                s1.execute();
                JOptionPane.showMessageDialog(null, "Done ", "UnBook", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, " Error  ", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
