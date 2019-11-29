package model.undefined;

public class Dice {
    private final int MAX = 6;
    private int faceValue;

    public Dice() {
        this.faceValue = 1;
    }

    public int roll() {
        faceValue = (int)(Math.random() * MAX) + 1;
        return faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }

}
