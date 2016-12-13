package buildercontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import builderboundary.Application;
import entities.BuilderModel;

public class PublishLevelsController implements ActionListener {

	BuilderModel model;
	Application app;

	public PublishLevelsController(BuilderModel model, Application app) {
		this.model = model;
		this.app = app;
	}

	public void actionPerformed(ActionEvent e) {
		// we want to serialize this
		//model.getSavedLevels()

		int confirmed = JOptionPane.showConfirmDialog(null, 
				"Are you sure you want to publish your built levels to LetterCraze?\n"
						+ "Your Custom Levels in the player application will be overridden.", "",
						JOptionPane.YES_NO_OPTION);

		if (confirmed == JOptionPane.YES_OPTION) {
			try {
				FileOutputStream fileOut =
						new FileOutputStream("customlevels.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(model.getSavedLevels());
				out.close();
				fileOut.close();
				System.out.println("Serialized data is saved in customlevels.ser");
			}catch(IOException i) {
				i.printStackTrace();
			}
		}

	}

}
