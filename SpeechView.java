import java.util.Observable;
import java.util.Observer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.util.*;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

public class SpeechView extends ModeView implements Observer {
    public XTrexController controller;
    public XTrexModel model;
    
    public SpeechView(XTrexController controller, XTrexModel model) {
        this.controller = controller;
        this.model = model;
        
        model.addObserver( this );
        repaint();
    }
    
    public void update( Observable obs, Object obj ) {
        System.out.println(obs);
    }

    /*
     * Creates a screen to be viewed on the XTrex JFrame
     */
    protected void paintComponent( Graphics g ) {
        super.paintComponent(g);

        //creating the while background
        g.setColor(Color.white);
        g.fillRect(0,0, 330, 415);
        
        //creates a box in orange if the current language state isn't "Off
        g.setColor(Color.orange);
        if (model.currentLanguageCount == 1){
            g.fillRect(25, 50, 200, 50);
        } else if (model.currentLanguageCount == 2){
            g.fillRect(25, 100, 200, 50);
        } else if (model.currentLanguageCount == 3){
            g.fillRect(25, 150, 200, 50);
        } else if (model.currentLanguageCount == 4){
            g.fillRect(25, 200, 200, 50);
        } else if (model.currentLanguageCount == 5){
            g.fillRect(25, 250, 200, 50);
        } 
        
        //draws all the box outlines
        g.setColor(Color.black);
        g.drawRect(25, 50 , 200, 50);
        g.drawRect(25, 100 , 200, 50);
        g.drawRect(25, 150 , 200, 50);
        g.drawRect(25, 200 , 200, 50);
        g.drawRect(25, 250 , 200, 50);
        
        
        //writes the text for each box
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("English",80,90);
        g.drawString("French",80,140);
        g.drawString("German",80,190);
        g.drawString("Italian",80,240);
        g.drawString("Spanish",80,290);

        repaint();
    }
    
    /*
     * Is prompted by the pushing of the select button on side of the device.
     * When pressed, the first direction audio is played (in the specified language) and directions continue to play until the destination has been reached.
     */
    public void selectButton(){
        model.playDirectionsUntilAtDestination();
    }
    
     /*
     * Is prompted by the pushing of the plus button on side of the device.
     * Changes the language by changing the currentLanguageCounter which represents an index of the list of languages.
     */
    public void plusButton(){
        //scroll up when button pressed.
        if (model.currentLanguageCount == 5){
            model.currentLanguageCount = 0;
        } else {
            model.currentLanguageCount += 1;
        }
    }
    
    /*
     * Is prompted by the pushing of the minus button on side of the device.
     * Changes the language by changing the currentLanguageCounter which represents an index of the list of languages.
     */
    public void minusButton(){
        //scroll down when button pressed
        if (model.currentLanguageCount == 0){
            model.currentLanguageCount = 5;
        } else {
            model.currentLanguageCount -= 1;
        }
    }
    
}