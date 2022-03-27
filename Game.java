import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.ToDoubleBiFunction;

public class Game {
  private int currentPlayer;
  private String [] playerIDs;

  private UnoDeck deck;
  private ArrayList<ArrayList<UnoCards>> playerHand;
  private ArrayList<UnoCards> stockpile;

  private UnoCards.Color validColor;
  private UnoCards.Value validValue;

  boolean gameDirection;

  public Game(String[] pids){
    deck = new UnoDeck();
    //deck.shuffle(); call shuffle function here
    stockpile = new ArrayList<UnoCards>();

    playerIDs = pids;
    currentPlayer = 0;
    gameDirection = false;

    playerHand = new ArrayList<ArrayList<UnoCards>>();

    for (int i = 0; i < pids.length; ++i){
      ArrayList<UnoCards> hand = new ArrayList<UnoCards>(Arrays.asList(deck.drawCard(7)));
      playerHand.add(hand);
    }
  }

  public void start (Game game){
    UnoCards card = deck.drawCard();
    validColor = card.getColor();
    validValue = card.getValue();

    if (card.getValue() == UnoCards.Value.WILD){
      start(game);
    }

    if (card.getValue() == UnoCards.Value.WILD_FOUR || card.getValue() == UnoCards.Value.DRAW_TWO){
      start(game);
    }

    if (card.getValue() == UnoCards.Value.SKIP){
      if (gameDirection == false){
        currentPlayer = (currentPlayer + 1) % playerIDs.length;
      }
      else if (gameDirection == true) {
        currentPlayer = (currentPlayer - 1) % playerIDs.length;
        if (currentPlayer == -1){
          currentPlayer = playerIDs.length -1;
        }
      }
    }

    if (card.getValue() == UnoCards.Value.REVERSE){
      gameDirection ^= true; //if its true its gonna be false, if its false its gonna be true
      currentPlayer = playerIDs.length -1;
    }

    stockpile.add(card);
  }

  public UnoCards getTopCard(){
    return new UnoCards(validColor,validValue);
  }

  public boolean isGameOver(){
    for (String player: this.playerIDs){
      if (hasEmptyHand(player)){
        return true;
      }
    }
    return false;
  }

  public String getCurrentPlayer(){
    return this.playerIDs[this.currentPlayer];
  }

  public String getPreviousPlayer(int i){
    int index = this.currentPlayer - i;
    if (index == -1){
      index = playerIDs.length -1;
    }
    return this.playerIDs[index];
  }

  public String [] getPlayers(){
    return playerIDs;
  }

  public ArrayList<UnoCards> getPlayerHand (String pid){
    int index = Arrays.asList(playerIDs).indexOf(pid);
    return playerHand.get(index);
  }

  public int getPlayerHandSize (String pid){
    return getPlayerHand(pid).size();
  }

  public UnoCards getPlayerCard (String pid, int choice){
    ArrayList<UnoCards> hand = getPlayerHand(pid);
    return hand.get(choice);
  }

  public boolean hasEmptyHand (String pid){
    return getPlayerHand(pid).isEmpty();
  }

  public boolean validCardPlayer(UnoCards card){
    return card.getColor() == validColor || card.getValue() == validValue;
  }

  public void checkPlayerTurn(String pid) throws IllegalArgumentException{ //replace with InvalidPlayerTurnException
    if (this.playerIDs[this.currentPlayer] != pid){
      throw new IllegalArgumentException("It is not this player's turn");
    }
  }

  public void submitDraw(String pid) throws IllegalArgumentException{
    checkPlayerTurn(pid);

    //if (deck.isEmpty()){
    //  deck.replaceDeckWith(stockpile); - functions made in pt UnoDeck
    // deck.shuffle();
    //}

    getPlayerHand(pid).add(deck.drawCard());
    if (gameDirection == false){
      currentPlayer = (currentPlayer + 1) % playerIDs.length;
    }

    else if (gameDirection == true){
      currentPlayer = (currentPlayer -1) % playerIDs.length;
      if (currentPlayer == -1){
        currentPlayer = playerIDs.length -1;
      }
    }
  }

  public void setCardColor ( UnoCards.Color color){
    validColor = color;
  }

  public void submitPlayerCard (String pid, UnoCards card, UnoCards.Color declaredColor) throws
    InvalidColorSubmissionException, InvalidPlayerTurnException, InvalidValueSubmissionException{

    checkPlayerTurn(pid);

    ArrayList<UnoCards> pHand = getPlayerHand(pid);

    if (!validCardPlayer((card))){
      if (card.getColor() == UnoCards.Color.WILD){
        validColor = card.getColor();
        validValue = card.getValue();
      }

      if (card.getColor() != validColor){
        throw new IllegalArgumentException("Error"); // here goes InvalidColorSubmissionException
      }

      else if (card.getValue() != validValue){
        throw new IllegalArgumentException("Error"); // here goes InvalidColorSubmissionException
      }
    }

    pHand.remove(card);

    if (hasEmptyHand(this.playerIDs[currentPlayer])){
      System.exit(0); //player won game
    }

    validColor = card.getColor();
    validValue = card.getValue();
    stockpile.add(card);

    if (gameDirection == false){
      currentPlayer = (currentPlayer + 1) % playerIDs.length;
    }
    else if (gameDirection == true){
      currentPlayer = (currentPlayer -1) % playerIDs.length;
      if (currentPlayer == -1){
        currentPlayer = playerIDs.length -1;
      }
    }

    if (card.getColor() == UnoCards.Color.WILD){
      validColor = declaredColor;
    }

    if (card.getValue() == UnoCards.Value.DRAW_TWO){
      pid = playerIDs[currentPlayer];
      getPlayerHand(pid).add(deck.drawCard());
      getPlayerHand(pid).add(deck.drawCard());
    }
    if (card.getValue() == UnoCards.Value.WILD_FOUR){
      pid = playerIDs[currentPlayer];
      getPlayerHand(pid).add(deck.drawCard());
      getPlayerHand(pid).add(deck.drawCard());
      getPlayerHand(pid).add(deck.drawCard());
      getPlayerHand(pid).add(deck.drawCard());
    }

    if (card.getValue() == UnoCards.Value.SKIP){
      if (gameDirection == false){
        currentPlayer = (currentPlayer + 1) % playerIDs.length;
      }

      else if (gameDirection == true){
        currentPlayer = (currentPlayer -1) % playerIDs.length;
        if (currentPlayer == -1) {
          currentPlayer = playerIDs.length -1;
        }
      }
    }

    if (card.getValue() == UnoCards.Value.REVERSE){
      gameDirection ^= true;
      if (gameDirection == true){
        currentPlayer = (currentPlayer -2 ) % playerIDs.length;
        if (currentPlayer == -1){
          currentPlayer = playerIDs.length -1;
        }

        if (currentPlayer == -2){
          currentPlayer = playerIDs.length -2;
        }
      }

      else if (gameDirection == false){
        currentPlayer = (currentPlayer + 2) % playerIDs.length;
      }
    }
  }

}

class InvalidPlayerTurnException extends Exception{
  String playerID;

  public InvalidPlayerTurnException(String message, String pid){
    super(message);
    playerID = pid;
  }

  public String getPid(){
    return playerID;
  }
}

class InvalidColorSubmissionException extends Exception{
  private UnoCards.Color expected;
  private UnoCards.Color actual;

  public InvalidColorSubmissionException(String message, UnoCards.Color actual, UnoCards.Color expected){
    this.actual = actual;
    this.expected = expected;
  }
}

class InvalidValueSubmissionException extends Exception{
  private UnoCards.Value expected;
  private UnoCards.Value actual;

  public InvalidValueSubmissionException(String message, UnoCards.Value actual, UnoCards.Value expected){
    this.actual = actual;
    this.expected = expected;
  }
}



