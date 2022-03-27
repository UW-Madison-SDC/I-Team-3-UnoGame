import java.util.List;

public class Player {
    private static int IDgenerator = 0;
    private List<Cards> deck;
    private int playerID;

    public Player(List<Cards> deck){
        this.deck = deck;
        this.playerID = IDgenerator;
        IDgenerator++;
    }

    public void addCard(Cards card){
        deck.add(card);
    }

    public void resetIDgenerator(){
        Player.IDgenerator = 0;
    }





}
