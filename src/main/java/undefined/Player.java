package undefined;

import fields.Street;

public class Player {
    private String name;
    private Account account;
    private Piece piece;
    private boolean getOutOfJail;

    public Player(String name, Account account, Piece piece) {
        this.name = name;
        this.account = account;
        this.piece = piece;
        this.getOutOfJail = false;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isGetOutOfJail() {
        return getOutOfJail;
    }

    public void setGetOutOfJail(boolean getOutOfJail) {
        this.getOutOfJail = getOutOfJail;
    }
}
