package undefined;

import fields.Chance;
import fields.Field;
import fields.Jail;
import fields.Street;

import java.util.Scanner;

public class Monopoly {
    private Player currentPlayer;
    private Player[] players;
    private Board board;
    private Dice dice;
    private Boolean gameLost = false;
    private Field fieldsGame[];
    private Street Street = new Street("Test", 0, Colors.BLUE, false);
    private Jail Jail = new Jail("Test",true);
    private Chance Chance = new Chance("Test", false);

    public Monopoly(Player[] players, Board board) {
        this.players = players;
        this.board = board;
        this.dice = new Dice();
        this.fieldsGame = board.getFields();
    }

    public void game() {
        initGame();
        while (!gameLost) {
            for (Player player :
                    players) {
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                currentPlayer = player;
                //playerTurn(currentPlayer);
                System.out.println(player.getName() + "s tur");
                playerTurn();
                System.out.println(players[0].getName() + players[0].getAccount().getBalance());
                System.out.println(players[1].getName() + players[1].getAccount().getBalance());
            }
        }

    }

    private void initGame() {
        if (players.length == 2) {
            for (Player player :
                    players) {
                player.getAccount().setBalance(20);
            }
        } else if (players.length == 3) {
            for (Player player :
                    players) {
                player.getAccount().setBalance(18);
            }
        } else if (players.length == 4) {
            for (Player player :
                    players) {
                player.getAccount().setBalance(16);
            }
        } else if (players.length == 1) {
            for (Player player :
                    players) {
                player.getAccount().setBalance(20);
                System.out.println("Balance set to 20");
            }
        }
    }

    private void playerTurn() {
        movePlayer();
        landOnField();
        checkIfLost();
    }

    private void checkIfLost() {
        for (Player player :
                players) {
            if (player.getAccount().getBalance() <= 0) {
                gameLost = true;
            }

        }
    }

    private void landOnField() {
        Piece piece = currentPlayer.getPiece();
        System.out.println(fieldsGame[piece.getPosition()].getClass());
        if (fieldsGame[piece.getPosition()].getClass().equals(Street.getClass())) {
            System.out.println("Street");
            landOnStreet((Street) fieldsGame[piece.getPosition()]);
        } else if (fieldsGame[piece.getPosition()].getClass().equals(Jail.getClass())) {
            System.out.println("Jail");
        } else if (fieldsGame[piece.getPosition()].getClass().equals(Chance.getClass())) {
            System.out.println("Chance");
        }
    }

    private void landOnStreet(Street street) {
        if (street.getOwner() == null && currentPlayer.getAccount().getBalance() >= street.getPrice()) {
            street.setOwner(currentPlayer);
            currentPlayer.getAccount().withdraw(street.getPrice());
            System.out.println(currentPlayer.getName() + " køber " + street.getName());
        } else if (street.getOwner() != null && street.getOwner() != currentPlayer) {
            currentPlayer.getAccount().withdraw(street.getPrice());
            street.getOwner().getAccount().deposit(street.getPrice());
            System.out.println(currentPlayer.getName() + " landede på " + street.getOwner().getName()+ "s vej " + street.getName());
        }
    }

    private void movePlayer() {
        int roll = dice.roll();
        System.out.println("Slag = " + roll);
        Piece piece = currentPlayer.getPiece();
        System.out.println("Old position = " + piece.getPosition());
        piece.setPosition(piece.getPosition() + roll);
        System.out.println("New position = " + piece.getPosition());
        if (piece.getPosition() >= fieldsGame.length) {
            piece.setPosition(piece.getPosition() - fieldsGame.length);
            System.out.println("Modded position = " + piece.getPosition());
        }
    }


}