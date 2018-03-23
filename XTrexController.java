import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XTrexController implements ActionListener {

	private XTrexModel model;
	private XTrexView view;
	private Constant constant;

	public XTrexController(XTrexModel model) {
		this.model = model;
		this.constant = new Constant();
	}
	public void setView(XTrexView view){
		this.view = view;
	}

	public void actionPerformed( ActionEvent e ) {
		/*
		*	OFF BUTTON
		*/
		if ( e.getSource() == view.onOffButton ) {
			if (model.getMode() == Mode.ONOFF) {
				model.setMode( Mode.MENU );
            } else {
                model.setMode( Mode.ONOFF );
            }

		/*
		*	MENU BUTTON
		*/
		} else if ( e.getSource() == view.menuButton ) {
			if (model.getMode() != Mode.ONOFF) {
				model.setMode( Mode.MENU );
			}

		/*
		*	PLUS BUTTON
		*/
		} else if ( e.getSource() == view.plusButton ) {

			if (model.getMode() == Mode.MENU) {
				if (model.getIndex() == 5) {
					model.setIndex(0);
				}
				else {
					model.setIndex(model.getIndex() + 1);
				}

            } else if (model.getMode() == Mode.WHERETO) {
				model.whereToPlusButton();
			} else if (model.getMode() == Mode.SPEECH) {
				model.speechPlusButton();
			}
                //different modes plus button

		/*
		*	MINUS BUTTON
		*/
		} else if ( e.getSource() == view.minusButton ) {
			if (model.getMode() == Mode.MENU) {
				if(model.getIndex() == 0){
					model.setIndex(5);
				} else {
					model.setIndex(model.getIndex() - 1) ;
				}

			} else if (model.getMode() == Mode.WHERETO) {
				model.whereToMinusButton();

			} else if (model.getMode() == Mode.SPEECH) {
				model.speechMinusButton();
			}

		/*
		*	SELECT BUTTON
		*/
		} else if ( e.getSource() == view.selectButton ) {
			if (model.getMode() == Mode.MENU) {
				// use tiles and dictionary somehow?
				model.setMode(Mode.values()[ model.getIndex() ]);
			} else if ( model.getMode() == Mode.WHERETO ) {
				model.whereToSelectButton ();
			}

			} else if ( model.getMode() == Mode.SPEECH ) {

				model.playDirectionsUntilAtDestination();

			}

		} else {
			//something weird has happened
		}
	}

}
