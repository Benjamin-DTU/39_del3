package undefined;

import fields.Field;
import fields.Jail;
import fields.Street;
import gui_fields.GUI_Board;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
        GUI_Street newStreet = new GUI_Street("Hej","hej1","hej2","20", Color.ORANGE, Color.BLUE);
        GUI_Street newStreet2 = new GUI_Street("Hej","hej1","hej2","20", Color.PINK, Color.BLUE);
        GUI_Field[] gui_fields = {newStreet,newStreet2};
        GUI gui = new GUI(gui_fields);
        GUI_Player player = new GUI_Player("Reza");
        gui.addPlayer(player);

 */
        Player player1 = new Player("Anton", new Account(), new Piece("Bil"));
        Player player2 = new Player("Reza", new Account(), new Piece("Bil2"));
        Player[] players = {player1,player2};
        //Player[] players = {player1};

        Street st1 = new Street("Vej1", 1, Colors.BLUE,false);
        Street st2 = new Street("Vej2", 1, Colors.BLUE,false);
        Street st3 = new Street("Vej3", 2, Colors.BLUE,false);
        Street st4 = new Street("Vej4", 2, Colors.BLUE,false);
        Street st5 = new Street("Vej5", 3, Colors.BLUE,false);
        Street st6 = new Street("Vej6", 3, Colors.BLUE,false);
        Street st7 = new Street("Vej7", 4, Colors.BLUE,false);
        Street st8 = new Street("Vej8", 4, Colors.BLUE,false);
        Jail jail = new Jail("Jail", true);
        Field[] fields = {st1, st2, st3, st4, st5, st6, st7, st8, jail};
        Board board = new Board(fields, fields[0]);
        Monopoly monopoly = new Monopoly(players,board);
        monopoly.game();



    }
}
