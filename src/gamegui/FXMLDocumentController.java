package gamegui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
//get our objects created

    BlackJack BJgame = new BlackJack();
    War warGame = new War();
    int FlipCount = 50; // hard limit on number of flips as game can technically be infinite otherwise..
    SaveGame game = new SaveGame();
    ScoreBoard scoreBoard = new ScoreBoard();
// describe the scene
    @FXML
    private Button playWarButton;
    @FXML
    private ImageView right1;
    @FXML
    private ImageView left1;
    @FXML
    private ImageView left2;
    @FXML
    private ImageView right2;
    @FXML
    private Button FlipCard;
    @FXML
    private Label playerTag;
    @FXML
    private Label computerTag;
    @FXML
    private Label playerCards;
    @FXML
    private Label computerCards;
    @FXML
    private Button PlayBJButton;
    @FXML
    private Label Pwins;
    @FXML
    private Label Cwins;
    @FXML
    private Button tieButton;
    @FXML
    private Label tieText;
    @FXML
    private Label gameOver;
    @FXML
    private Label winLose;
    @FXML
    private Label PWarWins;
    @FXML
    private Label CWarWins;
    @FXML
    private Button Back;
    @FXML
    private Button Save;
    @FXML
    private Button WarReset;
    @FXML
    private Button BJReset;
    @FXML
    private Label BJPWins;
    @FXML
    private Label BJDWins;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Pane BJPane;
    @FXML
    private Button HIT;
    @FXML
    private Button STAY;
    @FXML
    private ImageView BJTopLeft;
    @FXML
    private ImageView BJTopMid;
    @FXML
    private ImageView BJTopRight;
    @FXML
    private ImageView BJCenterLeft;
    @FXML
    private ImageView BJCenterMid;
    @FXML
    private ImageView BJCenterRight;
    @FXML
    private ImageView BJBottomLeft;
    @FXML
    private ImageView BJBottomMid;
    @FXML
    private ImageView BJBottomRight;
    @FXML
    private ImageView BJDTopRight;
    @FXML
    private ImageView BJDTopMid;
    @FXML
    private ImageView BJDTopLeft;
    @FXML
    private ImageView BJDCenterRight;
    @FXML
    private ImageView BJDCenterMid;
    @FXML
    private ImageView BJDCenterLeft;
    @FXML
    private ImageView BJDBottomRight;
    @FXML
    private ImageView BJDBottomMid;
    @FXML
    private ImageView BJDBottomLeft;
    @FXML
    private Label BJPlayerTotal;
    @FXML
    private Label BJPlayerBust;
    @FXML
    private Label BJPlayerWins;
    @FXML
    private Label BJDealerWins;
    @FXML
    private Label BJDealerTotal;
    @FXML
    private Label BJDealerBust;
    @FXML
    private Button BJBack;
    @FXML
    private Button BJPlayAgain;
    @FXML
    private ImageView BJDeck;
    @FXML
    private Button BJDealCards;
    @FXML
    private Text choicePrompt;
    @FXML
    private Button fiftyFlip;
    @FXML
    private Button hundredFlips;
    @FXML
    private Button fliptwoHund;
    @FXML
    private Text teamBlack;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (game.getScoreBoard() != null) {
            scoreBoard = game.getScoreBoard();
        }
        PWarWins.setText("Player wins: " + scoreBoard.getWarPlayer());
        CWarWins.setText("Computer wins:  " + scoreBoard.computer);
        BJDWins.setText("Dealer Wins: " + scoreBoard.dealer);
        BJPWins.setText("Player Wins: " + scoreBoard.player1);

    }

    @FXML //player selects war game.. war game features  become visible
    private void handlePlayWarButton(ActionEvent event) {
        warGame = new War();
        teamBlack.setVisible(false);
        choicePrompt.setVisible(true);
        fiftyFlip.setVisible(true);
        hundredFlips.setVisible(true);
        fliptwoHund.setVisible(true);
        anchorPane.setStyle("-fx-background-color: green");
        computerCards.setText(Integer.toString(warGame.Computer.size()));
        playerCards.setText(Integer.toString(warGame.Player.size()));
        Save.setVisible(false);
        WarReset.setVisible(false);
        BJReset.setVisible(false);
        BJPWins.setVisible(false);
        BJDWins.setVisible(false);

        Back.setVisible(false);
        PWarWins.setVisible(false);
        CWarWins.setVisible(false);
        computerCards.setVisible(true);
        playerCards.setVisible(true);
        PlayBJButton.setVisible(false);
        left1.setVisible(true);
        right1.setVisible(true);
        playWarButton.setVisible(false);
        playerTag.setVisible(true);
        computerTag.setVisible(true);

    }

    @FXML
    private void handleFlipCard(ActionEvent event) {

        FlipCount--;// increment the counter down
        FlipCard.setText("Flip: " + Integer.toString(FlipCount));
        if (FlipCount == 0) {//if the counter has reached zero, the game is over
            gameOver.setVisible(true);
            FlipCard.setVisible(false);
            Pwins.setVisible(false);
            Cwins.setVisible(false);
            if (warGame.Player.size() < warGame.Computer.size()) {
                winLose.setText("You Lose.");
                scoreBoard.computer++;
                Pwins.setVisible(false);
                Cwins.setVisible(false);
            } else {
                scoreBoard.setWarPlayer(scoreBoard.getWarPlayer() + 1);
                Pwins.setVisible(false);
                Cwins.setVisible(false);
            }
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(1.5), ae -> winLose.setVisible(true)));
            timeline.play();
            Back.setVisible(true);
            Pwins.setVisible(false);
            Cwins.setVisible(false);
            return;

        }

        if (!warGame.Player.isEmpty()) {
            Image leftImage = new Image("cards/" + warGame.Player.get(0) + ".png");
            left2.setImage(leftImage);
            left2.setVisible(true);
        } else {
            left2.setVisible(false);
            left1.setVisible(false);
        }

        if (!warGame.Computer.isEmpty()) {
            Image rightImage = new Image("cards/" + warGame.Computer.get(0) + ".png");
            right2.setImage(rightImage);
            right2.setVisible(true);
        } else {
            right2.setVisible(false);
            right1.setVisible(false);
        }
        if (warGame.Player.isEmpty()) {
            gameOver.setVisible(true);
            FlipCard.setVisible(false);
            left1.setVisible(false);
            left2.setVisible(false);
            winLose.setText("You Lose.");
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(1.5), ae -> winLose.setVisible(true)));
            timeline.play();
            scoreBoard.computer++;
            return;
        }
        if (warGame.Computer.isEmpty()) {
            gameOver.setVisible(true);
            FlipCard.setVisible(false);
            right1.setVisible(false);
            right2.setVisible(false);
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(1.5), ae -> winLose.setVisible(true)));
            timeline.play();
            scoreBoard.setWarPlayer(scoreBoard.getWarPlayer() + 1);
            return;
        }

        String result = warGame.play();

        Pwins.setVisible(false);
        Cwins.setVisible(false);

        if (result.equals("Computer has Won")) {
            Back.setVisible(true);
            gameOver.setVisible(true);
            FlipCard.setVisible(false);
            scoreBoard.computer++;

        }
        if (result.equals("Player has Won")) {
            Back.setVisible(true);
            gameOver.setVisible(true);
            FlipCard.setVisible(false);
            scoreBoard.setWarPlayer(scoreBoard.getWarPlayer() + 1);
        }

        if (result.equals("PLAYER WINS!")) {
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(.5), ae -> Pwins.setVisible(true)));
            timeline.play();
            computerCards.setText(Integer.toString(warGame.Computer.size()));
            playerCards.setText(Integer.toString(warGame.Player.size()));
            if (warGame.Computer.isEmpty()) {
                gameOver.setVisible(true);
                FlipCard.setVisible(false);
                return;
            }

        }
        if (result.equals("COMPUTER WINS!")) {
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(.5), ae -> Cwins.setVisible(true)));
            timeline.play();
            computerCards.setText(Integer.toString(warGame.Computer.size()));
            playerCards.setText(Integer.toString(warGame.Player.size()));
            if (warGame.Player.size() == 0) {
                gameOver.setVisible(true);
                FlipCard.setVisible(false);
                return;
            }
        }
        if (result.equals("A Tie")) {
            FlipCard.setVisible(false);
            Pwins.setVisible(false);
            Cwins.setVisible(false);

            if (warGame.Player.size() < 5 || warGame.Computer.size() < 5) {
                gameOver.setVisible(true);
                tieText.setText(".. Not enough cards for WAR");
                tieText.setVisible(true);
                Pwins.setVisible(false);
                Cwins.setVisible(false);
                if (warGame.Player.size() < warGame.Computer.size()) {
                    winLose.setText("You Lose.");
                }
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.seconds(1.5), ae -> winLose.setVisible(true)));
                timeline.play();
                scoreBoard.computer++;
                Back.setVisible(true);
                return;
            }
            tieButton.setVisible(true);
            tieText.setVisible(true);
        }

    }

    @FXML
    private void handleTie(ActionEvent event) {
        tieButton.setVisible(false);
        tieText.setVisible(false);
        FlipCard.setVisible(true);
        Image leftImage = new Image("cards/" + warGame.Player.get(4) + ".png");
        left2.setImage(leftImage);
        Image rightImage = new Image("cards/" + warGame.Computer.get(4) + ".png");
        right2.setImage(rightImage);
        String result = warGame.resolveTie();

        if (result.equals("PLAYER WINS!")) {
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(.5), ae -> Pwins.setVisible(true)));
            timeline.play();
            computerCards.setText(Integer.toString(warGame.Computer.size()));
            playerCards.setText(Integer.toString(warGame.Player.size()));

        }
        if (result.equals("Computer Wins!")) {
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(.5), ae -> Cwins.setVisible(true)));
            timeline.play();
            computerCards.setText(Integer.toString(warGame.Computer.size()));
            playerCards.setText(Integer.toString(warGame.Player.size()));

        }

    }

    @FXML
    private void handleBack(ActionEvent event) {
        teamBlack.setVisible(true);
        BJPane.setVisible(false);
        anchorPane.setStyle("-fx-background-color: #F2F2F2");
        Save.setVisible(true);
        WarReset.setVisible(true);
        BJReset.setVisible(true);
        BJPWins.setVisible(true);
        BJDWins.setVisible(true);
        Back.setVisible(false);
        left1.setVisible(false);
        left2.setVisible(false);
        right1.setVisible(false);
        right2.setVisible(false);
        gameOver.setVisible(false);
        winLose.setVisible(false);
        PWarWins.setText("Player wins: " + scoreBoard.getWarPlayer());
        CWarWins.setText("Computer wins:  " + scoreBoard.computer);
        BJPWins.setText("Player wins: " + scoreBoard.player1);
        BJDWins.setText("Dealer wins: " + scoreBoard.dealer);
        PWarWins.setVisible(true);
        CWarWins.setVisible(true);
        playWarButton.setVisible(true);
        PlayBJButton.setVisible(true);
        playerTag.setVisible(false);
        computerTag.setVisible(false);
        computerCards.setVisible(false);
        playerCards.setVisible(false);
        Pwins.setVisible(false);
        Cwins.setVisible(false);
    }

    @FXML
    private void handleSave(ActionEvent event) {

        game.ScoreBoard = scoreBoard;
        game.saveScoreBoard();
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    private void handleWarReset(ActionEvent event) {
        scoreBoard.setWarPlayer(0);
        scoreBoard.computer = 0;
        PWarWins.setText("Player wins: " + scoreBoard.getWarPlayer());
        CWarWins.setText("Computer wins:  " + scoreBoard.computer);
    }

    @FXML
    private void handleBJReset(ActionEvent event) {
        scoreBoard.dealer = 0;
        scoreBoard.player1 = 0;
        BJDWins.setText("Player wins: " + scoreBoard.dealer);
        BJPWins.setText("Player wins: " + scoreBoard.player1);
    }

    @FXML
    private void handleHit(ActionEvent event) {
        int aceCount = 0;
        //player's next card
        if (BJgame.playerCardCount == 2) {
            String Pcard2 = BJgame.playerDistribution();
            if (Pcard2.contains("Ace")) {
                aceCount++;
            }
            Image PImage = new Image("cards/" + Pcard2 + ".png");
            BJTopRight.setImage(PImage);
            BJTopRight.setVisible(true);
            if (BJgame.playerTotal > 21 && aceCount > 0) {
                BJgame.playerTotal = BJgame.playerTotal - (aceCount * 10);

                aceCount--;
            }

        } else if (BJgame.playerCardCount == 3) {
            String Pcard3 = BJgame.playerDistribution();
            if (Pcard3.contains("Ace")) {
                aceCount++;
            }
            Image PImage3 = new Image("cards/" + Pcard3 + ".png");
            BJCenterLeft.setImage(PImage3);
            BJCenterLeft.setVisible(true);
            if (BJgame.playerTotal > 21 && aceCount > 0) {
                BJgame.playerTotal = BJgame.playerTotal - (aceCount * 10);

                aceCount--;
            }

        } else if (BJgame.playerCardCount == 4) {
            String Pcard4 = BJgame.playerDistribution();
            if (Pcard4.contains("Ace")) {
                aceCount++;
            }
            Image PImage4 = new Image("cards/" + Pcard4 + ".png");
            BJCenterMid.setImage(PImage4);
            BJCenterMid.setVisible(true);
            if (BJgame.playerTotal > 21 && aceCount > 0) {
                BJgame.playerTotal = BJgame.playerTotal - (aceCount * 10);

                aceCount--;
            }

        } else if (BJgame.playerCardCount == 5) {
            String Pcard5 = BJgame.playerDistribution();
            if (Pcard5.contains("Ace")) {
                aceCount++;
            }
            Image PImage5 = new Image("cards/" + Pcard5 + ".png");
            BJCenterRight.setImage(PImage5);
            BJCenterRight.setVisible(true);
            if (BJgame.playerTotal > 21 && aceCount > 0) {
                BJgame.playerTotal = BJgame.playerTotal - (aceCount * 10);

                aceCount--;
            }

        } else if (BJgame.playerCardCount == 6) {
            String Pcard6 = BJgame.playerDistribution();
            if (Pcard6.contains("Ace")) {
                aceCount++;
            }
            Image PImage6 = new Image("cards/" + Pcard6 + ".png");
            BJBottomLeft.setImage(PImage6);
            BJBottomLeft.setVisible(true);
            if (BJgame.playerTotal > 21 && aceCount > 0) {
                BJgame.playerTotal = BJgame.playerTotal - (aceCount * 10);

                aceCount--;
            }

        } else if (BJgame.playerCardCount == 7) {
            String Pcard7 = BJgame.playerDistribution();
            if (Pcard7.contains("Ace")) {
                aceCount++;
            }
            Image PImage7 = new Image("cards/" + Pcard7 + ".png");
            BJBottomMid.setImage(PImage7);
            BJBottomMid.setVisible(true);
            if (BJgame.playerTotal > 21 && aceCount > 0) {
                BJgame.playerTotal = BJgame.playerTotal - (aceCount * 10);

                aceCount--;
            }

        } else if (BJgame.playerCardCount == 8) {
            String Pcard8 = BJgame.playerDistribution();
            if (Pcard8.contains("Ace")) {
                aceCount++;
            }
            Image PImage8 = new Image("cards/" + Pcard8 + ".png");
            BJBottomRight.setImage(PImage8);
            BJBottomRight.setVisible(true);
            if (BJgame.playerTotal > 21 && aceCount > 0) {
                BJgame.playerTotal = BJgame.playerTotal - (aceCount * 10);
                aceCount--;
            }

        }

        if (BJgame.playerTotal > 21) {
            BJPlayerBust.setVisible(true);
            HIT.setVisible(false);
            STAY.setVisible(false);
            BJBack.setVisible(true);
            BJPlayAgain.setVisible(true);
            BJDealerWins.setVisible(true);
            BJPlayerTotal.setText("Player has: " + BJgame.playerTotal);

            scoreBoard.dealer++;

        } else {
            BJPlayerTotal.setText("Player has: " + BJgame.playerTotal);
        }

    }

    @FXML
    private void handleStay(ActionEvent event) {
        int dealerCount = 0;
        int aceCount = 0;
        if (BJgame.D.theDeck[3].contains("Ace")) {
            aceCount = 1;
        }
        boolean keepDealing = true;
        //set up the next few cards in the deck
        while (keepDealing) {

            if (dealerCount == 0) {
                String Dcard2 = BJgame.D.theDeck[1];
                if (Dcard2.contains("Ace")) {
                    aceCount++;
                }
                Image PImage2 = new Image("cards/" + Dcard2 + ".png");
                BJDTopRight.setImage(PImage2);
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.seconds(.5), ae -> BJDTopRight.setVisible(true)));
                timeline.play();
                dealerCount++;
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                if (BJgame.dealerTotal > 21 || BJgame.dealerTotal > BJgame.playerTotal) {
                    keepDealing = false;
                }

            } else if (dealerCount == 1) {
                String Dcard3 = BJgame.dealerDistribution();
                if (Dcard3.contains("Ace")) {
                    aceCount++;
                }
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                Image PImage3 = new Image("cards/" + Dcard3 + ".png");
                BJDTopLeft.setImage(PImage3);
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.seconds(.5), ae -> BJDTopLeft.setVisible(true)));
                timeline.play();
                dealerCount++;
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                if (BJgame.dealerTotal > 21 || BJgame.dealerTotal > BJgame.playerTotal) {
                    keepDealing = false;
                }
            } else if (dealerCount == 2) {
                String Dcard4 = BJgame.dealerDistribution();
                if (Dcard4.contains("Ace")) {
                    aceCount++;
                }
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                Image PImage4 = new Image("cards/" + Dcard4 + ".png");
                BJDCenterRight.setImage(PImage4);
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.seconds(.5), ae -> BJDCenterRight.setVisible(true)));
                timeline.play();
                dealerCount++;
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                if (BJgame.dealerTotal > 21 || BJgame.dealerTotal > BJgame.playerTotal) {
                    keepDealing = false;
                }
            } else if (dealerCount == 3) {
                String Dcard5 = BJgame.dealerDistribution();
                if (Dcard5.contains("Ace")) {
                    aceCount++;
                }
                Image PImage5 = new Image("cards/" + Dcard5 + ".png");
                BJDCenterMid.setImage(PImage5);
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.seconds(.5), ae -> BJDCenterMid.setVisible(true)));
                timeline.play();
                dealerCount++;
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                if (BJgame.dealerTotal > 21 || BJgame.dealerTotal > BJgame.playerTotal) {
                    keepDealing = false;
                }
            } else if (dealerCount == 4) {
                String Dcard6 = BJgame.dealerDistribution();
                if (Dcard6.contains("Ace")) {
                    aceCount++;
                }
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                Image PImage6 = new Image("cards/" + Dcard6 + ".png");
                BJDCenterLeft.setImage(PImage6);
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.seconds(.5), ae -> BJDCenterLeft.setVisible(true)));
                timeline.play();
                dealerCount++;
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                if (BJgame.dealerTotal > 21 || BJgame.dealerTotal > BJgame.playerTotal) {
                    keepDealing = false;
                }
            } else if (dealerCount == 5) {
                String Dcard7 = BJgame.dealerDistribution();
                if (Dcard7.contains("Ace")) {
                    aceCount++;
                }
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                Image PImage7 = new Image("cards/" + Dcard7 + ".png");
                BJDBottomRight.setImage(PImage7);
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.seconds(.5), ae -> BJDBottomRight.setVisible(true)));
                timeline.play();
                dealerCount++;
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                if (BJgame.dealerTotal > 21 || BJgame.dealerTotal > BJgame.playerTotal) {
                    keepDealing = false;
                }
            } else if (dealerCount == 6) {
                String Dcard8 = BJgame.dealerDistribution();
                if (Dcard8.contains("Ace")) {
                    aceCount++;
                }
                Image PImage8 = new Image("cards/" + Dcard8 + ".png");
                BJDBottomMid.setImage(PImage8);
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.seconds(.5), ae -> BJDBottomMid.setVisible(true)));
                timeline.play();
                dealerCount++;
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                if (BJgame.dealerTotal > 21 || BJgame.dealerTotal > BJgame.playerTotal) {
                    keepDealing = false;
                }
            } else if (dealerCount == 7) {
                String Dcard9 = BJgame.dealerDistribution();
                if (Dcard9.contains("Ace")) {
                    aceCount++;
                }
                Image PImage9 = new Image("cards/" + Dcard9 + ".png");
                BJDBottomLeft.setImage(PImage9);
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.seconds(.5), ae -> BJDBottomLeft.setVisible(true)));
                timeline.play();
                dealerCount++;
                if (BJgame.dealerTotal > 21 && aceCount > 0) {
                    BJgame.dealerTotal = BJgame.dealerTotal - (aceCount * 10);
                    aceCount--;
                }
                if (BJgame.dealerTotal > 21 || BJgame.dealerTotal > BJgame.playerTotal) {
                    keepDealing = false;
                }
            }
            BJDealerTotal.setText("Dealer has: " + BJgame.dealerTotal);
        }
        if (BJgame.dealerTotal > 21) {
            BJDealerBust.setVisible(true);
            HIT.setVisible(false);
            STAY.setVisible(false);
            BJBack.setVisible(true);
            BJPlayAgain.setVisible(true);
            BJPlayerWins.setVisible(true);

            scoreBoard.player1++;
        } else {

            HIT.setVisible(false);
            STAY.setVisible(false);
            BJBack.setVisible(true);
            BJPlayAgain.setVisible(true);
            BJDealerWins.setVisible(true);

            scoreBoard.dealer++;
        }

    }

    @FXML
    private void handlePlayBJ(ActionEvent event) {
        // set the scene...
        teamBlack.setVisible(false);
        BJDealCards.setVisible(true);
        BJPane.setVisible(true);
        WarReset.setVisible(false);
        BJReset.setVisible(false);
        BJPWins.setVisible(false);
        BJDWins.setVisible(false);
        PlayBJButton.setVisible(false);
        playWarButton.setVisible(false);
        Save.setVisible(false);
        BJBack.setVisible(false);
        BJPlayAgain.setVisible(false);
        BJPlayerBust.setVisible(false);
        BJDealerBust.setVisible(false);
        BJTopLeft.setVisible(false);
        BJTopMid.setVisible(false);
        BJTopRight.setVisible(false);
        BJCenterLeft.setVisible(false);
        BJCenterMid.setVisible(false);
        BJCenterRight.setVisible(false);
        BJBottomLeft.setVisible(false);
        BJBottomRight.setVisible(false);
        BJBottomMid.setVisible(false);
        BJDTopLeft.setVisible(false);
        BJDTopMid.setVisible(false);
        BJDTopRight.setVisible(false);
        BJDCenterRight.setVisible(false);
        BJDCenterMid.setVisible(false);
        BJDCenterLeft.setVisible(false);
        BJDBottomRight.setVisible(false);
        BJDBottomMid.setVisible(false);
        BJDBottomLeft.setVisible(false);

        BJPlayerWins.setVisible(false);
        BJDealerWins.setVisible(false);
        BJPlayerTotal.setVisible(false);
        BJDealerTotal.setVisible(false);

        HIT.setVisible(false);
        STAY.setVisible(false);
        // create a Black Jack game
        BJgame = new BlackJack();
    }

    @FXML
    private void handleBJDeal(ActionEvent event) {
        BJDealCards.setVisible(false);
        //player's first card
        String Pcard1 = BJgame.playerDistribution();
        Image PImage = new Image("cards/" + Pcard1 + ".png");
        BJTopLeft.setImage(PImage);

//dealer's first card ( not actually displayed yet, just displaying a temp card-back image)
        String Dcard1 = BJgame.dealerDistribution();
        Image DImage = new Image("cards/back.png");
        BJDTopRight.setImage(DImage);

        //player's second card
        String Pcard2 = BJgame.playerDistribution();
        Image P2Image = new Image("cards/" + Pcard2 + ".png");
        BJTopMid.setImage(P2Image);

        //dealer's second card
        String Dcard2 = BJgame.dealerDistribution();

        Image D2Image = new Image("cards/" + Dcard2 + ".png");
        BJDTopMid.setImage(D2Image);
        //calculate totals
        BJDealerTotal.setText("Dealer has: " + (BJgame.dealerTotal - BJgame.determineValue(Dcard1)));
        BJPlayerTotal.setText("Player has: " + BJgame.playerTotal);

        //animate the displaying of the three cards and BlackJack Buttons
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(.5), ae -> BJTopLeft.setVisible(true)),
                new KeyFrame(Duration.seconds(.7), ae -> BJDTopRight.setVisible(true)),
                new KeyFrame(Duration.seconds(1), ae -> BJTopMid.setVisible(true)),
                new KeyFrame(Duration.seconds(1.3), ae -> BJDTopMid.setVisible(true)),
                new KeyFrame(Duration.seconds(1.5), ae -> HIT.setVisible(true)),
                new KeyFrame(Duration.seconds(1.5), ae -> STAY.setVisible(true)),
                new KeyFrame(Duration.seconds(1.6), ae -> BJPlayerTotal.setVisible(true)),
                new KeyFrame(Duration.seconds(1.6), ae -> BJDealerTotal.setVisible(true)));

        timeline.play();
    }

    @FXML
    private void handleFifty(ActionEvent event) {
        FlipCount = 50;
        fliptwoHund.setVisible(false);
        fiftyFlip.setVisible(false);
        hundredFlips.setVisible(false);
        choicePrompt.setVisible(false);
        FlipCard.setText("Flips:" + FlipCount);
        FlipCard.setVisible(true);

    }

    @FXML
    private void handleHundred(ActionEvent event) {
        FlipCount = 100;
        fliptwoHund.setVisible(false);
        fiftyFlip.setVisible(false);
        hundredFlips.setVisible(false);
        choicePrompt.setVisible(false);
        FlipCard.setText("Flips:" + FlipCount);
        FlipCard.setVisible(true);
    }

    @FXML
    private void handleTwoHund(ActionEvent event) {
        FlipCount = 200;
        fliptwoHund.setVisible(false);
        fiftyFlip.setVisible(false);
        hundredFlips.setVisible(false);
        choicePrompt.setVisible(false);
        FlipCard.setText("Flips:" + FlipCount);
        FlipCard.setVisible(true);
    }

}
