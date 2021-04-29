package gamegui;


public class Deck {
String[] theDeck;
    String[] Suits = {
        "Hearts", "Diamonds", "Clubs", "Spades"
    };

    String[] Ranks = {
        "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King",
        "Ace" // Highest or lowest depending on the game
    };

    //constructor
    public Deck() {
       
    

    // initialize deck
    
        int n = Suits.length * Ranks.length;
         theDeck = new String[n];
        for (int i = 0; i < Ranks.length; i++) {
            for (int j = 0; j < Suits.length; j++) {
                theDeck[Suits.length * i + j] = Ranks[i] + " of " + Suits[j];
            }
        }
    

    // shuffle
    for (int i = 0; i< n; i++) {
        int r = i + (int) (Math.random() * (n - i));
        String temp = theDeck[r];
        theDeck[r] = theDeck[i];
        theDeck[i] = temp;
    }
    }
    
    // print for debug
    public void printDeck(){
    for (int i = 0; i< theDeck.length; i ++) {
        System.out.println(theDeck[i]);
    }
    }


}
