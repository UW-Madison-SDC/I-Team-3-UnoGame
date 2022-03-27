public class Test {
    private final int players;

    private boolean forward; // true means that the queue is moving forwards

    private int currPlayer;

    private int[] queue;

    public Test(int players, int[] queue) {
        this.players = players;
        currPlayer = 0;
        this.queue = queue;
        this.forward = true;
    }

    public int getPlayer(){
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
