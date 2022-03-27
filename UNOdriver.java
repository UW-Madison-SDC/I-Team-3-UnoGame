import java.util.Scanner;

public class UNOdriver {

    Scanner scanner = new Scanner(System.in);
    String input;
    int playerCount;

    public static void main(String[] args){
        // initializing the game
        Cards[] deck = CardBuilder.buildInitial();

        // initializing players
        // later we can replace 4 with playerCount to allow for more flexible uses
        Player[] temp = new Player[4];
        for (int i = 0; i < 4; i++){

        }

    }
}
