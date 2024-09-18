package se.miun.alrn1700.dt187g.jpaint;

import javax.swing.SwingUtilities;

import se.miun.studentid.dt187g.jpaint.gui.JPaintFrame;

public class AppStart {

	public static void main(String[] args) {
		
		
		// Make sure GUI is created on the event dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JPaintFrame().setVisible(true);
			}
		});
	}
}
