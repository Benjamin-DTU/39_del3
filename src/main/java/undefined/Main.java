package undefined;

import gui_fields.GUI_Board;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GUI_Street newStreet = new GUI_Street("Hej","hej1","hej2","20", Color.ORANGE, Color.BLUE);
        GUI_Street newStreet2 = new GUI_Street("Hej","hej1","hej2","20", Color.PINK, Color.BLUE);
        GUI_Field[] gui_fields = {newStreet,newStreet2};
        GUI gui = new GUI(gui_fields);
        GUI_Player player = new GUI_Player("Reza");
        gui.addPlayer(player);

    }
}
