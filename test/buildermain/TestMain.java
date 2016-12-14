package buildermain;

import java.awt.event.WindowListener;

import builderboundary.Application;
import entities.BuilderModel;
import junit.framework.TestCase;

public class TestMain extends TestCase {
	
	public void testInitialization() {
		
		Main main = new Main();  //Should make its own fresh entities 
		//Just need to check everything can run through

		BuilderModel model = new BuilderModel();
		Application app = new Application(model);
		String[] args = new String[2];
		main.main(args);	
	}	

}
