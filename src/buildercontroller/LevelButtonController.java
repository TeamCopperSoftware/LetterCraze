package buildercontroller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;

import entities.*;
import builderboundary.Application;
import builderboundary.CreateNewLevelApplication;

import java.util.*;

/**
 * 
 */
public class LevelButtonController implements ActionListener {


    /**
     * 
     */
    public BuilderModel model;

    /**
     * 
     */
    public Application application;
    
    /**
     * 
     */
    public JButton button;

    /**
     * 
     */
    public JComboBox box;


    /**
     * @param MapModel m 
     * @param MapApplication app
     */
    public LevelButtonController(BuilderModel m, Application app, JButton b, JComboBox c) {
        this.model = m;
        this.application = app;
        this.button = b;
        this.box = c;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if (button.getBackground().equals(Color.WHITE)) {
			button.setBackground(null);
			box.setVisible(false);
		}
		else {
			button.setBackground(Color.WHITE);
			box.setVisible(true);
		}
	}

}