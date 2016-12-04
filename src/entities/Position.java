package entities;

public class Position {
    int row;
    int column;
    
    public Position (int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    void updateRow (int row) {
        this.row = row;
    }
    
    void updateColumn (int column) {
        this.column = column;
    }
    
    int getRow () {
        return row;
    }
    
    int getColumn() {
        return column;
    }
}
