package entities;

public class Position {
    int x;
    int y;
    
    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    void updateY (int y) {
        this.y = y;
    } 
    
    void updateX (int x) {
        this.x = x;
    }
    
    int getX () {
        return x;
    }
    
    int getY() {
        return y;
    }
}
