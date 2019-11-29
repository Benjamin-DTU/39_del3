package model.undefined;

public class Piece {
    private String name;
    private int position;

    public Piece(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
