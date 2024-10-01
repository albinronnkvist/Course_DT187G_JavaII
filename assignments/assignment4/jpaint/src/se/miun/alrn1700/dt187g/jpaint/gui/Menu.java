package se.miun.alrn1700.dt187g.jpaint.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {
    public void addJMenu(String name) {
        this.add(new JMenu(name));
    }

    public void addJMenuItem(String parentName, String itemName) {
        var menuItem = new MenuItemBuilder(itemName).build();

        addItemToParentMenu(parentName, menuItem);
    }

    public void addJMenuItem(String parentName, String itemName, ActionListener actionListener) {        
        var menuItem = new MenuItemBuilder(itemName)
            .withActionListener(actionListener)
            .build();

        addItemToParentMenu(parentName, menuItem);
    }

    public void addJMenuItem(String parentName, String itemName, ActionListener actionListener, KeyStroke keyStroke) {        
        var menuItem = new MenuItemBuilder(itemName)
            .withActionListener(actionListener)
            .withKeyStroke(keyStroke)
            .build();

        addItemToParentMenu(parentName, menuItem);
    }

    public void addSubJMenu(String parentName, String subMenuName) {
        var component = getComponentByName(parentName);
        if (!(component instanceof JMenu)) {
            System.err.println("Could not get parent menu '" + parentName + "'. Parent was null or not a JMenu.");
            return;
        }

        var parentMenu = (JMenu) component;
        parentMenu.add(new JMenu(subMenuName));
    }

    public JMenu getJMenu(int index) {
        return this.getMenu(index);
    }

    // (╯°□°）╯︵ ┻━┻ 
    private JComponent getComponentByName(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }

        for (var component : this.getComponents()) {
            if (!(component instanceof JMenu)) {
                continue;
            }

            var menu = (JMenu) component;
            if (menu.getText().equals(name)) {
                return menu;
            }

            for (var menuComponent : menu.getMenuComponents()) {
                if (!(menuComponent instanceof JMenuItem)) {
                    continue;
                }

                var menuItem = (JMenuItem) menuComponent;
                if (menuItem.getText().equals(name)) {
                    return menuItem;
                }
            }
        }

        return null;
    }
    // ¯\_(ツ)_/¯

    private void addItemToParentMenu(String parentName, JMenuItem menuItem) {
        var component = getComponentByName(parentName);
        if (!(component instanceof JMenu)) {
            System.err.println("Could not get parent menu '" + parentName + "'. Parent was null or not a JMenu.");
            return;
        }

        var parentMenu = (JMenu) component;
        parentMenu.add(menuItem);
    }

    private class MenuItemBuilder {
        private JMenuItem menuItem;
    
        public MenuItemBuilder(String itemName) {
            this.menuItem = new JMenuItem(itemName);
        }
    
        public MenuItemBuilder withActionListener(ActionListener actionListener) {
            this.menuItem.addActionListener(actionListener);
            return this;
        }
    
        public MenuItemBuilder withKeyStroke(KeyStroke keyStroke) {
            this.menuItem.setAccelerator(keyStroke);
            return this;
        }
    
        public JMenuItem build() {    
            return menuItem;
        }
    }
}
