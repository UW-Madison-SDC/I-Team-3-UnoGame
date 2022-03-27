public class Cycler {
    private final int players;

    private boolean forward; // true means that the queue is moving forwards

    private int currPlayer;

    private Player[] queue;

    public Cycler(int players, Player[] queue) {
        this.players = players;
        currPlayer = 0;
        this.queue = queue;
        this.forward = true;
    }

    public Player getPlayer(){
        return this.queue[currPlayer];
    }
    /**
     * uses modulo operator to implement the circular array
     * has two
     */
    public void nextPlayer(){
        currPlayer = forward ? (currPlayer + 1) % players
                : (currPlayer - 1 + players) % players;
    }


    /**
     * a toggle to switch forward and backward
     */
    public void toggleDirection(){
        this.forward = !forward;
    }


    public void skip(){
        // all it does is calling next player two times and return the second player in line
        nextPlayer();
        nextPlayer();
    }
}
