package se.miun.alrn1700.dt187g.jpaint;

import javax.swing.*;
import se.miun.alrn1700.dt187g.jpaint.gui.JPaintFrame;

public class AppStart {

	public static void main(String[] args) {
		
		
		// Make sure GUI is created on the event dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}

				new JPaintFrame().setVisible(true);
			}
		});
	}
}
