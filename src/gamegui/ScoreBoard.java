
package gamegui;

import java.io.Serializable;
/**
 * A class for keeping score during and between game sessions
 * @author TEAMBLACK, Jinhyuk L.
 */

public class ScoreBoard  implements Serializable {// so we can use it to keep a record of our scores

    private  int warPlayer; 
     int dealer;
    int player1;
     int computer; 
     int score; 
    
    public ScoreBoard(){
        warPlayer = 0;
        dealer = 0;
        player1 = 0;
        computer = 0;
   
    }
   
    

    //------------------------BlackJack Scoreboard---------------------------------------
    // adds to a running total of the player and dealer scores
    public void  addBJScoreBoard(int playerScore, int dealerScore) {

        if ((playerScore > 21 || playerScore < dealerScore) && (dealerScore < 22)) {
            dealer++;
        } else if ((dealerScore > 21 || playerScore > dealerScore) && (playerScore < 22)) {
            warPlayer++;
        }
    }

    public void setWarPlayer(int WarPlayer){
        this.warPlayer = WarPlayer;
            

    }
    public int getWarPlayer(){
        return warPlayer;
    }

    //--------------------------------War Game Scoreboard----------------------------------
    // Constructor to store score of player and computer
    public ScoreBoard(double p, double c) {
        player1 = (int) p;
        computer = (int) c;
    }

   

  
}
