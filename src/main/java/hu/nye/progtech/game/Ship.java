package hu.nye.progtech.game;

import java.util.Arrays;

/**
 * Ship's property.
 */
public class Ship {

    String name;
    int size;
    char[] cells;
    int lives;
    int rowBegin;
    int columnBegin;
    int rowEnd;
    int columnEnd;
    boolean isPlaced;

    Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.lives = lives;
        this.cells = new char[size];
        Arrays.fill(cells, 'O');
        this.isPlaced = false;
    }

    void place(int rowBegin, int columnBegin, int rowEnd, int columnEnd) {
        this.rowBegin = rowBegin;
        this.columnBegin = columnBegin;
        this.rowEnd = rowEnd;
        this.columnEnd = columnEnd;
        this.isPlaced = true;
    }

    void hit() {
        lives--;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getLives() {
        return lives;
    }

    public int getRowBegin() {
        return rowBegin;
    }

    public int getColumnBegin() {
        return columnBegin;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public int getColumnEnd() {
        return columnEnd;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    //Nice
}
