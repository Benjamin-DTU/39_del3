package model.undefined;

import model.fields.*;

import java.util.Scanner;

public class Monopoly {
    private Player currentPlayer;
    private Player[] players;
    private Board board;
    private Dice dice;
    private Boolean gameLost = false;
    private Field[] fieldsGame;
    private Street Street = new Street("Test", 0, Colors.BLUE, false);
    private Jail Jail = new Jail("Test", true);
    private Chance Chance = new Chance("Test", true);
    private GoToJail GoToJail = new GoToJail("Test", true);
    private ChanceCard[] chanceCards;
    private int cardPicker = 0;
    private Player winnerPlayer;

    public Monopoly(Player[] players, Board board, ChanceCard[] chanceCards) {
        this.players = players;
        this.board = board;
        this.dice = new Dice();
        this.fieldsGame = board.getFields();
        this.chanceCards = chanceCards;
        initGame();
    }

    public void game(Player player) {
        //initGame();
        //while (!gameLost) {
            //for (Player player :
             //       players) {
               // Scanner scanner = new Scanner(System.in);
               // scanner.nextLine();
        currentPlayer = player;
        System.out.println(currentPlayer.getName() + "s tur");
        playerTurn();
        for (Player p :
                players) {
            System.out.println(p.getName() + p.getAccount().getBalance());
        }
        System.out.println();
        //     if (gameLost) break;
        //  }
       // }

    }

    public void initGame() {
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
            //for testing
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
        if (fieldsGame[piece.getPosition()].getClass().equals(Street.getClass())) {
            landOnStreet((Street) fieldsGame[piece.getPosition()]);
        } else if (fieldsGame[piece.getPosition()].getClass().equals(GoToJail.getClass())) {
            System.out.println("Jail");
            landOnJail();
        } else if (fieldsGame[piece.getPosition()].getClass().equals(Chance.getClass())) {
            System.out.println("Chance");
            landOnChance();
        }

    }

    private void landOnChance() {
        if (chanceCards[cardPicker].getName().equals("getOutOfJail")) {
            currentPlayer.setGetOutOfJail(true);
            System.out.println("Spiller fik fængselskort");
        } else if (chanceCards[cardPicker].getName().equals("move3fields")) {
            currentPlayer.getPiece().setPosition(currentPlayer.getPiece().getPosition() + 3);
            System.out.println("Spiller rykker 3 felter frem");
        } else if (chanceCards[cardPicker].getName().equals("move5fields")) {
            currentPlayer.getPiece().setPosition(currentPlayer.getPiece().getPosition() + 5);
            System.out.println("Spiller rykker 5 felter frem");
        }
        if (currentPlayer.getPiece().getPosition() >= fieldsGame.length) {
            currentPlayer.getPiece().setPosition(currentPlayer.getPiece().getPosition() - fieldsGame.length);
        }
        cardPicker++;
        if (cardPicker >= chanceCards.length) {
            cardPicker = 0;
        }
    }

    private void landOnJail() {
        int jailPosition = 0;
        for (Field field :
                fieldsGame) {
            if (field.getClass().equals(Jail.getClass())) {
                break;
            }
            jailPosition++;
        }
        currentPlayer.getPiece().setPosition(jailPosition);
        System.out.println(currentPlayer.getName() + " er røget i fængsel på feltet " + fieldsGame[currentPlayer.getPiece().getPosition()].getName());
        if (currentPlayer.isGetOutOfJail()) {
            System.out.println("Spiller bruger fængselskortet og kommer ud gratis");
            currentPlayer.setGetOutOfJail(false);
        } else {
            currentPlayer.getAccount().withdraw(1);
            System.out.println("Spiller betaler 1 for af komme ud af fængslet");
        }
    }

    private void landOnStreet(Street street) {
        if (street.getOwner() == null) {
            if (currentPlayer.getAccount().getBalance() < street.getPrice()) {
                gameLost = true;
                return;
            }
            street.setOwner(currentPlayer);
            currentPlayer.getAccount().withdraw(street.getPrice());
            System.out.println(currentPlayer.getName() + " køber " + street.getName());
            checkForBothOwned(street);
        } else if (street.getOwner() != null && street.getOwner() != currentPlayer && !street.isBothOwned()) {
            System.out.println(currentPlayer.getName() + " landede på " + street.getOwner().getName() + "s vej " + street.getName());
            if (currentPlayer.getAccount().getBalance() < street.getPrice()) {
                System.out.println(currentPlayer.getName() + " har ikke nok til at betale - spillet er tabt");
                gameLost = true;
                return;
            }
            currentPlayer.getAccount().withdraw(street.getPrice());
            street.getOwner().getAccount().deposit(street.getPrice());
        } else if (street.getOwner() != null && street.getOwner() != currentPlayer && street.isBothOwned()) {
            System.out.println("DOBBELT " + currentPlayer.getName() + " landede på " + street.getOwner().getName() + "s vej " + street.getName());
            if (currentPlayer.getAccount().getBalance() < street.getPrice() * 2) {
                System.out.println(currentPlayer.getName() + " har ikke nok til at betale - spillet er tabt");
                gameLost = true;
                return;
            }
            currentPlayer.getAccount().withdraw(street.getPrice() * 2);
            street.getOwner().getAccount().deposit(street.getPrice() * 2);
        } else System.out.println("Landed på sig egen " + street.getName());
    }

    private void checkForBothOwned(Street street) {
        for (Field field :
                fieldsGame) {
            if (field.getClass().equals(Street.getClass())) {
                if (((Street) field).getColor() == street.getColor() && ((Street) field).getOwner() == street.getOwner() && ((Street) field) != street) {
                    street.setBothOwned(true);
                    ((Street) field).setBothOwned(true);
                }
            }
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
            currentPlayer.getAccount().deposit(2);
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public Boolean isGameLost() {
        return gameLost;
    }

    public Dice getDice() {
        return dice;
    }

    public Player getWinner() {
        for (Player player :
                players) {
            if (winnerPlayer == null) {
                winnerPlayer = player;
            } else if (player.getAccount().getBalance() > winnerPlayer.getAccount().getBalance()) {
                winnerPlayer = player;
            }
        }
        return winnerPlayer;
    }
}