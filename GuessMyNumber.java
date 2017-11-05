import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {
        int programmNumber;
        int myNumber;
        int count = 1;

        programmNumber = (int) (Math.random() * 100);
        System.out.println("I Entered number from 0 to 100, guess witch is it?");
        do {
            System.out.println("Enter your number from 0 to 100 ");

            Scanner scanner = new Scanner(System.in);
            myNumber = scanner.nextInt();
            if (myNumber == programmNumber) {
                System.out.println("You win!");
            } else {
                if (myNumber != programmNumber && myNumber > 0 && myNumber < 100) {
                    System.out.println("Wrong number! Try Again!");
                    count = count + 1;

                    if (programmNumber < myNumber) {
                        System.out.println("My number is less");
                    } else {
                        System.out.println("My number is bigger!");
                    }
                } else {
                    System.out.println("You Entered wrong number!");
                }
            }

        } while (myNumber != programmNumber);
        System.out.println("Your number is correct!");
        System.out.println("Number of your tryings is - " + count);
    }

}