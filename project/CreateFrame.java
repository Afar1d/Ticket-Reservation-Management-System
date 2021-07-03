package project;

import Database.Crew;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreateFrame extends JFrame implements ActionListener {

    Image i2;
    JButton b4, b5;
    JTextField t3;
    JPasswordField t4;
    JLabel l3, l4;
    JRadioButton r1, r2;
    ButtonGroup g1;
    Crew a= new Crew();
    
    //Encapsulation
    String name ;
    String password ;
    int id ;
    
    
    public CreateFrame() {

    }

    public void Show_CreateFrame() {
        i2 = new Image();
        l3 = new JLabel("UserName");
        l4 = new JLabel("Password");
        t3 = new JTextField();
        t4 = new JPasswordField();
        b4 = new JButton("Create");
        b5 = new JButton("Back");
        r1 = new JRadioButton("Admin");
        r2 = new JRadioButton("Employee");
        g1 = new ButtonGroup();

        /////////////////////////////////////////////////////////
        this.setTitle("Create");
        this.setSize(400, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(700, 200);
        /////////////////////////////////////////////////////////
        l3.setBounds(10, 10, 100, 25);
        i2.add(l3);
        t3.setBounds(100, 10, 200, 25);
        i2.add(t3);
        l4.setBounds(10, 50, 100, 25);
        i2.add(l4);
        t4.setBounds(100, 50, 200, 25);
        i2.add(t4);
        r1.setBounds(110, 120, 100, 50);
        g1.add(r1);
        i2.add(r1);
        r2.setBounds(210, 120, 100, 50);
        g1.add(r2);
        i2.add(r2);
        b4.setBounds(100, 170, 200, 50);
        i2.add(b4);
        b5.setBounds(160, 222, 80, 40);
        i2.add(b5);
        add(i2);

        r1.addActionListener(this);
        r2.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
    }
    static int x = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == r1) {
            x = 1;

        } else if (e.getSource() == r2) {
            x = 2;
        } 

        if (e.getSource() == b4) {

            switch (x) {

                case 1:
                    name = t3.getText();
                    a.setName(name);
                    password = t4.getText();
                    a.setPassword(password);
                    if (name.equals("") || password.equals("") ) {
                        JOptionPane.showMessageDialog(null, " Please, fill all fields  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Database.Create_DB.Insert_Admin(name, password);
                        JOptionPane.showMessageDialog(null, "Done ", "Add Admin", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        new SignInFrame().Show_SignInFrame();
                    }
                    break;

                case 2:
                    name = t3.getText();
                    password = t4.getText();
                    if (name.equals("") || password.equals("") ) {
                        JOptionPane.showMessageDialog(null, " Please, fill all fields  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Database.Create_DB.Insert_Employee(name, password);
                        JOptionPane.showMessageDialog(null, "Done ", "Add Emloyee", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        new SignInFrame().Show_SignInFrame();
                    }
                    break;
                  case 0:
                     JOptionPane.showMessageDialog(null, " Please, fill all fields and make sure that is for Admin or Employee  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                       break;
                default:

                    break;
            }

        }

        if (e.getSource() == b5) {
            this.dispose();
            new SignInFrame().Show_SignInFrame();
        }
    }

}
