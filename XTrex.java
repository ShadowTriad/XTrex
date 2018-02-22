/**
 * Main class that displays the XTrex, along with it's screens.
 *
 * @version 22/02/18
 * @author Chris Tyson
 */

import javax.swing.*;
import java.awt.*;

public class XTrex extends JFrame {

    public XTrex() {

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(727, 727);
        setResizable(false);
        setTitle("XTrex");

        setContentPane( new JLabel( new ImageIcon("img/xtrex.jpg") ) );
        getContentPane().setLayout(null);

    }

    private void showScreen( JPanel scr ) {
        //getContentPane().setLayout(null);
        getContentPane().removeAll();
        this.add(scr);

        scr.setSize(new Dimension(240, 353));
        scr.setBounds(240, 210, 240, 353);

        this.setVisible(true);
    }

    public static void main( String[] argv ) {
        XTrex xt = new XTrex();

        Satellite sat = new Satellite();
        About ab = new About();
        Speech spe = new Speech();

        xt.showScreen( spe );
        spe.selectButton();
    }
}
