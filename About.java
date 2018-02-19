import javax.swing.*;
import java.awt.*;

class About extends JPanel {

    String version;
    ImageIcon img;

    public About() {

        this.version = "7.01a";
        this.img = new ImageIcon( "dino.gif" );

    }

    public void paintComponent( Graphics g ) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0,0, 330, 415);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("XTrek", 25, 100);
        g.drawString(version, 235, 100);

        g.drawString("(c) 2018", 100, 350);
        g.drawString("Dinosoft", 100, 390);

        img.paintIcon(this, g, 100, 25);
    }
}
