package undefined;

public class Player {
    private String name;
    private Account account;
    private Piece piece;

    public Player(String name, Account account, Piece piece) {
        this.name = name;
        this.account = account;
        this.piece = piece;
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
}
