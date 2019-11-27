package controller;

import gui_fields.GUI_Player;
import gui_main.GUI;
import model.undefined.Monopoly;
import model.undefined.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Controller implements ActionListener {
    private model.undefined.Monopoly monopoly;
    private GUI gui;

    public Controller(Monopoly monopoly, GUI gui) {
        this.monopoly = monopoly;
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void setupAndStart() {
        int noOfPlayers = gui.getUserInteger("Hvor mange spillere?", 2, 4);

        if (noOfPlayers == 2) {
            GUI_Player pl1 = new GUI_Player(gui.getUserString("Spiller 1 hedder:"));
            GUI_Player pl2 = new GUI_Player(gui.getUserString("Spiller 2 hedder:"));
            gui.addPlayer(pl1);
            gui.addPlayer(pl2);

            //Scanner scanner = new Scanner(System.in);
            monopoly.initGame();
            while (!monopoly.isGameLost()) {
                //scanner.nextLine();
                for (Player player :
                        monopoly.getPlayers()) {
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine();
                    gui.getFields()[monopoly.getPlayers()[0].getPiece().getPosition()].setCar(pl1, false);
                    gui.getFields()[monopoly.getPlayers()[1].getPiece().getPosition()].setCar(pl2, false);
                    monopoly.game(player);
                    gui.getFields()[monopoly.getPlayers()[0].getPiece().getPosition()].setCar(pl1, true);
                    gui.getFields()[monopoly.getPlayers()[1].getPiece().getPosition()].setCar(pl2, true);

                    pl1.setBalance(monopoly.getPlayers()[0].getAccount().getBalance());
                    pl2.setBalance(monopoly.getPlayers()[1].getAccount().getBalance());

                    if (monopoly.isGameLost()) break;
                }
            }
        }
    }
}
