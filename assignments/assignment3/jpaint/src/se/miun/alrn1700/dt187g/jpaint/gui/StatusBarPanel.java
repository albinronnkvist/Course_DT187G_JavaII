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
		// TODO
	
		/*
		 * 2. Initialisera samtliga privata datafält.
		 *  För JLabel så är "0, 0" ett lämplig värde att skicka till konstruktorn.
		 */
		// TODO

		// 3. Sätt Layout till BorderLayout
		// TODO
		
		/* 4. JPanel-objektet selectedColor ska visa den färg
		* som du anser ska vara den förvalda färgen i ritprogrammet
		* (rimligen en av de färger som finns i färgpaletten)
		*/
		// TODO
		
		/* 5. leftPanel 
		 * - sätt bakgrunden för leftPanel
		 * - Skapa en JLabel där det står "Coordinates: ". Lägg till den till leftPanel via metoden add(Component comp, Object constraints),
		 * dvs den add-metod som tillåter oss ange ett "constraint", i detta fall BorderLayout.LÄMPLIG_CONSTRAINT.
		 * - Lägg sedan till instansvariabeln coordinates via samma add-metod som ovan.
		*/
		// TODO
		
		/* 6. rightPanel
		 * - sätt bakgrunden för rightPanel
		 * - Skapa en JLabel där det står "Selected color: ". Lägg till den till rightPanel på samma sätt som beskrivs i punkt 5.
		 * - Lägg sedan till instansvariabeln selectedColor via samma add-metod som ovan.
		*/
		// TODO
		
		/*
		 * 7. Lägg till leftPanel och rightPanel genom att anropa
		 * this.add(Component comp, Object constraints)
		 * för respektive panel.
		 */
		// TODO


	}

	/*
	 *  Uppdatera JLabel-objektet som visar koordinater med de nya värdena
	 */
	public void updateCoordinates(int x, int y) {
		// TODO
	}
	
	/*
	 *  Uppdatera JPanel-objektet som visar vald färg med den nya färgen.
	 */
	public void updateSelectedColor(Color color) {
		// TODO
	}

}
