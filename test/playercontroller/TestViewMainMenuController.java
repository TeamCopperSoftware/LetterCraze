package playercontroller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import entities.LevelModel;
import entities.Model;
import junit.framework.TestCase;
import playerboundary.Application;

public class TestViewMainMenuController extends TestCase {

	public void testNavigation() {
		Model model = new Model();
		Application app = new Application(model);
		ViewMainMenuController vmmc = new ViewMainMenuController(app, model);
		JButton butt = new JButton();
		ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		vmmc.actionPerformed(ae);
		
	}
	/*
	private WindowAdapter exitListener(){
		return new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				app.dispose();}          };
	} */
	
	//this.addWindowListener(new java.awt.event.WindowAdapter() {
	//	public void windowClosing(java.awt.event.WindowEvent windowEvent) 
	public void testCloseWindow() {
		
		Model model = new Model();
		Application app = new Application(model);
		ViewMainMenuController vmmc = new ViewMainMenuController(app, model);
		//exitListener();
		
		JButton butt = vmmc.app.getMapApplication().getLevelButtons().get(1);
		
		//WindowAdapter wl = vmmc.app.addWindowListener(exitListener());
		//vmmc.app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		WindowEvent we = new WindowEvent(app, (int) WindowEvent.WINDOW_CLOSED);
		//ActionEvent ae = new ActionEvent(butt, (int) ActionEvent.MOUSE_EVENT_MASK, "click butt"); //want butt.doClick or butt.doClick()
		//app.vmmc.app.;
		
	}
	
}
