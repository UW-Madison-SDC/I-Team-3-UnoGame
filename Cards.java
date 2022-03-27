public class Cards implements ICards{
    private static int currID = 0;

    private int color;
    private int ID;
    private int faceVal;


    // creates a new card
    public Cards(int color, int faceVal){
        this.color = color;
        this.faceVal = faceVal;
        this.ID = currID;
        currID++;
    }

    @Override
    public int getColor() {
        return this.color;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public int getFaceVal() {
        return this.faceVal;
    }

    @Override
    public String toString(){
        return "ID: " + this.ID + " "
                + "color: " + this.color + " "
                + "faceVal: " + this.faceVal;
    }


    public void cardAction(Cycler cycler){
        cycler.nextPlayer();
    }

    // resets the ID generator to 0
    public static void resetIDGenerator(){
        Cards.currID = 0;
    }
}
