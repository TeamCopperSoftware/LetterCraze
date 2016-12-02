package entities;

import java.io.IOException;
import java.util.ArrayList;

public class ThemeLevel extends LevelModel {

    String theme;
    Dictionary dictionary;//TODO implement dictionary
    ArrayList<String> validWords;
    
    public ThemeLevel(Board b, Goal g, Dictionary d, String theme, ArrayList<String> validWords) {
        super(b, g, d);
        this.theme = theme;
        this.validWords = validWords;
    }
    
    @Override
    void initializeWordTable() {
    	WordTable.loadWordTable(validWords);
    }
    
    String getTheme() {
        return theme;
    }
    
}
