package undefined;

import fields.Chance;
import fields.Field;
import fields.Jail;
import fields.Street;

public class Monopoly {
    private Player player;
    private Player[] players;
    private Board board;
    private Dice dice;
    private Boolean gameLost = false;
    private Field fields[];
    private Street Street;
    private Jail jail;
    private Chance chance;

    public Monopoly(Player[] players, Board board) {
        this.players = players;
        this.board = board;
        this.dice = new Dice();
        this.fields = board.getFields();
    }

    public void game() {
        while (!gameLost) {
            for (Player player :
                    players) {
                playerTurn(player);

            }
        }

    }
    public void playerTurn(Player player) {
        movePlayer(player);
        landOnField(player);
    }

    public void landOnField(Player player) {
        Piece piece = player.getPiece();
        if (fields[piece.getPosition()].getClass().equals(Street)) {

        }
    }

    public void movePlayer(Player player) {
        int roll = dice.roll();
        Piece piece = player.getPiece();
        piece.setPosition(piece.getPosition() + roll);

    }


}