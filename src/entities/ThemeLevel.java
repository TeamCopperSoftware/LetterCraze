package entities;

public class ThemeLevel extends LevelModel {

    String theme;
    Dictionary dictionary;//TODO implement dictionary
    
    public ThemeLevel(Board b, Goal g, Dictionary d, String theme) { //TODO verify if limit is supposed to be theme
        super(b, g, d);
        this.theme = theme;
    }
    
    String getTheme() {
        return theme;
    }
    
}
