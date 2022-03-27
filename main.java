import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Scanner;

public class main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] testArr = {0,1,2,3,4,5,6,7};

        System.out.println("The original array: ");
        for(Integer i: testArr) System.out.print(i + " ") ;

        System.out.println("\n");

        Test test = new Test(testArr.length, testArr);


        System.out.print("Current Player: ");
        System.out.println(test.getPlayer());



        while(true){

            System.out.println("Enter command: ");
            String input = scanner.next();

            if ( input.equals("n")) {
                test.nextPlayer();
                System.out.print("Current Player: ");
                System.out.println(test.getPlayer());
            }
            else if (input.equals("s")) {
                test.skip();
                System.out.print("Current Player: ");
                System.out.println(test.getPlayer());
            }else if (input.equals("r")) {
                test.toggleDirection();
                test.nextPlayer();
                System.out.print("Current Player: ");
                System.out.println(test.getPlayer());
            }else if (input.equals("q")) break;

        }
    }
}
