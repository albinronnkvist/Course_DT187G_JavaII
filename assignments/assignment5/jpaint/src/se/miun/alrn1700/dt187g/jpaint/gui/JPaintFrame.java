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
	private String drawingTitle;

	public JPaintFrame() {
		init();
	}

	public void updateHeader() {
		this.setTitle(drawingTitle);
	}

	public void setDrawingTitle(String name, String author) {
		if (!isNullOrBlank(name) && !isNullOrBlank(author)) {
			drawingTitle = header + " - " + name + " by " + author;
		} else if (!isNullOrBlank(name)) {
			drawingTitle = header + " - " + name;
		} else if (!isNullOrBlank(author)) {
			drawingTitle = header + " - " + "[untitled drawing] by " + author;
		} else {
			drawingTitle = header;
		}
	}

	public String getDrawingTitle() {
		return drawingTitle;
	}

	private void init() {
		setupFrame();
		setupDrawingPanel();
		setupToolbarPanel();
		setupStatusBarPanel();
		
		container.add(topPanel, BorderLayout.PAGE_START);
		container.add(drawingPanel, BorderLayout.CENTER);
		container.add(statusBarPanel, BorderLayout.PAGE_END);

		var menu = new MenuManager(this, drawingPanel);
		this.setJMenuBar(menu.getMenu());
	}

	private void setupFrame() {
		this.setSize(500, 500);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		var icon = new ImageIcon(imgFolderName + "icon.png");
		this.setIconImage(icon.getImage());

		this.setTitle(header);
		
		container.setLayout(new BorderLayout());
	}

	private void setupDrawingPanel() {
		drawingPanel = new DrawingPanel();
		var customMouseAdapter = new CustomMouseAdapter();
		drawingPanel.addMouseListener(customMouseAdapter);
		drawingPanel.addMouseMotionListener(customMouseAdapter);
	}

	private void setupToolbarPanel() {
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(0, 50));

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
		
		var shapes = new String[] { "Rectangle", "Circle" };
		var comboBox = new JComboBox<String>(shapes);
		comboBox.setPreferredSize(new Dimension(100, comboBox.getPreferredSize().height));
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(e -> drawingPanel.setActiveShape(comboBox.getSelectedItem().toString()));

		topPanel.setLayout(new BorderLayout());
		topPanel.add(colorPalettePanel, BorderLayout.CENTER);
		topPanel.add(comboBox, BorderLayout.LINE_END);
	}

	private void setupStatusBarPanel() {
		statusBarPanel = new StatusBarPanel();
		statusBarPanel.setPreferredSize(new Dimension(statusBarPanel.getPreferredSize().width, 25));
		
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
				drawingPanel.setEndPoint(e.getX(), e.getY());
				drawingPanel.repaint();
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

		@Override
		public void mousePressed(MouseEvent e) {
			statusBarPanel.updateCoordinates(e.getX(), e.getY());
			drawingPanel.setDrawIsActive(true);
			drawingPanel.setDrawColor(Color.BLUE); // TODO: this will be replaced by StatusBarPanel
			drawingPanel.setStartPoint(e.getX(), e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			statusBarPanel.updateCoordinates(e.getX(), e.getY());
			drawingPanel.setEndPoint(e.getX(), e.getY());
			drawingPanel.addShape();
			drawingPanel.setDrawIsActive(false);
			drawingPanel.repaint();
		}

		private void resetCoordinates() {
			statusBarPanel.updateCoordinates(0, 0);
		}
	}

	private boolean isNullOrBlank(String str) {
		return str == null || str.isBlank();
	}
}
