import javax.swing.JFrame;

public class XTrexMVC {
	public static void main( String[] argv ) {
    XTrexModel      model      = new XTrexModel( Mode.ONOFF );
	
	System.out.println( "model made" );
	
    XTrexController controller = new XTrexController( model );
	System.out.println( "controller made" );
	
    XTrexView       view       = new XTrexView( controller, model );
	System.out.println( "view made" );
	
	controller.setView( view );
	System.out.println( "view set" );
	
    view.pack();
    view.setVisible( true );
	
	System.out.println( model.getMode() );
	//model.setCoords("52", "0");
	}
}