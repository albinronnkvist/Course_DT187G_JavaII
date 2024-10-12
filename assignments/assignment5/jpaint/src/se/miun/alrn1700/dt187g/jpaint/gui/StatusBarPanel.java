package se.miun.alrn1700.dt187g.jpaint.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.miun.alrn1700.dt187g.jpaint.OnChangeListener;

import javax.swing.BorderFactory;

public class StatusBarPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel coordinates;
	private JPanel selectedColor;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private OnChangeListener<StatusBarPanel> onChangeListener;

	public StatusBarPanel() {
		this.setBackground(Color.GRAY);
	
		coordinates = new JLabel("0, 0");
		selectedColor = new JPanel();
		leftPanel = new JPanel();
		rightPanel = new JPanel();

		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		selectedColor.setBackground(Color.RED);
		
		leftPanel.setBackground(Color.GRAY);
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(new JLabel("Coordinates: "), BorderLayout.LINE_START);
		leftPanel.add(coordinates, BorderLayout.LINE_END);
		
		rightPanel.setBackground(Color.GRAY);
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(new JLabel("Selected color: "), BorderLayout.LINE_START);
		rightPanel.add(selectedColor, BorderLayout.LINE_END);
		
		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(rightPanel, BorderLayout.LINE_END);
	}

	public void updateCoordinates(int x, int y) {
		coordinates.setText(x + ", " + y);
	}
	
	public void updateSelectedColor(Color color) {
		selectedColor.setBackground(color);

		if (onChangeListener != null) {
			onChangeListener.onChange(this);
		}
	}

	public Color getSelectedColor() {
		return selectedColor.getBackground();
	}

	public void setOnChangeListener(OnChangeListener<StatusBarPanel> onChangeListener) {
		this.onChangeListener = onChangeListener;
	}
}
