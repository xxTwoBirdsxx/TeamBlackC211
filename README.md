# TeamBlackC211
An end-of-term project simulating some simple card games
Names of the various team members were added to the classes they were originally assigned, though after revisions, pretty much every member had input and code into every class.
The Gui was designed with scenebuilder and Javafx, on JDK 1.8. 

The landing page has a few buttons for choosing whether to play War! or BlackJack. Below each button is the current scores for the computer and player for those respective games. 
The scores are loaded from a local .dat file that the game simulator creates when the player selects the Save and Exit button (also located on the landing page)Clicking the reset 
buttons will reset the scores to zero. 

War!
War is played by dividing a deck of cards into two equal stacks, and then taking turns flipping the top card of each stack. The winner of each of these rounds is the player with the
highest card, taking into acount the heirarchy of facecards.
Upon clicking the War! game button, the player will be prompted to choose the maximum number of card flips before the winner is determined. (The game can technically be infinite otherwise)
After choosing the max flips, the player will then move the game forward by clicking the flip button. Each round, the winner is determined by comparing the cards flipped
by either the computer or player. The winner gets both cards added to the bottom of their card stacks. In the case of a tie, four cards are skipped and the fifth is flipped, with the
winner again taking all of the cards. The game is over when either the player or the computer runs out of cards, or if the flip counter reaches zero. If the counter reaches zero, the 
player with the most cards remaining is the winner. 

BlackJack
The game of blackjack is game built around trying to get one's cards to add up to 21, without going over. At the beginning of the game, two cards are dealt to the dealer and player.
The cardsd are both face up for the player, but one of the dealer's cards will remain hidden. The player can then decide to "HIT" and receive another card, or "STAY"
 and allow the dealer's turn to begin. If the player goes over 21 during their turn, the dealer wins. If the dealer has more points than the player, the dealer wins. The dealer will 
 therefore only take more cards until they have either more points than the player, or they have gone over 21. If the dealer goes over 21, the player wins.
 In this simulator, the player will click a deal button to begin each game, and then either the HIT button get a card, or the STAY button to allow the dealer's turn to begin. 
 After a winner is determined, the player can decide to play again, or go back to the landing page.
 

