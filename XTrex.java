import javax.swing.*;
import java.awt.*;

public class XTrex extends JFrame {

    public XTrex() {

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(1000, 1000);
        setResizable(false);
        setTitle("XTrex");

        setContentPane(new JLabel(new ImageIcon("xtrex.jpg")));
        getContentPane().setLayout(null);

    }

    private void showScreen( JPanel scr ) {
        //getContentPane().setLayout(null);
        getContentPane().removeAll();
        this.add(scr);

        scr.setSize(new Dimension(330, 415));
        scr.setBounds(330, 380, 330, 415);

        this.setVisible(true);
    }

    public static void main( String[] argv ) {
        XTrex xt = new XTrex();

        Satellite sat = new Satellite();
        About ab = new About();

        xt.showScreen( sat );
    }
}
