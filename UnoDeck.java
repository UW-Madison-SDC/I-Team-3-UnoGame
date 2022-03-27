//Dealing cards
//+2, +4
//Wild card function
//command 1

public class UnoDeck {

  private UnoCards[] deck;
  private int numCardsInDeck;

  public UnoDeck() {
    deck = new UnoCards[108];
  }

  /**
   * builds deck, keeps track of number of cards created
   */
  public void buildDeck() {
    //this array filled with enumeration values of red,green,blue,yellow,wild
    UnoCards.Color[] colors = UnoCards.Color.values();
    numCardsInDeck = 0;

    //One loop for red, one loop for blue, one loop for green, one loop for yellow, one loop for wild
    for (int i = 0; i < colors.length - 1; ++i) {
      //assign color data field with current color in colors array (starts with red, then blue, then green)
      UnoCards.Color color = colors[i];
      deck[numCardsInDeck++] = new UnoCards(color, UnoCards.Value.getValue(
        0)); //Creates 0 card once (there are only four 0 cards in a Uno deck).

      for (int j = 1; j < 10; j++) {
        deck[numCardsInDeck++] =
          new UnoCards(color, UnoCards.Value.getValue(j)); //creates 0-9 cards, twice
        deck[numCardsInDeck++] = new UnoCards(color, UnoCards.Value.getValue(j));
      }

      UnoCards.Value[] values =
        new UnoCards.Value[] {UnoCards.Value.DRAW_TWO, UnoCards.Value.SKIP, UnoCards.Value.REVERSE};
      for (UnoCards.Value value : values) {
        deck[numCardsInDeck++] = new UnoCards(color, value);//creates special cards, twice
        deck[numCardsInDeck++] = new UnoCards(color, value);
      }
    } //loop finishes

    UnoCards.Value[] values = new UnoCards.Value[] {UnoCards.Value.WILD, UnoCards.Value.WILD_FOUR};
    for (UnoCards.Value value : values) {
      for (int i = 0; i < 4; i++) {
        deck[numCardsInDeck++] =
          new UnoCards(UnoCards.Color.WILD, value);// create 4 wild, and 4 wild_four cards
      }
    }
  }

  public UnoCards drawCard() throws IllegalArgumentException {
    if (deck.length == 0) { //may be problematic. Checking correct deck?
      throw new IllegalArgumentException("Cannot draw, there are no cards in the deck");
    }
    return deck[--numCardsInDeck];
  }


  public UnoCards[] drawCard (int a){ //plusTwoPlusFour
    if (a < 0){
      throw new IllegalArgumentException("Must draw positive cards, but tried to draw a negative amt of cards.");
    }
    if (a > numCardsInDeck){
      throw new IllegalArgumentException("Cannot draw, there are not enough cards in the deck.");
    }

    UnoCards [] ret = new UnoCards[a];

    for (int i = 0; i < a; i++){
      ret[i] = deck[--numCardsInDeck];
    }
    return ret;
  }



}



