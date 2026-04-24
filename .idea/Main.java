package numberGuessing;
import java.util.Scanner;

public class Main
{

    public static void numberGuessingGame()
    {
        Scanner sc = new Scanner(System.in);

        // Generate a random number between 1 and 100
        int number = 1 + (int)(100 * Math.random());

        // Number of attempts
        int attempts = 7;

        int counter = 0;

        System.out.println("Guess a Number between 1 & 100, you have " + attempts + " attempts to guess correctly");

        while (counter < attempts)
        {
            counter++;

            int guess = sc.nextInt();

            if(guess == number)
            {
                System.out.println("Congratulations! You win!");
                sc.close();

                return;
            }
            else if (guess < number)
            {
                System.out.println("Too low");
            }
            else if (guess > number)
            {
                System.out.println("Too High");
            }

        }

        System.out.println("You've exhausted all attempts, the correct number is " + number);
    }

    public static void main(String[] args)
    {
        numberGuessingGame();
    }
}