package playermain;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.JButton;

import entities.Board;
import entities.Goal;
import entities.LevelModel;
import entities.LightningLevel;
import entities.Map;
import entities.Model;
import entities.Position;
import entities.Square;
import entities.ThemeLevel;
import junit.framework.TestCase;
import playerboundary.Application;
import playerboundary.ThemeLevelApplication;
import playercontroller.AddWordController;
import playercontroller.HowToPlayController;
import playercontroller.ResetBoardController;
import playercontroller.ResetProgressController;
import playercontroller.SelectLetterController;
import playercontroller.UndoController;
import playercontroller.ViewAdventureMapController;
import playercontroller.ViewCustomLevelController;
import playercontroller.ViewCustomLevelsController;
import playercontroller.ViewLevelController;
import playercontroller.ViewMainMenuController;

public class TestMain extends TestCase {
	
	public void testInitialization() {
			
		Main main = new Main();  //Should make its own fresh entities 
		//Just need to check everything can run through
		assertNotNull(main.getApp());
		assertNotNull(main.getModel());
		
	}
	
	public void testInitialization2() {
		
		String[] args = new String[2];
		Main main = new Main();  //Should make its own fresh entities 
		//Just need to check everything can run through
		assertNotNull(main.getApp());
		assertNotNull(main.getModel());
		Main.main(args);
		
	}
	
	public void testInitialization3() {
		
		Main main = new Main();  //Should make its own fresh entities 
		//Just need to check everything can run through
		Application app = main.getApp();
		Model model = main.getModel();
		assertNotNull(app);
		assertNotNull(model);
		
		ArrayList<LevelModel> customLevels = new ArrayList<LevelModel>();
				// Create Level 8
				Square[] squaresArray = new Square[36];
				squaresArray[0] = new Square(new Position(0,0), false);
				squaresArray[1] = new Square(new Position(1,0), false);
				squaresArray[2] = new Square(new Position(2,0), false);
				squaresArray[3] = new Square(new Position(3,0), false);
				squaresArray[4] = new Square(new Position(4,0), true);
				squaresArray[5] = new Square(new Position(5,0), true);

				squaresArray[6] = new Square(new Position(0,1), false);
				squaresArray[7] = new Square(new Position(1,1), false);
				squaresArray[8] = new Square(new Position(2,1), false);
				squaresArray[9] = new Square(new Position(3,1), true);
				squaresArray[10] = new Square(new Position(4,1), true);
				squaresArray[11] = new Square(new Position(5,1), true);

				squaresArray[12] = new Square(new Position(0,2), false);
				squaresArray[13] = new Square(new Position(1,2), false);
				squaresArray[14] = new Square(new Position(2,2), true);
				squaresArray[15] = new Square(new Position(3,2), true);
				squaresArray[16] = new Square(new Position(4,2), true);
				squaresArray[17] = new Square(new Position(5,2), true);

				squaresArray[18] = new Square(new Position(0,3), false);
				squaresArray[19] = new Square(new Position(1,3), true);
				squaresArray[20] = new Square(new Position(2,3), true);
				squaresArray[21] = new Square(new Position(3,3), true);
				squaresArray[22] = new Square(new Position(4,3), true);
				squaresArray[23] = new Square(new Position(5,3), true);

				squaresArray[24] = new Square(new Position(0,4), true);
				squaresArray[25] = new Square(new Position(1,4), true);
				squaresArray[26] = new Square(new Position(2,4), true);
				squaresArray[27] = new Square(new Position(3,4), true);
				squaresArray[28] = new Square(new Position(4,4), true);
				squaresArray[29] = new Square(new Position(5,4), true);

				squaresArray[30] = new Square(new Position(0,5), true);
				squaresArray[31] = new Square(new Position(1,5), true);
				squaresArray[32] = new Square(new Position(2,5), true);
				squaresArray[33] = new Square(new Position(3,5), true);
				squaresArray[34] = new Square(new Position(4,5), true);
				squaresArray[35] = new Square(new Position(5,5), true);

				Board b8 = new Board(squaresArray);
				Goal g8 = new Goal(25, 35, 50);
				int timeLimit3 = 120; // seconds
				LightningLevel l8 = new LightningLevel(b8, g8, timeLimit3);
				LightningLevel l9 = new LightningLevel(b8, g8, 90);
		customLevels.add(l8);
		customLevels.add(l9);
		main.getModel().importCustomLevels(customLevels);
			
	}

}
