package Admin;

import static Admin.Edit.x;
import Database.Admin_DB;
import static Database.Admin_DB.z;
import Database.Crew;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import project.Image;


public class DeleteC extends Image implements ActionListener {

    JRadioButton r7, r8;
    static JButton remove, Back3;
    ButtonGroup g4;
    JTextField t18, t19;
    JLabel l18, l19;
    Crew d1 =new Crew();
    Admin_DB d2=new Admin_DB();

    ////////////////////////////////////////////////////////
    public DeleteC() {
        remove = new JButton("Remove");
        Back3 = new JButton("Back");
        r7 = new JRadioButton("Category");
        r8 = new JRadioButton("Event");
        g4 = new ButtonGroup();
        t18 = new JTextField();
        t19 = new JTextField();
        l18 = new JLabel("Category Name :");
        l19 = new JLabel("Event Name :");
        ////////////////////////////////////////////////////////
        r7.setBounds(100, 25, 100, 50);
        g4.add(r7);
        add(r7);
        r8.setBounds(200, 25, 100, 50);
        g4.add(r8);
        add(r8);
        l18.setBounds(25, 75, 150, 25);
        add(l18);
        t18.setBounds(165, 75, 150, 25);
        add(t18);
        l19.setBounds(25, 75, 150, 25);
        add(l19);
        t19.setBounds(165, 75, 150, 25);
        add(t19);
        Back3.setBounds(160, 307, 80, 40);
        add(Back3);
        t18.setVisible(false);
        l18.setVisible(false);
        t19.setVisible(false);
        l19.setVisible(false);
        remove.setBounds(100, 255, 200, 50);
        add(remove);
        r7.addActionListener(this);
        r8.addActionListener(this);
        remove.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == r7) {
            t18.setVisible(true);
            l18.setVisible(true);
            t19.setVisible(false);
            l19.setVisible(false);

        }
        if (e.getSource() == r8) {

            t18.setVisible(false);
            l18.setVisible(false);
            t19.setVisible(true);
            l19.setVisible(true);
        }

        if (e.getSource() == r7) {
            x = 1;

        } else if (e.getSource() == r8) {
            x = 2;
        }

        if (e.getSource() == remove) {

            switch (x) {

                case 1:
                    Database.Admin_DB.Check_category(t18.getText());

                    if (z == 1) {
                        d1.delete(t18.getText());
                        JOptionPane.showMessageDialog(null, "OK ", "delete Category", JOptionPane.INFORMATION_MESSAGE);
                    } else if (z == 2) {
                        JOptionPane.showMessageDialog(null, " Category not found ", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 2:

                    Database.Crew.Check_Event(t19.getText());

                    if (z == 1) {
                        d2.delete(t19.getText());
                        JOptionPane.showMessageDialog(null, "OK ", "delete Events", JOptionPane.INFORMATION_MESSAGE);
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
