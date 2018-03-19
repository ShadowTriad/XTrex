import javax.swing.JFrame;

public class XTrexMVC {
	public static void main( String[] argv ) {
    XTrexModel      model      = new XTrexModel( Mode.ONOFF );
    XTrexController controller = new XTrexController( model );
    XTrexView       view       = new XTrexView( controller, model );
	controller.setView( view );
	
	//MapView map = new MapView( controller, model );

    view.pack();
    view.setVisible( true );
	
	System.out.println( model.getMode() );
	//model.setCoords("52", "0");
	}
}