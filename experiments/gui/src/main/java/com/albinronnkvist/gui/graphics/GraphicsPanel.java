package com.albinronnkvist.gui.graphics;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GraphicsPanel extends JPanel {
    Image image;

    public GraphicsPanel() {
        this.setPreferredSize(new Dimension(500, 500));
        image = new ImageIcon(getClass().getResource("/java.png")).getImage();
    }

    public void paint(Graphics g) {
        colorGradientExamples(g);
    }

    private void colorGradientExamples(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int x1 = 20;
        int y1 = 30;
        int x2 = 200;
        int y2 = 30;

        Rectangle2D r1 = new Rectangle2D.Double(
                10, 10, 210, 40);

        GradientPaint paint = new GradientPaint(
                x1, y1, Color.YELLOW, x2, y2, Color.BLUE);

        g2d.setPaint(paint);
        g2d.fill(r1);
    }

    private void colorOpacityExamples(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D r1 = new Rectangle2D.Double(40, 10, 130, 30);
        Rectangle2D r2 = new Rectangle2D.Double(70, 20, 130, 30);
        Rectangle2D r3 = new Rectangle2D.Double(115, 0, 10, 60);

        Color c1 = new Color(255, 0, 0, 128);

        Color c2 = new Color(255, 255, 255, 100);

        g2d.setPaint(Color.BLUE);
        g2d.fill(r1);
        g2d.setPaint(c1);
        g2d.fill(r2);
        g2d.setPaint(c2);
        g2d.fill(r3);
    }

    private void textExamples(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        String line1 = "Java";
        String line2 = "is fun!";

        FontMetrics fm = g2d.getFontMetrics();
        int textHeight = fm.getHeight();
        int line1Width = fm.stringWidth(line1);
        int line2Width = fm.stringWidth(line2);
        g2d.drawString(line1, getWidth() / 2 - line1Width / 2, textHeight);
        g2d.drawString(line2, getWidth() / 2 - line2Width / 2, textHeight * 2);
    }

    private void polygonExamples(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int[] xPoints = { 0, 23, 31, 39, 62, 43, 50, 31, 12, 19 };
        int[] yPoints = { 22, 22, 0, 22, 22, 37, 59, 46, 59, 37 };
        int nPoints = xPoints.length;

        g2d.translate(10, 0);
        g2d.drawPolygon(xPoints, yPoints, nPoints);
        g2d.translate(90, 0);
        g2d.fillPolygon(xPoints, yPoints, nPoints);
    }

    private void elipseExamples(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.drawOval(10, 10, 20, 40);

        g2d.setColor(Color.BLUE);
        g2d.fillOval(110, 10, 100, 100);

        g2d.setColor(Color.GREEN);
        g2d.fillOval(170, 20, 52, 20);
        g2d.fillOval(186, 4, 20, 52);
    }

    private void lineExamples(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);

        int w = getWidth();
        int h = getHeight();
        int steps = 2;
        for (int i = 0; i < w; i += steps) {
            int rgb = (int) ((i / (double) w) * 255);
            g.setColor(new Color(rgb, rgb, rgb));
            g.drawLine(i, 10, i, h - 11);
        }
    }

    private void archExamples(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.drawArc(10, 10, 100, 100, 0, 180);

        g2d.setColor(Color.BLUE);
        g2d.fillArc(110, 10, 100, 100, 0, 90);

        g2d.setColor(Color.YELLOW);
        g2d.fillArc(210, 10, 100, 100, 30, 300);
    }

    private void rectangleExamples(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.GREEN);
        g2d.fill3DRect(10, 10, 100, 100, true);

        g2d.setColor(Color.RED);
        g2d.draw3DRect(110, 110, 100, 100, false);

        g2d.setColor(Color.BLUE);
        g2d.fillRoundRect(210, 210, 100, 100, 20, 20);

        g2d.setColor(Color.MAGENTA);
        g2d.fillRect(310, 310, 100, 100);
    }

    private void examples1(Graphics g) {
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
