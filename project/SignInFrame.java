package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static Database.SignIn_DB.y;

public class SignInFrame extends JFrame implements ActionListener {

    Image i1;
    JButton b1, b2, b3;
    JTextField t1, t2;
    JLabel l1, l2;

    public SignInFrame() {

    }

    public void Show_SignInFrame() {
        i1 = new Image();
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        t1 = new JTextField();
        t2 = new JPasswordField();
        b1 = new JButton("Sign In As Admin");
        b2 = new JButton("Sign In As Employee");
        b3 = new JButton("Create New Account");

        /////////////////////////////////////////////////////////////
        this.setTitle("Sign In");
        this.setSize(400, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(700, 200);
        //////////////////////////////////////////////////////////
        l1.setBounds(10, 10, 100, 25);
        i1.add(l1);
        t1.setBounds(100, 10, 200, 25);
        i1.add(t1);
        l2.setBounds(10, 50, 100, 25);
        i1.add(l2);
        t2.setBounds(100, 50, 200, 25);
        i1.add(t2);
        b1.setBounds(50, 100, 150, 50);
        i1.add(b1);
        b2.setBounds(210, 100, 150, 50);
        i1.add(b2);
        b3.setBounds(100, 160, 200, 50);
        i1.add(b3);
        add(i1);
        b3.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b3) {
            this.dispose();
            new CreateFrame().Show_CreateFrame();
        }
        if (e.getSource() == b1) {
            Database.SignIn_DB.Check_Admin(t1.getText(), t2.getText());
            switch (y) {
                case 1:
                    this.dispose();
                    new Admin.AdminFrame().Show_AdminFrame();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, " Username or Password Wrong ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    break;

                default:

                    break;
            }
        }
        if (e.getSource() == b2) {
            Database.SignIn_DB.Check_Employee(t1.getText(), t2.getText());
            switch (y) {
                case 1:
                    this.dispose();
                    new Employee.EmployeeFrame().Show_EmployeeFrame();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Username or Password Wrong ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    break;

                default:
                    break;
            }
        }
    }
}
