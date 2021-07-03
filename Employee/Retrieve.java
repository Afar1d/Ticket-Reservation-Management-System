package Employee;

import static Database.Admin_DB.Connect;
import static Database.Admin_DB.z;
import static Database.Employee_DB.z1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import project.Image;

public class Retrieve extends Image implements ActionListener {

    JRadioButton r9, r10;
    JTextField t26, t27;
    JLabel l26, l27;
    JButton retrieve;
    ButtonGroup g5;
     static JButton  Back4;
    ////////////////////////////////////////////////////////

    public Retrieve() {
        retrieve = new JButton("Done");
        r9 = new JRadioButton("Client");
        r10 = new JRadioButton("Events");
        l26 = new JLabel("Client Serial :");
        l27 = new JLabel("Category Name :");
        t26 = new JTextField();
        t27 = new JTextField();
        g5 = new ButtonGroup();
         Back4 = new JButton("Back");

        ////////////////////////////////////////////////////////
        r9.setBounds(100, 25, 100, 50);
        g5.add(r9);
        add(r9);
        r10.setBounds(200, 25, 100, 50);
        g5.add(r10);
        add(r10);
        l26.setBounds(25, 75, 100, 25);
        add(l26);
        t26.setBounds(165, 75, 150, 25);
        add(t26);
        l27.setBounds(25, 75, 100, 25);
        add(l27);
        t27.setBounds(165, 75, 150, 25);
        add(t27);
        retrieve.setBounds(100, 255, 200, 50);
        add(retrieve);
        t26.setVisible(false);
        l26.setVisible(false);
        t27.setVisible(false);
        l27.setVisible(false);
        r9.addActionListener(this);
        r10.addActionListener(this);
        retrieve.addActionListener(this);
        Back4.setBounds(160, 307, 80, 40);
        add(Back4);

    }

    public void showClient(String b) throws SQLException {
        JLabel l1, l2, l3, l4;
        JTextField tf1, tf2, tf3, tf4;
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();

        JFrame f1 = new JFrame();

        f1.setSize(500, 500);
        f1.setVisible(true);
        f1.setResizable(false);
        f1.setLocation(700, 200);

        f1.setLayout(null);

        f1.setTitle("Client Information");

        l1 = new JLabel("Client Name:");

        l2 = new JLabel("Serial:");

        l3 = new JLabel("Previous Events:");

        l4 = new JLabel("Up Coming Events:");

        l1.setBounds(20, 110, 200, 20);

        l2.setBounds(20, 140, 200, 20);

        l3.setBounds(20, 170, 200, 20);

        l4.setBounds(20, 200, 200, 20);

        tf1.setBounds(240, 110, 200, 20);

        tf2.setBounds(240, 140, 200, 20);

        tf3.setBounds(240, 170, 200, 20);

        tf4.setBounds(240, 200, 200, 20);

        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);

        f1.add(l1);

        f1.add(tf1);

        f1.add(l2);

        f1.add(tf2);

        f1.add(l3);

        f1.add(tf3);

        f1.add(l4);
        f1.add(tf4);

        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("select * from Clients where Serial=? ");) {

            s.setString(1, b);

            try (ResultSet r = s.executeQuery()) {

                while (r.next()) {

                    tf1.setText(r.getString(1));

                    tf2.setText(r.getString(2));

                    tf3.setText(r.getString(3));

                    tf4.setText(r.getString(4));

                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

     public void showCategory(String b) throws SQLException {

        JLabel l;
        JTextField tf;
        JFrame f = new JFrame();

        f.setSize(500, 500);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocation(700, 200);

        f.setLayout(null);

        f.setTitle("Category Information");

        int x = 110;
        int y = 110;
        int counter =80 ;
        try (Connection c = Connect();
                PreparedStatement s = c.prepareStatement("select * from Events where Category_Name=? ");) {

            s.setString(1, b);
            
            try (ResultSet r = s.executeQuery()) {

                for (int i = 1; i < counter; i++) {
                    while (r.next()) {
                        l = new JLabel("Event Name:");
                        tf = new JTextField();
                        l.setBounds(20, x, 200, 20);
                        tf.setBounds(240, y, 200, 20);
                        tf.setEditable(false);
                        f.add(l);
                        f.add(tf);
                        tf.setText(r.getString(1));
                        x += 30;
                        y += 30;
                    }

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    static int fl = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == r9) {
            t27.setVisible(false);
            l27.setVisible(false);
            t26.setVisible(true);
            l26.setVisible(true);

        }
        if (e.getSource() == r10) {
            t27.setVisible(true);
            l27.setVisible(true);
            t26.setVisible(false);
            l26.setVisible(false);

        }
        if (e.getSource() == r9) {
            fl = 1;
        } else if (e.getSource() == r10) {
            fl = 2;
        }

        if (e.getSource() == retrieve) {
            switch (fl) {

                case 1:
                       if (t26.getText().equals("")  ) {
                        JOptionPane.showMessageDialog(null, " Please, fill all fields  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    } else {
                    int serial = Integer.parseInt(t26.getText());
                    Database.Employee_DB.Check_Client(serial);
                    if (z1 == 1) {
                        try {

                            showClient(t26.getText());

                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else if (z1 == 2) {
                        JOptionPane.showMessageDialog(null, "Client not found ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    }
                       }
                    break;
                case 2:
                       if (t27.getText().equals("") ) {
                        JOptionPane.showMessageDialog(null, " Please, fill all fields  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    } else {
                    Database.Crew.Check_category(t27.getText());
                    if (z == 1) {
                        try {

                            showCategory(t27.getText());

                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else if (z == 2) {
                        JOptionPane.showMessageDialog(null, "Category not found ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                       }
            }
        }

    }
}
