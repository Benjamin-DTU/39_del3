package controller;

import gui_fields.GUI_Player;
import gui_main.GUI;
import model.undefined.Monopoly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private model.undefined.Monopoly monopoly;
    private GUI gui;

    public Controller(Monopoly monopoly, GUI gui) {
        this.monopoly = monopoly;
        this.gui = gui;
        setupAndStart();
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void setupAndStart() {
        GUI_Player player = new GUI_Player(gui.getUserString("Spillerens navn: "));
        gui.addPlayer(player);

    }
}
