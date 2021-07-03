package Admin;

import static Database.Admin_DB.z;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import project.Image;

public class Edit extends Image implements ActionListener {

    JRadioButton r5, r6;
    static JButton edit, Back2;
    ButtonGroup g3;
    JTextField t11, t12, t13, t14, t15, t16, t17, t18;
    JLabel l11, l12, l13, l14, l15, l16, l17, l18;
    ////////////////////////////////////////////////////////

    public Edit() {
        edit = new JButton("Done");
        Back2 = new JButton("Back");
        r5 = new JRadioButton("Category");
        r6 = new JRadioButton("Event");
        g3 = new ButtonGroup();
        t11 = new JTextField();
        t12 = new JTextField();
        t13 = new JTextField();
        t14 = new JTextField();
        t15 = new JTextField();
        t16 = new JTextField();
        t17 = new JTextField();
        t18 = new JTextField();
        l11 = new JLabel("Old Category Name :");
        l12 = new JLabel("New Category Name :");
        l13 = new JLabel("Old Event Name :");
        l14 = new JLabel("New Event Name :");
        l15 = new JLabel("New Event Time :");
        l16 = new JLabel("New Event Place :");
        l17 = new JLabel("New Event Discraption :");
        l18 = new JLabel("New Category Name:");
        ////////////////////////////////////////////////////////
        r5.setBounds(100, 25, 100, 50);
        g3.add(r5);
        add(r5);
        r6.setBounds(200, 25, 100, 50);
        g3.add(r6);
        add(r6);
        l11.setBounds(25, 75, 150, 25);
        add(l11);
        t11.setBounds(165, 75, 150, 25);
        add(t11);
        l12.setBounds(25, 110, 150, 25);
        add(l12);
        t12.setBounds(165, 110, 150, 25);
        add(t12);
        l13.setBounds(25, 75, 150, 25);
        add(l13);
        t13.setBounds(165, 75, 150, 25);
        add(t13);
        l14.setBounds(25, 110, 150, 25);
        add(l14);
        t14.setBounds(165, 110, 150, 25);
        add(t14);
        l15.setBounds(25, 145, 150, 25);
        add(l15);
        t15.setBounds(165, 145, 150, 25);
        add(t15);
        l16.setBounds(25, 180, 150, 25);
        add(l16);
        t16.setBounds(165, 180, 150, 25);
        add(t16);
        l17.setBounds(25, 215, 150, 25);
        add(l17);
        t17.setBounds(165, 215, 150, 25);
        add(t17);
        l18.setBounds(25, 250, 150, 25);
        add(l18);
        t18.setBounds(165, 250, 150, 25);
        add(t18);
        Back2.setBounds(160, 342, 80, 40);
        add(Back2);
        t11.setVisible(false);
        l11.setVisible(false);
        t12.setVisible(false);
        l12.setVisible(false);
        t13.setVisible(false);
        l13.setVisible(false);
        t14.setVisible(false);
        l14.setVisible(false);
        t15.setVisible(false);
        l15.setVisible(false);
        t16.setVisible(false);
        l16.setVisible(false);
        t17.setVisible(false);
        l17.setVisible(false);
        t18.setVisible(false);
        l18.setVisible(false);
        edit.setBounds(100, 290, 200, 50);
        add(edit);

        r5.addActionListener(this);
        r6.addActionListener(this);
        edit.addActionListener(this);

    }
    static int x = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == r5) {
            t11.setVisible(true);
            l11.setVisible(true);
            t12.setVisible(true);
            l12.setVisible(true);
            t13.setVisible(false);
            l13.setVisible(false);
            t14.setVisible(false);
            l14.setVisible(false);
            t15.setVisible(false);
            l15.setVisible(false);
            t16.setVisible(false);
            l16.setVisible(false);
            t17.setVisible(false);
            l17.setVisible(false);
            t18.setVisible(false);
            l18.setVisible(false);
        }
        if (e.getSource() == r6) {
            t11.setVisible(false);
            l11.setVisible(false);
            t12.setVisible(false);
            l12.setVisible(false);
            t13.setVisible(true);
            l13.setVisible(true);
            t14.setVisible(true);
            l14.setVisible(true);
            t15.setVisible(true);
            l15.setVisible(true);
            t16.setVisible(true);
            l16.setVisible(true);
            t17.setVisible(true);
            l17.setVisible(true);
            t18.setVisible(true);
            l18.setVisible(true);

        }
        if (e.getSource() == r5) {
            x = 1;

        } else if (e.getSource() == r6) {
            x = 2;
        }

        if (e.getSource() == edit) {

            switch (x) {

                case 1:

                    Database.Admin_DB.Check_category(t11.getText());
                    if (z == 1) {
                        Database.Admin_DB.update_Category(t11.getText(), t12.getText());
                        JOptionPane.showMessageDialog(null, "OK ", "Edit Category", JOptionPane.INFORMATION_MESSAGE);
                    } else if (z == 2) {
                        JOptionPane.showMessageDialog(null, " Category not found ", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 2:
                    Database.Admin_DB.Check_Event(t13.getText());

                    if (z == 1) {
                        Database.Crew.Check_category(t18.getText());
                        if (z == 1) {
                            Database.Admin_DB.update_Events(t13.getText(), t14.getText(), t15.getText(), t16.getText(), t17.getText(), t18.getText());
                            JOptionPane.showMessageDialog(null, "OK ", "Edit Events", JOptionPane.INFORMATION_MESSAGE);
                        } else if (z == 2) {
                            JOptionPane.showMessageDialog(null, "Category not found ", "Erorr", JOptionPane.WARNING_MESSAGE);
                        }
                    } else if (z == 2) {
                        JOptionPane.showMessageDialog(null, " Event not found ", "Error", JOptionPane.WARNING_MESSAGE);
                    }

                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, " Please, choose category or Events  ", "Error", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    break;
            }

        }
    }
}
