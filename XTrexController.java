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
				model.setMode( Mode.MENU );
            } else {
                model.setMode( Mode.ONOFF );
            }
		} else if ( e.getSource() == view.menuButton ) {
			if (model.getMode() != Mode.ONOFF) {
				model.setMode( Mode.MENU );
			}
		} else if ( e.getSource() == view.plusButton ) {
			
			if (model.getMode() == Mode.MENU) {
				if (model.getIndex() == 5) {
					model.setIndex(0);
				}
				else {
					model.setIndex(model.getIndex() + 1);
				}
            } else {
                //different modes plus button
            }
			
		} else if ( e.getSource() == view.minusButton ) {
			if (model.getMode() == Mode.MENU) {
				if(model.getIndex() == 0){
					model.setIndex(5);
				} else {
					model.setIndex(model.getIndex() - 1) ;
				}
			} else {} // other modes minusbutton
			
		} else if ( e.getSource() == view.selectButton ) {
			if (model.getMode() == Mode.MENU) {
				// use tiles and dictionary somehow?
				model.setMode(Mode.values()[ model.getIndex() ]);
			}
			
		} else {
			//something weird has happened
		}
	}

}