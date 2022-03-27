public interface ICards {
    // private int ID

    // private int color
    // 5 = null, ie no color
    // 0 = blue
    // 1 = green
    // 2 = yellow
    // 3 = red

    // private faceVal special cards will have face value of 0-9, 10 means null
    // private boolean isSpecial - true if it is, false if not

    public int getColor();
    public int getID();
    public int getFaceVal();
    public void cardAction(Cycler cycler);
    public String toString();

}
