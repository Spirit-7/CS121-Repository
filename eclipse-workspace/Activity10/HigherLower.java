import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 10: Activity - while Loops and Iterators 
 * 
 * @author Java Foundations
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class HigherLower
{
	public static void main(String[] args)
	{
		final int MAX = 10;
		int answer;
		int guess;
		char yesOrNo;
		boolean optToPlay = true;
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		while (optToPlay)
		{
			answer = random.nextInt(MAX) + 1;
		
			System.out.print("I'm thinking of a number between 1 and " + MAX + ". ");
			System.out.print("Guess what it is: ");
		
			//		guess = scan.nextInt(); //Warning! Using nextInt() will screw up your ability
					//to read anything other than ints later on!
			guess = Integer.parseInt(scan.nextLine());	//THIS is how you should read
														//a line of input when an int
														//is expected and you still want
														//to be able to read something
														//else later.
			while (guess != answer)
			{
				if ((guess > MAX) || (guess < 1))
				{
					System.out.println("Your guess is out of the range!");
				}
				else if (guess < answer)
				{
					System.out.println("Guess higher");
				}
				else
				{
					System.out.println("Guess lower");
				}
				guess = Integer.parseInt(scan.nextLine());
			}
			System.out.println("You got it! Good guessing!");
			System.out.println("");
			System.out.println("Would you like to play again? (y/n) ");
			yesOrNo = scan.nextLine().charAt(0);
			if (yesOrNo == 'y')
			{
				optToPlay = true;
			}
			else if (yesOrNo == 'n')
			{
				optToPlay = false;
			}
			else
			{
				System.out.println("Your input was invalid! Quitting game...");
				optToPlay = false;
			}
			System.out.println("");
		}
		System.out.println("Game over. Goodbye!");
		scan.close();
	}
}
