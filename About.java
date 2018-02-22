/**
 * About screen that displays information about the XTrex.
 *
 * @version 22/02/18
 * @author Chris Tyson
 */

import javax.swing.*;
import java.awt.*;

class About extends JPanel {

    String version;
    ImageIcon img;

    public About() {

        this.version = "7.01a";
        this.img = new ImageIcon( "img/dino.gif" );

    }

    public void paintComponent( Graphics g ) {
        //paint the about page onto the JPanel

        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0,0, 240, 353);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("XTrek", 25, 60);
        g.drawString(version, 150, 60);

        g.drawString("(c) 2018", 80, 300);
        g.drawString("Dinosoft", 80, 340);

        img.paintIcon(this, g, 85, 60);
    }
}
