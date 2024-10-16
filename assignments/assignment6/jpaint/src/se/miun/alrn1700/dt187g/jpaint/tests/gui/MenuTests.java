package se.miun.alrn1700.dt187g.jpaint.tests.gui;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionListener;
import javax.swing.*;
import se.miun.alrn1700.dt187g.jpaint.gui.Menu;

public class MenuTests {
     private Menu menu;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void testAddJMenu() {
        final String menuName = "File";

        menu.addJMenu(menuName);

        var fileMenu = menu.getJMenu(0);

        assertThat(fileMenu).isNotNull();
        assertThat(fileMenu.getText()).isEqualTo(menuName);
    }

    @Test
    public void testAddJMenuItem() {
        final String parentMenuName = "File";
        final String itemName = "New";

        menu.addJMenu(parentMenuName);
        menu.addJMenuItem(parentMenuName, itemName);

        var parentMenu = menu.getJMenu(0);
        assertThat(parentMenu.getItemCount()).isEqualTo(1);

        var item = parentMenu.getItem(0);
        assertThat(item).isNotNull();
        assertThat(item.getText()).isEqualTo(itemName);
    }

    @Test
    public void testAddJMenuItemWithActionListener() {
        final String parentMenuName = "File";
        final String itemName = "New";

        menu.addJMenu(parentMenuName);
        ActionListener actionListener = e -> System.out.println("New item clicked");
        menu.addJMenuItem(parentMenuName, itemName, actionListener);

        var parentMenu = menu.getJMenu(0);
        var item = parentMenu.getItem(0);

        assertThat(item.getActionListeners()).hasSize(1);
        assertThat(item.getText()).isEqualTo(itemName);
    }

    @Test
    public void testAddJMenuItemWithActionListenerAndKeyStroke() {
        final String parentMenuName = "File";
        final String itemName = "New";

        menu.addJMenu(parentMenuName);
        ActionListener actionListener = e -> System.out.println("New item clicked");
        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl S");
        menu.addJMenuItem(parentMenuName, itemName, actionListener, keyStroke);

        var parentMenu = menu.getJMenu(0);
        var item = parentMenu.getItem(0);

        assertThat(item.getActionListeners()).hasSize(1);
        assertThat(item.getAccelerator()).isEqualTo(keyStroke);
        assertThat(item.getText()).isEqualTo(itemName);
    }

    @Test
    public void testAddJMenuItemToNonExistentParent() {
        menu.addJMenuItem("NonExistentMenu", "New");

        assertThat(menu.getMenuCount()).isEqualTo(0);
    }

    @Test
    public void testAddSubMenu() {
        final String parentMenuName = "File";
        final String subMenuName = "Open Recent";

        menu.addJMenu(parentMenuName);
        menu.addSubJMenu(parentMenuName, subMenuName);

        var fileMenu = menu.getJMenu(0);
        var openRecentMenu = (JMenu) fileMenu.getMenuComponent(0);

        assertThat(openRecentMenu).isNotNull();
        assertThat(openRecentMenu.getText()).isEqualTo(subMenuName);
    }

    @Test
    public void testGetJMenu() {
        final String menuName = "File";
        menu.addJMenu(menuName);

        var editMenu = menu.getJMenu(0);

        assertThat(editMenu).isNotNull();
        assertThat(editMenu.getText()).isEqualTo(menuName);
    }
}
