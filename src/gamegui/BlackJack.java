package gamegui;
/**
 * A class for simulating a game of Black Jack.
 * @author TEAM BLACK, Blake J.
 */
public class BlackJack {

    public static Deck D;

    public static int playerCardCount; // the number of cards player has drawn
    public static int dealerCardCount; // the number of cards dealer has drawn
    public static int playerTotal; //the total points for the cards dealt to player
    public static int dealerTotal;//the total points fot the cards dealt to the dealer

    public BlackJack() {//constructor for BlackJack Class
        D = new Deck();//creates a new, shuffled deck.
        playerTotal = 0;//no cards yet
        dealerTotal = 0; // no cards yet
        playerCardCount = 0; // no cards dealt yet
        dealerCardCount = 0; // no cards dealt yet
    }

    /*
    * method for dealing cards to the player
     */
    public static String playerDistribution() {
        int cardsDealt = playerCardCount + dealerCardCount;//determine where we are in the deck
        String playerCard = D.theDeck[cardsDealt];// find the string representing the next card
        playerCardCount++;//increment the player card counter
        playerTotal = playerTotal + determineValue(playerCard);
        return playerCard;//return the card (as a String)
    }

    public static String dealerDistribution() {
        int cardsDealt = playerCardCount + dealerCardCount;//determine where we are in the deck
        String dealerCard = D.theDeck[cardsDealt];// find the string representing the next card
        dealerCardCount++;//increment the player card counter
        dealerTotal = dealerTotal + determineValue(dealerCard);
        return dealerCard;//return the card (as a String)
    }

    /*
    uses the ranks to assign points to the cards
    
     */
    static int determineValue(String s) {//s here being the String representing a card
        int points = 1;
        if (s.contains("Ace")) {
            points = 11;// Aces are special and can require player input, but are initialized to 11
            return points;
        }
        if (s.contains("King")) {
            points = 10;
            return points;
        }
        if (s.contains("Queen")) {
            points = 10;
            return points;
        }
        if (s.contains("Jack")) {
            points = 10;
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
