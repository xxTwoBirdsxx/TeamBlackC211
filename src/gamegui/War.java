package gamegui;

import java.util.ArrayList;
/**
 * A class for simulating the WAR! cardgame
 * @author TEAM BLACK , Zachary C.
 */
public class War {

    static double player = 0;
    static double computer = 0;
    static ScoreBoard sb;

    public static ArrayList<String> Player;  //to hold the player's cards
    public static ArrayList<String> Computer; //to hold the computer's cards

    public War() {
        Player = new ArrayList<>();
        Computer = new ArrayList<>();
        Deck D = new Deck();
        dealCards(D);

    }

    static String play() {

        if (Player.size() > 0 && Computer.size() > 0) {
            String result = resolvePlay();// see who wins, and swap cards
            return result;
        } else if (Player.size() == 0) {// player lost

            return "Computer has Won";
        } else {//computer lost

            return "Player has Won";
        }

    }

    static void dealCards(Deck D) {
        for (int i = 0; i < D.theDeck.length; i++) {
            if (i % 2 == 0)//even numbers
            {
                Player.add(D.theDeck[i]);
            } else {//odd numbers
                Computer.add(D.theDeck[i]);
            }

        }
    }

    /*
    Method for testing the dealCards function
     */
    static void printCards() {
        System.out.println("######## PLAYER'S HAND #################3");
        for (String card : Player) {
            System.out.println(card);
        }
        System.out.println("##################### Computer's Hand ###############");
        for (String card : Computer) {
            System.out.println(card);
        }
    }

    static void showPlayerCard() {
        System.out.println("Player flips: " + Player.get(0));

    }

    static void showComputerCard() {
        System.out.println("Computer flips: " + Computer.get(0));
    }

    static String resolvePlay() {

        if (determineValue(Player.get(0)) > determineValue(Computer.get(0))) {
            Player.add(Computer.get(0));//take the computers top card
            Computer.remove(0);
            Player.add(Player.get(0));//add the top card to the back
            Player.remove(0);//remove the now duplicate top card
            return "PLAYER WINS!";
        } else if (determineValue(Player.get(0)) < determineValue(Computer.get(0))) {

            Computer.add(Player.get(0));
            Player.remove(0);
            Computer.add(Computer.get(0));
            Computer.remove(0);
            return "COMPUTER WINS!";
        } else {
            return "A Tie";

        }

    }

    static String resolveTie() {
        String result;
        //System.out.println("Three cards down, flipping the fourth...");
        if (Player.size() < 5) {
            result = "Plow";
            Player.clear();
            return result;
        }
        if (Computer.size() < 5) {
            result = "Clow";
            Computer.clear();
            return result;
        }
        if (determineValue(Player.get(4)) > determineValue(Computer.get(4))) {
            result = "PLAYER WINS!";
            Player.add(Computer.get(0));
            Player.add(Computer.get(1));
            Player.add(Computer.get(2));
            Player.add(Computer.get(3));
            Player.add(Computer.get(4));
            Computer.remove(0);
            Computer.remove(0);
            Computer.remove(0);
            Computer.remove(0);
            Computer.remove(0);
            return result;
        } else {
            result = "Computer Wins!";

            Computer.add(Player.get(0));
            Computer.add(Player.get(1));
            Computer.add(Player.get(2));
            Computer.add(Player.get(3));
            Computer.add(Player.get(4));
            Player.remove(0);
            Player.remove(0);
            Player.remove(0);
            Player.remove(0);
            Player.remove(0);
            return result;
        }
    }

    /*
    uses the ranks to assign points to the cards
    aces high
     */
    static int determineValue(String s) {
        int points = 1;
        if (s.contains("Ace")) {
            points = 14;
            return points;
        }
        if (s.contains("King")) {
            points = 13;
            return points;
        }
        if (s.contains("Queen")) {
            points = 12;
            return points;
        }
        if (s.contains("Jack")) {
            points = 11;
            return points;
        }
        if (s.contains("10")) {
            points = 10;
            return points;
        }
        if (s.contains("9")) {
            points = 9;
            return points;
        }

        if (s.contains("8")) {
            points = 8;
            return points;
        }
        if (s.contains("7")) {
            points = 7;
            return points;
        }
        if (s.contains("6")) {
            points = 6;
            return points;
        }
        if (s.contains("5")) {
            points = 5;
            return points;
        }
        if (s.contains("4")) {
            points = 4;
            return points;
        }
        if (s.contains("3")) {
            points = 3;
            return points;
        }
        if (s.contains("2")) {
            points = 2;
            return points;
        } else {
            return points;
        }
    }
}
