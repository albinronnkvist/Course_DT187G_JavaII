/**
* An interface that other "drawable" classes can implement.
* The interface defines a set of public abstract methods (methods without implementation).
*   - It uses method overloading which allows multiple methods in the same class to share the same name but with different parameters.
*   - Classes that implement this interface must provide implementations for these methods.
*
* @author Albin Rönnkvist (alrn1700)
* @version 1.0
*/

package se.miun.alrn1700.dt187g.jpaint.interfaces;

public interface Drawable {
    void draw();
    void draw(java.awt.Graphics g);
}
