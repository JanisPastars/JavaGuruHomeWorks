import java.util.Scanner;

public class GuessNumber {

    PlayerNumber p;

    public void startGame() {
        p = new PlayerNumber();
        int guessp = 0;
        int count = 1;
        boolean pisRight = false;
        int targetNumber;
        System.out.println("Enter your number:");
        Scanner scanner = new Scanner(System.in);
        targetNumber = scanner.nextInt();


        System.out.println("I guess number from 0 to 100");
        while (true) {
            System.out.println("Number need guess - " + targetNumber);
            p.guess();
            guessp = p.number;
            System.out.println("Player think this number is - " + guessp);
            if (guessp == targetNumber) {
                pisRight = true;
            }
            if (pisRight) {
                System.out.println("We have a winner!");
                System.out.println("Player right number is" + pisRight);
                System.out.println("Machine has tried - " + count + " times ");
                System.out.println("End");
                break;
            }
            if (guessp > targetNumber) {
                pisRight = false;
                System.out.println("Target number is less");
            } else
                System.out.println("Target number is bigger");
            count = count + 1;
            System.out.println("Need try again!");
        }
    }
}



