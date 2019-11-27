package model.undefined;

import controller.Controller;
import gui_fields.*;
import gui_main.GUI;
import model.fields.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
/*
        GUI_Street newStreet = new GUI_Street("Hej","hej1","hej2","20", Color.ORANGE, Color.BLUE);
        GUI_Street newStreet2 = new GUI_Street("Hej","hej1","hej2","20", Color.PINK, Color.BLUE);
        GUI_Field[] gui_fields = {newStreet,newStreet2};
        GUI gui = new GUI(gui_fields);
        GUI_Player player = new GUI_Player("Reza");
        gui.addPlayer(player);

 */
        /*
        GUI gui = new GUI();
        final GUI_Player player = new GUI_Player("Reza");
        gui.addPlayer(player);
        final GUI_Field[] gui_fields = gui.getFields();
        gui_fields[0].setCar(player,true);
        for (int i = 0; i < gui_fields.length; i++) {
            gui_fields[i].setCar(player,false);
            gui_fields[i+1].setCar(player,true);
            Thread.sleep(500);
        }

         */

        //MODEL
        Player player1 = new Player("Anton", new Account(), new Piece("Bil"));
        Player player2 = new Player("Reza", new Account(), new Piece("Bil2"));
        Player[] players = {player1,player2};

        Street st1 = new Street("Vej1", 1, Colors.BLUE,false);
        Street st2 = new Street("Vej2", 1, Colors.BLUE,false);
        Chance ch1 = new Chance("Chance1", true);
        Street st3 = new Street("Vej3", 2, Colors.BROWN,false);
        Street st4 = new Street("Vej4", 2, Colors.BROWN,false);
        Street st5 = new Street("Vej5", 3, Colors.RED,false);
        Street st6 = new Street("Vej6", 3, Colors.RED,false);
        Chance ch2 = new Chance("Chance2", true);
        Street st7 = new Street("Vej7", 4, Colors.GREEN,false);
        Street st8 = new Street("Vej8", 4, Colors.GREEN,false);
        GoToJail goToJail = new GoToJail("JailGo", true);
        Jail jail = new Jail("Jail", true);

        Field[] fields = {st1, st2, ch1, st3, st4, jail,st5, st6, ch2, st7, st8, goToJail};
        Board board = new Board(fields, fields[0]);

        ChanceCard getOutOfJail = new ChanceCard("getOutOfJail", "Ryg gratis ud af fængslet!");
        ChanceCard move3fields = new ChanceCard("move3fields","Ryk 3 fælter frem");
        ChanceCard move5fields = new ChanceCard("move5fields", "Ryk 3 fælter frem");
        ChanceCard[] chanceCards = {getOutOfJail,move3fields,move3fields,move5fields,move5fields};

        Monopoly monopoly = new Monopoly(players,board, chanceCards);
        //monopoly.game();

        //VIEW
        GUI_Street guist1 = new GUI_Street("Vej1","hej1","hej2","1", Color.ORANGE, Color.BLUE);
        GUI_Street guist2 = new GUI_Street("Vej2","hej1","hej2","1", Color.ORANGE, Color.BLUE);
        GUI_Chance guich1 = new GUI_Chance("Chance","Chancekort","Chancekort",Color.PINK,Color.BLUE);
        GUI_Street guist3 = new GUI_Street("Vej3","hej1","hej2","1", Color.ORANGE, Color.BLUE);
        GUI_Street guist4 = new GUI_Street("Vej4","hej1","hej2","1", Color.ORANGE, Color.BLUE);
        GUI_Street guist5 = new GUI_Street("Vej5","hej1","hej2","1", Color.ORANGE, Color.BLUE);
        GUI_Street guist6 = new GUI_Street("Vej6","hej1","hej2","1", Color.ORANGE, Color.BLUE);
        GUI_Chance guich2 = new GUI_Chance("Chance","Chancekort","Chancekort",Color.PINK,Color.BLUE);
        GUI_Street guist7 = new GUI_Street("Vej7","hej1","hej2","1", Color.ORANGE, Color.BLUE);
        GUI_Street guist8 = new GUI_Street("Vej8","hej1","hej2","1", Color.ORANGE, Color.BLUE);
        GUI_Jail guijail1 = new GUI_Jail();
        GUI_Refuge guirefuge = new GUI_Refuge();

        GUI_Field[] gui_fields = {guist1,guist2,guich1,guist3, guist4,guijail1,guist5,guist6,guich2,guist7,guist8,guirefuge};
        GUI gui = new GUI(gui_fields);

        Controller controller = new Controller(monopoly,gui);
        controller.setupAndStart();
    }
}
