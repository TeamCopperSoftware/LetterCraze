package playermain;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import entities.LevelModel;
import entities.Map;
import entities.Model;
import entities.ThemeLevel;
import junit.framework.TestCase;
import playerboundary.Application;
import playerboundary.ThemeLevelApplication;
import playercontroller.SelectLetterController;

public class TestMain extends TestCase {
	
	public void testInitialization() {
			
		Main main = new Main();  //Should make its own fresh entities 
		//Just need to check everything can run through
		
	}

}
