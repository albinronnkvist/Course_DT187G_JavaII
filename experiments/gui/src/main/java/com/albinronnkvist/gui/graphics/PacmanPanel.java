package com.albinronnkvist.gui.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PacmanPanel extends JPanel 
{
    private Pacman pacman;

    public PacmanPanel() {
        pacman = new Pacman();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pacman.toggleMouthOpen();
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        pacman.setLocation(getWidth() / 2, getHeight() / 2);
        pacman.setSize(Math.min(getWidth(), getHeight()) - 10);
        pacman.draw(g);
    }

    private class Pacman {
        private int x;
        private int y;
        private int size;
        private boolean mouthOpen;

        public Pacman() {
            x = y = 0;
            size = 40;
            mouthOpen = true;
        }

        public void setLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void toggleMouthOpen() {
            mouthOpen = !mouthOpen;
        }

        public void draw(Graphics g) {
            int startAngle = 30;
            int arcAngle = 300;
            if (!mouthOpen) {
                startAngle = 10;
                arcAngle = 340;
            }

            g.setColor(Color.YELLOW);
            g.fillArc(x - size / 2, y - size / 2, size, size, startAngle, arcAngle);

            g.setColor(Color.BLACK);
            g.drawArc(x - size / 2, y - size / 2, size, size, startAngle, arcAngle);

            g.drawLine(x, y,
                    x + (int) (size / 2 * Math.cos(Math.toRadians(startAngle))),
                    y + (int) (size / 2 * Math.sin(Math.toRadians(startAngle))));
            g.drawLine(x, y,
                    x + (int) (size / 2 * Math.cos(Math.toRadians(arcAngle + startAngle))),
                    y + (int) (size / 2 * Math.sin(Math.toRadians(arcAngle + startAngle))));

            int eyeSize = size / 6;
            g.fillOval(x + size / 10, y - (int) (size / 2.5), eyeSize, eyeSize);
        }
    }
}
