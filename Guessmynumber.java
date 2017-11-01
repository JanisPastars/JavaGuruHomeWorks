import java.util.Scanner;

public class Guessmynumber {
    public static void main(String[] args) {
        int programmnumber;
        int mynumber;
        int count = 1;

        programmnumber = (int) (Math.random() * 100);
        System.out.println("I Entred number from 0 to 100, guess wich is it?");
        do {
            System.out.println("Enter your number from 0 to 100 ");

            Scanner scanner = new Scanner(System.in);
            mynumber = scanner.nextInt();
            if (mynumber == programmnumber) {
                System.out.println("You win!");
            } else {
                if (mynumber != programmnumber && mynumber > 0 && mynumber < 100) {
                    System.out.println("Wrong number! Try Again!");
                    count = count + 1;
                    {
                        if (programmnumber < mynumber) {
                            System.out.println("My number is less");
                        } else {
                            System.out.println("My number is bigger!");
                        }
                    }
                } else {
                    System.out.println("You Entered wrong number!");
                }
            }

            }  while (mynumber != programmnumber) ;
                System.out.println("Your number is correct!");
        System.out.println("Number of your tryings is - " + count);
    }

}