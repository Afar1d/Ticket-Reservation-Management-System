package Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import project.Image;

public class AddClient extends Image implements ActionListener {

    JButton addC;
    JTextField t20, t21;
    JLabel l20, l21;
    static JButton  Back1;
    ////////////////////////////////////////////////////////

    public AddClient() {

        addC = new JButton("Add");

        t20 = new JTextField();
        t21 = new JTextField();
        l20 = new JLabel("Client Name :");
        l21 = new JLabel("Client Serial :");
        Back1 = new JButton("Back");
        ////////////////////////////////////////////////////////

        l20.setBounds(25, 25, 150, 25);
        add(l20);
        t20.setBounds(165, 25, 150, 25);
        add(t20);
        l21.setBounds(25, 60, 150, 25);
        add(l21);
        t21.setBounds(165, 60, 150, 25);
        add(t21);

        addC.setBounds(100, 100, 200, 50);
        add(addC);
        addC.addActionListener(this);
        Back1.setBounds(160, 160, 80, 40);
        add(Back1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addC)
        {
            if (t20.getText().equals("") || t21.getText().equals("") ) {
                        JOptionPane.showMessageDialog(null, " Please, fill all fields  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    } else {
            int cl = Integer.parseInt(t21.getText()) ;
            Database.Employee_DB.insert_Client(t20.getText(),cl) ;
            JOptionPane.showMessageDialog(null, "Done ", "Add Client", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
}
