package Admin;

import static Admin.Add.Back1;
import static Admin.Edit.Back2;
import static Admin.DeleteC.Back3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import project.SignInFrame;

public class AdminFrame extends JFrame implements ActionListener {

    JTabbedPane tab;
    Add a1;
    Edit e1;
    DeleteC d1;

    public AdminFrame() {

    }

    public void Show_AdminFrame() {
        a1 = new Add();
        e1 = new Edit();
        d1 = new DeleteC();
        tab = new JTabbedPane();
        /////////////////////////////////////////////////
        this.setTitle("Admin");
        this.setSize(400, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(700, 200);
        //////////////////////////////////////////////////////////
        tab.addTab("Add", a1);
        tab.addTab("Edit", e1);
        tab.addTab("Remove", d1);
        add(tab);
        Back1.addActionListener(this);
        Back2.addActionListener(this);
        Back3.addActionListener(this);
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
    }
}
