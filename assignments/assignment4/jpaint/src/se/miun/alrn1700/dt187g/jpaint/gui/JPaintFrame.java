package se.miun.alrn1700.dt187g.jpaint.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JPaintFrame extends JFrame {

	private final String header = "JPaint";
	private final String imgFolderName = "img/";

	private Container container = this.getContentPane();
	private JPanel topPanel;
	private ColorPalettePanel colorPalettePanel;
	private DrawingPanel drawingPanel;
	private StatusBarPanel statusBarPanel;

	public JPaintFrame() {
		init();
	}

	private void init() {

		setupFrame();
		setupToolbarPanel();
		setupDrawingPanel();
		setupStatusBarPanel();
		
		/*
		 * 13. Avslutningsvis, lägg till topPanel, drawingPanel och statusBarPanel till 
		 * Container c.
		 */
		container.add(topPanel, BorderLayout.PAGE_START);
		container.add(drawingPanel, BorderLayout.CENTER);
		container.add(statusBarPanel, BorderLayout.PAGE_END);
	}

	private void setupFrame() {
		// 1. Sätt storleken på JFrame till vad ni nu känner för.
		this.setSize(500, 500);

		// 2. Se till att programmet stängs ner när man trycker på krysset upp i högra hörnet.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * 3. Välj ikon för programmet. Ni kan skapa en mapp som heter "img" i
		 * root-katalogen och hänvisa till den genom "img/filenameOfYourIcon.png".
		 */
		var icon = new ImageIcon(imgFolderName + "icon.png");
		this.setIconImage(icon.getImage());

		/*
		 * 4. Initialisera strängen "header" med något värde ("JPaint" exempelvis), och
		 * sätt detta som title för programmet. Att vi lagrar vårat applikationsnamn i
		 * en String kommer bli tydligare till kommande uppgifter.
		 */
		this.setTitle(header);
		
		/*
		 * 5. Sätt layout för denna klass till BorderLayout
		 */
		container.setLayout(new BorderLayout());
	}

	private void setupToolbarPanel() {
		/*
		 * 6. Följande kod skapar en JPanel där vi sätter en önskad storlek på höjden
		 * genom att skicka ett Dimension-objekt till prefferedSize (Dimension(width,
		 * height)). Att vi anger width till 0 är mest för att vi inte kommer kunna
		 * påverka detta ändå (den kommer bli så bred som applikationen är bred). Det är
		 * detta JPanel-objekt som kommer inhysa våran ColorPalettePanel samt våran
		 * JComboBox (den som visar vilken typ av form vi ritar).
		 */
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(0, 50));

		/*
		 * 7. Initialisera ColorPalettePanel. Om du väljer att initialisera
		 * ColorPalettePanel via "default"-constructorn (den utan argument), då måste du
		 * anropa addColorPanel för varje ColorPanel-objekt du vill lägga till.
		 * 
		 * Alternativ så anropar du ColorPalettePanel(ArrayList<ColorPanel>) och då
		 * sköter ColorPalettePanel resten
		 */
		var colorPanels = new ArrayList<ColorPanel>(Arrays.asList(
			new ColorPanel(Color.RED),
			new ColorPanel(Color.ORANGE),
			new ColorPanel(Color.YELLOW),
			new ColorPanel(Color.GREEN),
			new ColorPanel(Color.BLUE),
			new ColorPanel(new Color(75, 0, 130)),
			new ColorPanel(new Color(238, 130, 238))
		));
		colorPalettePanel = new ColorPalettePanel(colorPanels);
		

		/*
		 * 8.
		 * 8.1 Skapa en String[] som håller "Rectangle" och "Circle" 
		 * 8.2 Skapa en JComboBox<String> och initalisera den med arrayen. 
		 * 8.3 Välj vilken form som ska vara default.
		 * 
		 * Våran JComboBox kommer vara bunden till den höjd som anges av topPanel.
		 * Däremot så har vi här möjlighet att ange bredd. Sätt bredden till något
		 * rimligt, exempelvis 100.
		 */
		var shapes = new String[] { "Rectangle", "Circle" };
		var comboBox = new JComboBox<String>(shapes);
		comboBox.setPreferredSize(new Dimension(100, comboBox.getPreferredSize().height));
		comboBox.setSelectedIndex(1);

		/*
		 * 12.
		 * 12.1 Sätt layouten för topPanel till BorderLayout.
		 * 12.2 "adda" colorPalettePanel med lämplig constraint (dvs BorderLayout.LÄMPLIG_CONSTRAINT)
		 * 12.3 "adda" din JComboBox med lämplig constraint (dvs BorderLayout.LÄMPLIG_CONSTRAINT)
		 */
		topPanel.setLayout(new BorderLayout());
		topPanel.add(colorPalettePanel, BorderLayout.CENTER);
		topPanel.add(comboBox, BorderLayout.LINE_END);
	}

	private void setupDrawingPanel() {
		/*
		 * 9.
		 * 9.1 Initialisera DrawingPanel
		 * 9.2 Deklarera en CustomMouseAdapter och initialisera den.
		 * 9.3 Lägg till denna CustomMouseAdapter som MouseListener till drawingPanel
		 * 9.4 Lägg även till CustomMouseAdapter som MouseMotionListener till drawingPanel
		 */
		drawingPanel = new DrawingPanel();
		var customMouseAdapter = new CustomMouseAdapter();
		drawingPanel.addMouseListener(customMouseAdapter);
		drawingPanel.addMouseMotionListener(customMouseAdapter);
	}

	private void setupStatusBarPanel() {
		/*
		 * 10.
		 * 10.1 Initialisera StatusBarPanel
		 * 10.2 Sätt en rimlig höjd på StatusBarPanel, exempelvis 25.
		 */
		statusBarPanel = new StatusBarPanel();
		statusBarPanel.setPreferredSize(new Dimension(statusBarPanel.getPreferredSize().width, 25));
		

		/*
		 * 11. Nu när StatusBarPanel väl är initialiserad så kan vi
		 * sätta en MouseListener för våra ColorPanel's. Eftersom vi inte har gått igenom
		 * anonyma klasser än, och eftersom det enkaste sättet att uträtta detta är genom en
		 * anonym klass, så följer den med här. 
		 * Ni måste fortfarande implementera mousePressed dock.
		 * Det vi vill ska hända är att när ett objekt klickas på, så ska dess bakgrundsfärg skickas
		 * som argument till StatusBarPanel.updateSelectedColor(Color color).
		 * Vi kommer behöva anropa MouseEvent.getSource() (i ren syntax innebär det alltså "e.getSource()".
		 * MouseEvent.getSource() returnerar ett Object. Vi kan inte få reda på bakgrundsfärgen bara genom 
		 * ett Object. Så vi måste "casta" det Object som returneras från getSource() till en ColorPanel.
		 * 
		 * 
		 * */
		colorPalettePanel.setMouseListenerForColorPanels(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				statusBarPanel.updateSelectedColor(((ColorPanel) e.getSource()).getColor());
			}
		});
	}
	
	private class CustomMouseAdapter extends MouseAdapter {

		@Override
		public void mouseDragged(MouseEvent e) {
			if (((Component) e.getSource()).getMousePosition() != null) {
				statusBarPanel.updateCoordinates(e.getX(), e.getY());
			} else {
				resetCoordinates();
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			resetCoordinates();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			statusBarPanel.updateCoordinates(e.getX(), e.getY());
		}

		private void resetCoordinates() {
			statusBarPanel.updateCoordinates(0, 0);
		}
	}

}
