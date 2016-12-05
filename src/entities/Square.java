package entities;

public class Square {

    Position position;
    Tile tile;
    boolean enabled;

    public Square(Position p, boolean enabled, Tile t) {
        this.position = p;
        this.enabled = enabled;
        this.tile = t;
    }
    
    public Square(Position p, boolean enabled) {
        this.position = p;
        this.enabled = enabled;
        this.tile = null;
    }
    
    public Square() {
        //TODO remove at a later time;
        
    }
    
    
    void generateRandomTile () {
        //TODO pseudo-rand generator
    }
    
    void tileAdd (Tile t) {
        this.tile = t;
    }
    
    public Tile tilePeek () {
        return tile;
    }
    
    Tile tilePop () {
        Tile t = tile;
        tileRemove();
        return t;
    }
    
    void tileRemove () {
        tile = null;
    }

    Position position() {
        return position;
        
    }
    
    public boolean isEnabled() {
    	return enabled;
    }
    
    public boolean hasTile() {
    	return tile != null;
    }

}
