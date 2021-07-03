package Employee;

import javax.swing.*;
import static Employee.AddClient.Back1;
import static Employee.Event.Back2;
import static Employee.RemoveClient.Back3;
import static Employee.Retrieve.Back4;
import static Employee.Tickets.Back5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import project.SignInFrame;

public class EmployeeFrame extends JFrame implements ActionListener {

    JTabbedPane tab2;
    AddClient a2;
    RemoveClient r2;
    Event e1;
    Tickets tc1;
    Retrieve rt1;
    /////////////////////////////////////////////////////

    public EmployeeFrame() {

    }

    public void Show_EmployeeFrame() {
        a2 = new AddClient();
        r2 = new RemoveClient();
        tab2 = new JTabbedPane();
        e1 = new Event();
        tc1 = new Tickets();
        rt1 = new Retrieve();
        /////////////////////////////////////////////////
        this.setTitle("Employee");
        this.setSize(400, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(700, 200);
        //////////////////////////////////////////////////////////
        tab2.addTab("Add", a2);
        tab2.addTab("Remove", r2);
        tab2.addTab("Event", e1);
        tab2.addTab("Tickets", tc1);
        tab2.addTab("Retrieve", rt1);
        add(tab2);
        Back1.addActionListener(this);
        Back2.addActionListener(this);
        Back3.addActionListener(this);
        Back4.addActionListener(this);
        Back5.addActionListener(this);
    }
        @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back1) {
            this.dispose();
            new SignInFrame().Show_SignInFrame();
        }
        if (e.getSource() == Back2) {
            this.dispose();
            new SignInFrame().Show_SignInFrame();
        }
        if (e.getSource() == Back3) {
            this.dispose();
            new SignInFrame().Show_SignInFrame();
        }    
            if (e.getSource() == Back4) {
            this.dispose();
            new SignInFrame().Show_SignInFrame();
                   
            }   
           if (e.getSource() == Back5) {
            this.dispose();
            new SignInFrame().Show_SignInFrame();
                    
           }
    }
}
