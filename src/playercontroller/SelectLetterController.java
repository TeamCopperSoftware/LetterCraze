package playercontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entities.Model;
import playerboundary.Application;

public class SelectLetterController implements ActionListener {
	Application app;
	Model model;
	JButton button;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//JButton button = 
	}
	
	public SelectLetterController(Application app, Model m) {
		this.app = app;
		this.model = m;
	}
}
