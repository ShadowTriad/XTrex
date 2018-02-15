import java.awt.Color;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class XTrex extends JFrame {

    private int northPos;
    private int westPos;
    private mode currentMode;
    private int lengthJourney;

    public XTrex() {
      setTitle( "XTrex" );
      setContentPane( new JLabel( new ImageIcon( "xtrex.jpg" ) ) );
      setLayout( null );

    }

    public static void main( String[] argv ) {
      JFrame frame = new XTrex();
      frame.setLocationRelativeTo( null );
      frame.setSize( 1000, 1000 ); /* title bar! */
      frame.setResizable( false );
      frame.setVisible( true );
    }

}
