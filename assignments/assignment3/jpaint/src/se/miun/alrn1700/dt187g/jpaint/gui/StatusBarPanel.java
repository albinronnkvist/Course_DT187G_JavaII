package se.miun.alrn1700.dt187g.jpaint.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBarPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel coordinates;
	private JPanel selectedColor;
	private JPanel leftPanel;
	private JPanel rightPanel;

	public StatusBarPanel() {
		
		// 1. Sätt bakgrund på detta objekt
		this.setBackground(Color.GRAY);
	
		/*
		 * 2. Initialisera samtliga privata datafält.
		 *  För JLabel så är "0, 0" ett lämplig värde att skicka till konstruktorn.
		 */
		coordinates = new JLabel("0, 0");
		selectedColor = new JPanel();
		leftPanel = new JPanel();
		rightPanel = new JPanel();

		// 3. Sätt Layout till BorderLayout
		this.setLayout(new BorderLayout());
		
		/* 4. JPanel-objektet selectedColor ska visa den färg
		* som du anser ska vara den förvalda färgen i ritprogrammet
		* (rimligen en av de färger som finns i färgpaletten)
		*/
		selectedColor.setBackground(Color.RED);
		
		/* 5. leftPanel 
		 * - sätt bakgrunden för leftPanel
		 * - Skapa en JLabel där det står "Coordinates: ". Lägg till den till leftPanel via metoden add(Component comp, Object constraints),
		 * dvs den add-metod som tillåter oss ange ett "constraint", i detta fall BorderLayout.LÄMPLIG_CONSTRAINT.
		 * - Lägg sedan till instansvariabeln coordinates via samma add-metod som ovan.
		*/
		leftPanel.setBackground(Color.GRAY);
		leftPanel.add(new JLabel("Coordinates: "), BorderLayout.WEST);
		leftPanel.add(coordinates, BorderLayout.EAST);
		
		/* 6. rightPanel
		 * - sätt bakgrunden för rightPanel
		 * - Skapa en JLabel där det står "Selected color: ". Lägg till den till rightPanel på samma sätt som beskrivs i punkt 5.
		 * - Lägg sedan till instansvariabeln selectedColor via samma add-metod som ovan.
		*/
		rightPanel.setBackground(Color.GRAY);
		rightPanel.add(new JLabel("Selected color: "), BorderLayout.WEST);
		rightPanel.add(selectedColor, BorderLayout.EAST);
		
		/*
		 * 7. Lägg till leftPanel och rightPanel genom att anropa
		 * this.add(Component comp, Object constraints)
		 * för respektive panel.
		 */
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
	}

	/*
	 *  Uppdatera JLabel-objektet som visar koordinater med de nya värdena
	 */
	public void updateCoordinates(int x, int y) {
		coordinates.setText(x + ", " + y);
	}
	
	/*
	 *  Uppdatera JPanel-objektet som visar vald färg med den nya färgen.
	 */
	public void updateSelectedColor(Color color) {
		selectedColor.setBackground(color);
	}

	public Color getSelectedColor() {
		return selectedColor.getBackground();
	}
}
