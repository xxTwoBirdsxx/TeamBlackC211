
package gamegui;

  import java.io.*;
/**
 * A class for storing and retrieving game session scores
 * @author TEAM BLACK, Jinhyuk L.
 */
public class SaveGame {
  final String FILENAME = "Score_Board.dat";
File f = new File(FILENAME);

ScoreBoard ScoreBoard;// a scoreboard for saving session scores into.

public SaveGame(){
    ScoreBoard = new ScoreBoard();
}

public SaveGame(ScoreBoard scoreboard){
    this.ScoreBoard = scoreboard;
}



public void saveScoreBoard() {
        try {
            //create a file in the java folder and save the scoreboard into it.
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(ScoreBoard);
            out.close();
        } catch (Exception e) {
            System.out.println("Unable to save accounts information");
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }

   public ScoreBoard getScoreBoard() {

        if (f.exists()) {
            try {//look for the file with the scoreboard
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));

               ScoreBoard = (ScoreBoard) in.readObject(); // requires casting

                in.close();
            } catch (Exception e) {
                System.out.println("Error occurred during reading the file");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return ScoreBoard;
    }
   
   public void resetScores(){
       ScoreBoard = new ScoreBoard();
   }
}
