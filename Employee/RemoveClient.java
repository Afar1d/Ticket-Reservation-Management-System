package Employee;

import static Database.Employee_DB.z1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import project.Image;

public class RemoveClient extends Image implements ActionListener{

    JButton removeC;
    JTextField t22;
    JLabel l22;
    static JButton  Back3;
    ////////////////////////////////////////////////////////

    public RemoveClient() {
        removeC = new JButton("Remove");
        t22 = new JTextField();
        l22 = new JLabel("Client Serial :");
        Back3 = new JButton("Back");
        ////////////////////////////////////////////////////////

        l22.setBounds(25, 25, 150, 25);
        add(l22);
        t22.setBounds(165, 25, 150, 25);
        add(t22);
        removeC.setBounds(100, 65, 200, 50);
        add(removeC);
        removeC.addActionListener(this);
        Back3.setBounds(160, 120, 80, 40);
        add(Back3);

    }
        @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == removeC) {
             if (t22.getText().equals("")  ) {
                        JOptionPane.showMessageDialog(null, " Please, fill all fields  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    } else {
                    int cl = Integer.parseInt(t22.getText()) ;
          
                    Database.Employee_DB.Check_Client(cl);

                    if (z1 == 1) {
                        Database.Employee_DB.delete_Client(cl);
                        JOptionPane.showMessageDialog(null, "OK ", "delete Client", JOptionPane.INFORMATION_MESSAGE);
                    } else if (z1 == 2) {
                        JOptionPane.showMessageDialog(null, " Client not found ", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    }
}
    }
}