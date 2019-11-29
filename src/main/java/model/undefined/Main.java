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


        //monopoly.game();

        //VIEW - Første Color er baggrund. Anden Color er tekst. Se klassen Colors.java, for farveliste. Burde guist1 ikke være START feltet?
        GUI_Street guistart = new GUI_Street("START","Få M2","Du modtager M2 ved passering","0", Color.WHITE, Color.BLACK);   // Skal modtage M2, ved ikke hvad jeg gør med "rent"

        GUI_Street guist1 = new GUI_Street("BUGERBAREN","M1","Du køber ejendom el. betaler husleje","1", Color.CYAN, Color.BLACK);
        GUI_Street guist2 = new GUI_Street("PIZZARIAET","M1","Du køber ejendom el. betaler husleje","1", Color.CYAN, Color.BLACK);
                GUI_Chance guich1 = new GUI_Chance("?","Chancekort","Du modtager en chancekort",Color.MAGENTA,Color.BLACK);
        GUI_Street guist3 = new GUI_Street("SLIKBUTIKKEN","M1","Du køber ejendom el. betaler husleje","1", Color.DARK_GRAY, Color.BLACK);
        GUI_Street guist4 = new GUI_Street("ISKIOSEN","M1","Du køber ejendom el. betaler husleje","1", Color.DARK_GRAY, Color.BLACK);
        GUI_Jail guijail2 = new GUI_Jail();
        GUI_Street guist5 = new GUI_Street("MUSEET","M2","Du køber ejendom el. betaler husleje","2", Color.PINK, Color.BLACK);
        GUI_Street guist6 = new GUI_Street("BIBLIOTEKET","M2","Du køber ejendom el. betaler husleje","2", Color.PINK, Color.BLACK);
                GUI_Chance guich2 = new GUI_Chance("?","Chancekort","Du modtager en chancekort",Color.MAGENTA,Color.BLACK);
        GUI_Street guist7 = new GUI_Street("SKATERPARKEN","M2","Du køber ejendom el. betaler husleje","2", Color.YELLOW, Color.BLACK);
        GUI_Street guist8 = new GUI_Street("SWIMMINGPOOL","M2","Du køber ejendom el. betaler husleje","2", Color.YELLOW, Color.BLACK);
        GUI_Refuge guirefuge = new GUI_Refuge();// GRATIS PARKERING HER :)
        GUI_Street guist9 = new GUI_Street("SPILLEHALLEN","M3","Du køber ejendom el. betaler husleje","3", Color.RED, Color.BLACK);
        GUI_Street guist10 = new GUI_Street("BIOGRAFEN","M3","Du køber ejendom el. betaler husleje","3", Color.RED, Color.BLACK);
                GUI_Chance guich3 = new GUI_Chance("?","Chancekort","Du modtager en chancekort",Color.MAGENTA,Color.BLACK);
        GUI_Street guist11 = new GUI_Street("LEJETØJSBUTIKKEN","M3","Du køber ejendom el. betaler husleje","3", Color.ORANGE, Color.BLACK);
        GUI_Street guist12 = new GUI_Street("DYREHANDLEN","M3","Du køber ejendom el. betaler husleje","3", Color.ORANGE, Color.BLACK);
                GUI_Jail guijail1 = new GUI_Jail();
        GUI_Street guist13 = new GUI_Street("BOWLINGHAL","M4","Du køber ejendom el. betaler husleje","4", Color.GREEN, Color.BLACK);
        GUI_Street guist14 = new GUI_Street("ZOO","M4","Du køber ejendom el. betaler husleje","4", Color.GREEN, Color.BLACK);
                GUI_Chance guich4 = new GUI_Chance("?","Chancekort","Du modtager en chancekort",Color.MAGENTA,Color.BLACK);
        GUI_Street guist15 = new GUI_Street("VANDLAND","M5","Du køber ejendom el. betaler husleje","5", Color.BLUE, Color.BLACK);
        GUI_Street guist16 = new GUI_Street("STRANDPROMENADEN","M5","Du køber ejendom el. betaler husleje","5", Color.BLUE, Color.BLACK);

        GUI_Field[] gui_fields = {guistart, guist1,guist2,guich1,guist3, guist4,guijail2,guist5,guist6,guich2,guist7,guist8,guirefuge,/* GUI PARKERING */ guist9, guist10, guich3, guist11, guist12, guijail1, guist13, guist14, guich4, guist15, guist16};
        GUI gui = new GUI(gui_fields);

        //MODEL
        // Farverne Colors.FARVE, gør ikke noget for GUI'en? Hvad bruges de til?
        Street start = new Street("START", 0, Colors.WHITE,false);

        Street st1 = new Street("BURGERBAREN", 1, Colors.CYAN,false);
        Street st2 = new Street("PIZZARIAET", 1, Colors.CYAN,false);
        Chance ch1 = new Chance("Chance1", true);
        Street st3 = new Street("SLIKBUTIKKEN", 1, Colors.DARK_GRAY,false);
        Street st4 = new Street("ISKIOSEN", 1, Colors.DARK_GRAY,false);
        Jail jail = new Jail("Jail", true);   // har copy/pastet det ind, for at holde kronologi
        Street st5 = new Street("MUSEET", 2, Colors.PINK,false);
        Street st6 = new Street("BIBLIOTEKET", 2, Colors.PINK,false);
        Chance ch2 = new Chance("Chance2", true);
        Street st7 = new Street("SKATERPARKEN", 2, Colors.YELLOW,false);
        Street st8 = new Street("SWIMMINGPOOL", 2, Colors.YELLOW,false);
        Street park = new Street("PARKERING",0,Colors.WHITE,true);//GRATIS PARKERING HER :)
        Street st9 = new Street("SPILLEHALLEN", 3, Colors.RED,false);
        Street st10 = new Street("BIOGRAFEN", 3, Colors.RED,false);
        Chance ch3 = new Chance("Chance3", true);
        Street st11 = new Street("LEGETØJSBUTIKKEN", 3, Colors.ORANGE,false);
        Street st12 = new Street("DYREHANDLEN", 3, Colors.ORANGE,false);
        GoToJail goToJail = new GoToJail("JailGo", true);   // har copy/pastet det ind, for at holde kronologi.
        Street st13 = new Street("BOWLINGHAL", 4, Colors.GREEN,false);
        Street st14 = new Street("ZOO", 4, Colors.GREEN,false);
        Chance ch4 = new Chance("Chance4", true);
        Street st15 = new Street("VANDLANDET", 5, Colors.BLUE,false);
        Street st16 = new Street("STRANDPROMENADEN", 5, Colors.BLUE,false);

        Field[] fields = {start, st1, st2, ch1, st3, st4, jail,st5, st6, ch2, st7, st8, park, st9, st10, ch3, st11, st12, goToJail, st13, st14, ch4, st15, st16};
        Board board = new Board(fields, fields[0]);

        ChanceCard getOutOfJail = new ChanceCard("getOutOfJail", "Ryg gratis ud af fængslet!");
        ChanceCard move3fields = new ChanceCard("move3fields","Ryk 3 fælter frem");
        ChanceCard move5fields = new ChanceCard("move5fields", "Ryk 3 fælter frem");
        ChanceCard[] chanceCards = {getOutOfJail,move3fields,move3fields,move5fields,move5fields};

        int noOfPlayers = gui.getUserInteger("Hvor mange spillere?", 2, 4);
        Player[] players = new Player[noOfPlayers];
        if (noOfPlayers == 2) {
            Player player1 = new Player(gui.getUserString("Spiller 1 hedder:"), new Account(), new Piece("Bil"));
            Player player2 = new Player(gui.getUserString("Spiller 2 hedder:"), new Account(), new Piece("Bil"));
            players[0] = player1;
            players[1] = player2;
        } else if (noOfPlayers == 3) {
            Player player1 = new Player(gui.getUserString("Spiller 1 hedder:"), new Account(), new Piece("Bil"));
            Player player2 = new Player(gui.getUserString("Spiller 2 hedder:"), new Account(), new Piece("Bil"));
            Player player3 = new Player(gui.getUserString("Spiller 3 hedder:"), new Account(), new Piece("Bil"));
            players[0] = player1;
            players[1] = player2;
            players[2] = player3;

        } else if (noOfPlayers == 4) {
            Player player1 = new Player(gui.getUserString("Spiller 1 hedder:"), new Account(), new Piece("Bil"));
            Player player2 = new Player(gui.getUserString("Spiller 2 hedder:"), new Account(), new Piece("Bil"));
            Player player3 = new Player(gui.getUserString("Spiller 3 hedder:"), new Account(), new Piece("Bil"));
            Player player4 = new Player(gui.getUserString("Spiller 4 hedder:"), new Account(), new Piece("Bil"));
            players[0] = player1;
            players[1] = player2;
            players[2] = player3;
            players[3] = player4;

        }
        //Player player1 = new Player("Anton", new Account(), new Piece("Bil"));
        //Player player2 = new Player("Reza", new Account(), new Piece("Bil2"));
       // Player[] players = {player1,player2};

        Monopoly monopoly = new Monopoly(players,board, chanceCards);



        Controller controller = new Controller(monopoly,gui,noOfPlayers);
        controller.setupAndStart();
    }
}
