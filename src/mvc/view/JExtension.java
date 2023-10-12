/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLayeredPane;

/**
 *
 * @author Michalis
 */
public class JExtension extends JLayeredPane {

      Image image;

        public JExtension(Image img) {
            image=img;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }