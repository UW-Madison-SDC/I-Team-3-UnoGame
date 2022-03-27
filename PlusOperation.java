public class PlusOperation {



    // private field to keep track of the current plus count
    private static int toBeAdded;

    // constructor
    public PlusOperation(){
        toBeAdded = 0;
    }

    // a static void method that handles the dealing cards action
    public static void plus(int numberOfCards) {
        // calls deal method

        // sets the toBeAdded to be zero again since the jackpot is cleared
        PlusOperation.toBeAdded = 0;
    }

    // public static method to stack the jackpot
    public static void stack(int cardsToBeStacked){
        PlusOperation.toBeAdded += cardsToBeStacked;
    }

}
