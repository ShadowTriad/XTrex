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
				model.incrementHighlighted();
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
				model.decrementHightlighted();
			}

		} else if ( e.getSource() == view.selectButton ) {
			if (model.getMode() == Mode.MENU) {
				// use tiles and dictionary somehow?
				model.setMode(Mode.values()[ model.getIndex() ]);
			} else if ( model.getMode() == Mode.WHERETO ) {

				boolean alphabetic = model.getKeyboardMode() == Keyboard.ALPHABETIC;
				boolean rightArrow = model.getHighlightedButton() == constant.getAlphabeticButtons()-1;
				boolean leftArrow = model.getHighlightedButton() == constant.getNumericButtons()-2;
				boolean delete = model.getHighlightedButton() == constant.getNumericButtons()-1;

				if ( alphabetic ) {
					if ( rightArrow ) {
						model.changeKeyboard();
					} else {
						model.addLetter();
					}
				} else {
					if ( leftArrow ) {
						model.changeKeyboard();
					} else if ( delete ) {
						model.delFromAddress();
					} else {
						model.addNumber();
					}
				}

			}

		} else {
			//something weird has happened
		}
	}

}
