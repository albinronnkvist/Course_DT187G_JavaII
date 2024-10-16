package se.miun.alrn1700.dt187g.jpaint.gui;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import se.miun.alrn1700.dt187g.jpaint.Drawing;
import se.miun.alrn1700.dt187g.jpaint.DrawingException;

public class MenuManager {
    private JPaintFrame frame;
    private DrawingPanel drawingPanel;
    private Menu menu;
    

    public MenuManager(JPaintFrame frame, DrawingPanel drawingPanel) {
        this.frame = frame;
        this.drawingPanel = drawingPanel;
        this.menu = new Menu();
        createMenu();
    }
    
    public Menu getMenu() {
        return menu;
    }

    private void createMenu() {
        createFileMenu();
        createEditMenu();
        createFilterMenu(); // TODO for assignment 6
    }

    private void createFileMenu() {
		final String sFile = "File";
		menu.addJMenu(sFile);
		menu.getJMenu(0).setMnemonic(KeyEvent.VK_F);

		menu.addJMenuItem(sFile, "New...", createNewDrawingAction(),
				KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		menu.addJMenuItem(sFile, "Load...", createLoadAction(),
				KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
		menu.addJMenuItem(sFile, "Save As...", createSaveAction(),
				KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		menu.addJMenuItem(sFile, "Info", showInfoAction());

		menu.getJMenu(0).addSeparator();
		menu.addJMenuItem(sFile, "Exit", al -> {
			int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		});

	}

    private void createEditMenu() {
		final String sEdit = "Edit";
		final String sDrawing = "Drawing";
		menu.addJMenu(sEdit);
		menu.addSubJMenu(sEdit, sDrawing);
		menu.getJMenu(1).setMnemonic(KeyEvent.VK_E);

		menu.addJMenuItem(sEdit, "Undo", createUndoAction(),
				KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
		menu.addJMenuItem(sDrawing, "Name...", createChangeNameAction());
		menu.addJMenuItem(sDrawing, "Author...", createChangeAuthorAction());

		/* Denna rad, som du inte får ta bort, kommer skapa ett NullException.
		 * Du måste hantera denna situation i Menu-klassen. I vanliga fall
		 * hade det varit rimligt att ett Exception kastades (klienten bör 
		 * i vanliga fall göras medveten om att den försöker skapa ett 
		 * JMenuItem till en JMenu som inte existerar), men nu räcker
		 * det med att ingenting alls händer i det läget man anropar
		 * addJMenuItem med en sträng som inte kan hittas.
		 */
		menu.addJMenuItem("This JMenu doesn't exist", "abc");

	}
    
    private void createFilterMenu() {
		// TODO for assignment 6
	}
    
    private ActionListener createNewDrawingAction() {
		return al -> {
			try {
				String name = promptUserInput("Enter the name of the new drawing:", "New Drawing");
				if(name == null) {
					return;
				}

				String author = promptUserInput("Enter the author of the new drawing:", "New Drawing");
				if(author == null) {
					return;
				}

				drawingPanel.setDrawing(new Drawing(name, author));
				frame.setDrawingTitle(name, author);	
				frame.updateHeader();
			}
			catch (DrawingException e) {
				showErrorDialog(e.getMessage());
			}
			catch(Exception e){
				System.err.println(e.getMessage());
			}
		};
	}

    private ActionListener createChangeNameAction() {
		return al -> {
			try {
				String name = promptUserInput("Enter the new name:", "Change Name");
				if (name == null) {
					return;
				}
	
				var drawing = drawingPanel.getDrawing();
				drawing.setName(name);
				frame.setDrawingTitle(name, drawing.getAuthor());
				frame.updateHeader();
			}
			catch (DrawingException e) {
				showErrorDialog(e.getMessage());
			}
		};
	}

	private ActionListener createChangeAuthorAction() {
		return al -> {
			try {
				String author = promptUserInput("Enter the new author:", "Change author");
				if (author == null) {
					return;
				}
	
				var drawing = drawingPanel.getDrawing();
				drawing.setAuthor(author);
				frame.setDrawingTitle(drawing.getName(), author);
				frame.updateHeader();
			}
			catch (DrawingException e) {
				showErrorDialog(e.getMessage());
			}
		};
	}

	private ActionListener createUndoAction() {
		return al -> {
			var drawing = drawingPanel.getDrawing();
			drawing.removeShape(drawing.getSize() - 1);

			drawingPanel.repaint();
		};
	}
	
	private ActionListener showInfoAction() {
		return al -> {
			var drawing = drawingPanel.getDrawing();
			if(drawing == null) {
				JOptionPane.showMessageDialog(frame, "No drawing selected", "Info", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			var name = drawing.getName();
			var author = drawing.getAuthor();
			String title;
			if (!isNullOrBlank(name) && !isNullOrBlank(author)) {
				title = name + " by " + author;
			} else if (!isNullOrBlank(name)) {
				title = name;
			} else if (!isNullOrBlank(author)) {
				title = "[Unnamed drawing] by " + author;
			} else {
				title = "[Unnamed drawing]";
			}

			var message = title + "\n" +
					"Number of Shapes: " + drawing.getSize() + "\n" +
					"Total Area: " + drawing.getTotalArea() + "\n" +
					"Total circumference: " + drawing.getTotalCircumference();

			JOptionPane.showMessageDialog(frame, message, "Info", JOptionPane.INFORMATION_MESSAGE);
		};
	}

	private ActionListener createLoadAction() {
		return al -> {
			// TODO for assignment 6
		};
	}

	private ActionListener createSaveAction() {
		return al -> {
			// TODO for assignment 6
		};
	}

	private String promptUserInput(String message, String title) {
		return JOptionPane.showInputDialog(frame, message, title, JOptionPane.PLAIN_MESSAGE);
	}

	private void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private boolean isNullOrBlank(String str) {
		return str == null || str.isBlank();
	}
}
