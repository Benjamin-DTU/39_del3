package undefined;

import gui_fields.GUI_Board;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    GUI gui = new GUI();
    GUI_Player player = new GUI_Player("Reza");
    gui.addPlayer(player);
    }
}
