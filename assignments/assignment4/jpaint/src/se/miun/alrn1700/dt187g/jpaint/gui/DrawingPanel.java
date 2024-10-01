package se.miun.alrn1700.dt187g.jpaint.gui;

import java.awt.Color;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	

	/*
	 * Beroende på vilken konstruktor som anropas så kommer antingen 
	 * bakgrunden för denna komponent sättas till den färg som skickas som argument,
	 * alternativt sätts bakgrunden till vit (Color.WHITE).
	 */
	
	public DrawingPanel() {
		this(Color.WHITE);
	}
	
	public DrawingPanel(Color backgroundColor) {
		this.setBackground(backgroundColor);
	}
	
}
