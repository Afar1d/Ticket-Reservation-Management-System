package Admin;

import static Database.Crew.z;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import project.Image;

public class Add extends Image implements ActionListener {

    JRadioButton r3, r4;
    JTextField t6, t7, t8, t9, t10, t11, t12;
    JLabel l6, l7, l8, l9, l10, l11, l12;
    static JButton add, Back1;
    ButtonGroup g2;

    ////////////////////////////////////////////////////////
   
    public Add() {
        add = new JButton("ADD");
        Back1 = new JButton("Back");
        r3 = new JRadioButton("Category");
        r4 = new JRadioButton("Event");
        l6 = new JLabel("Category Name :");
        l7 = new JLabel("Event Name :");
        l8 = new JLabel("Event Time :");
        l9 = new JLabel("Event Place :");
        l10 = new JLabel("Event Description :");
        l11 = new JLabel("Category Name :");
        l12 = new JLabel(" Tickets :");
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();
        t11 = new JTextField();
        t12 = new JTextField();
        g2 = new ButtonGroup();
        ////////////////////////////////////////////////////////
        r3.setBounds(100, 25, 100, 50);
        g2.add(r3);
        add(r3);
        r4.setBounds(200, 25, 100, 50);
        g2.add(r4);
        add(r4);
        l6.setBounds(25, 75, 100, 25);
        add(l6);
        t6.setBounds(165, 75, 150, 25);
        add(t6);
        l7.setBounds(25, 75, 100, 25);
        add(l7);
        t7.setBounds(165, 75, 150, 25);
        add(t7);
        l8.setBounds(25, 110, 100, 25);
        add(l8);
        t8.setBounds(165, 110, 150, 25);
        add(t8);
        l9.setBounds(25, 145, 100, 25);
        add(l9);
        t9.setBounds(165, 145, 150, 25);
        add(t9);
        l10.setBounds(25, 180, 150, 25);
        add(l10);
        t10.setBounds(165, 180, 150, 25);
        add(t10);
        l11.setBounds(25, 215, 150, 25);
        l12.setBounds(25, 250, 150, 25);
        add(l11);
        add(l12);
        t11.setBounds(165, 215, 150, 25);
        add(t11);
        t12.setBounds(165, 250, 150, 25);
        add(t12);
        add.setBounds(100, 275, 200, 50);
        Back1.setBounds(160, 327, 80, 40);
        add(Back1);
        t6.setVisible(false);
        l6.setVisible(false);
        t7.setVisible(false);
        l7.setVisible(false);
        t8.setVisible(false);
        l8.setVisible(false);
        t9.setVisible(false);
        l9.setVisible(false);
        t10.setVisible(false);
        l10.setVisible(false);
        t11.setVisible(false);
        l11.setVisible(false);
        t12.setVisible(false);
        l12.setVisible(false);
        add(add);
        r3.addActionListener(this);
        r4.addActionListener(this);
        add.addActionListener(this);

    }
    static int x = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == r3) {
            t6.setVisible(true);
            l6.setVisible(true);
            t7.setVisible(false);
            l7.setVisible(false);
            t8.setVisible(false);
            l8.setVisible(false);
            t9.setVisible(false);
            l9.setVisible(false);
            t10.setVisible(false);
            l10.setVisible(false);
            t11.setVisible(false);
            l11.setVisible(false);
            t12.setVisible(false);
            l12.setVisible(false);
        }
        if (e.getSource() == r4) {
            t6.setVisible(false);
            l6.setVisible(false);
            t7.setVisible(true);
            l7.setVisible(true);
            t8.setVisible(true);
            l8.setVisible(true);
            t9.setVisible(true);
            l9.setVisible(true);
            t10.setVisible(true);
            l10.setVisible(true);
            t11.setVisible(true);
            l11.setVisible(true);
            t12.setVisible(true);
            l12.setVisible(true);

        }

        if (e.getSource() == r3) {
            x = 1;

        } else if (e.getSource() == r4) {
            x = 2;
        }

        if (e.getSource() == add) {

            switch (x) {

                case 1:
                    if (t6.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, " Please, fill field  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Database.Admin_DB.insert(t6.getText());
                        JOptionPane.showMessageDialog(null, "Done ", "Add Category", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 2:
                    if (t7.getText().equals("") || t8.getText().equals("") || t9.getText().equals("") || t10.getText().equals("") || t11.getText().equals("") || t12.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, " Please, fill all field  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    } else {
                            Database.Crew.Check_category(t11.getText());
                            if(z==1){
                        int ti = Integer.parseInt(t12.getText());
                        Database.Admin_DB.insert(t7.getText(), t9.getText(), t8.getText(), t10.getText(), ti, t11.getText());
                        JOptionPane.showMessageDialog(null, "Done ", "Add Events", JOptionPane.INFORMATION_MESSAGE);}
                            else if (z==2)
                                JOptionPane.showMessageDialog(null, "Category not found ", "Erorr", JOptionPane.WARNING_MESSAGE);
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
