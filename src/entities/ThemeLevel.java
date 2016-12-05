package entities;

import java.io.IOException;
import java.util.ArrayList;

public class ThemeLevel extends LevelModel {

    String theme;
    ArrayList<String> validWords;
    
    public ThemeLevel(Board b, Goal g, String theme, ArrayList<String> validWords) {
        super(b, g, "Theme");
        this.theme = theme;
        this.validWords = validWords;
    }
    
    @Override
    void initializeWordTable() {
    	WordTable.loadWordTable(validWords);
    }
    
    public String getTheme() {
        return theme;
    }
    
    public ArrayList<String> getValidWords() {
    	return validWords;
    }
    
}
