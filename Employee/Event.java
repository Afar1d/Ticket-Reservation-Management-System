package Employee;

import static Database.Admin_DB.Connect;
import static Database.Admin_DB.z;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import project.Image;

public class Event extends Image implements ActionListener {

    JButton done;
    JTextField t23;
    JLabel l23;
    Image i;
    static JButton  Back2;
    ////////////////////////////////////////////////////////

    public Event() {
        done = new JButton("Search");
        t23 = new JTextField();
        l23 = new JLabel("Event Name :");
        i = new Image();
        Back2 = new JButton("Back");
        ////////////////////////////////////////////////////////
        l23.setBounds(25, 25, 150, 25);
        add(l23);
        t23.setBounds(165, 25, 150, 25);
        add(t23);
        done.setBounds(100, 65, 200, 50);
        add(done);
        done.addActionListener(this);
         Back2.setBounds(160, 120, 80, 40);
        add(Back2);
    }

    public void showEvent(String b) throws SQLException {
        JLabel l1, l2, l3, l4, l5, l6;
        JTextField tf1, tf2, tf3, tf4, tf5, tf6;
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();

        JFrame f1 = new JFrame();

        f1.setSize(500, 500);
        f1.setVisible(true);
        f1.setResizable(false);
        f1.setLocation(700, 200);

        f1.setLayout(null);

        f1.setTitle("Event Information");

        l1 = new JLabel("Event Name:");

        l2 = new JLabel("Place:");

        l3 = new JLabel("Time:");

        l4 = new JLabel("Description:");
        l5 = new JLabel("Tickets:");
        l6 = new JLabel("Category:");

        l1.setBounds(20, 110, 200, 20);

        l2.setBounds(20, 140, 200, 20);

        l3.setBounds(20, 170, 200, 20);

        l4.setBounds(20, 200, 200, 20);
        l5.setBounds(20, 230, 200, 20);
        l6.setBounds(20, 260, 260, 20);
        tf1.setBounds(240, 110, 200, 20);

        tf2.setBounds(240, 140, 200, 20);

        tf3.setBounds(240, 170, 200, 20);

        tf4.setBounds(240, 200, 200, 20);
        tf5.setBounds(240, 230, 200, 20);
        tf6.setBounds(240, 260, 200, 20);
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);

        f1.add(l1);

        f1.add(tf1);

        f1.add(l2);

        f1.add(tf2);

        f1.add(l3);

        f1.add(tf3);

        f1.add(l4);
        f1.add(tf4);
        f1.add(l5);
        f1.add(l6);

        f1.add(tf5);
        f1.add(tf6);

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("select * from Events where Event_Name=? ");) {

            s.setString(1, b);

            try (ResultSet r = s.executeQuery()) {

                while (r.next()) {

                    tf1.setText(r.getString(1));

                    tf2.setText(r.getString(2));

                    tf3.setText(r.getString(3));

                    tf4.setText(r.getString(4));
                    tf5.setText(r.getString(5));
                    tf6.setText(r.getString(6));

                } 
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {
            Database.Employee_DB.Check_Event(t23.getText());
            if(z==1){
            try {

                showEvent(t23.getText());

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            }
            else if (z==2)  
                JOptionPane.showMessageDialog(null, "Event not found ", "Erorr", JOptionPane.WARNING_MESSAGE);
        }

    }
}
