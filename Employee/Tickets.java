package Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import project.Image;

public class Tickets extends Image implements ActionListener{
    
    
    
    JButton book, unbook;
    JTextField t24, t25;
    JLabel l24, l25;
     static JButton  Back5;
    ////////////////////////////////////////////////////////

    public Tickets() {
        book = new JButton("Book");
        unbook = new JButton("UnBook");
        t24 = new JTextField();
        t25 = new JTextField();
        l24 = new JLabel("Client Serial :");
        l25 = new JLabel("Event Name :");
        Back5 = new JButton("Back");
        ////////////////////////////////////////////////////////
        l24.setBounds(25, 25, 150, 25);
        add(l24);
        t24.setBounds(165, 25, 150, 25);
        add(t24);
        l25.setBounds(25, 60, 150, 25);
        add(l25);
        t25.setBounds(165, 60, 150, 25);
        add(t25);
        book.setBounds(50, 100, 150, 50);
        add(book);
        unbook.setBounds(210, 100, 150, 50);
        add(unbook);
        Back5.setBounds(160, 170, 80, 40);
        add(Back5);
        book.addActionListener(this);
        unbook.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == book )
       {
              if (t24.getText().equals("") || t25.getText().equals("") ) {
                        JOptionPane.showMessageDialog(null, " Please, fill all fields  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    } else {
           int se = Integer.parseInt(t24.getText());
           Database.Employee_DB.Book(se,t25.getText());
              }
       }
        if (e.getSource() == unbook )
       {
              if (t24.getText().equals("") || t25.getText().equals("") ) {
                        JOptionPane.showMessageDialog(null, " Please, fill all fields  ", "Erorr", JOptionPane.WARNING_MESSAGE);
                    } else {
           int se = Integer.parseInt(t24.getText());
           Database.Employee_DB.UnBook(se,t25.getText());
              }
       }
    }
}
