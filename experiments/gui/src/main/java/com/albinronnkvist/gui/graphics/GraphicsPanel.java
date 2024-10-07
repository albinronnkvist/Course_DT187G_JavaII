package com.albinronnkvist.gui.graphics;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.ImageIcon;

public class GraphicsPanel extends JPanel {
    Image image;
    public GraphicsPanel() {
        this.setPreferredSize(new Dimension(500, 500));
        image = new ImageIcon(getClass().getResource("/java.png")).getImage();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.RED);
        g2d.drawLine(0, 0, 500, 500);

        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, 100, 100);


        g2d.setColor(Color.GREEN);
        g2d.drawOval(100, 100, 100, 100);

        g2d.setColor(Color.MAGENTA);
        g2d.setFont(new Font("SansSerif", Font.BOLD, 50));
        g2d.drawString("Hello lad", 200, 200);
        
        g2d.drawImage(image, 0, 0, null);
    }
}
