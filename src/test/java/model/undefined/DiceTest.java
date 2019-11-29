package model.undefined;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {
    private int rolls[] = {0, 0, 0, 0, 0, 0};

        @Test
        public void simpleRoll() {
            Dice dice = new Dice();
            for (int i = 0; i < 1000000; i++) {
                assertEquals(3.5, dice.roll(), 2.5);
            }

        }

        @Test
        public void frequencyRoll() {
            Dice dice = new Dice();
            for (int i = 0; i < 6000000; i++) {
                dice.roll();
                if (dice.getFaceValue() == 1) {
                    rolls[0]++;
                } else if (dice.getFaceValue() == 2) {
                    rolls[1]++;
                } else if (dice.getFaceValue() == 3) {
                    rolls[2]++;
                } else if (dice.getFaceValue() == 4) {
                    rolls[3]++;
                } else if (dice.getFaceValue() == 5) {
                    rolls[4]++;
                } else if (dice.getFaceValue() == 6) {
                    rolls[5]++;
                }

            }
            assertEquals(1000000, rolls[0], 5000);
            assertEquals(1000000, rolls[1], 5000);
            assertEquals(1000000, rolls[2], 5000);
            assertEquals(1000000, rolls[3], 5000);
            assertEquals(1000000, rolls[4], 5000);
            assertEquals(1000000, rolls[5], 5000);
            System.out.println("1 : " + rolls[0]);
            System.out.println("2 : " + rolls[1]);
            System.out.println("3 : " + rolls[2]);
            System.out.println("4 : " + rolls[3]);
            System.out.println("5 : " + rolls[4]);
            System.out.println("6 : " + rolls[5]);
        }
    }


