package se.miun.alrn1700.dt187g.jpaint.gui;

import java.awt.Color;

import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/*
	 *  Sätt bakgrunden på denna komponent till det
	 *  Color-objekt som skickas som argument.
	 */
	public ColorPanel(Color color) {
		this.setBackground(color);
	}
	
	/*
	 * Returnera bakgrunden för detta objekt.
	 */
	public Color getColor() {
		return this.getBackground();
	}
	
	/*
	 * Den här är det inte meningen att ni ska behöva skriva själv.
	 * Jag tror dock att jag missade att inkludera den i uppgiftsbeskrivingen för
	 * Uppgift 3.
	 */
	public String getColorAsHexString() {
		var color = this.getBackground();
		String red = Integer.toHexString(color.getRed());
		String green = Integer.toHexString(color.getGreen());
		String blue = Integer.toHexString(color.getBlue());
		red = red.length() == 1 ? "0"+red : red;
		green = green.length() == 1 ? "0"+green : green;
		blue = blue.length() == 1 ? "0"+blue : blue;

        return "#" + red + green + blue;
	}
		
}
