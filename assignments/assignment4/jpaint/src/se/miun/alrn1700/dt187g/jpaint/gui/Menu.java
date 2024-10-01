package se.miun.alrn1700.dt187g.jpaint.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {
    public void addJMenu(String name) {
        this.add(new JMenu(name));
    }

    /*
	 * Använd metoden getComponentByName (du måste skriva den först)
	 * för att hitta vilken JMenu som ett JMenuItem ska läggas till.
	 * Tänk på att metoden getComponentByName kan returnera null!
	 */
    public void addJMenuItem(String parentName, String itemName) {
        var component = getComponentByName(parentName);
        if (component instanceof JMenu) {
            JMenu parentMenu = (JMenu) component;
            parentMenu.add(new JMenuItem(itemName));
            return;
        }

        // Log errors
        System.out.println("Parent menu '" + parentName + "' not found.");
    }

    /*
	 * Ni får själv bestämma om ni vill anropa addJMenuItem(parentName, itemName)
	 * för att på så sätt "kedja" anropen och göra koden lättare att underhålla.
	 * ActionListener ska helt enkelt "addas" till det JMenuItem vi skapar.
	 */
    public void addJMenuItem(String parentName, String itemName, ActionListener actionListener) {
        addJMenuItem(parentName, itemName);

        var component = getComponentByName(itemName);
        if (component instanceof JMenuItem) {
            var item = (JMenuItem) component;
            item.addActionListener(actionListener);
            return;
        }

        // Log errors
    }

    /*
	 * För att kunna använda tangentbord-kommandon för att nå meny-alternativ, så anropar man
	 * metoden setAccelerator(KeyStroke keyStroke).
	 */
    public void addJMenuItem(String parentName, String itemName, ActionListener actionListener, KeyStroke keyStroke) {
        addJMenuItem(parentName, itemName, actionListener);
        var component = getComponentByName(itemName);
        if (component instanceof JMenuItem) {
            var item = (JMenuItem) component;
            item.setAccelerator(keyStroke);
            return;
        }

        // Log errors
    }

    /*
	 * Denna metod kommer lägga till ett JMenu-objekt
	 * till ett befintligt JMenu-objekt.
	 * parentName är namnet på den JMenu som sub-menyn ska
	 * tillhöra.
	 */
    public void addSubJMenu(String parentName, String subMenuName) {
        var component = getComponentByName(parentName);
        if (component instanceof JMenu) {
            JMenu parentMenu = (JMenu) component;
            parentMenu.add(new JMenu(subMenuName));
            return;
        }

        // Log errors
    }

    public JMenu getJMenu(int index) {
        return this.getMenu(index);
    }

    /*
	 * Denna metod kommer returnera en komponent som har lagts till
	 * i våran Menu-klass, oavsett om komponenten är en JMenu eller ett JMenuItem,
	 * Vi är alltså ute efter komponenter utifrån "namn".
	 * Med namn så menar vi i det här fallet vad JMenu- och JMenuItem-objekt
	 * heter i vårat GUI, såsom "File", "Load...", "Drawing" osv.
	 * En sak som kan vara bra att veta är att JMenu faktiskt ärver från JMenuItem.
	 * Så även fast JMenuItem är något som ligger inuti en JMenu, såsom våra kodexempel 
	 * visar, så är JMenu en mer specificerad klass än JMenuItem.
	 */
    /*
        * 1. JMenuBar ärver från 
        * javax.swing.JComponent, som ärver från
        * java.awt.Container, som ärver från
        * java.awt.Component, som ärver från
        * java.lang.Object.
        * 
        * ¯\_(ツ)_/¯
        *  
        * Tack vare java.awt.Container så ärver JMenuBar metoden getComponents().
        * getComponents() returnerar en array med samtliga barn-komponenter (Component).
        * Använd en for-each loop för att loopa över våran Menu-klass samtliga barn-komponenter.
        */

    // TODO

    /*
        * 2. Vi är egentligen säkra på att alla "närmaste" barn-komponenter till våran Menu-klass
        * kommer vara JMenu-objekt, så vi kan tryggt "casta" varje objekt som loopas igenom
        * till ett JMenu-objekt. (egentligen kan vi casta till JMenuItem också. Hur kommer det sig tror du?)
        */

    // TODO

    /*
        * 3. Varför vill vi casta till ett JMenu-objekt? Jo, för att kunna anropa metoden
        * getText() och jämföra med parametern "name". Om så är fallet,
        * då har vi hittar våran komponent, och kan returnera den. Kom ihåg att INTE använda
        * likhetsoperatorn (==) när du kollar efter att texten är densamma.
        */

    // TODO

    /*
        * 4. Ok, med den kod som skrivits fram till nu så kan vi hitta alla JMenu-objekt som är
        * addade direkt till våran JMenuBar. Men hur gör vi för att nå JMenu-objekt som är addade
        * till andra JMenu-objekt, såsom fallet med att Drawing är tillagd till Edit?
        * Well, JMenu-klassen har en metod som heter getMenuComponents(), 
        * så vi kan på precis samma sätt som innan köra en for-each loop. Denna loop ska
        * ske inuti den befintliga loopen.
        */

    // TODO

    /*
        * 5. I det här fallet kan vi inte casta allt som passerar loopen som JMenu.
        * Just nu har denna klass ingen nytta av att komma åt JMenuItems, men det
        * är ändå inte så snyggt att begränsa en metod med namnet "getComponentByName"
        * att bara returnera JMenu-objekt.
        * Men en till orsak är att JMenu är en subklass till JMenuItem, så att försöka casta
        * ett JMenuItem till en JMenu kommer leda till att ett Exception kastas.
        * Och sen har vi en JSeparator i en av menyerna, och den kan vi inte heller
        * casta till vare sig JMenuItem eller JMenu.
        * 
        * Vi behöver använda oss av "instanceof"-operatorn. 
        * Eftersom JMenu ärver från JMenuItem, och eftersom getText(), vilket är den metod vi behöver, 
        * är en metod som tillhör en föräldraklassen till JMenuItem (javax.swing.AbstractButton), 
        * så räcker det med att vi kollar om det rör sig om ett JMenuItem.
        */

    // TODO

    /*
        * 6. Om det objekt som passerar genom loopen är ett JMenuItem, så är det bara
        * att casta objektet och returnera det om den har samma text som parametern. 
        */

    // TODO

    /*
        * 7. Om inga av dessa vilkor har kunna uppfyllas, då måste metoden returnera null.
        */

    // TODO ...eller vänta, den bjuder jag på ;-)
    private JComponent getComponentByName(String name) {
        for (var comp : this.getComponents()) {
            if (comp instanceof JComponent) {
                JComponent jComp = (JComponent) comp;
                if (name.equals(jComp.getName())) {
                    return jComp;
                }
            }
        }
        
        return null;
    }
}
