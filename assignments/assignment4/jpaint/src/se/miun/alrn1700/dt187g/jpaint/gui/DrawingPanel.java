package se.miun.alrn1700.dt187g.jpaint.gui;

import java.awt.Color;

import javax.swing.JPanel;

import se.miun.alrn1700.dt187g.jpaint.Drawing;

public class DrawingPanel extends JPanel {
	private Drawing drawing;

	public DrawingPanel() {
		this(Color.WHITE);
	}
	
	public DrawingPanel(Color backgroundColor) {
		this.setBackground(backgroundColor);
		this.drawing = new Drawing();
	}
	
	public Drawing getDrawing() {
		return drawing;
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}
}
