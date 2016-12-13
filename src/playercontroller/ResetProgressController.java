package playercontroller;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import entities.Model;
import playerboundary.Application;
import playermain.Main;

public class ResetProgressController implements ActionListener {

	Application app;
	Model model;

	public ResetProgressController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	public void actionPerformed(ActionEvent ae) {

		int confirmed = JOptionPane.showConfirmDialog(null, 
				"Are you sure you want to reset your main game progress?\n"
						+ "This will quit the game and require you to restart it.", "",
						JOptionPane.YES_NO_OPTION);

		if (confirmed == JOptionPane.YES_OPTION) {
			try {
				FileWriter fileOut = new FileWriter("playersave.ser");
				fileOut.write("");
				fileOut.close();
				// progress reset
				System.out.println("Main Game progress reset. Quitting game...");
				System.exit(0);
			}catch(IOException i) {
				System.out.println("Error - playersave.ser not configured correctly.");
			}
		}
	}

}


