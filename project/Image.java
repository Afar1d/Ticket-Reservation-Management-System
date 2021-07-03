package project;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Image extends JPanel {

    private ImageIcon i;

    public Image() {
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        i = new ImageIcon(getClass().getResource("..\\Project\\V1.jpeg"));
        i.paintIcon(this, g, 0, 0);
    }

}
