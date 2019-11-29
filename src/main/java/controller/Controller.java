package controller;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import model.undefined.Monopoly;
import model.undefined.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Controller {
    private model.undefined.Monopoly monopoly;
    private GUI gui;
    private int noOfPlayers;

    public Controller(Monopoly monopoly, GUI gui, int noOfPlayers) {
        this.monopoly = monopoly;
        this.gui = gui;
        this.noOfPlayers = noOfPlayers;
    }

    public void setupAndStart() throws InterruptedException {
        //int noOfPlayers = gui.getUserInteger("Hvor mange spillere?", 2, 4);

        if (noOfPlayers == 2) {
            GUI_Player pl1 = new GUI_Player(monopoly.getPlayers()[0].getName(),20);
            GUI_Player pl2 = new GUI_Player(monopoly.getPlayers()[1].getName(),20);
            gui.addPlayer(pl1);
            gui.addPlayer(pl2);

            while (!monopoly.isGameLost()) {
                for (Player player :
                        monopoly.getPlayers()) {
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine();

                    gui.getFields()[monopoly.getPlayers()[0].getPiece().getPosition()].setCar(pl1, false);
                    gui.getFields()[monopoly.getPlayers()[1].getPiece().getPosition()].setCar(pl2, false);
                    monopoly.game(player);
                    gui.setDie(monopoly.getDice().getFaceValue());
                    gui.getFields()[monopoly.getPlayers()[0].getPiece().getPosition()].setCar(pl1, true);
                    gui.getFields()[monopoly.getPlayers()[1].getPiece().getPosition()].setCar(pl2, true);

                    pl1.setBalance(monopoly.getPlayers()[0].getAccount().getBalance());
                    pl2.setBalance(monopoly.getPlayers()[1].getAccount().getBalance());
                    //Thread.sleep(1000);

                    if (monopoly.isGameLost()) {
                        gui.showMessage("Spillet er slut. " + monopoly.getWinner().getName() + " vandt.");
                        break;
                    }
                }
            }
        } else if (noOfPlayers == 3) {
            GUI_Player pl1 = new GUI_Player(monopoly.getPlayers()[0].getName(),18);
            GUI_Player pl2 = new GUI_Player(monopoly.getPlayers()[1].getName(),18);
            GUI_Player pl3 = new GUI_Player(monopoly.getPlayers()[2].getName(),18);
            gui.addPlayer(pl1);
            gui.addPlayer(pl2);
            gui.addPlayer(pl3);

            while (!monopoly.isGameLost()) {
                for (Player player :
                        monopoly.getPlayers()) {
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine();

                    gui.getFields()[monopoly.getPlayers()[0].getPiece().getPosition()].setCar(pl1, false);
                    gui.getFields()[monopoly.getPlayers()[1].getPiece().getPosition()].setCar(pl2, false);
                    gui.getFields()[monopoly.getPlayers()[2].getPiece().getPosition()].setCar(pl2, false);
                    monopoly.game(player);
                    gui.setDie(monopoly.getDice().getFaceValue());
                    gui.getFields()[monopoly.getPlayers()[0].getPiece().getPosition()].setCar(pl1, true);
                    gui.getFields()[monopoly.getPlayers()[1].getPiece().getPosition()].setCar(pl2, true);
                    gui.getFields()[monopoly.getPlayers()[2].getPiece().getPosition()].setCar(pl2, true);

                    pl1.setBalance(monopoly.getPlayers()[0].getAccount().getBalance());
                    pl2.setBalance(monopoly.getPlayers()[1].getAccount().getBalance());
                    pl3.setBalance(monopoly.getPlayers()[2].getAccount().getBalance());

                    if (monopoly.isGameLost()) {
                        gui.showMessage("Spillet er slut. " + monopoly.getWinner().getName() + " vandt.");
                        break;
                    }
                }
            }
        } else if (noOfPlayers == 4) {
            GUI_Player pl1 = new GUI_Player(monopoly.getPlayers()[0].getName(),16);
            GUI_Player pl2 = new GUI_Player(monopoly.getPlayers()[1].getName(),16);
            GUI_Player pl3 = new GUI_Player(monopoly.getPlayers()[2].getName(),16);
            GUI_Player pl4 = new GUI_Player(monopoly.getPlayers()[3].getName(),16);
            gui.addPlayer(pl1);
            gui.addPlayer(pl2);
            gui.addPlayer(pl3);
            gui.addPlayer(pl4);

            while (!monopoly.isGameLost()) {
                for (Player player :
                        monopoly.getPlayers()) {
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine();

                    gui.getFields()[monopoly.getPlayers()[0].getPiece().getPosition()].setCar(pl1, false);
                    gui.getFields()[monopoly.getPlayers()[1].getPiece().getPosition()].setCar(pl2, false);
                    gui.getFields()[monopoly.getPlayers()[2].getPiece().getPosition()].setCar(pl2, false);
                    gui.getFields()[monopoly.getPlayers()[3].getPiece().getPosition()].setCar(pl2, false);
                    monopoly.game(player);
                    gui.setDie(monopoly.getDice().getFaceValue());
                    gui.getFields()[monopoly.getPlayers()[0].getPiece().getPosition()].setCar(pl1, true);
                    gui.getFields()[monopoly.getPlayers()[1].getPiece().getPosition()].setCar(pl2, true);
                    gui.getFields()[monopoly.getPlayers()[2].getPiece().getPosition()].setCar(pl2, true);
                    gui.getFields()[monopoly.getPlayers()[3].getPiece().getPosition()].setCar(pl2, true);

                    pl1.setBalance(monopoly.getPlayers()[0].getAccount().getBalance());
                    pl2.setBalance(monopoly.getPlayers()[1].getAccount().getBalance());
                    pl3.setBalance(monopoly.getPlayers()[2].getAccount().getBalance());
                    pl4.setBalance(monopoly.getPlayers()[3].getAccount().getBalance());

                    if (monopoly.isGameLost()) {
                        gui.showMessage("Spillet er slut. " + monopoly.getWinner().getName() + " vandt.");
                        break;
                    }
                }
            }
        }
    }
}
