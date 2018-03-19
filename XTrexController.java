import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XTrexController implements ActionListener {
	
	private XTrexModel model;
	private XTrexView view;
	
	public XTrexController(XTrexModel model) {
		this.model = model;
	}
	public void setView(XTrexView view){
		this.view = view;	
	}
	
	public void actionPerformed( ActionEvent e ) {
		if ( e.getSource() == view.onOffButton ) {
			if (model.getMode() == Mode.ONOFF) {
				model.setMode( Mode.MAP );
				System.out.println(model.getMode());
            } else {
                model.setMode( Mode.ONOFF );
				System.out.println(model.getMode());
            }
		} else if ( e.getSource() == view.menuButton ) {
			System.out.println('d');
			if (model.getMode() != Mode.ONOFF) {
				System.out.println('d');
				model.setMode( Mode.MENU );
			}
		} else if ( e.getSource() == view.plusButton ) {
			
		
		} else if ( e.getSource() == view.minusButton ) {
			
		} else if ( e.getSource() == view.selectButton ) {
			
		} else {
			//something weird has happened
		}
	}

}